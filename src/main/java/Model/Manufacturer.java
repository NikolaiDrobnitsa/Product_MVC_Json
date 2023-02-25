package Model;

public class Manufacturer {
    protected int Id;
    protected String Name;
    protected int Rating;
    public Manufacturer(int id, String name, int rating){
        Id = id;
        Name = name;
        Rating = rating;
    }



    public int getId() {
        return Id;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    @Override
    public String toString() {
        return "{id:" + Id + ", name: " + Name + "rating: " + Rating + "}";
    }
}
