package com.joshuayingwhat.bytecode.handler;

import com.joshuayingwhat.bytecode.ClassFile;
import com.joshuayingwhat.bytecode.type.AttributeInfo;
import com.joshuayingwhat.bytecode.type.FileInfo;
import com.joshuayingwhat.bytecode.type.U2;
import com.joshuayingwhat.bytecode.type.U4;

import java.nio.ByteBuffer;

/**
 * 字段处理函数
 */
public class FieldHandler implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 6;
    }

    @Override
    public void read(ByteBuffer codeBuff, ClassFile classFile) {
        U2 field_count = new U2(codeBuff.get(), codeBuff.get());
        if (field_count.toInt() < 0) {
            return;
        }
        classFile.setFields_count(field_count);
        FileInfo[] fileInfo = new FileInfo[field_count.toInt()];
        classFile.setFileInfos(fileInfo);
        for (int i = 0; i < field_count.toInt(); i++) {
            fileInfo[i] = new FileInfo();
            fileInfo[i].access_flags = new U2(codeBuff.get(), codeBuff.get());
            fileInfo[i].name_index = new U2(codeBuff.get(), codeBuff.get());
            fileInfo[i].descriptor_index = new U2(codeBuff.get(), codeBuff.get());
            fileInfo[i].attributes_count = new U2(codeBuff.get(), codeBuff.get());
            //获取属性总数
            int attr_lenght = fileInfo[i].attributes_count.toInt();
            if (attr_lenght == 0) {
                continue;
            }
            fileInfo[i].attributeInfos = new AttributeInfo[attr_lenght];
            //解析每个属性
            for (int j = 0; j < attr_lenght; j++) {
                fileInfo[i].attributeInfos[j].attribute_name_index = new U2(codeBuff.get(),codeBuff.get());
                U4 attributeLength = new U4(codeBuff.get(), codeBuff.get(), codeBuff.get(), codeBuff.get());
                fileInfo[i].attributeInfos[j].attribute_length = attributeLength;
                //解析info
                byte[] info = new byte[attributeLength.toInt()];
                codeBuff.get(info,0,info.length);
                fileInfo[i].attributeInfos[j].info = info;
            }
        }
    }
}
