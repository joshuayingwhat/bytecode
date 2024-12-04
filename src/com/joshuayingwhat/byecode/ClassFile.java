package com.joshuayingwhat.byecode;

import com.joshuayingwhat.byecode.type.*;

/**
 * 字节class文件结构
 */
public class ClassFile {
    private U4 Magic;
    private U2 Minor_version;
    private U2 Major_vresion;
    private U2 constant_Pool_count;
    private CpInfo[] constant_pools;
    private U2 access_flags;
    private U2 this_class;
    private U2 super_class;
    private U2 interface_count;
    private U2[] interfaces;
    private U2 fields_count;
    private FileInfo[] fileInfos;
    private U2 method_count;
    private MethodInfo[] methods;
    private U2 attributes_count;
    private AttributeInfo[] attributeInfos;

    public U4 getMagic() {
        return Magic;
    }

    public void setMagic(U4 magic) {
        Magic = magic;
    }

    public U2 getMinor_version() {
        return Minor_version;
    }

    public void setMinor_version(U2 minor_version) {
        Minor_version = minor_version;
    }

    public U2 getMajor_vresion() {
        return Major_vresion;
    }

    public void setMajor_vresion(U2 major_vresion) {
        Major_vresion = major_vresion;
    }

    public U2 getConstant_Pool_count() {
        return constant_Pool_count;
    }

    public void setConstant_Pool_count(U2 constant_Pool_count) {
        this.constant_Pool_count = constant_Pool_count;
    }

    public CpInfo[] getConstant_pools() {
        return constant_pools;
    }

    public void setConstant_pools(CpInfo[] constant_pools) {
        this.constant_pools = constant_pools;
    }

    public U2 getAccess_flags() {
        return access_flags;
    }

    public void setAccess_flags(U2 access_flags) {
        this.access_flags = access_flags;
    }

    public U2 getThis_class() {
        return this_class;
    }

    public void setThis_class(U2 this_class) {
        this.this_class = this_class;
    }

    public U2 getSuper_class() {
        return super_class;
    }

    public void setSuper_class(U2 super_class) {
        this.super_class = super_class;
    }

    public U2 getInterface_count() {
        return interface_count;
    }

    public void setInterface_count(U2 interface_count) {
        this.interface_count = interface_count;
    }

    public U2[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(U2[] interfaces) {
        this.interfaces = interfaces;
    }

    public U2 getFields_count() {
        return fields_count;
    }

    public void setFields_count(U2 fields_count) {
        this.fields_count = fields_count;
    }

    public FileInfo[] getFileInfos() {
        return fileInfos;
    }

    public void setFileInfos(FileInfo[] fileInfos) {
        this.fileInfos = fileInfos;
    }

    public U2 getMethod_count() {
        return method_count;
    }

    public void setMethod_count(U2 method_count) {
        this.method_count = method_count;
    }

    public MethodInfo[] getMethods() {
        return methods;
    }

    public void setMethods(MethodInfo[] methods) {
        this.methods = methods;
    }

    public U2 getAttributes_count() {
        return attributes_count;
    }

    public void setAttributes_count(U2 attributes_count) {
        this.attributes_count = attributes_count;
    }

    public AttributeInfo[] getAttributeInfos() {
        return attributeInfos;
    }

    public void setAttributeInfos(AttributeInfo[] attributeInfos) {
        this.attributeInfos = attributeInfos;
    }
}
