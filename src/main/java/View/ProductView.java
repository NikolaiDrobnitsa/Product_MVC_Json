package View;
import Model.Category;
import Model.Manufacturer;
import Model.Product;

import java.io.IOException;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileWriter;

public class ProductView {
    private Scanner scanner;
    public ProductView() {
        scanner = new Scanner(System.in);
    }
    public static ArrayList<Manufacturer> ArrayManufacturers = new ArrayList<Manufacturer>();
    public static ArrayList<Category> ArrayCategories = new ArrayList<Category>();
    public static ArrayList<Product> ArrayProducts = new ArrayList<Product>();
    public static Category getCategory(int id){
        return ArrayCategories.stream().filter(c->c.getId() == id).findFirst().orElse(null);
    }
    public static Manufacturer getManufacturer(int id){
        return ArrayManufacturers.stream().filter(c->c.getId() == id).findFirst().orElse(null);
    }
    public void Fill_Info(){
        Random rand = new Random();
        float randPrice= rand.nextFloat(1,1000);
        float randCount= rand.nextFloat(1,100);
        float randWeight= rand.nextFloat(1,1000);
        ArrayManufacturers.add(new Manufacturer(0, "Ukraine",9));
        ArrayManufacturers.add(new Manufacturer(1, "USA",7));
        ArrayManufacturers.add(new Manufacturer(2, "Germany",5));

        ArrayCategories.add(new Category(0, "Fruit", 8));
        ArrayCategories.add(new Category(1, "Sweet", 9));
        ArrayCategories.add(new Category(2, "Dairy", 6));
        ArrayCategories.add(new Category(3, "Fish", 4));
        ArrayCategories.add(new Category(4, "Meat", 7));


        ArrayProducts.add(new Product(0, "kiwi", rand.nextFloat(1,1000), rand.nextFloat(1,100),rand.nextFloat(1,1000), getCategory(0), getManufacturer(1) ));
        ArrayProducts.add(new Product(0, "Orange", rand.nextFloat(1,1000), rand.nextFloat(1,100), rand.nextFloat(1,1000),getCategory(0), getManufacturer(1) ));
        ArrayProducts.add(new Product(0, "Melon", rand.nextFloat(1,1000), rand.nextFloat(1,100), rand.nextFloat(1,1000),getCategory(0), getManufacturer(2) ));

        ArrayProducts.add(new Product(0, "spring", rand.nextFloat(1,1000), rand.nextFloat(1,100), rand.nextFloat(1,1000),getCategory(3), getManufacturer(0) ));
        ArrayProducts.add(new Product(0, "salmon", rand.nextFloat(1,1000), rand.nextFloat(1,100), rand.nextFloat(1,1000),getCategory(3), getManufacturer(1) ));
        ArrayProducts.add(new Product(0, "trout", rand.nextFloat(1,1000), rand.nextFloat(1,100), rand.nextFloat(1,1000),getCategory(3), getManufacturer(1) ));

        ArrayProducts.add(new Product(0, "beef", rand.nextFloat(1,1000), rand.nextFloat(1,100), rand.nextFloat(1,1000),getCategory(2), getManufacturer(1) ));
        ArrayProducts.add(new Product(0, "chicken", rand.nextFloat(1,1000), rand.nextFloat(1,100), rand.nextFloat(1,1000),getCategory(2), getManufacturer(2) ));
        ArrayProducts.add(new Product(0, "turkey", rand.nextFloat(1,1000), rand.nextFloat(1,100), rand.nextFloat(1,1000),getCategory(2), getManufacturer(2) ));

        ArrayProducts.add(new Product(0, "caramel", rand.nextFloat(1,1000), rand.nextFloat(1,100), rand.nextFloat(1,1000),getCategory(3), getManufacturer(2) ));
        ArrayProducts.add(new Product(0, "Dough", rand.nextFloat(1,1000), rand.nextFloat(1,100), rand.nextFloat(1,1000),getCategory(3), getManufacturer(0) ));
        ArrayProducts.add(new Product(0, "croissant", rand.nextFloat(1,1000), rand.nextFloat(1,100), rand.nextFloat(1,1000),getCategory(3), getManufacturer(2) ));

        ArrayProducts.add(new Product(0, "Curd", rand.nextFloat(1,1000), rand.nextFloat(1,100), rand.nextFloat(1,1000),getCategory(4), getManufacturer(1) ));
        ArrayProducts.add(new Product(0, "Yogurt", rand.nextFloat(1,1000), rand.nextFloat(1,100), rand.nextFloat(1,1000),getCategory(4), getManufacturer(0) ));
        ArrayProducts.add(new Product(0, "Sour cream", rand.nextFloat(1,1000), rand.nextFloat(1,100), rand.nextFloat(1,1000),getCategory(4), getManufacturer(2) ));
    }
    public void showMenu() {
        System.out.println("\n===Product Menu ===");
        System.out.println("1. View all product");
        System.out.println("2. View all category");
        System.out.println("3. Products from a specific manufacturer");
        System.out.println("4. Products up to $100");
        System.out.println("5. Products below the average price in the list among all categories");
        System.out.println("6. Products below the average price in the list among the most NOT popular categories");
        System.out.println("7. Products of the most unpopular manufacturer in the most popular category");
        System.out.println("8. Product weighing up to 1kg (random)");
        System.out.println("9. Products priced from $1 to $5 and weighing up to 500 grams");
        System.out.println("10. Write product in txt");
        System.out.println("10. Write Result in txt");
        System.out.println("0. Exit");
    }
    public int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public static ArrayList<Product> All_Product(){
        return ArrayProducts;
    }
    public static ArrayList<Category> All_Category(){
        return ArrayCategories;
    }
    public static List<Product> Specific_manufacturer(int num){
        return ArrayProducts.stream().filter(p->p.getManufacturer().getId() == num).toList();
    }
    public static List<Product> up_to_100(){
        return ArrayProducts.stream().filter(p->p.getPrice() < 100).toList();
    }

