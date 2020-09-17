package com.project.long_learn.group;

public class StudyLocation implements Comparable<StudyLocation> {
    private double latitude;
    private double longitude;
    private String name;

    @Override
    public int compareTo(StudyLocation studyLocation) {
        return name.compareTo(studyLocation.name);
    }
}
