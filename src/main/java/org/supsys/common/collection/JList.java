package org.supsys.common.collection;

import org.supsys.common.functional.function.BooleanFunction;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JList {

    public static <T> List<T> list(T... values) {
        return Stream.of(values).collect(Collectors.toList());
    }

    public static <T> Optional<T> firstMatch(List<T> functions, BooleanFunction<T> condition){
        for(T o: functions){
            if (condition.apply(o)) return Optional.of(o);
        }
        return Optional.empty();
    }
}
