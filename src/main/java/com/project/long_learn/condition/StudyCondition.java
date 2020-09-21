package com.project.long_learn.condition;

import com.project.long_learn.group.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
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
        if (minStudent > maxStudent) {
            throw new StudyStudentArrangeException();
        }
        if (costPerClass < 0) {
            throw new StudyCostArrangeException();
        }
        if (recruitmentLimit.isBefore(LocalDateTime.now())) {
            throw new StudyRecruitmentLimitArrangeException();
        }
    }

    public int getMax() {
        return maxStudent + maxTeacher;
    }

    public boolean isLectureStudy() {
        return minTeacher > 0;
    }

    public int getMinTeacher() {
        return minTeacher;
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

        public Builder start(LocalDate start) {
            this.start = start;
            return this;
        }

        public Builder end(LocalDate end) {
            this.end = end;
            return this;
        }

        public Builder studyDay(StudyDays studyDays) {
            this.studyDays = studyDays;
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

        public Builder recruitmentLimit(LocalDateTime recruitmentLimit) {
            this.recruitmentLimit = recruitmentLimit;
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
                && (info.studyDays == null || studyDays.contains(info.studyDays))
                && (info.location == null || location.contains(info.location))
                && (info.description == null || (description != null && description.contains(info.description)))
                && (info.minStudent == 0 || minStudent >= info.minStudent)
                && (info.maxStudent == 0 || maxStudent <= info.maxStudent)
                && (info.costPerClass == 0 || costPerClass <= info.costPerClass)
                ;

    }

    @Override
    public int compareCondition(Condition condition, Comparator comparator) {
        if (!(condition instanceof StudyCondition)) {
            return 0;
        }
        if (!(comparator instanceof StudyInformationComparator)) {
            return 0;
        }
        StudyCondition info = (StudyCondition) condition;
        StudyInformationComparator studyInformationComparator = (StudyInformationComparator) comparator;
        return studyInformationComparator.compare(this, info);
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
    }

    public enum StudyInformationComparator implements Comparator<StudyCondition> {
        START {
            @Override
            public int compare(StudyCondition o1, StudyCondition o2) {
                return o1.start.compareTo(o2.start);
            }
        },
        END {
            @Override
            public int compare(StudyCondition o1, StudyCondition o2) {
                return o1.end.compareTo(o2.end);
            }
        },
        LOCATION {
            @Override
            public int compare(StudyCondition o1, StudyCondition o2) {
                return o1.location.compareTo(o2.location);
            }
        },
        MINSTUDENT {
            @Override
            public int compare(StudyCondition o1, StudyCondition o2) {
                return o1.minStudent >= o2.minStudent ? 1 : -1;
            }
        },
        MAXSTUDENT {
            @Override
            public int compare(StudyCondition o1, StudyCondition o2) {
                return o1.maxStudent >= o2.maxStudent ? 1 : -1;
            }
        },
        COSTPERCLASS {
            @Override
            public int compare(StudyCondition o1, StudyCondition o2) {
                return o1.costPerClass >= o2.costPerClass ? 1 : -1;
            }
        },
        RECRUITMENTLIMIT {
            @Override
            public int compare(StudyCondition o1, StudyCondition o2) {
                return o1.recruitmentLimit.compareTo(o2.recruitmentLimit);
            }
        },
        ;


    }
}
