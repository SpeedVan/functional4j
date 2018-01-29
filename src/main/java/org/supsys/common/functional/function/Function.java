package org.supsys.common.functional.function;

@FunctionalInterface
public interface Function<T1, R> extends java.util.function.Function<T1, R>, FunctionType<R> {

    @Override
    default R apply(Object... args) {
        Object[] argsTmp = new Object[1];
        System.arraycopy(args,0,argsTmp, 0, Math.min(args.length, argsTmp.length));
        return apply((T1)argsTmp[0]);
    }
}
