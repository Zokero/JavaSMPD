package sample.view;

public class Message {
    private String messageText;
    private String timestamp;
    private String author;

    public Message() {
    }

    public Message(String messageText, String timestamp, String author) {
        this.messageText = messageText;
        this.timestamp = timestamp;
        this.author = author;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return timestamp + " " + author + " " + messageText;

    }
}
