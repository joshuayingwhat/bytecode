package com.joshuayingwhat.bytecode.type;

/**
 * 字段表解析
 */
public class FileInfo {
    public U2 access_flags;
    public U2 name_index;
    public U2 descriptor_index;
    public U2 attributes_count;
    public AttributeInfo[] attributeInfos;
}
