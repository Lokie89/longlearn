package com.project.long_learn.scene;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerRole;
import com.project.long_learn.condition.StudyInformation;
import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Study;
import com.project.long_learn.group.StudyLocation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Scene1Test {
    // SCENE #1 Test
    StudyInformation defaultStudyInformation = new StudyInformation(LocalDate.now(), LocalDate.now(), new HashSet<>(), new StudyLocation());
    Study study = new Study(3, defaultStudyInformation);
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
