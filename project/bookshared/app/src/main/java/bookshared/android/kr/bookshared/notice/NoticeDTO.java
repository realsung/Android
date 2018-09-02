package bookshared.android.kr.bookshared.notice;

public class NoticeDTO {

    String name;
    String notice;
    String date;

    public NoticeDTO(String name, String notice, String date) {
        this.name = name;
        this.notice = notice;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
