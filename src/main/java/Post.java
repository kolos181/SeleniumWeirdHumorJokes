/**
 * Created by Kolos on 09.01.2016.
 */
public class Post {

   private String text;
   private int like;
   private int repost;

    public String getText() {
        return text;
    }

    public Post(String text) {
        this.text = text;
    }

    public Post(String text, int like, int repost) {
        this.text = text;
        this.like = like;
        this.repost = repost;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getRepost() {
        return repost;
    }

    public void setRepost(int repost) {
        this.repost = repost;
    }

    @Override
    public String toString() {
        return text;
    }
}
