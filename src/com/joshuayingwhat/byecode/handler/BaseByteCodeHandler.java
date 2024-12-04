package com.joshuayingwhat.byecode.handler;

import com.joshuayingwhat.byecode.ClassFile;

import java.nio.ByteBuffer;

public interface BaseByteCodeHandler {
    int order();

    void read(ByteBuffer codeBuff, ClassFile classFile);
}
