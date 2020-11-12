package com.project.long_learn.domain;


import com.project.long_learn.condition.Condition;
import com.project.long_learn.text.TextReceiver;
import com.project.long_learn.text.TextSender;

import java.util.Objects;

/**
 * 데이터 베이스와 매핑 시킬 객체
 */
public class Member implements Condition, TextSender, TextReceiver {

    // 임시
    private int id;
    private int reported;
    private String name;

    public Member(int id) {
        this.id = id;
    }

    public void participate(int involveId) {
        // database save
    }

    public void absent(int involveId) {
        // database save
    }

    public void pass(int involveId) {
        // database save
    }

    public void fail(int involveId) {
        // database save
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Member)) {
            return false;
        }
        Member member = (Member) obj;
        return id == member.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean isSatisfiedCondition(Condition condition) {
        if (!(condition instanceof Member)) {
            return false;
        }
        Member mc = (Member) condition;
        return (mc.id == 0 || mc.id == this.id)
                && (Objects.isNull(mc.name) || this.name.contains(mc.name))
                && (mc.reported == 0 || mc.reported == this.reported);
    }

    public int compareId(Member member) {
        return Integer.compare(this.id, member.id);
    }

    public int compareReported(Member member) {
        return Integer.compare(this.reported, member.reported);
    }

    public int compareName(Member member) {
        return this.name.compareTo(member.name);
    }

    @Override
    public void receive(long textId) {
        //update
    }

    @Override
    public void send(long textId) {
        //update
    }
}
