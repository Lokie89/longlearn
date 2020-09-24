package com.project.long_learn.alignable;

import com.project.long_learn.condition.Condition;

import java.util.Comparator;
import java.util.function.Predicate;

/**
 * 그룹으로 이뤄진 리스트들을 다루기 위한 인터페이스
 */
public interface Alignable<T> {
    Alignable filter(Condition condition);
    Alignable sort(Comparator<T> comparator);
    int size();
    Alignable copy();
}
