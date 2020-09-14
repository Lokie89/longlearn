package com.project.long_learn.apply;

import com.project.long_learn.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VolunteerSetTest {

    VolunteerSet volunteerSet = new VolunteerSet(new LinkedHashSet<>());

    @BeforeEach
    void setUp() {
        volunteerSet.add(new Volunteer(new Member(3), VolunteerRole.STUDENT));
        volunteerSet.add(new Volunteer(new Member(4), VolunteerRole.STUDENT));
        volunteerSet.add(new Volunteer(new Member(5), VolunteerRole.STUDENT));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void contains() {
        assertTrue(volunteerSet.contains(new Volunteer(new Member(3), VolunteerRole.STUDENT)));
        assertTrue(volunteerSet.contains(new Volunteer(new Member(3), VolunteerRole.TEACHER)));
        assertTrue(volunteerSet.contains(new Volunteer(new Member(5), VolunteerRole.STUDENT)));
    }

    @Test
    void size(){
        assertEquals(3, volunteerSet.size());
    }

    @Test
    void size2(){
        volunteerSet.remove(new Volunteer(new Member(3), VolunteerRole.STUDENT));
        volunteerSet.remove(new Volunteer(new Member(3), VolunteerRole.TEACHER));
        assertEquals(2, volunteerSet.size());
    }
}