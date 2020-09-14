package com.project.long_learn.group;

import com.project.long_learn.apply.Apply;
import com.project.long_learn.apply.ApplySet;

import java.util.LinkedHashSet;

public abstract class Study implements Group<Apply> {

    private final ApplySet applySet = new ApplySet(new LinkedHashSet<>());
    private int studyId;

    public Study(int studyId) {
        this.studyId = studyId;
    }

    @Override
    public int involve(Apply apply) {
        applySet.add(apply);
        return studyId;
    }

    @Override
    public int except(Apply apply) {
        applySet.remove(apply);
        return studyId;
    }

    @Override
    public boolean isContain(Apply apply) {
        return applySet.contains(apply);
    }


}
