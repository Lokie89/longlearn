package com.project.long_learn.condition;

import com.project.long_learn.group.StudyDay;
import com.project.long_learn.group.StudyLocation;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;

public class StudyCondition implements Condition {


    // 필드 재정의 시 Builder 와 Condition 메서드 내부 수정
    private final LocalDate start;
    private final LocalDate end;
    private final Set<StudyDay> studyDays;
    private final StudyLocation location;
    private final String description;
    private final int minStudent;
    private final int maxStudent;

    public static class Builder {

        private LocalDate start;
        private LocalDate end;
        private Set<StudyDay> studyDays;
        private StudyLocation location;

        private String description;
        private int minStudent;
        private int maxStudent;

        public Builder start(LocalDate start) {
            this.start = start;
            return this;
        }

        public Builder end(LocalDate end) {
            this.end = end;
            return this;
        }

        public Builder studyDay(Set<StudyDay> studyDays) {
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
        return (info.start == null || start.equals(info.start))
                && (info.end == null || end.equals(info.end))
                && (info.studyDays == null || studyDays.equals(info.studyDays))
                && (info.location == null || location.equals(info.location))
                && (info.description == null || (description != null && description.contains(info.description)))
                && (info.minStudent == 0 || minStudent > info.minStudent)
                && (info.maxStudent == 0 || maxStudent < info.maxStudent)
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
        ;


    }
}