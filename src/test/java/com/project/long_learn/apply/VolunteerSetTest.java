package com.project.long_learn.apply;

import com.project.long_learn.condition.VolunteerCondition;
import com.project.long_learn.domain.Member;
import com.project.long_learn.alignable.VolunteerSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VolunteerSetTest {

    VolunteerSet volunteerSet = new VolunteerSet();

    @BeforeEach
    void setUp() {
        volunteerSet.add(new Volunteer(new Member(3), VolunteerCondition.of(VolunteerRole.STUDENT)));
        volunteerSet.add(new Volunteer(new Member(4), VolunteerCondition.of(VolunteerRole.STUDENT)));
        volunteerSet.add(new Volunteer(new Member(5), VolunteerCondition.of(VolunteerRole.STUDENT)));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void contains() {
        assertTrue(volunteerSet.contains(new Volunteer(new Member(3), VolunteerCondition.of(VolunteerRole.STUDENT))));
        assertTrue(volunteerSet.contains(new Volunteer(new Member(3), VolunteerCondition.of(VolunteerRole.TEACHER))));
        assertTrue(volunteerSet.contains(new Volunteer(new Member(5), VolunteerCondition.of(VolunteerRole.STUDENT))));
    }

    @Test
    void size(){
        assertEquals(3, volunteerSet.size());
    }

    @Test
    void size2(){
        volunteerSet.remove(new Volunteer(new Member(3), VolunteerCondition.of(VolunteerRole.STUDENT)));
        volunteerSet.remove(new Volunteer(new Member(3), VolunteerCondition.of(VolunteerRole.TEACHER)));
        assertEquals(2, volunteerSet.size());
    }

    @Test
    void compareTest(){
        volunteerSet.add(new Volunteer(new Member(12), VolunteerCondition.of(VolunteerRole.TEACHER)));
        volunteerSet.add(new Volunteer(new Member(13), VolunteerCondition.of(VolunteerRole.STUDENT)));
        volunteerSet.add(new Volunteer(new Member(8), VolunteerCondition.of(VolunteerRole.TEACHER)));
        volunteerSet.add(new Volunteer(new Member(9), VolunteerCondition.of(VolunteerRole.STUDENT)));
        volunteerSet.add(new Volunteer(new Member(10), VolunteerCondition.of(VolunteerRole.TEACHER)));
        volunteerSet.add(new Volunteer(new Member(11), VolunteerCondition.of(VolunteerRole.STUDENT)));
        volunteerSet.add(new Volunteer(new Member(6), VolunteerCondition.of(VolunteerRole.STUDENT)));

        volunteerSet.copy().filter(VolunteerCondition.of(VolunteerRole.TEACHER)).sort(Volunteer.VolunteerComparator.ID);
    }
}