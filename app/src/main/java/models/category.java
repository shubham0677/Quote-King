package models;

/**
 * Created by hp on 9/19/2016.
 */
public class category {

    public String name;
    public String poster;

    public category(){

    }
    public category(String catName,String poster){
        name = catName; this.poster = poster;
    }

    public String getCatName() {
        return name;
    }

    public void setCatName(String catName) {
        name = catName;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
