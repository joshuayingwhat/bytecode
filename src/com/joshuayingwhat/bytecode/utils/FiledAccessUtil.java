package com.joshuayingwhat.bytecode.utils;

import com.joshuayingwhat.bytecode.type.U2;

import java.util.HashMap;

public class FiledAccessUtil {
    private static final HashMap<Integer,String> field_access_map = new HashMap<>();

    static {
        field_access_map.put(0x0001,"public");
        field_access_map.put(0x0002,"private");
        field_access_map.put(0x0004,"protected");
        field_access_map.put(0x0008,"static");
        field_access_map.put(0x0010,"final");
        field_access_map.put(0x0040,"volatile");
        field_access_map.put(0x0080,"transient");
        field_access_map.put(0x1000,"由编译器生成,不在源码中");
        field_access_map.put(0x4000,"enum");
    }

    public static String get_field_access_flag(U2 access_flag) {
        final int flagVlaue =access_flag.toInt();
        StringBuilder flagBuild = new StringBuilder();
        field_access_map.keySet()
                .forEach(key -> {
                    if ((flagVlaue & key) == key) {
                        flagBuild.append(field_access_map.get(key)).append(",");
                    }
                });
        return flagBuild.length() > 0 && flagBuild.charAt(flagBuild.length() - 1) == ',' ?
                flagBuild.substring(0, flagBuild.length() - 1)  : flagBuild.toString();
    }
}
