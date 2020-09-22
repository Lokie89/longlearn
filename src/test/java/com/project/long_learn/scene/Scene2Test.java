package com.project.long_learn.scene;

import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.condition.StudyDay;
import com.project.long_learn.condition.StudyLocation;
import com.project.long_learn.group.Study;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

public class Scene2Test {
    // SCENE #2 Test
    Study study;

    @BeforeEach
    void setUp() {
        study = new Study(6, new StudyCondition.Builder()
                .recruitmentLimit(2020, 9, 20, 00, 00)
                .start(2020, 9, 30)
                .end(2020, 10, 30)
                .costPerClass(5000)
                .minTeacher(1)
                .minStudent(6)
                .maxStudent(10)
                .location(StudyLocation.of("홍대역 땡땡스터디룸"))
                .studyDay(StudyDay.of(DayOfWeek.MONDAY, 19, 00, 21, 00), StudyDay.of(DayOfWeek.TUESDAY, 19, 00, 21, 00))
                .description("책은 땡땡쿠버네티스로 하겠습니다.\n 첫 수업은 맛보기 입니다.")
                .build());
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void scene1_1() {
    }

    @Test
    void scene1_2() {
    }

    @Test
    void scene1_3() {
    }

    @Test
    void scene1_4() {
    }
}
