import java.util.ArrayList;
/**
 * product
 */

public class Product {
    /**
     * Product number
     */
    private int id;
    /**
     * The title of the product
     */
    private String name;
    /**
     * The price of the product
     */
    private double price;
    /**
     * The product category  belongs to
     */
    private Product()
    {

    }
    private Category category;
    public Product(int id,String name,double price,Category category)
    {
        this.id=id;
        this.name=name;
        this.price=price;
        this.category=category;
    }
    {

    }
    public int getId()
    {
        return id;
    }
    public void setId()
    {
        this.id=id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price=price;
    }
    public Category getCategory()
    {
        return category;
    }
    public void setCategory(Category category)
    {
        this.category=category;
    }

    public static ArrayList<Product> getProducts()
    {
        return initProducts();
    }
    /**
     * Initialize the product
     * @return   List of products
     */
    private static ArrayList<Product> initProducts()
    {
        ArrayList<Product>products=new ArrayList<>();
        products.add(new Product(1,"iPhone16 pro max",9888.00,Category.getOneId(1)));
        products.add(new Product(2,"Huawei",8888.00,Category.getOneId(1)));
        products.add(new Product(3,"Lenovo laptop",5588.00,Category.getOneId(2)));
        products.add(new Product(4,"Dell laptop",5588.00,Category.getOneId(2)));
        products.add(new Product(5,"Bluetooth headphones",1088.00,Category.getOneId(3)));
        products.add(new Product(6,"Matepad Air",2699.00,Category.getOneId(4)));
        products.add(new Product(7,"Mini 7",3699.00,Category.getOneId(4)));
        return products;
    }
}
