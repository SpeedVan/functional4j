package org.supsys.common.functional.function;

@FunctionalInterface
public interface Function5<T1, T2, T3, T4, T5, R> extends FunctionType<R> {

    R apply(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5);

    @Override
    default R apply(Object... args) {
        Object[] argsTmp = new Object[5];
        System.arraycopy(args,0,argsTmp, 0, Math.min(args.length, argsTmp.length));
        return apply((T1)argsTmp[0], (T2)argsTmp[1], (T3)argsTmp[2], (T4)argsTmp[3], (T5)argsTmp[4]);
    }
}
