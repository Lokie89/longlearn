package com.project.long_learn.club;

import com.project.long_learn.Member;

/**
 * 포함하다.
 * 이 메서드는 포함할 객체를 매개 변수로 받아 객체의 상태를 변화 시켜줌
 * 변화된 객체의 일정 상태 값을 반환해줌
 */
public interface Club {
    int involve(Member member);
}