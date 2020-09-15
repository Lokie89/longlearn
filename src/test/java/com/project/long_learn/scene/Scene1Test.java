package com.project.long_learn.scene;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerRole;
import com.project.long_learn.domain.Member;
import com.project.long_learn.group.LectureStudy;
import com.project.long_learn.group.Study;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Scene1Test {
    // SCENE #1 Test

    Study study = new LectureStudy(3);
    Volunteer volunteer = new Volunteer(new Member(1), VolunteerRole.STUDENT);

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void 지원해야겠다() {
        volunteer.apply(study);
        assertTrue(study.isContain(volunteer));
    }
}
