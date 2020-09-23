package com.project.long_learn.grouplist;

import com.project.long_learn.condition.Condition;

import java.util.Comparator;

/**
 * 그룹으로 이뤄진 리스트들을 다루기 위한 인터페이스
 */
public interface Alignable {
    Alignable filter(Condition condition);
    Alignable sort(Comparator comparator);
    int size();
}
