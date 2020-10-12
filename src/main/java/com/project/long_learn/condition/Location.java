package com.project.long_learn.condition;

public class Location implements Comparable<Location> {
    private double latitude;
    private double longitude;
    private String name;

    private Location(String name) {
        this.name = name;
    }

    private Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // TODO Google map API 이용 - latitude, longitude 에 맞는 주소값 + 상호명 name 에 저장
    public static Location of(double latitude, double longitude) {
        return new Location(latitude, longitude);
    }

    public static Location of(String name) {
        return new Location(name);
    }

    @Override
    public int compareTo(Location location) {
        return name.compareTo(location.name);
    }

    public boolean isStudyLocationNull() {
        return (latitude == 0 || longitude == 0) && name == null;
    }

    public boolean contains(Location location) {
        return this.name.contains(location.name);
    }
}
