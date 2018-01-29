package org.supsys.common.functional.maybe;

import org.supsys.common.functional.feature.PatternMatch;
import org.supsys.common.functional.function.FunctionType;
import org.supsys.common.functional.matcher.Matcher;

public interface Maybe<T> extends PatternMatch {

    Nothing NOTHING = new Nothing<>();

    default <R> R pm(Matcher<Maybe<T>, R> matcher){
        return matcher.apply(this);
    }

    @Override
    default <R> R pm(FunctionType<R> f){
        return pm((Matcher<Maybe<T>, R>)f);
    }

    static <V> Just<V> just(V v){
        return new Just<>(v);
    }

    static <V> Nothing<V> nothing() {
        return Maybe.NOTHING;
    }
}
