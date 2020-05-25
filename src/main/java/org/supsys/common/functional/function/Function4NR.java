package org.supsys.common.functional.function;

/**
 * Created with IntelliJ IDEA.
 * User: sunheavenvan@gmail.com
 * Time: 下午8:01
 * Description:
 */
@FunctionalInterface
public interface Function4NR<T1, T2, T3, T4> extends FunctionType<Void> {

    void apply(T1 _1, T2 _2, T3 _3, T4 _4);

    @Override
    default Void apply(Object... args) {
        Object[] argsTmp = new Object[4];
        System.arraycopy(args,0,argsTmp, 0, Math.min(args.length, argsTmp.length));
        apply((T1)argsTmp[0], (T2)argsTmp[1], (T3)argsTmp[2], (T4)argsTmp[3]);
        return null;
    }
}
