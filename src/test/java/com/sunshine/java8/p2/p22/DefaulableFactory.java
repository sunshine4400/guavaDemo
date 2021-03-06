package com.sunshine.java8.p2.p22;

import java.util.function.Supplier;

/**
 * @Author changwenhu
 * @Date 2017/10/10
 * @Blog https://jetbrains.org.cn/
 * @Description ${todo}
 */
public interface DefaulableFactory {
    // Interfaces now allow static methods
    static Defaulable create(Supplier<Defaulable> supplier) {
        return supplier.get();
    }


}
