package org.supsys.common.functional.tuple;

import org.supsys.common.functional.feature.PatternMatch;
import org.supsys.common.functional.function.FunctionType;
import org.supsys.common.functional.function.Function2;

public class Tuple<T1, T2> implements TupleType {
    public final T1 _1;
    public final T2 _2;

    public Tuple(T1 _1, T2 _2){
        this._1 = _1;
        this._2 = _2;
    }

    public static <T1,T2> Tuple<T1, T2> t(T1 _1, T2 _2){
        return new Tuple<>(_1, _2);
    }

    /**
     * 支持类型推导的PatternMatch
     * @param f
     * @param <R>
     * @return
     */
    public <R> R pm(Function2<T1,T2,R> f) {
        return f.apply(_1,_2);
    }

    @Override
    public <R> R pm(FunctionType<R> f) {
        return pm((Function2<T1,T2,R>)f);
    }

    @Override
    public String toString() {
        return "("+_1+","+_2+")";
    }
}
