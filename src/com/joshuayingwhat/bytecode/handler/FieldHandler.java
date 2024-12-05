package com.joshuayingwhat.bytecode.handler;

import com.joshuayingwhat.bytecode.ClassFile;

import java.nio.ByteBuffer;

/**
 * 字段处理函数
 */
public class FieldHandler implements BaseByteCodeHandler{
    @Override
    public int order() {
        return 6;
    }

    @Override
    public void read(ByteBuffer codeBuff, ClassFile classFile) {

    }
}
