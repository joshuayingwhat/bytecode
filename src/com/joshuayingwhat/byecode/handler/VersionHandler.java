package com.joshuayingwhat.byecode.handler;

import com.joshuayingwhat.byecode.ClassFile;

import java.nio.ByteBuffer;

/**
 * 版本处理函数
 */
public class VersionHandler implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 1;
    }


    @Override
    public void read(ByteBuffer codeBuff, ClassFile classFile) {

    }
}
