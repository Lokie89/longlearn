package com.project.long_learn.domain;


/**
 * 데이터 베이스와 매핑 시킬 객체
 */
public class Member {

    // 임시
    private int id;

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
                && (mc.name == null || this.name.contains(mc.name))
                && (mc.reported == 0 || mc.reported == this.reported);
    }

    public int compareId(Member member) {
        return this.id >= member.id ? 1 : -1;
    }

    public int compareReported(Member member) {
        return this.reported >= member.reported ? 1 : -1;
    }

    public int compareName(Member member) {
        return this.name.compareTo(member.name);
    }

}
