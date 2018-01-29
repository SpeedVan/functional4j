package org.supsys.common.functional.function;

import java.util.function.BiFunction;

@FunctionalInterface
public interface Function2<T1, T2, R> extends BiFunction<T1, T2, R>, FunctionType<R> {

    @Override
    default R apply(Object... args) {
        Object[] argsTmp = new Object[2];
        System.arraycopy(args,0,argsTmp, 0, Math.min(args.length, argsTmp.length));
        return apply((T1)argsTmp[0], (T2)argsTmp[1]);
    }
}
