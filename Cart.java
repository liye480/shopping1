import java.util.ArrayList;
import java.util.Scanner;

/**
 * Shopping cart
 */
public class Cart {
    public static Cart cart=new Cart();

    /**
     * Shopping cart items
     */
    private ArrayList<Product> products;
    public Cart()
    {

    }

    public Cart(ArrayList<Product> products)
    {

        this.products=products;
    }
    public ArrayList<Product> getProducts()
    {
        if(products==null)
        {
            products=new ArrayList<>();
        }
        return products;
    }
    public void setProducts(ArrayList<Product> products)
    {

        this.products=products;
    }
    public static void addToCart()
    {
        boolean flag=false;

        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter the item number you want to add to your cart：");
        int productId=scanner.nextInt();

        //Traverse through the product
        ArrayList<Product> allProducts=Product.getProducts();
        //If you find an item, put it in your shopping cart
        for(Product product:allProducts)
        {
            if(product.getId()==productId)
            {
                flag=true;



                //Add items to your shopping cart
                cart.getProducts().add(product);
                System.out.println("Successfully added\""+product.getName()+"\"to the shopping cart");
                break;
            }
        }
        if(!flag)
        {
            System.out.println("The product does not exist, please select it again：");
            addToCart();
        }
    }
}



