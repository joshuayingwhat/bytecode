package com.joshuayingwhat.byecode.handler;

import com.joshuayingwhat.byecode.ClassFile;

import java.nio.ByteBuffer;

/**
 * 常量池处理函数
 */
public class ConstantPoolHandler implements BaseByteCodeHandler{
    @Override
    public int order() {
        return 2;
    }

    @Override
    public void read(ByteBuffer codeBuff, ClassFile classFile) {

    }
}
