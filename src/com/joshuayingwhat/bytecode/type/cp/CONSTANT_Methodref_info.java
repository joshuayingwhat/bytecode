package com.joshuayingwhat.bytecode.type.cp;

import com.joshuayingwhat.bytecode.type.CpInfo;
import com.joshuayingwhat.bytecode.type.U1;
import com.joshuayingwhat.bytecode.type.U2;

import java.nio.ByteBuffer;

public class CONSTANT_Methodref_info extends CpInfo {
    private U2 class_inex;
    private U2 name_and_type_index;

    public CONSTANT_Methodref_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer buffer) {
        //解析class_index
        class_inex = new U2(buffer.get(), buffer.get());
        //解析name_and_type_index
        name_and_type_index = new U2(buffer.get(), buffer.get());
    }

    @Override
    public String toString() {
        return super.toString()+" CONSTANT_Methodref_info class_index ="+class_inex.toHexString()+"  name_and_type_index ="+name_and_type_index.toHexString();
    }
}
