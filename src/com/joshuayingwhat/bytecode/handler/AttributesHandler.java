package com.joshuayingwhat.bytecode.handler;

import com.joshuayingwhat.bytecode.ClassFile;
import com.joshuayingwhat.bytecode.type.AttributeInfo;
import com.joshuayingwhat.bytecode.type.U2;
import com.joshuayingwhat.bytecode.type.U4;

import java.nio.ByteBuffer;

/**
 * class属性处理
 */
public class AttributesHandler implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 8;
    }

    @Override
    public void read(ByteBuffer codeBuff, ClassFile classFile) {
        U2 attribute_len = new U2(codeBuff.get(), codeBuff.get());
        classFile.setAttributes_count(attribute_len);
        classFile.setAttributeInfos(new AttributeInfo[attribute_len.toInt()]);
        if (attribute_len.toInt() == 0) return;
        for (int i = 0; i < attribute_len.toInt(); i++) {
            classFile.getAttributeInfos()[i] = new AttributeInfo();
            classFile.getAttributeInfos()[i].attribute_name_index = new U2(codeBuff.get(), codeBuff.get());
            classFile.getAttributeInfos()[i].attribute_length = new U4(codeBuff.get(), codeBuff.get(), codeBuff.get(), codeBuff.get());
            int info_len = classFile.getAttributeInfos()[i].attribute_length.toInt();
            if (info_len == 0) continue;
            byte[] info = new byte[info_len];
            codeBuff.get(info, 0, info_len);
            classFile.getAttributeInfos()[i].info = info;
        }
    }
}
