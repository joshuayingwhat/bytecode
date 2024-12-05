package com.joshuayingwhat.bytecode;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class ClassFileAnalysisMain {
    public static void main(String[] args) throws Exception {

        ByteBuffer buffer = readClassFile("C:\\Users\\joshu\\Desktop\\bytecode\\src\\com\\joshuayingwhat\\bytecode\\TestClass.class");
        ClassFile classFile = new ClassFileAnalysiser().analysis(buffer);
        System.out.println(classFile.getMagic().toHexString());
        System.out.println(classFile.getMinor_version().toHexString() + " ---- " + classFile.getMajor_vresion().toHexString());
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