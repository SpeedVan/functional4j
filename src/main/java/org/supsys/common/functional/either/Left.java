package org.supsys.common.functional.either;

public class Left<T> implements Either<T, Void> {

    public final T value;

    public Left(T value) {
        this.value = value;
    }
}
