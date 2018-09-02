package bookshared.android.kr.bookshared.chat;

public class ChatDTO {

    public ChatDTO(){}

    public ChatDTO(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    private String userName;
    private String message;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
