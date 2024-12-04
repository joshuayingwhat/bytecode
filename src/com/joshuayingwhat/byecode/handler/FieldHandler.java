package com.joshuayingwhat.byecode.handler;

import com.joshuayingwhat.byecode.ClassFile;

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
