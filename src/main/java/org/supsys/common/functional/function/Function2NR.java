package org.supsys.common.functional.function;

/**
 * Created with IntelliJ IDEA.
 * User: shizhiyin@finupgroup.com
 * Time: 下午7:16
 * Description:
 */
@FunctionalInterface
public interface Function2NR<T1, T2> extends FunctionType<Void> {

    void apply(T1 _1, T2 _2);

    @Override
    default Void apply(Object... args) {
        Object[] argsTmp = new Object[3];
        System.arraycopy(args,0,argsTmp, 0, Math.min(args.length, argsTmp.length));
        apply((T1)argsTmp[0], (T2)argsTmp[1]);
        return null;
    }
}
