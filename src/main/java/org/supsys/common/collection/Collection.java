package org.supsys.common.collection;


import org.supsys.common.functional.function.BooleanFunction;
import org.supsys.common.functional.maybe.Maybe;
import org.supsys.common.functional.tuple.Tuple;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.supsys.common.functional.maybe.Maybe.just;
import static org.supsys.common.functional.maybe.Maybe.nothing;

public class Collection {

    public static <T> List<T> list(T... values){
        return JList.list(values);
    }

    public static <K,V> Map<K, V> map(Tuple<K, V>... tuples){
        return JMap.map(tuples);
    }

    public static <T> Set<T> set(T... values) {
        return JSet.set(values);
    }

    public static <T> Maybe<T> firstMatch(java.util.Collection<T> list, BooleanFunction<T> condition){
        for(T o: list){
            if (condition.apply(o)) return just(o);
        }
        return nothing();
    }
}
