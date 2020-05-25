package org.supsys.common.functional.function;

import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * User: sunheavenvan@gmail.com
 * Time: 下午7:08
 * Description:
 */
@FunctionalInterface
public interface FunctionNR<T1> extends Consumer<T1>, FunctionType<Void> {

    default void apply(T1 _1){
        accept(_1);
    }

    @Override
    default Void apply(Object... args) {
        Object[] argsTmp = new Object[3];
        System.arraycopy(args,0,argsTmp, 0, Math.min(args.length, argsTmp.length));
        apply((T1)argsTmp[0]);
        return null;
    }
}
