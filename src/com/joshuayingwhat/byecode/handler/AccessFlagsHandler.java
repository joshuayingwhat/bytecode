package com.joshuayingwhat.byecode.handler;

import com.joshuayingwhat.byecode.ClassFile;

import java.nio.ByteBuffer;

/**
 * 权限标记处理函数
 */
public class AccessFlagsHandler implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 3;
    }

    @Override
    public void read(ByteBuffer codeBuff, ClassFile classFile) {

    }
}
