package com.sunshine.java8.p2.p22;

/**
 * @Author changwenhu
 * @Date 2017/10/10
 * @Blog https://jetbrains.org.cn/
 * @Description ${todo}
 */
public class OverridableImpl implements Defaulable {
    @Override
    public String notRequired() {
        return "Overriding return value";
    }
}
