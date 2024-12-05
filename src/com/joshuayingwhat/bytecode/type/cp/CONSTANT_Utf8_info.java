package com.joshuayingwhat.bytecode.type.cp;

import com.joshuayingwhat.bytecode.type.CpInfo;
import com.joshuayingwhat.bytecode.type.U1;
import com.joshuayingwhat.bytecode.type.U2;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class CONSTANT_Utf8_info extends CpInfo {
    private U2 lenght;
    private byte[] bytes;

    public CONSTANT_Utf8_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer buffer) {
        //lenght
        lenght = new U2(buffer.get(), buffer.get());
        bytes = new byte[lenght.toInt()];
        buffer.get(bytes, 0, lenght.toInt());
    }

    @Override
    public String toString() {
        return super.toString() + " CONSTANT_Utf8_info lenght = " + lenght.toInt() + " bytes = " + new String(bytes, StandardCharsets.UTF_8);
    }
}
