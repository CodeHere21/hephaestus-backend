package Olympus.Hephaestus.Model;

public class Comment {

    private int id;
    private String body;
    private String author;
    private java.sql.Date writtenOn;
    private int postId;

    public Comment(){}

    public Comment(String b, String a, java.sql.Date d){
        body=b;
        author=a;
        writtenOn=d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public java.sql.Date getWrittenOn() {
        return writtenOn;
    }

    public void setWrittenOn(java.sql.Date writtenOn) {
        this.writtenOn = writtenOn;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }


}
