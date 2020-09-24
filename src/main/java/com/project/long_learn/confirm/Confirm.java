package com.project.long_learn.confirm;

public interface Confirm<E> {
    void pass(E e);
    void fail(E e);
}
