package com.joshuayingwhat.byecode.handler;

import com.joshuayingwhat.byecode.ClassFile;
import com.joshuayingwhat.byecode.type.U4;

import java.nio.ByteBuffer;

/**
 * 魔数处理函数
 */
public class MagicHandler implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 0;
    }

    //读取class文件头4个字节 也就是0xcafbaba
    @Override
    public void read(ByteBuffer codeBuff, ClassFile classFile) {
        U4 magic = new U4(codeBuff.get(), codeBuff.get(), codeBuff.get(), codeBuff.get());
        classFile.setMagic(magic);
    }
}
