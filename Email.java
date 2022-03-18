package DataBase;

public class Email {
    private String title;
    private String body;
    private User sender;
    private User receiver;
    private Integer messageId;
    private boolean isStatus;

    public boolean isStatus() {
        return isStatus;
    }

    public void setStatus(boolean status) {
        isStatus = status;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    private boolean statuts;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public boolean isStatuts() {
        return statuts;
    }

    public void setStatuts(boolean statuts) {
        this.statuts = statuts;
    }

    public Email(String title, String body, User sender, User receiver,Integer messageId, boolean statuts) {
        this.title = title;
        this.body = body;
        this.sender = sender;
        this.receiver = receiver;
        this.messageId=messageId;
        this.statuts = statuts;
    }
}
