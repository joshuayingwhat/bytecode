package com.joshuayingwhat.bytecode.type.cp;

import com.joshuayingwhat.bytecode.type.CpInfo;
import com.joshuayingwhat.bytecode.type.U1;
import com.joshuayingwhat.bytecode.type.U4;

import java.nio.ByteBuffer;

public class CONSTANT_Float_info extends CpInfo {
    private U4 bytes;

    public CONSTANT_Float_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer buffer) {
        bytes = new U4(buffer.get(), buffer.get(), buffer.get(), buffer.get());
    }

    @Override
    public String toString() {
        return super.toString()+ " CONSTANT_Float_info bytes ="+bytes.toHexString();
    }
}
