package com.joshuayingwhat.bytecode.handler;

import com.joshuayingwhat.bytecode.ClassFile;

import java.nio.ByteBuffer;

/**
 * 方法处理函数
 */
public class MethodHandler implements BaseByteCodeHandler{
    @Override
    public int order() {
        return 7;
    }

    @Override
    public void read(ByteBuffer codeBuff, ClassFile classFile) {

    }
}