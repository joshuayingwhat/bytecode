package com.joshuayingwhat.bytecode.type.cp;

import com.joshuayingwhat.bytecode.type.CpInfo;
import com.joshuayingwhat.bytecode.type.U1;

import java.nio.ByteBuffer;

public class CONSTANT_InvokeDynamic_info extends CpInfo {
    public CONSTANT_InvokeDynamic_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer buffer) {

    }
}
