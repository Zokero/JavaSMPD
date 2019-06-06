package sample.view;

public class Message {
    private String messageText;
    private String timestamp;
    private String uuid;

    public Message(String messageText, String timestamp, String uuid) {
        this.messageText = messageText;
        this.timestamp = timestamp;
        this.uuid = uuid;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return messageText + " "+ uuid +" " + timestamp;
    }
}
