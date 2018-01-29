package org.supsys.common.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.supsys.common.functional.langfunction.HaskellFunc.foldl;

public class JSet {

    public static <T> Set<T> set(T... values) {
        return Stream.of(values).collect(Collectors.toSet());
    }

    /**
     * 并集
     * 跟 Set.addAll 等效
     * @param sets
     * @param <T>
     * @return
     */
    public static <T> Set<T> union(Set<T>... sets){
        return foldl((r,i)->{
            r.addAll(i);
            return r;
        } ,new HashSet<T>(), Stream.of(sets));
    }

    /**
     * 交集
     * 跟 Set.retainAll 等效
     * @param sets
     * @param <T>
     * @return
     */
    public static <T> Set<T> intersection(Set<T>... sets){
        return foldl((r,i)->{
            r.retainAll(i);
            return r;
        } ,new HashSet<T>(), Stream.of(sets));
    }

    /**
     * 补集（相对补集）
     * @param <T> 第一个为全集
     * @return
     */
    public static <T> Set<T> complementary(Set<T> universe, Set<T>... sets){
        return foldl((r,i)->{
            r.removeAll(i);
            return r;
        } ,new HashSet<>(universe), Stream.of(sets));
    }

}
