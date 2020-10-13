package com.project.long_learn.condition;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Locations {
    private List<Location> locations;

    public Locations(Location... locations) {
        this.locations = Arrays.asList(locations);
    }

    public boolean contains(Locations locations) {
        return this.locations
                .stream()
                .filter(location -> locations.locations
                        .stream()
                        .filter(location2 -> location.equals(location2))
                        .count() > 0)
                .count() > 0;
    }

    public boolean isLocationsEmpty() {
        return locations.stream().filter(location -> Objects.isNull(location) || location.isLocationEmpty()).count() > 0;
    }

}
