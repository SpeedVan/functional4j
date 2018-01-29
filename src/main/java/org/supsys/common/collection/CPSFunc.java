package org.supsys.common.collection;


import org.supsys.common.functional.tuple.Tuple;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.supsys.common.functional.langfunction.HaskellFunc.foldl;

/**
 * 这里是临时存放满足Continuation-passing style函数，找到从属模块（类）时取消，
 * 当使用这里的函数一定要持续跟进，但发现使用的方法被@Deprecated后2个星期内必须修改为从属模块里的函数。
 */
public class CPSFunc {

    /**
     * 放到JMap类
     * @param tuples
     * @param <K>
     * @param <V>
     * @return
     */
    @Deprecated
    public static <K,V> Map<K, V> map(Tuple<K, V>... tuples){
        return foldl((r,i)->{
            r.put(i._1,i._2);
            return r;
        },new LinkedHashMap<>(),Stream.of(tuples));
    }

    /**
     * 该方法已补充在各个Tuple里，以满足所谓的多态
     * @param key
     * @param value
     * @param <K>
     * @param <V>
     * @return
     */
    @Deprecated
    public static <K,V> Tuple<K, V> t(K key, V value){
        return new Tuple<>(key, value);
    }






}
