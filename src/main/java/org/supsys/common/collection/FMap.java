package org.supsys.common.collection;

import org.supsys.common.functional.feature.PatternMatch;
import org.supsys.common.functional.function.FunctionType;
import org.supsys.common.functional.function.Function;
import org.supsys.common.functional.matcher.Matcher;
import org.supsys.common.functional.maybe.Just;
import org.supsys.common.functional.maybe.Maybe;
import org.supsys.common.functional.maybe.Nothing;
import org.supsys.common.functional.tuple.Tuple;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.supsys.common.functional.maybe.Maybe.just;
import static org.supsys.common.functional.maybe.Maybe.nothing;
import static org.supsys.common.functional.tuple.Tuple.t;

public interface FMap<K,V> extends Map<K,V>, PatternMatch {

    default FMap<K, V> _update(K key, V zero, Function<V,V> atom){
        return _get(key).pm(new Matcher<Maybe<V>, FMap<K,V>>()
                .match((Nothing<V> n)->_put(key, atom.apply(zero)))
                .match((Just<V> v)->_put(key, atom.apply(v.value)))
        );
    }

    default FMap<K, V> _put(K key, V val){
        put(key, val);
        return this;
    }

    default Maybe<V> _get(K key){
        V result = get(key);
        return result == null? nothing():just(result);
    }

    default FMap<K, V> _remove(K key){
        remove(key);
        return this;
    }

    default FMap<K, V> _putAll(Map<? extends K, ? extends V> map){
        putAll(map);
        return this;
    }

    default FMap<K, V> _clear(){
        clear();
        return this;
    }

    default Set<Tuple<K, V>> _tuples(){
        return entrySet().stream().map(e->t(e.getKey(), e.getValue())).collect(Collectors.toSet());
    }

    default <R> R pm(Function<Set<Tuple<K, V>>, R> f) {
        return f.apply(_tuples());
    }

    @Override
    default <R> R pm(FunctionType<R> f) {
        return pm((Function<Set<Tuple<K, V>>, R>) f);
    }
}
