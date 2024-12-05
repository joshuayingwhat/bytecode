package com.joshuayingwhat.bytecode.handler;

import com.joshuayingwhat.bytecode.ClassFile;

import java.nio.ByteBuffer;

/**
 * 子类和父类处理函数
 */
public class ThisAndSuperClassHandler implements BaseByteCodeHandler{
    @Override
    public int order() {
        return 4;
    }

    @Override
    public void read(ByteBuffer codeBuff, ClassFile classFile) {

    }
}
