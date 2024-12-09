package com.joshuayingwhat.bytecode.utils;

import com.joshuayingwhat.bytecode.type.U2;

import java.util.HashMap;
import java.util.Map;

public class ClassAccessFlagUtil {

    private static final Map<Integer, String> access_flag_map = new HashMap<Integer, String>();

    static {
        access_flag_map.put(0x0001, "public");
        access_flag_map.put(0x0010, "final");
        access_flag_map.put(0x0020, "super");
        access_flag_map.put(0x0200, "interface");
        access_flag_map.put(0x0400, "abstract");
        access_flag_map.put(0x1000, "synthetic");
        access_flag_map.put(0x2000, "annotation");
        access_flag_map.put(0x4000, "enum");
    }

    //获取16进制对应访问标志字符串
    public static String getAccessFlag(U2 access_flag) {
        int flag = access_flag.toInt();
        StringBuilder builder = new StringBuilder();
        access_flag_map.keySet().forEach(key -> {
            if ((flag & key) == key) {
                builder.append(access_flag_map.get(key)).append(",");
            }
        });
        char c = builder.charAt(builder.length() - 1);
        return builder.length() > 0 && c == ',' ? builder.substring(0, builder.length() - 1) : builder.toString();
    }
}
