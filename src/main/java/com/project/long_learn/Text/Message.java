package com.project.long_learn.Text;

import com.project.long_learn.domain.Member;

public class Message implements Text {
    private Member from;
    private Member to;
    private String message;

    public Message(Member from, Member to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
    }

    @Override
    public void text() {
        // save
    }
}
