package bookshared.android.kr.bookshared.book;

import java.io.Serializable;

public class BookDTO implements Serializable{
    private String logo;    // 알라딘 로고
    private String title;   // 제목
    private String link;    // 알라딘 링크
    private String author;  // 작가
    private String description; // 내용
    private String cover;   // 책 이미지
    private String price;   // 가격

    public BookDTO() {
    }

    public String getLogo() {
        return logo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "logo='" + logo + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }
}