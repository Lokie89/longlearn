package com.project.long_learn.alignable;

import com.project.long_learn.apply.Volunteer;
import com.project.long_learn.apply.VolunteerRole;
import com.project.long_learn.condition.*;
import com.project.long_learn.domain.Member;
import com.project.long_learn.group.Study;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        studies.add(new Study(1, new StudyCondition.EssentialBuilder(master,LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 30), LocalDateTime.of(2020, 9, 27, 00, 00), new StudyDays(StudyDay.of(DayOfWeek.MONDAY)), new Locations(Location.of("홍대"))).costPerClass(1257).maxStudent(3)));
        studies.add(new Study(2, new StudyCondition.EssentialBuilder(master,LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 30), LocalDateTime.of(2020, 9, 27, 00, 00), new StudyDays(StudyDay.of(DayOfWeek.TUESDAY)), new Locations(Location.of("강남"))).costPerClass(555)));
        studies.add(new Study(4, new StudyCondition.EssentialBuilder(master,LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 30), LocalDateTime.of(2020, 9, 27, 00, 00), new StudyDays(StudyDay.of(DayOfWeek.MONDAY)), new Locations(Location.of("홍대"))).costPerClass(500880)));
        studies.add(new Study(8, new StudyCondition.EssentialBuilder(master,LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 30), LocalDateTime.of(2020, 9, 27, 00, 00), new StudyDays(StudyDay.of(DayOfWeek.MONDAY)), new Locations(Location.of("압구정"))).costPerClass(55)));
        studies.add(new Study(5, new StudyCondition.EssentialBuilder(master,LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 30), LocalDateTime.of(2020, 9, 27, 00, 00), new StudyDays(StudyDay.of(DayOfWeek.MONDAY)), new Locations(Location.of("강남"))).costPerClass(110)));
        studies.add(new Study(3, new StudyCondition.EssentialBuilder(master,LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 30), LocalDateTime.of(2020, 9, 27, 00, 00), new StudyDays(StudyDay.of(DayOfWeek.MONDAY)), new Locations(Location.of("홍대"))).costPerClass(77)));
        studies.add(new Study(10, new StudyCondition.EssentialBuilder(master,LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 30), LocalDateTime.of(2020, 9, 27, 00, 00), new StudyDays(StudyDay.of(DayOfWeek.MONDAY)), new Locations(Location.of("강남"))).costPerClass(60)));
        studies.add(new Study(9, new StudyCondition.EssentialBuilder(master,LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 30), LocalDateTime.of(2020, 9, 27, 00, 00), new StudyDays(StudyDay.of(DayOfWeek.MONDAY)), new Locations(Location.of("홍대"))).costPerClass(200)));
        studies.add(new Study(15, new StudyCondition.EssentialBuilder(master,LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 30), LocalDateTime.of(2020, 9, 27, 00, 00), new StudyDays(StudyDay.of(DayOfWeek.MONDAY)), new Locations(Location.of("홍대"))).costPerClass(1)));
        studies.add(new Study(7, new StudyCondition.EssentialBuilder(master,LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 30), LocalDateTime.of(2020, 9, 27, 00, 00), new StudyDays(StudyDay.of(DayOfWeek.THURSDAY)), new Locations(Location.of("강남"))).costPerClass(80)));
        studies.add(new Study(20, new StudyCondition.EssentialBuilder(master,LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 30), LocalDateTime.of(2020, 9, 27, 00, 00), new StudyDays(StudyDay.of(DayOfWeek.MONDAY)), new Locations(Location.of("홍대"))).costPerClass(48)));
        studies.add(new Study(6, new StudyCondition.EssentialBuilder(master,LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 30), LocalDateTime.of(2020, 9, 27, 00, 00), new StudyDays(StudyDay.of(DayOfWeek.MONDAY)), new Locations(Location.of("압구정"))).costPerClass(77)));
        studyList = new StudyList(studies);
    }

    @Test
    void filter() {
        volunteerSet.filter(VolunteerCondition.of(VolunteerRole.STUDENT));
        Assertions.assertTrue(volunteerSet.size() == 6);

        studyList.filter(new StudyCondition.Builder().locations(Location.of("강남")).build());
        Assertions.assertEquals(studyList.size(), 4);
        studyList.filter(new StudyCondition.Builder().day(StudyDay.of(DayOfWeek.MONDAY)).build());
        Assertions.assertEquals(studyList.size(), 2);
    }

    @Test
    void filter2() {
        volunteerSet.filter(VolunteerCondition.of(VolunteerRole.TEACHER, true));
        Assertions.assertEquals(volunteerSet.size(), 1);
    }

    @Test
    void sort() {
        volunteerSet.sort(Volunteer.VolunteerComparator.ROLE.reversed()).sort(Volunteer.VolunteerComparator.PASSED);

        studyList.sort(Study.StudyComparator.COSTPERCLASS.reversed());
    }

}