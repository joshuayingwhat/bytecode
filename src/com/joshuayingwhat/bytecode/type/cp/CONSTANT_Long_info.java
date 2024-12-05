package com.joshuayingwhat.bytecode.type.cp;

import com.joshuayingwhat.bytecode.type.CpInfo;
import com.joshuayingwhat.bytecode.type.U1;
import com.joshuayingwhat.bytecode.type.U4;

import java.nio.ByteBuffer;

public class CONSTANT_Long_info extends CpInfo {
    private U4 hight_bytes;
    private U4 low_bytes;

    public CONSTANT_Long_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer buffer) {
        hight_bytes = new U4(buffer.get(), buffer.get(), buffer.get(), buffer.get());
        low_bytes = new U4(buffer.get(), buffer.get(), buffer.get(), buffer.get());
    }

    @Override
    public String toString() {
        return super.toString() + " CONSTANT_Long_info hight_bytes =" + hight_bytes.toHexString() + " low_bytes =" + low_bytes.toHexString();
    }
}
