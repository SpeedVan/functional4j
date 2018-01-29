package org.supsys.common.functional.function;

/**
 * Func是所有函数的抽象，注意这是底层接口，业务上是极不可能用到这个的，用到了也想办法切换抽象方式。
 */
@FunctionalInterface
public interface FunctionType<R> {

    R apply(Object... args);
}
