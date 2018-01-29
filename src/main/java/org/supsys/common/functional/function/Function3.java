package org.supsys.common.functional.function;

@FunctionalInterface
public interface Function3<T1, T2, T3, R> extends FunctionType<R> {

    R apply(T1 _1, T2 _2, T3 _3);

    @Override
    default R apply(Object... args) {
        Object[] argsTmp = new Object[3];
        System.arraycopy(args,0,argsTmp, 0, Math.min(args.length, argsTmp.length));
        return apply((T1)argsTmp[0], (T2)argsTmp[1], (T3)argsTmp[2]);
    }
}
