package com.joshuayingwhat.byecode.handler;

import com.joshuayingwhat.byecode.ClassFile;

import java.nio.ByteBuffer;

/**
 * 属性处理
 */
public class AttributesHandler implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 8;
    }

    @Override
    public void read(ByteBuffer codeBuff, ClassFile classFile) {

    }
}
