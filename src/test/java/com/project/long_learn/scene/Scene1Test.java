package com.project.long_learn.scene;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerRole;
import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Study;
import com.project.long_learn.group.StudyDay;
import com.project.long_learn.group.StudyDays;
import com.project.long_learn.group.StudyLocation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Scene1Test {
    // SCENE #1 Test
    StudyCondition.Builder defaultBuilder = new StudyCondition.Builder().start(LocalDate.now()).end(LocalDate.now()).studyDay(new StudyDays(new StudyDay(DayOfWeek.FRIDAY, LocalTime.NOON))).location(new StudyLocation(1,1,"강남"));
    Study study = new Study(3, defaultBuilder.build());
    Volunteer volunteer = new Volunteer(new Member(1), VolunteerRole.STUDENT);

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void 지원해야겠다() {
        study.involve(volunteer);
        assertTrue(study.isContain(volunteer));
    }
}
