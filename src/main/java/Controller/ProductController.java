package Controller;

import View.ProductView;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductController {

    private ProductView productView;
    Scanner scanner = new Scanner(System.in);
    public ProductController(ProductView productView) {
        this.productView = productView;

    }

    public void run() {
        int choice = -1;
        while (choice != 0) {
            productView.showMenu();
            choice = productView.getUserChoice();
            try {
                switch (choice) {
                    case 1:
                        productView.All_Product().forEach(product -> System.out.println(product.toString()));
                        break;
                    case 2:
                        productView.All_Category().forEach(category -> System.out.println(category.toString()));
                        break;
                    case 3:

                       productView.ArrayManufacturers.forEach(m->System.out.println(m.getId() + " - " + m.getName()));
                       System.out.println("Enter number manufacturer:");
                       int num =  scanner.nextInt();
                        productView.Specific_manufacturer(num).forEach(product -> System.out.println(product.toString()));
                        break;
                    case 4:
                        productView.up_to_100().forEach(product -> System.out.println(product.toString()));
                        break;
                    case 5:
                        productView.BelowAveragePrice().forEach(product -> System.out.println(product.toString()));
                        break;
                    case 6:
                        productView.BelowAveragePriceNoPopular().forEach(product -> System.out.println(product.toString()));
                        break;
                    case 7:
                        productView.PopularManufWthNoPopularCaregory().forEach(product -> System.out.println(product.toString()));
                        break;
                    case 8:
                        System.out.println(productView.RandomProduct());
                        break;
                    case 9:
                        productView.ChipProduct().forEach(product -> System.out.println(product.toString()));
                        break;
                    case 10:
                        productView.ChipProduct().forEach(product -> System.out.println(product.toString()));
                        break;
                    case 11:
                        productView.WriteResultToFile();
                        break;

                    case 0:
                        System.out.println("EXIT...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
    }
}
