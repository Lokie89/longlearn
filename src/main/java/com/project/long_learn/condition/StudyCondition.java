package com.project.long_learn.condition;

import com.project.long_learn.condition.exception.*;
import com.project.long_learn.domain.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class StudyCondition implements Condition {


    // 필드 재정의 시 Builder 와 Condition 메서드 내부 수정
    private final LocalDate start;
    private final LocalDate end;
    private final StudyDays studyDays;
    private final Locations locations;
    private final String description;
    private final int minStudent;
    private final int maxStudent;

    private final int minTeacher;
    private final int maxTeacher;

    private final int costPerClass;
    private final LocalDateTime recruitmentLimit;

    private final Member master;


    public void extend(long day) {
        end.plusDays(day);
    }

    /**
     * return StudyEssentialFieldNotSatisfiedException
     */
    private void validateEssentialField() {
        if (Objects.isNull(start)
                || Objects.isNull(end)) {
            throw new StudyDateIsNullException();
        }
        if (Objects.isNull(studyDays) || studyDays.isStudyDaysNull()) {
            throw new StudyDaysIsNullException();
        }
        if (Objects.isNull(locations) || locations.isLocationsEmpty()) {
            throw new StudyLocationIsNullException();
        }
        if (Objects.isNull(recruitmentLimit) || recruitmentLimit.isAfter(LocalDateTime.of(start, LocalTime.MIDNIGHT))) {
            throw new StudyRecruitmentLimitArrangeException();
        }
        if (Objects.isNull(master)) {
            throw new StudyMasterIsNotExistException();
        }
    }

    private void validateField() {
        if (!Objects.isNull(start) && !Objects.isNull(end) && start.isAfter(end)) {
            throw new StudyDateArrangeException();
        }
        if (!isUnlimitedStudent() && minStudent > maxStudent) {
            throw new StudyStudentArrangeException();
        }
        if ((!isUnlimitedTeacher() && maxTeacher == 0) || minTeacher > maxTeacher) {
            throw new StudyStudentArrangeException();
        }
        if (costPerClass < 0) {
            throw new StudyCostArrangeException();
        }
    }

    private boolean isUnlimitedStudent() {
        return minStudent == 0 && maxStudent == 0;
    }

    private boolean isUnlimitedTeacher() {
        return minTeacher == 0 && maxTeacher == 0;
    }

    public boolean isMaster(Member master) {
        return this.master.equals(master);
    }

    public boolean isSatisfiedStudentArrange(int passedStudent) {
        return passedStudent >= minStudent && passedStudent <= maxStudent;
    }

    public boolean isSatisfiedTeacherArrange(int passedTeacher) {
        return passedTeacher >= minTeacher && passedTeacher <= maxTeacher;
    }

    public boolean isSatisfiedRecruitment() {
        return recruitmentLimit.isAfter(LocalDateTime.now());
    }

    public int compareStart(StudyCondition studyCondition) {
        return this.start.compareTo(studyCondition.start);
    }

    public int compareEnd(StudyCondition studyCondition) {
        return this.end.compareTo(studyCondition.end);
    }

    public int compareMinStudent(StudyCondition studyCondition) {
        return Integer.compare(this.minStudent, studyCondition.minStudent);
    }

    public int compareMaxStudent(StudyCondition studyCondition) {
        return Integer.compare(this.maxStudent, studyCondition.maxStudent);
    }

    public int compareCostPerClass(StudyCondition studyCondition) {
        return Integer.compare(this.costPerClass, studyCondition.costPerClass);
    }

    public int compareRecruitmentLimit(StudyCondition studyCondition) {
        return this.recruitmentLimit.compareTo(studyCondition.recruitmentLimit);
    }

    public static class Builder {

        LocalDate start;
        LocalDate end;
        StudyDays studyDays;
        Locations locations;

        String description;
        int minStudent;
        int maxStudent;
        int minTeacher;
        int maxTeacher;
        int costPerClass;

        LocalDateTime recruitmentLimit;

        Member master;

        public Builder start(int year, int month, int dayOfMonth) {
            this.start = LocalDate.of(year, month, dayOfMonth);
            return this;
        }

        public Builder end(int year, int month, int dayOfMonth) {
            this.end = LocalDate.of(year, month, dayOfMonth);
            return this;
        }

        public Builder day(StudyDay... studyDays) {
            this.studyDays = new StudyDays(studyDays);
            return this;
        }

        public Builder locations(Location... locations) {
            this.locations = new Locations(locations);
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder minStudent(int minStudent) {
            this.minStudent = minStudent;
            return this;
        }

        public Builder maxStudent(int maxStudent) {
            this.maxStudent = maxStudent;
            return this;
        }

        public Builder minTeacher(int minTeacher) {
            this.minTeacher = minTeacher;
            return this;
        }

        public Builder maxTeacher(int maxTeacher) {
            this.maxTeacher = maxTeacher;
            return this;
        }

        public Builder costPerClass(int costPerClass) {
            this.costPerClass = costPerClass;
            return this;
        }

        public Builder recruitmentLimit(int year, int month, int dayOfMonth, int hour, int minute) {
            this.recruitmentLimit = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
            return this;
        }

        public Builder master(Member master) {
            this.master = master;
            return this;
        }


        public StudyCondition build() {
            return new StudyCondition(this);
        }

    }

    public static class EssentialBuilder extends Builder {

        public EssentialBuilder(Member master, LocalDate start, LocalDate end, LocalDateTime recruitmentLimit, StudyDays studyDays, Locations locations) {
            this.start = start;
            this.end = end;
            this.recruitmentLimit = recruitmentLimit;
            this.studyDays = studyDays;
            this.locations = locations;
            this.master = master;
        }

        public EssentialBuilder(Member master,
                                int startYear, int startMonth, int startDayOfMonth,
                                int endYear, int endMonth, int endDayOfMonth,
                                int recruitYear, int recruitMonth, int recruitDayOfMonth, int recruitHour, int recruitMinute,
                                StudyDays studyDays, Locations locations) {
            this.start = LocalDate.of(startYear, startMonth, startDayOfMonth);
            this.end = LocalDate.of(endYear, endMonth, endDayOfMonth);
            this.recruitmentLimit = LocalDateTime.of(recruitYear, recruitMonth, recruitDayOfMonth, recruitHour, recruitMinute);
            this.studyDays = studyDays;
            this.locations = locations;
            this.master = master;
        }

        public EssentialBuilder description(String description) {
            this.description = description;
            return this;
        }

        public EssentialBuilder minStudent(int minStudent) {
            this.minStudent = minStudent;
            return this;
        }

        public EssentialBuilder maxStudent(int maxStudent) {
            this.maxStudent = maxStudent;
            return this;
        }

        public EssentialBuilder minTeacher(int minTeacher) {
            this.minTeacher = minTeacher;
            return this;
        }

        public EssentialBuilder maxTeacher(int maxTeacher) {
            this.maxTeacher = maxTeacher;
            return this;
        }

        public EssentialBuilder costPerClass(int costPerClass) {
            this.costPerClass = costPerClass;
            return this;
        }

        public StudyCondition build() {
            return new StudyCondition(this);
        }

    }

    @Override
    public boolean isSatisfiedCondition(Condition condition) {
        if (!(condition instanceof StudyCondition)) {
            return false;
        }
        StudyCondition info = (StudyCondition) condition;
        return (info.start == null || start.isAfter(info.start))
                && (info.end == null || end.isBefore(info.end))
                && (info.studyDays == null || studyDays.available(info.studyDays))
                && (info.locations == null || locations.contains(info.locations))
                && (info.description == null || (description != null && description.contains(info.description)))
                && (info.minStudent == 0 || minStudent >= info.minStudent)
                && (info.maxStudent == 0 || maxStudent <= info.maxStudent)
                && (info.costPerClass == 0 || costPerClass <= info.costPerClass)
                && (info.master == null || master.equals(info.master))
                ;

    }

    private StudyCondition(Builder builder) {
        this.start = builder.start;
        this.end = builder.end;
        this.studyDays = builder.studyDays;
        this.locations = builder.locations;
        this.description = builder.description;
        this.minStudent = builder.minStudent;
        this.maxStudent = builder.maxStudent;
        this.minTeacher = builder.minTeacher;
        this.maxTeacher = builder.maxTeacher;
        this.costPerClass = builder.costPerClass;
        this.recruitmentLimit = builder.recruitmentLimit;
        this.master = builder.master;
        validateField();
    }

    private StudyCondition(EssentialBuilder builder) {
        this.start = builder.start;
        this.end = builder.end;
        this.studyDays = builder.studyDays;
        this.locations = builder.locations;
        this.description = builder.description;
        this.minStudent = builder.minStudent;
        this.maxStudent = builder.maxStudent;
        this.minTeacher = builder.minTeacher;
        this.maxTeacher = builder.maxTeacher;
        this.costPerClass = builder.costPerClass;
        this.recruitmentLimit = builder.recruitmentLimit;
        this.master = builder.master;
        validateEssentialField();
        validateField();
    }

}
