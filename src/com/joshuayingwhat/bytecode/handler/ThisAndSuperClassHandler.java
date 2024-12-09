package com.joshuayingwhat.bytecode.handler;

import com.joshuayingwhat.bytecode.ClassFile;
import com.joshuayingwhat.bytecode.type.U2;

import java.nio.ByteBuffer;

/**
 * 子类和父类处理函数
 */
public class ThisAndSuperClassHandler implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 4;
    }

    @Override
    public void read(ByteBuffer codeBuff, ClassFile classFile) {
        U2 this_class = new U2(codeBuff.get(), codeBuff.get());
        classFile.setThis_class(this_class);
        U2 super_class = new U2(codeBuff.get(), codeBuff.get());
        classFile.setSuper_class(super_class);
    }
}