    public static List<Product> BelowAveragePrice(){
        double average = AveragePrice();
        return ArrayProducts.stream().filter(p->p.getPrice() < average).toList();
    }

    public static double AveragePrice(){
        double AveragePrice = ArrayProducts.stream().map(Product::getPrice).mapToDouble(a -> a).average().orElse(0.0);
        System.out.println("AveragePrice = " + AveragePrice);
        return AveragePrice;
    }
    public static List<Product> BelowAveragePriceNoPopular(){
        Category category = CategoryMinRating();
        double average = AveragePrice();
        return ArrayProducts.stream().filter(p->p.getPrice() < average && p.getCategory() == category).toList();
    }
    public static Category CategoryMinRating(){
        Category category = ArrayCategories.stream().min(Comparator.comparing(Category::getRating)).orElse(null);
        System.out.println("Category with min rating: " + category);
        return category;
    }
    public static List<Product> PopularManufWthNoPopularCaregory(){
        Category category = CategoryMaxRating();
        Manufacturer manufacturer = ManufacturerMinRating();
        return ArrayProducts.stream().filter(p->p.getManufacturer() == manufacturer && p.getCategory() == category).toList();
    }
    public static Category CategoryMaxRating(){
        Category category = ArrayCategories.stream().max(Comparator.comparing(Category::getRating)).orElse(null);
        System.out.println("category with max rating: " + category);
        return category;
    }
    public static Manufacturer ManufacturerMinRating(){
        Manufacturer manufacturer = ArrayManufacturers.stream().min(Comparator.comparing(Manufacturer::getRating)).orElse(null);
        System.out.println("Manufacturer with min rating: " + manufacturer);
        return manufacturer;
    }
    public static Product RandomProduct(){
        List<Product> listProductSizes = ArrayProducts.stream().filter(p->p.getWeight() < 1000).toList();
        Random random = new Random();
        return listProductSizes.get(random.nextInt(listProductSizes.size()));
    }
    public static List<Product> ChipProduct(){
        return ArrayProducts.stream().filter(p->p.getPrice() > 1 && p.getPrice() < 5 && p.getWeight() < 500).toList();
    }
    public static void WriteResultToFile(){
        JSONArray json = new JSONArray();

        json.put(All_Product());
        json.put(All_Category());
        json.put(Specific_manufacturer(1));
        json.put(up_to_100());
        json.put(BelowAveragePrice());
        json.put(BelowAveragePriceNoPopular());
        json.put(PopularManufWthNoPopularCaregory());
        Product[] products = { RandomProduct() };
        json.put(products);
        json.put(ChipProduct());
        try(FileWriter writer = new FileWriter("res.json", false))
        {
            writer.write(json.toString(4));
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
