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
    private final StudyLocation location;
    private final String description;
    private final int minStudent;
    private final int maxStudent;

    private final int minTeacher;
    private final int maxTeacher;

    private final int costPerClass;
    private final LocalDateTime recruitmentLimit;

    private final Member master;


    /**
     * return StudyEssentialFieldNotSatisfiedException
     */
    public void validateEssentialField() {
        if (Objects.isNull(start)
                || Objects.isNull(end)
                || start.isAfter(end)) {
            throw new StudyDateIsNullException();
        }
        if (start.isAfter(end)) {
            throw new StudyDateArrangeException();
        }
        if (Objects.isNull(studyDays) || studyDays.isStudyDaysNull()) {
            throw new StudyDaysIsNullException();
        }
        if (Objects.isNull(location) || location.isStudyLocationNull()) {
            throw new StudyLocationIsNullException();
        }
        if ((!isUnlimitedStudent() && maxStudent == 0) || minStudent > maxStudent) {
            throw new StudyStudentArrangeException();
        }
        if ((!isUnlimitedTeacher() && maxTeacher == 0) || minTeacher > maxTeacher) {
            throw new StudyStudentArrangeException();
        }
        if (costPerClass < 0) {
            throw new StudyCostArrangeException();
        }
        if (recruitmentLimit.isAfter(LocalDateTime.of(start, LocalTime.MIDNIGHT))) {
            throw new StudyRecruitmentLimitArrangeException();
        }
        if (Objects.isNull(master)) {
            throw new StudyMasterIsNotExistException();
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

    public int compareLocation(StudyCondition studyCondition) {
        return this.location.compareTo(studyCondition.location);
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

        private LocalDate start;
        private LocalDate end;
        private StudyDays studyDays;
        private StudyLocation location;

        private String description;
        private int minStudent;
        private int maxStudent;
        private int minTeacher;
        private int maxTeacher;
        private int costPerClass;

        private LocalDateTime recruitmentLimit;

        private Member master;

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

        public Builder location(StudyLocation location) {
            this.location = location;
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

    @Override
    public boolean isSatisfiedCondition(Condition condition) {
        if (!(condition instanceof StudyCondition)) {
            return false;
        }
        StudyCondition info = (StudyCondition) condition;
        return (info.start == null || start.isAfter(info.start))
                && (info.end == null || end.isBefore(info.end))
                && (info.studyDays == null || studyDays.available(info.studyDays))
                && (info.location == null || location.contains(info.location))
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
        this.location = builder.location;
        this.description = builder.description;
        this.minStudent = builder.minStudent;
        this.maxStudent = builder.maxStudent;
        this.minTeacher = builder.minTeacher;
        this.maxTeacher = builder.maxTeacher;
        this.costPerClass = builder.costPerClass;
        this.recruitmentLimit = builder.recruitmentLimit;
        this.master = builder.master;
    }

}
