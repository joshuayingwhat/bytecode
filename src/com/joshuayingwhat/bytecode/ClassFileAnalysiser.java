package com.joshuayingwhat.bytecode;

import com.joshuayingwhat.bytecode.handler.*;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;

public class ClassFileAnalysiser {
    private static final ArrayList<BaseByteCodeHandler> handlers = new ArrayList<>();

    //添加各个解析器
    public ClassFileAnalysiser() {
        handlers.add(new MagicHandler());
        handlers.add(new VersionHandler());
        handlers.add(new ConstantPoolHandler());
        handlers.add(new AccessFlagsHandler());
        handlers.add(new ThisAndSuperClassHandler());
        handlers.add(new InterfacesHandler());
        handlers.add(new FieldHandler());
        handlers.add(new MethodHandler());
        handlers.add(new AttributesHandler());
        handlers.sort((Comparator.comparingInt(BaseByteCodeHandler::order)));//排序 按顺序解析
    }

    public ClassFile analysis(ByteBuffer codeBuffer) {
        codeBuffer.position(0);//从0开始读字节
        ClassFile classFile = new ClassFile();
        for (BaseByteCodeHandler handler : handlers) {
            handler.read(codeBuffer, classFile);
        }
        return classFile;
    }
}
