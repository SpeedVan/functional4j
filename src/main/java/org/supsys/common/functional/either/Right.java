package org.supsys.common.functional.either;

public class Right<T> implements Either<Void, T> {

    public final T value;

    public Right(T value) {
        this.value = value;
    }
}
