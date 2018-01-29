package org.supsys.common.functional.tuple;

import org.supsys.common.functional.feature.PatternMatch;
import org.supsys.common.functional.function.FunctionType;
import org.supsys.common.functional.function.Function5;

public class Tuple5<T1, T2, T3, T4, T5> implements TupleType {
    public final T1 _1;
    public final T2 _2;
    public final T3 _3;
    public final T4 _4;
    public final T5 _5;

    public Tuple5(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
    }

    public static <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> t(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5){
        return new Tuple5<>(_1, _2, _3, _4, _5);
    }

    /**
     * pattern match
     * @param f
     * @param <R>
     * @return
     */
    public <R> R pm(Function5<T1, T2, T3, T4, T5, R> f){
        return f.apply(_1,_2,_3,_4,_5);
    }

    @Override
    public <R> R pm(FunctionType<R> f) {
        return pm((Function5<T1,T2,T3,T4,T5,R>)f);
    }

    @Override
    public String toString() {
        return "("+_1+","+_2+","+_3+","+_4+","+_5+")";
    }
}
