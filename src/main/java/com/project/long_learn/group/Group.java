package com.project.long_learn.group;

import com.project.long_learn.apply.Apply;

/**
 * 그룹.
 * 이 메서드는 포함할 객체를 매개 변수로 받아 객체의 상태를 변화 시켜줌
 * 변화된 객체의 일정 상태 값을 반환해줌
 */
public interface Group<E extends Apply> {
    int involve(E apply);
    int except(E apply);
    boolean isContain(E apply);
}
