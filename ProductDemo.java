import java.util.HashMap;
import java.util.Map;

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
            System.out.println("Invalid Value");
        }
        this.price = uPrice;
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
        System.out.println(catlog.getClass().getName());
        catlog.put("P001",new ProductDemo("P001_00","Laptop",15000.0));
        catlog.put("P002",new ProductDemo("P002_00","Book",150.0));
        catlog.put("P003",new ProductDemo("P003_00","Cloths",1500.0));
        catlog.put("P004",new ProductDemo("P004_00","Groceries",2500.0));

        //Add the condition to check the product is not null

        ProductDemo product =catlog.get("P001");
        System.out.println(product);


        //Update the price of the product
        product.updatePrice(2000);
        catlog.put("P001", product);
        System.out.println(product);

        catlog.get("P001").updatePrice(100);
        System.out.println(catlog.get("P001"));
        

        //display all the product
        for (Map.Entry<String,ProductDemo> e : catlog.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }


        //remove a product by id

        //displayall product after removal

        //Write a addproduct method to add the product to catalog
    }


    //Product product =c
    

}