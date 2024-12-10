package com.joshuayingwhat.bytecode;

import com.joshuayingwhat.bytecode.type.FileInfo;
import com.joshuayingwhat.bytecode.type.MethodInfo;
import com.joshuayingwhat.bytecode.type.U2;
import com.joshuayingwhat.bytecode.type.cp.CONSTANT_Class_info;
import com.joshuayingwhat.bytecode.type.cp.CONSTANT_Utf8_info;
import com.joshuayingwhat.bytecode.utils.ClassAccessFlagUtil;
import com.joshuayingwhat.bytecode.utils.FiledAccessUtil;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class ClassFileAnalysisMain {
    public static void main(String[] args) throws Exception {
        ByteBuffer buffer = readClassFile("C:\\Users\\joshu\\Desktop\\bytecode\\out\\production\\bytecode\\com\\joshuayingwhat\\bytecode\\TestClass.class");
        ClassFile classFile = new ClassFileAnalysiser().analysis(buffer);
        U2 accessFlags = classFile.getAccess_flags();
        System.out.println(ClassAccessFlagUtil.getAccessFlag(accessFlags));
        System.out.println(classFile.getMagic().toHexString());
        System.out.println(classFile.getMinor_version().toHexString() + " ---- " + classFile.getMajor_vresion().toHexString());
        //this和super符号引用
        U2 thisClass = classFile.getThis_class();
        CONSTANT_Class_info this_class_info = (CONSTANT_Class_info) classFile.getConstant_pools()[thisClass.toInt() - 1];
        CONSTANT_Utf8_info this_class_name = (CONSTANT_Utf8_info) classFile.getConstant_pools()[this_class_info.getName_index().toInt() - 1];
        System.out.println(this_class_name);
        U2 superClass = classFile.getSuper_class();
        CONSTANT_Class_info super_class_info = (CONSTANT_Class_info) classFile.getConstant_pools()[superClass.toInt() - 1];
        CONSTANT_Utf8_info super_class_name = (CONSTANT_Utf8_info) classFile.getConstant_pools()[super_class_info.getName_index().toInt() - 1];
        System.out.println(super_class_name);
        //接口
        int interface_count = classFile.getInterface_count().toInt();
        System.out.println("接口总数: " + interface_count);
        for (int i = 0; i < interface_count; i++) {
            U2 inteface = classFile.getInterfaces()[i];
            CONSTANT_Class_info constant_interface = (CONSTANT_Class_info) classFile.getConstant_pools()[inteface.toInt() - 1];
            CONSTANT_Utf8_info interface_name = (CONSTANT_Utf8_info) classFile.getConstant_pools()[constant_interface.getName_index().toInt() - 1];
            System.out.println("接口名称:" + interface_name.toString());
        }
        //字段和属性
        U2 fieldsCount = classFile.getFields_count();
        System.out.println("字段总数:" + fieldsCount.toInt());
        FileInfo[] fileInfos = classFile.getFileInfos();
        for (FileInfo fileInfo : fileInfos) {
            System.out.println("访问标志和属性：" + FiledAccessUtil.get_field_access_flag(fileInfo.access_flags));
            System.out.println("字段名："
                    + getName(fileInfo.name_index, classFile));
            System.out.println("字段的类型描述符："
                    + getName(fileInfo.descriptor_index, classFile));
            System.out.println("属性总数："
                    + fileInfo.attributes_count.toInt());
            System.out.println();
        }
        //方法
        U2 methodCount = classFile.getMethod_count();
        System.out.println("方法总数:" + methodCount.toInt());
        MethodInfo[] methods = classFile.getMethods();
        for (MethodInfo method : methods) {
            System.out.println("访问标志和属性：" + FiledAccessUtil.get_field_access_flag(method.getAccess_flags()));
            System.out.println("字段名："
                    + getName(method.getName_index(), classFile));
            System.out.println("字段的类型描述符："
                    + getName(method.getDescriptor_index(), classFile));
            System.out.println("属性总数："
                    + method.getAttribute_count().toInt());
            System.out.println();
        }
    }

    private static String getName(U2 name_index, ClassFile classFile) {
        CONSTANT_Utf8_info name_info = (CONSTANT_Utf8_info)
                classFile.getConstant_pools()[name_index.toInt() - 1];
        return name_info.toString();
    }

    //读文件
    public static ByteBuffer readClassFile(String path) throws Exception {
        File file = new File(path);
        if (!file.exists()) {
            throw new Exception("文件不存在 " + path);
        }
        byte[] bytes = new byte[4096];
        int readLine;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            InputStream in = new BufferedInputStream(Files.newInputStream(file.toPath()));
            while ((readLine = in.read(bytes)) != -1) {
                buffer.write(bytes, 0, readLine);
            }
        } catch (IOException e) {
            throw new IOException("文件读取出错");
        }

        return ByteBuffer.wrap(buffer.toByteArray()).asReadOnlyBuffer();
    }
}