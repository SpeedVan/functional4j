package org.supsys.common.collection;

import org.supsys.common.functional.tuple.Tuple;

import java.util.Map;
import java.util.stream.Stream;

import static org.supsys.common.functional.langfunction.HaskellFunc.foldl;

public class JMap {

    public static <K,V, M extends Map<K,V>> M map(Tuple<K, V>... tuples){
        return (M)foldl((r,i)->{
            r.put(i._1,i._2);
            return r;
        },new FHashMap<K,V>(), Stream.of(tuples));
    }

}
