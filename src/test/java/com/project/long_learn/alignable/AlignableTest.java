package com.project.long_learn.alignable;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerRole;
import com.project.long_learn.condition.StudyCondition;
import com.project.long_learn.condition.StudyDay;
import com.project.long_learn.condition.StudyLocation;
import com.project.long_learn.condition.VolunteerCondition;
import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Study;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

class AlignableTest {

    VolunteerSet volunteerSet;

    StudyList studyList;

    Member master = new Member(1);

    @BeforeEach
    void setUp() {
        volunteerSet = new VolunteerSet();
        volunteerSet.add(new Volunteer(new Member(1), VolunteerCondition.of(VolunteerRole.STUDENT)));
        volunteerSet.add(new Volunteer(new Member(4), VolunteerCondition.of(VolunteerRole.STUDENT)));
        volunteerSet.add(new Volunteer(new Member(3), VolunteerCondition.of(VolunteerRole.TEACHER, true)));
        volunteerSet.add(new Volunteer(new Member(5), VolunteerCondition.of(VolunteerRole.TEACHER)));
        volunteerSet.add(new Volunteer(new Member(2), VolunteerCondition.of(VolunteerRole.STUDENT)));
        volunteerSet.add(new Volunteer(new Member(8), VolunteerCondition.of(VolunteerRole.STUDENT)));
        volunteerSet.add(new Volunteer(new Member(9), VolunteerCondition.of(VolunteerRole.TEACHER)));
        volunteerSet.add(new Volunteer(new Member(35), VolunteerCondition.of(VolunteerRole.STUDENT)));
        volunteerSet.add(new Volunteer(new Member(20), VolunteerCondition.of(VolunteerRole.STUDENT)));


        List<Study> studies = new ArrayList<>();
        studies.add(new Study(1, new StudyCondition.Builder().start(2020, 10, 1).end(2020, 10, 30).recruitmentLimit(2020, 9, 27, 00, 00).day(StudyDay.of(DayOfWeek.MONDAY)).location(StudyLocation.of("홍대")).costPerClass(1257).maxStudent(3).master(master).build()));
        studies.add(new Study(2, new StudyCondition.Builder().start(2020, 9, 30).end(2020, 10, 30).recruitmentLimit(2020, 9, 26, 00, 00).day(StudyDay.of(DayOfWeek.THURSDAY)).location(StudyLocation.of("강남")).costPerClass(555).master(master).build()));
        studies.add(new Study(4, new StudyCondition.Builder().start(2020, 9, 30).end(2020, 10, 30).recruitmentLimit(2020, 9, 27, 00, 00).day(StudyDay.of(DayOfWeek.TUESDAY)).location(StudyLocation.of("홍대")).costPerClass(500880).master(master).build()));
        studies.add(new Study(8, new StudyCondition.Builder().start(2020, 9, 30).end(2020, 10, 30).recruitmentLimit(2020, 9, 25, 00, 00).day(StudyDay.of(DayOfWeek.THURSDAY)).location(StudyLocation.of("압구정")).costPerClass(55).master(master).build()));
        studies.add(new Study(5, new StudyCondition.Builder().start(2020, 10, 8).end(2020, 10, 30).recruitmentLimit(2020, 9, 26, 00, 00).day(StudyDay.of(DayOfWeek.MONDAY)).location(StudyLocation.of("강남")).costPerClass(110).maxStudent(41).master(master).build()));
        studies.add(new Study(3, new StudyCondition.Builder().start(2020, 9, 30).end(2020, 10, 30).recruitmentLimit(2020, 9, 22, 00, 00).day(StudyDay.of(DayOfWeek.THURSDAY)).location(StudyLocation.of("홍대")).costPerClass(77).master(master).build()));
        studies.add(new Study(10, new StudyCondition.Builder().start(2020, 9, 30).end(2020, 10, 30).recruitmentLimit(2020, 9, 20, 00, 00).day(StudyDay.of(DayOfWeek.MONDAY)).location(StudyLocation.of("강남")).costPerClass(60).maxStudent(333).master(master).build()));
        studies.add(new Study(9, new StudyCondition.Builder().start(2020, 10, 15).end(2020, 10, 30).recruitmentLimit(2020, 9, 19, 00, 00).day(StudyDay.of(DayOfWeek.MONDAY)).location(StudyLocation.of("홍대")).costPerClass(200).maxStudent(66).master(master).build()));
        studies.add(new Study(15, new StudyCondition.Builder().start(2020, 9, 30).end(2020, 10, 30).recruitmentLimit(2020, 9, 27, 00, 00).day(StudyDay.of(DayOfWeek.THURSDAY)).location(StudyLocation.of("홍대")).costPerClass(1).master(master).build()));
        studies.add(new Study(7, new StudyCondition.Builder().start(2020, 9, 30).end(2020, 10, 30).recruitmentLimit(2020, 9, 28, 00, 00).day(StudyDay.of(DayOfWeek.TUESDAY)).location(StudyLocation.of("강남")).costPerClass(80).master(master).build()));
        studies.add(new Study(20, new StudyCondition.Builder().start(2020, 10, 5).end(2020, 10, 30).recruitmentLimit(2020, 9, 20, 00, 00).day(StudyDay.of(DayOfWeek.MONDAY)).location(StudyLocation.of("홍대")).costPerClass(48).maxStudent(1).master(master).build()));
        studies.add(new Study(6, new StudyCondition.Builder().start(2020, 9, 30).end(2020, 10, 30).recruitmentLimit(2020, 9, 2, 00, 00).day(StudyDay.of(DayOfWeek.TUESDAY)).location(StudyLocation.of("압구정")).costPerClass(77).master(master).build()));
        studyList = new StudyList(studies);
    }

    @Test
    void filter() {
        volunteerSet.filter(VolunteerCondition.of(VolunteerRole.STUDENT));
        Assertions.assertTrue(volunteerSet.size() == 6);

        studyList.filter(new StudyCondition.Builder().location(StudyLocation.of("강남")).build());
        Assertions.assertTrue(studyList.size() == 4);
        studyList.filter(new StudyCondition.Builder().day(StudyDay.of(DayOfWeek.MONDAY)).build());
        Assertions.assertTrue(studyList.size() == 2);
    }

    @Test
    void filter2() {
        volunteerSet.filter(VolunteerCondition.of(VolunteerRole.TEACHER, true));
        Assertions.assertTrue(volunteerSet.size() == 1);
    }

    @Test
    void sort() {
        volunteerSet.sort(Volunteer.VolunteerComparator.ROLE.reversed()).sort(Volunteer.VolunteerComparator.PASSED);

        studyList.sort(Study.StudyComparator.COSTPERCLASS.reversed());
    }

}