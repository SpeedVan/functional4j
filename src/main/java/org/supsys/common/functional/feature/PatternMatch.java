package org.supsys.common.functional.feature;

import org.supsys.common.functional.function.FunctionType;

/**
 * 需要这个的原因：存在对一堆具有析构需求的数据结构，进行集体析构
 */
public interface PatternMatch {

    /**
     * pattern match
     * 这方法不能类型推导，也就是说抽象成PatternMatch的时候是无法推导的，
     * PatternMatch只能约束必须要有一个（无法推导的）pm方法，方便底层处理，
     * 业务逻辑上是根本不需要抽象成PatternMatch的。
     * @param f
     * @param <R>
     * @return
     */
    <R> R pm(FunctionType<R> f);
}
