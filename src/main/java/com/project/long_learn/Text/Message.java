package com.project.long_learn.text;

public class Message implements Text {
    private TextSender from;
    private TextReceiver to;
    private String message;

    public Message(TextSender from, TextReceiver to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
    }

    @Override
    public void text() {
        // save
        long textId = 3L;
        // save 후
        from.send(textId);
        to.receive(textId);
    }
}
