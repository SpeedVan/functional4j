package org.supsys.common.functional.either;

import org.supsys.common.functional.feature.PatternMatch;
import org.supsys.common.functional.function.FunctionType;
import org.supsys.common.functional.matcher.Matcher;


public interface Either<L, R> extends PatternMatch {

    default <Re> Re pm(Matcher<Either, Re> matcher){
        return matcher.apply(this);
    }

    @Override
    default <Re> Re pm(FunctionType<Re> f) {
        return pm((Matcher<Either, Re>) f);
    }

    static <V> Left<V> left(V v){
        return new Left<>(v);
    }

    static <V> Right<V> right(V v){
        return new Right<>(v);
    }

}
