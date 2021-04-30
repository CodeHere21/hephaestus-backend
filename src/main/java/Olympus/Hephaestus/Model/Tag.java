package Olympus.Hephaestus.Model;

public class Tag {
    private int id;
    private String label;
    private int postId;

    public Tag(){}

    public Tag(String l, int p){
        label=l;
        postId=p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
