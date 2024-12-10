package com.joshuayingwhat.bytecode.handler;

import com.joshuayingwhat.bytecode.ClassFile;
import com.joshuayingwhat.bytecode.type.AttributeInfo;
import com.joshuayingwhat.bytecode.type.MethodInfo;
import com.joshuayingwhat.bytecode.type.U2;
import com.joshuayingwhat.bytecode.type.U4;

import java.nio.ByteBuffer;

/**
 * 方法处理函数
 */
public class MethodHandler implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 7;
    }

    @Override
    public void read(ByteBuffer codeBuff, ClassFile classFile) {
        classFile.setMethod_count(new U2(codeBuff.get(), codeBuff.get()));
        U2 methodCount = classFile.getMethod_count();
        MethodInfo[] methods = new MethodInfo[methodCount.toInt()];
        classFile.setMethods(methods);
        for (int i = 0; i < methodCount.toInt(); i++) {
            methods[i] = new MethodInfo();
            methods[i].setAccess_flags(new U2(codeBuff.get(), codeBuff.get()));
            methods[i].setName_index(new U2(codeBuff.get(), codeBuff.get()));
            methods[i].setDescriptor_index(new U2(codeBuff.get(), codeBuff.get()));
            methods[i].setAttribute_count(new U2(codeBuff.get(), codeBuff.get()));
            //获取方法的属性总数
            int attribute_count = methods[i].getAttribute_count().toInt();
            if (attribute_count == 0) {
                continue;
            }
            methods[i].setAttributeInfos(new AttributeInfo[attribute_count]);
            for (int j = 0; j < attribute_count; j++) {
                methods[i].getAttributeInfos()[j] = new AttributeInfo();
                methods[i].getAttributeInfos()[j].attribute_name_index = new U2(codeBuff.get(), codeBuff.get());
                U4 attr_info_len = new U4(codeBuff.get(), codeBuff.get(), codeBuff.get(), codeBuff.get());
                if (attr_info_len.toInt() == 0) continue;
                byte[] info = new byte[attr_info_len.toInt()];
                codeBuff.get(info, 0, attr_info_len.toInt());
                methods[i].getAttributeInfos()[j].info = info;
            }
        }
    }
}
