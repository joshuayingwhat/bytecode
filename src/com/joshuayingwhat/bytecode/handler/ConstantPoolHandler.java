package com.joshuayingwhat.bytecode.handler;

import com.joshuayingwhat.bytecode.ClassFile;
import com.joshuayingwhat.bytecode.type.CpInfo;
import com.joshuayingwhat.bytecode.type.U1;
import com.joshuayingwhat.bytecode.type.U2;
import com.joshuayingwhat.bytecode.type.cp.CONSTANT_Long_info;

import java.nio.ByteBuffer;

/**
 * 常量池处理函数
 */
public class ConstantPoolHandler implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 2;
    }

    @Override
    public void read(ByteBuffer codeBuff, ClassFile classFile) throws Exception {
        //获取常量池大小
        U2 cp_len = new U2(codeBuff.get(), codeBuff.get());
        classFile.setConstant_pools(new CpInfo[cp_len.toInt() - 1]);
        classFile.setConstant_Pool_count(cp_len);
        for (int i = 0; i < cp_len.toInt() - 1; i++) {
            U1 tag = new U1(codeBuff.get());
            CpInfo cpInfo = CpInfo.newCpInfo(tag);
            cpInfo.read(codeBuff);
            System.out.println("#" + (i + 1) + ":" + cpInfo.toString());
            classFile.getConstant_pools()[i] = cpInfo;
            if (cpInfo instanceof CONSTANT_Long_info) {
                i++;
            }
        }
    }
}
