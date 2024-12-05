package com.joshuayingwhat.bytecode.type.cp;

import com.joshuayingwhat.bytecode.type.CpInfo;
import com.joshuayingwhat.bytecode.type.U1;
import com.joshuayingwhat.bytecode.type.U2;

import java.nio.ByteBuffer;

public class CONSTANT_Fieldref_info extends CpInfo {
    private U2 class_index;
    private U2 name_and_type_index;

    public CONSTANT_Fieldref_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer buffer) {
        class_index = new U2(buffer.get(), buffer.get());
        name_and_type_index = new U2(buffer.get(), buffer.get());
    }

    @Override
    public String toString() {
        return super.toString() + " CONSTANT_Fieldref_info class_index =" + class_index.toHexString() + " name_and_type_index =" + name_and_type_index.toHexString();
    }
}
