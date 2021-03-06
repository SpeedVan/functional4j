package org.supsys.common.collection;


import org.supsys.common.functional.tuple.Tuple;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collection {

    public static <T> List<T> list(T... values){
        return FList.list(values);
    }

    public static <K,V> Map<K, V> map(Tuple<K, V>... tuples){
        return FMap.map(tuples);
    }

    public static <T> Set<T> set(T... values) {
        return FSet.set(values);
    }


}
