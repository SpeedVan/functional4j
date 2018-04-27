package org.supsys.common.collection;

import org.supsys.common.functional.feature.PatternMatch;
import org.supsys.common.functional.function.Function;
import org.supsys.common.functional.function.FunctionType;
import org.supsys.common.functional.matcher.Matcher;
import org.supsys.common.functional.maybe.Just;
import org.supsys.common.functional.maybe.Maybe;
import org.supsys.common.functional.maybe.Nothing;
import org.supsys.common.functional.tuple.Tuple;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.supsys.common.functional.langfunction.HaskellFunc.foldl;
import static org.supsys.common.functional.maybe.Maybe.just;
import static org.supsys.common.functional.maybe.Maybe.nothing;
import static org.supsys.common.functional.tuple.Tuple.t;

public interface FMap<K,V> extends Map<K,V>, FCollection<Tuple<K,V>>, PatternMatch {

    default FMap<K, V> _update(K key, V zero, Function<V,V> atom){
        return _get(key).pm(Matcher.<Maybe<V>, FMap<K,V>>
                firstMatch((Nothing<V> n)->_put(key, atom.apply(zero)))
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

    default Maybe<Tuple<K,V>> _getByIndex(int index){
        if(index>=size()){
            return nothing();
        }
        final int[] i={0};
        return FCollection.firstMatch(this, a->i[0]++==index);
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

    default <K2, V2> FMap<K2, V2> _map(Function<Tuple<K,V>, Tuple<K2, V2>> f){
        return entrySet().stream()
                .map(e->f.apply(t(e.getKey(), e.getValue())))
                .collect(Collectors.<Tuple<K2,V2>, K2, V2, FMap<K2,V2>>toMap(a->a._1,a->a._2, (v1,v2)->v2,FHashMap::new));
    }

    default FSet<Tuple<K, V>> _tuples(){
        return entrySet().stream().map(e->t(e.getKey(), e.getValue())).collect(Collectors.toCollection(FHashSet::new));
    }

    default <R> R pm(Function<FSet<Tuple<K, V>>, R> f) {
        return f.apply(_tuples());
    }

    @Override
    default <R> R pm(FunctionType<R> f) {
        return pm((Function<FSet<Tuple<K, V>>, R>) f);
    }

    static <K,V, M extends Map<K,V>> M map(Tuple<K, V>... tuples){
        return (M)foldl((r,i)->{
            r.put(i._1,i._2);
            return r;
        },new FHashMap<K,V>(), Stream.of(tuples));
    }
}
