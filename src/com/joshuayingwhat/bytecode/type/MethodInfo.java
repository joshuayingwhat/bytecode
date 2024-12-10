package com.joshuayingwhat.bytecode.type;

/**
 * 方法表
 */
public class MethodInfo {
    private U2 access_flags;
    private U2 name_index;
    private U2 descriptor_index;
    private U2 attribute_count;
    private AttributeInfo[] attributeInfos;

    public U2 getAccess_flags() {
        return access_flags;
    }

    public void setAccess_flags(U2 access_flags) {
        this.access_flags = access_flags;
    }

    public U2 getName_index() {
        return name_index;
    }

    public void setName_index(U2 name_index) {
        this.name_index = name_index;
    }

    public U2 getDescriptor_index() {
        return descriptor_index;
    }

    public void setDescriptor_index(U2 descriptor_index) {
        this.descriptor_index = descriptor_index;
    }

    public U2 getAttribute_count() {
        return attribute_count;
    }

    public void setAttribute_count(U2 attribute_count) {
        this.attribute_count = attribute_count;
    }

    public AttributeInfo[] getAttributeInfos() {
        return attributeInfos;
    }

    public void setAttributeInfos(AttributeInfo[] attributeInfos) {
        this.attributeInfos = attributeInfos;
    }
}
