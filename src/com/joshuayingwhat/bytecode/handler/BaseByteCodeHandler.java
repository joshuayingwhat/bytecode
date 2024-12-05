package com.joshuayingwhat.bytecode.handler;

import com.joshuayingwhat.bytecode.ClassFile;

import java.nio.ByteBuffer;

public interface BaseByteCodeHandler {
    int order();

    void read(ByteBuffer codeBuff, ClassFile classFile);
}
