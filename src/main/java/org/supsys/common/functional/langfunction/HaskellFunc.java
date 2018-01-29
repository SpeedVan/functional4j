package org.supsys.common.functional.langfunction;

import org.supsys.common.functional.matcher.Matcher;
import org.supsys.common.functional.maybe.Just;
import org.supsys.common.functional.maybe.Maybe;
import org.supsys.common.functional.maybe.Nothing;
import org.supsys.common.functional.tuple.Tuple;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiFunction;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.supsys.common.functional.maybe.Maybe.just;
import static org.supsys.common.functional.maybe.Maybe.nothing;
import static org.supsys.common.functional.tuple.Tuple.t;

public class HaskellFunc {

    public static <I> I head(Stream<I> l){
        return l.iterator().next();
    }

    public static <I> Stream<I> tail(Stream<I> l){
        Iterator<I> i = l.iterator();
        i.next();//丢弃第一个
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(i, Spliterator.ORDERED), false);
    }

    public static <I> Tuple<Maybe<I>, Stream<I>> headTail(Stream<I> l){
        Iterator<I> iter = l.iterator();
        if(!iter.hasNext())
            return t(nothing(), l);
        else
            return t(just(iter.next()), StreamSupport.stream(Spliterators.spliteratorUnknownSize(iter, Spliterator.ORDERED), false));
    }

    public static <Z,I> Z foldl(BiFunction<Z,I,Z> f, Z zero, Stream<I> l){
//        Iterator<I> iter = l.iterator();
//        if(!iter.hasNext()) return zero;
//        I head = iter.next();
//        Stream<I> tail = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iter, Spliterator.ORDERED), false);

        return headTail(l).pm((Maybe<I> mb_head, Stream<I> tail)->
            mb_head.pm(new Matcher<Maybe, Z>()
                    .match((Nothing n)->zero)
                    .match((Just<I> v)->foldl(f,f.apply(zero,v.value),tail))
            )
        );

//        return foldl(f,f.apply(zero,head),tail);
    }

    public static void main(String[] args) {
        Stream<Integer> s = Stream.of(1,2,3,4,5,6,7);
        System.out.println(foldl((r,i)->r+i, 0, s));
    }
}
