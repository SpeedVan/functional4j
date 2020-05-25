package org.supsys.common.functional.function;

/**
 * Created with IntelliJ IDEA.
 * User: sunheavenvan@gmail.com
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
