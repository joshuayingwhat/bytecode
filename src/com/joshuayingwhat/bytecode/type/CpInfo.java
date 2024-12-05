package com.joshuayingwhat.bytecode.type;

import com.joshuayingwhat.bytecode.type.cp.*;

/**
 * 常量池抽象类
 */
public abstract class CpInfo implements ConstantInfoHandler {

    private U1 tag;

    public CpInfo(U1 tag) {
        this.tag = tag;
    }

    public static CpInfo newCpInfo(U1 tag) {
        CpInfo cp = null;
        switch (tag.toInt()) {
            case 1://UTF-8编码字符串
                cp = new CONSTANT_Utf8_info(tag);
                break;
            case 10://类中方法的符号引用
                cp = new CONSTANT_Methodref_info(tag);
                break;
            case 4://浮点型字面量
                cp = new CONSTANT_Float_info(tag);
                break;
            case 9://字段的符号引用CONSTANT\_Fieldref\_info
                cp = new CONSTANT_Fieldref_info(tag);
                break;
            case 5://长整形字面类
                cp = new CONSTANT_Long_info(tag);
                break;
            case 6://双精度浮点型字面量
                cp = new CONSTANT_Double_info(tag);
                break;
            case 7://类或接口的符号引用
                cp = new CONSTANT_Class_info(tag);
                break;
            case 12://字段与字段类型或方法与方法类型的符号引用
                cp = new CONSTANT_InterfaceMethodref_info(tag);
                break;
            default:
                System.out.println("无法匹配常量池解析器 tag = " + tag.toInt());
                break;
        }
        return cp;
    }

    @Override
    public String toString() {
        return "tag =" + tag.toInt();
    }
}
