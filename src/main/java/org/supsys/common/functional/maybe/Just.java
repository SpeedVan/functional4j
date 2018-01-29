package org.supsys.common.functional.maybe;

public class Just<T> implements Maybe<T> {
    public final T value;

    public Just(T value){
        this.value = value;
    }
}
