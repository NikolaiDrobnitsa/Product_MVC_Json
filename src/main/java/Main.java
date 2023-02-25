import Controller.ProductController;
import View.ProductView;

public class Main {

    public static void main(String[] args) {
        ProductView productView = new ProductView();
        productView.Fill_Info();
//        productView.run();
        ProductController productController = new ProductController(productView);
        productController.run();


    }

}