package com.project.long_learn.apply;

import java.util.Set;

public class ApplySet<E extends Apply> {
    private final Set<E> applies;

    public ApplySet(Set<E> applies) {
        this.applies = applies;
    }

    public void add(E apply) {
        applies.add(apply);
    }

    public boolean contains(E apply) {
        return applies.contains(apply);
    }

    public int size() {
        return applies.size();
    }

    public void remove(E volunteer) {
        applies.remove(volunteer);
    }

}
