package org.supsys.common.collection;

import org.supsys.common.functional.function.Function;
import org.supsys.common.functional.maybe.Maybe;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.supsys.common.functional.maybe.Maybe.just;
import static org.supsys.common.functional.maybe.Maybe.nothing;

public interface FList<T> extends List<T>, FCollection<T> {

    default Maybe<T> _get(int index){
        T result = get(index);
        return result==null?nothing():just(result);
    }

    default FList<T> _update(int index, T v){
        add(index, v);
        return this;
    }

    default <R> FList<R> _map(Function<T, R> f){
        return stream().map(f).collect(Collectors.toCollection(FArrayList::new));
    }

    static <T,L extends List<T>> L list(T... values) {
        return (L) Stream.of(values).collect(Collectors.toCollection(FArrayList::new));
    }
}
