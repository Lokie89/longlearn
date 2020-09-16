package com.project.long_learn.grouplist;

import com.project.long_learn.condition.Condition;

/**
 * 그룹으로 이뤄진 리스트들을 다루기 위한 인터페이스
 */
public interface GroupList{
    GroupList filter(Condition condition);
    GroupList sort(Condition condition);
}
