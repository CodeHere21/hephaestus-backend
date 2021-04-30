package Olympus.Hephaestus.Model;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class Post {

    private int id;
    private String title;
    private String body;
    private String author;
    private java.sql.Date published;

    public Post(){}

    public Post(String t, String b, String a, java.sql.Date p){
        title=t;
        body=b;
        author=a;
        published=p;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

}
