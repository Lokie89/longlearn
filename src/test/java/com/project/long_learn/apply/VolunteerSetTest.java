package com.project.long_learn.apply;

import com.project.long_learn.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

class VolunteerSetTest {

    VolunteerSet volunteerSet = new VolunteerSet(new LinkedHashSet<>());

    @BeforeEach
    void setUp() {
        volunteerSet.add(new Volunteer(new Member(3)));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {

    }

    @Test
    void contains() {
        assertTrue(volunteerSet.contains(new Volunteer(new Member(3))));
    }
}