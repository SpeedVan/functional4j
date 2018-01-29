package org.supsys.common.functional.stream;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamUtils {

    public static <T> Stream<T> parse(Iterable<T> iterable){
        return parse(iterable.iterator());
    }

    public static <T> Stream<T> parse(Iterator<T> iterator){
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED),false);
    }
}
