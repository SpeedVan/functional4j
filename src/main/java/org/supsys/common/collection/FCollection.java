package org.supsys.common.collection;

import org.supsys.common.functional.function.BooleanFunction;
import org.supsys.common.functional.maybe.Maybe;

import static org.supsys.common.functional.maybe.Maybe.just;
import static org.supsys.common.functional.maybe.Maybe.nothing;

public interface FCollection<T> extends Iterable<T> {

    static <T> Maybe<T> firstMatch(FCollection<T> list, BooleanFunction<T> condition){
        for(T o: list){
            if (condition.apply(o)) return just(o);
        }
        return nothing();
    }
}
