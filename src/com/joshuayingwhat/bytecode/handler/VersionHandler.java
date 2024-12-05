package com.joshuayingwhat.bytecode.handler;

import com.joshuayingwhat.bytecode.ClassFile;
import com.joshuayingwhat.bytecode.type.U2;

import java.nio.ByteBuffer;

/**
 * 版本处理函数
 */
public class VersionHandler implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 1;
    }

    /**
     * 解析版本号
     * @param codeBuff
     * @param classFile
     */
    @Override
    public void read(ByteBuffer codeBuff, ClassFile classFile) {
        U2 minor_version = new U2(codeBuff.get(), codeBuff.get());
        classFile.setMinor_version(minor_version);
        U2 major_version = new U2(codeBuff.get(), codeBuff.get());
        classFile.setMajor_vresion(major_version);
    }
}
