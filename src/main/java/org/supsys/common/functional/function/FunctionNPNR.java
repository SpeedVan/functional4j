package org.supsys.common.functional.function;

/**
 * Created with IntelliJ IDEA.
 * User: shizhiyin@finupgroup.com
 * Time: 下午8:08
 * Description:
 */
@FunctionalInterface
public interface FunctionNPNR extends FunctionType<Void> {

    void apply();

    @Override
    default Void apply(Object... args) {
        apply();
        return null;
    }
}
