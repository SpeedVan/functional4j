package org.supsys.common.functional.matcher;


import net.jodah.typetools.TypeResolver;
import org.supsys.common.functional.function.Function;

import java.util.HashMap;
import java.util.Map;

/**
 * 作为语法支持的函数，不能使用函数，否则会递归调用，如FMap, FHashMap, Maybe
 * @param <T>
 * @param <R>
 */
public class Matcher<T, R> implements Function<T, R> {

    private Map<Class, Function<? extends T, R>> functionMap = new HashMap<>();

    public Matcher<T, R> match(Function<? extends T, R> f){
        Class<?>[] typeArgs = TypeResolver.resolveRawArguments(Function.class, f.getClass());
        functionMap.put(typeArgs[0], f);
        return this;
    }

    @Override
    public R apply(T a){
        Function<? extends T, R> f = functionMap.get(a.getClass());
        if(f == null) throw new RuntimeException("Pattern matcher type["+a.getClass()+"] missing");
        return f.apply(a);
    }
}
