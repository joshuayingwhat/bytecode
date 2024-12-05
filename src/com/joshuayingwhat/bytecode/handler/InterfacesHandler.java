package com.joshuayingwhat.bytecode.handler;

import com.joshuayingwhat.bytecode.ClassFile;

import java.nio.ByteBuffer;

/**
 * 接口处理函数
 */
public class InterfacesHandler implements BaseByteCodeHandler{
    @Override
    public int order() {
        return 5;
    }

    @Override
    public void read(ByteBuffer codeBuff, ClassFile classFile) {

    }
}
