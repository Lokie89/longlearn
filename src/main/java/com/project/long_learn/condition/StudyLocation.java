package com.project.long_learn.condition;

public class StudyLocation implements Comparable<StudyLocation> {
    private double latitude;
    private double longitude;
    private String name;

    private StudyLocation(String name) {
        this.name = name;
    }

    private StudyLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public static StudyLocation of(double latitude, double longitude) {
        return new StudyLocation(latitude, longitude);
    }

    public static StudyLocation of(String name) {
        return new StudyLocation(name);
    }

    @Override
    public int compareTo(StudyLocation studyLocation) {
        return name.compareTo(studyLocation.name);
    }

    public boolean isStudyLocationNull() {
        return (latitude == 0 || longitude == 0) && name == null;
    }

    public boolean contains(StudyLocation studyLocation) {
        return this.name.contains(studyLocation.name);
    }
}
