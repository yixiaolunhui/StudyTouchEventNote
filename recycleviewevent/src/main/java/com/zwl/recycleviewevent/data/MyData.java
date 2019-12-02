package com.zwl.recycleviewevent.data;

/**
 * @author zwl
 * @date on 2019-12-02
 */
public class MyData {
    public static final int TYPE_NAME = 100;
    public static final int TYPE_VIEWPAGER = 101;
    public static final int TYPE_LIST = 102;
    public int type;
    public String name;

    public MyData(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public MyData() {
    }

    @Override
    public String toString() {
        return "MyData{" +
                "type=" + type +
                ", name=" + name +
                '}';
    }
}
