package com.joshuayingwhat.bytecode.handler;

import com.joshuayingwhat.bytecode.ClassFile;
import com.joshuayingwhat.bytecode.type.U2;

import java.nio.ByteBuffer;

/**
 * 接口处理函数
 */
public class InterfacesHandler implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 5;
    }

    @Override
    public void read(ByteBuffer codeBuff, ClassFile classFile) {
        classFile.setInterface_count(new U2(codeBuff.get(), codeBuff.get()));
        int interface_count = classFile.getInterface_count().toInt();
        U2[] interfaces = new U2[interface_count];
        classFile.setInterfaces(interfaces);
        for (int i = 0; i < interface_count; i++) {
            interfaces[i] = new U2(codeBuff.get(), codeBuff.get());
        }
    }
}
