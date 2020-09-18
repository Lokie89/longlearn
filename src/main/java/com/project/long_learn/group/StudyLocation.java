package com.project.long_learn.group;

public class StudyLocation implements Comparable<StudyLocation> {
    private double latitude;
    private double longitude;
    private String name;

    public StudyLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public StudyLocation(double latitude, double longitude, String name) {
        this(latitude, longitude);
        this.name = name;
    }

    @Override
    public int compareTo(StudyLocation studyLocation) {
        return name.compareTo(studyLocation.name);
    }

    public boolean isStudyLocationNull() {
        return latitude == 0 && longitude == 0;
    }
}
