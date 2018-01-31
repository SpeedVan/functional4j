package org.supsys.common.collection;

import org.supsys.common.functional.function.BooleanFunction;
import org.supsys.common.functional.maybe.Maybe;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.supsys.common.functional.maybe.Maybe.just;
import static org.supsys.common.functional.maybe.Maybe.nothing;

public class JList {

    public static <T,L extends List<T>> L list(T... values) {
        return (L)Stream.of(values).collect(Collectors.toCollection(FArrayList::new));
    }
}
