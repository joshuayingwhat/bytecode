package com.joshuayingwhat.bytecode;

import com.joshuayingwhat.bytecode.type.U2;
import com.joshuayingwhat.bytecode.type.cp.CONSTANT_Class_info;
import com.joshuayingwhat.bytecode.type.cp.CONSTANT_Utf8_info;
import com.joshuayingwhat.bytecode.utils.ClassAccessFlagUtil;

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
        System.out.println("接口总数: "+interface_count);
        for (int i = 0 ; i < interface_count;i++) {
            U2 inteface = classFile.getInterfaces()[i];
            CONSTANT_Class_info constant_interface = (CONSTANT_Class_info) classFile.getConstant_pools()[inteface.toInt() - 1];
            CONSTANT_Utf8_info interface_name = (CONSTANT_Utf8_info) classFile.getConstant_pools()[constant_interface.getName_index().toInt() - 1];
            System.out.println("接口名称:"+interface_name.toString());
        }

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