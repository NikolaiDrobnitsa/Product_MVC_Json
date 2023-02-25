package Model;

public class Product {
    protected int Id;
    protected String Name;
    protected float Price;
    protected float Count;
    protected float Weight;
    protected Category Category;
    protected Manufacturer Manufacturer;
    public Product(int id, String name, float price,float count, float weight, Category category, Manufacturer manufacturer){
        Id = id;
        Name = name;
        Price = price;
        Count = count;
        Weight = weight;
        Category = category;
        Manufacturer = manufacturer;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public float getCount() {
        return Count;
    }

    public void setCount(float count) {
        Count = count;
    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float weight) {
        Weight = weight;
    }

    public Manufacturer getManufacturer() {
        return Manufacturer;
    }

    public Category getCategory() {
        return Category;
    }

    @Override
    public String toString() {
        return "{id:" + Id + ", name: " + Name +", price: " + Price +", count: " + Count +", weight: " + Weight + ", category: " + Category + ", manufacturer: " + Manufacturer + "}";
    }
}
