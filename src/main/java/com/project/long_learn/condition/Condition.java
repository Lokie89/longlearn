package com.project.long_learn.condition;

import java.util.Comparator;

/**
 * 조건과 해당 조건을 검사함
 */
public interface Condition {
    boolean isSatisfiedCondition(Condition condition);
    int compareCondition(Condition condition, Comparator comparator);
}
