package org.supsys.common.functional.tuple;

import org.supsys.common.functional.feature.PatternMatch;
import org.supsys.common.functional.function.FunctionType;
import org.supsys.common.functional.function.Function3;

public class Tuple3<T1, T2, T3> implements TupleType {
    public final T1 _1;
    public final T2 _2;
    public final T3 _3;

    public Tuple3(T1 _1, T2 _2, T3 _3){
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
    }

    public static <T1, T2, T3> Tuple3<T1, T2, T3> t(T1 _1, T2 _2, T3 _3){
        return new Tuple3<>(_1, _2, _3);
    }

    /**
     * pattern match
     * @param f
     * @param <R>
     * @return
     */
    public <R> R pm(Function3<T1, T2, T3, R> f){
        return f.apply(_1,_2,_3);
    }

    @Override
    public <R> R pm(FunctionType<R> f) {
        return pm((Function3<T1,T2,T3,R>)f);
    }

    @Override
    public String toString() {
        return "("+_1+","+_2+","+_3+")";
    }
}
