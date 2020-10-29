package Model;

public class StarWarsModel {
    private String title;
    private int revenue, rating;
    //Creates constructor
    public StarWarsModel(String title, int revenue, int rating) {
        setTitle(title);
        setRevenue(revenue);
        setRating(rating);
    }
    //creates get and set methods for each variable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
