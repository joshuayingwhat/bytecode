package com.joshuayingwhat.bytecode.handler;

import com.joshuayingwhat.bytecode.ClassFile;
import com.joshuayingwhat.bytecode.type.U2;

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
        classFile.setAccess_flags(new U2(codeBuff.get(), codeBuff.get()));
    }
}
