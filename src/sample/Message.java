package sample;

import java.sql.Timestamp;

public class Message {
    private String messageText;
    private Timestamp timestamp;

    public Message(String messageText, Timestamp timestamp) {
        this.messageText = messageText;
        this.timestamp = timestamp;
    }

    public String getMessageText() {
        return messageText;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
