package com.project.long_learn.apply;

import com.project.long_learn.group.Group;

/**
 * 지원 하다.
 * 이 메서드는 지원할 객체를 매개 변수로 받아 객체의 상태를 변화 시켜줌
 */
public interface Apply {
    void apply(Group group);

    boolean isApplied();
}