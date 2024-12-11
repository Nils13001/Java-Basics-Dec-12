import java.util.HashMap;
import java.util.Map;

class CustomException extends Exception{

    public CustomException(String message){
        super(message);
    }

}

public class ProductDemo{

    String id;
    String name;
    double price;

    //Todo1:
            //--> Add the Exception here

    public ProductDemo(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public void updatePrice(double uPrice){
        if(uPrice<0){
            throw new IllegalArgumentException("Price can't be less than zero");
        }
        this.price = uPrice;
    }

    public void addProduct(Map<String, ProductDemo> prod, ProductDemo product) throws CustomException{

        String key = product.id.substring(0, 4);
        if(prod.containsKey(key)){
            throw new CustomException("Product Already Exists");
        }
        prod.put(key, product);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static void main(String args[]){
        // System.out.println("Hello World!");
        Map<String,ProductDemo> catlog=new HashMap<>();
        catlog.put("P001",new ProductDemo("P001_00","Laptop",15000.0));
        catlog.put("P002",new ProductDemo("P002_00","Book",150.0));
        catlog.put("P003",new ProductDemo("P003_00","Cloths",1500.0));
        catlog.put("P004",new ProductDemo("P004_00","Groceries",2500.0));

        ProductDemo product = new ProductDemo(null, null, 0);

        //Add the condition to check the product is not null
        try {
            if(catlog.containsKey("P010")){
                product =catlog.get("P010");
                System.out.println(product);
            } else {
                throw new CustomException("Product does not exist");   
            }    
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        //Update the price of the product
        product.updatePrice(2000);
        catlog.put("P001", product);
        System.out.println(product);

        // catlog.get("P001").updatePrice(-100);
        // System.out.println(catlog.get("P001"));
        

        //display all the product
        for (Map.Entry<String,ProductDemo> e : catlog.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }

        //remove a product by id
        try {
            if(catlog.containsKey("P001")){
                catlog.remove("P001");
            } else{
                throw new CustomException("Product doesn't exist");
            }    
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }


        //displayall product after removal
        for (Map.Entry<String,ProductDemo> e : catlog.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }

        

        //Write a addproduct method to add the product to catalog

        try {
            ProductDemo prod = new ProductDemo("P002_00","Laptop",15000.0);
            prod.addProduct(catlog, prod);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }


    }  
}