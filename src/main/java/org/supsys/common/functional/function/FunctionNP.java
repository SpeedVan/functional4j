package org.supsys.common.functional.function;

import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 * User: shizhiyin@finupgroup.com
 * Time: 下午8:11
 * Description:
 */
@FunctionalInterface
public interface FunctionNP<R> extends Supplier<R>, FunctionType<R> {

    default R apply(){
        return get();
    }

    @Override
    default R apply(Object... args) {
        return apply();
    }
}
