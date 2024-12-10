package com.joshuayingwhat.bytecode;

public class TestClass implements Test_Interface {
    private static float TEST_FLOAT = 100F;
    private static long TEST_LONG = 100L;
    private static double TEST_DOUBLE = 100d;
    private static int TEST_INT = 100;

    private String name;

    private String access_flag;

    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccess_flag() {
        return access_flag;
    }

    public void setAccess_flag(String access_flag) {
        this.access_flag = access_flag;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
