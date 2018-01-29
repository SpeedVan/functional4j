package org.supsys.common.functional.function;

/**
 * Created with IntelliJ IDEA.
 * User: shizhiyin@finupgroup.com
 * Time: 下午7:20
 * Description:
 */
@FunctionalInterface
public interface Function3NR<T1, T2, T3> extends FunctionType<Void> {

    void apply(T1 _1, T2 _2, T3 _3);

    @Override
    default Void apply(Object... args) {
        Object[] argsTmp = new Object[3];
        System.arraycopy(args,0,argsTmp, 0, Math.min(args.length, argsTmp.length));
        apply((T1)argsTmp[0], (T2)argsTmp[1], (T3)argsTmp[2]);
        return null;
    }
}
