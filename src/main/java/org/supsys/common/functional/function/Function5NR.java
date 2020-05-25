package org.supsys.common.functional.function;

/**
 * Created with IntelliJ IDEA.
 * User: sunheavenvan@gmail.com
 * Time: 下午8:02
 * Description:
 */
@FunctionalInterface
public interface Function5NR<T1, T2, T3, T4, T5> extends FunctionType<Void> {

    void apply(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5);

    @Override
    default Void apply(Object... args) {
        Object[] argsTmp = new Object[5];
        System.arraycopy(args,0,argsTmp, 0, Math.min(args.length, argsTmp.length));
        apply((T1)argsTmp[0], (T2)argsTmp[1], (T3)argsTmp[2], (T4)argsTmp[3], (T5)argsTmp[4]);
        return null;
    }
}
