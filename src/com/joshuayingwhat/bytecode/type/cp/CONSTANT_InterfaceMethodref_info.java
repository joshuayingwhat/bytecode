package com.joshuayingwhat.bytecode.type.cp;

import com.joshuayingwhat.bytecode.type.CpInfo;
import com.joshuayingwhat.bytecode.type.U1;
import com.joshuayingwhat.bytecode.type.U2;

import java.nio.ByteBuffer;

public class CONSTANT_InterfaceMethodref_info extends CpInfo {
    private U2 name_index;

    public CONSTANT_InterfaceMethodref_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer buffer) {
        name_index = new U2(buffer.get(),buffer.get());
    }
}
