import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Menu class
 */

public class Menu {
    /**
     * Menu number
     */
    private int id;
    /**
     * Menu name
     */
    private String name;

    public Menu(int id, String name) {
        this.id=id;
        this.name=name;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
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
    /**
     * Display menu
     */
    public static void showMenu()
    {
        ArrayList<Menu> menus=initMenu();
        //打印菜单
        System.out.println("----------My market-------");
        System.out.println("Menu number\tMenu name");
        for(Menu menu:menus)
        {
            System.out.println(menu.getId()+"\t\t"+menu.getName());
        }

        operation();
    }

    /**
     * Function of operation menu
     */
    public static void operation()
    {
        //Accepts user input and uses specified functions
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please select:");
        //Menu option
        int opt=scanner.nextInt();

        //Receive user revenue on a recurring basis
        switch(opt)
        {
            case 1:
                showCategories();
                break;
            case 2:
                showProducts();
                break;
            case 3:
                User.reg();
                showMenu();
                break;
            case 4:
                User.login();
                showMenu();
                break;
            case 5:
                User.showInformation();
                back();
                break;
            case 6:
                showProductsForCart();
                Cart.addToCart();
                showMenu();
                break;
            case 7:
                showCartProducts();
                break;
            case 8:
                Order.buy(Cart.cart.getProducts());
                showMenu();
            case 9:
                showOrders();
                break;
            case 10:
                break;
            default:
        }

    }

    /**
     * Show all product categories
     */
    public static void showCategories()
    {
        System.out.println("----------My Market - Product categories----------");
        System.out.println("Classification number\tClassification name");

        //Printed goods classification
        ArrayList<Category> categories=Category.getCategories();
        for(Category category:categories)
        {
            System.out.println(category.getId()+"\t\t"+category.getName());
        }

        //Return to the upper-level menu
        back();
    }

    /**
     * Show all products
     */
    public static void showProducts()
    {
        printProducts();
        //Return to the upper-level menu
        back();
    }

    /**
     * The shopping cart menu displays all items
     */
    private static void showProductsForCart()
    {
        printProducts();
    }

    /**
     * Print all products
     */
    private static void printProducts()
    {
        //Print a list of product classes
        System.out.println("----------My Market - Product list----------");
        System.out.println("Product number\tProduct Name\tProduct price\tsubcategory");
        ArrayList<Product> products=Product.getProducts();
        for(Product product:products)
        {
            System.out.println(product.getId()+"\t\t\t"+product.getName()+"\t"+product.getPrice()+"\t"+product.getCategory().getName());

        }
    }

    /**
     * View cart
     */
    private static void showCartProducts()
    {
        //Print a list of product classes
        System.out.println("----------My Market - Shopping cart----------");
        System.out.println("Product number\tProduct Name\tProduct price\tsubcategory");
        ArrayList<Product> products=Cart.cart.getProducts();
        //Print a list of product classes
        for(Product product:products)
        {
            System.out.println(product.getId()+"\t\t\t"+product.getName()+"\t"+product.getPrice()+"\t"+product.getCategory().getName());

        }
        //Back to upper menu
        back();
    }

    /**
     * View order history
     */
    private static void showOrders()
    {
        System.out.println("----------My Market - Historical orders----------");
        System.out.println("Order number\tCreation time\tOrder status\tOrder amount");

        //Print order information
        for(Order order:Order.orders)
        {
            String strStatus=null;
            if(order.getStatus()==0)
            {
                strStatus="unpaid";
            }else if(order.getStatus()==1)
            {
                strStatus="paid";
            }

            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String creatTime=dateFormat.format(order.getCreatTime());
            System.out.println(order.getId()+"\t\t\t"+creatTime+"\t"+order.getStatus()+"\t"+order.getTotalPrice());
            System.out.println("Product list");
            ArrayList<Product> products=order.getProducts();
            for(Product product:products)
            {
                System.out.println(product.getId()+"\t\t\t"+product.getName()+"\t"+product.getPrice()+"\t"+product.getCategory().getName());
            }
        }
        back();

    }


    /**
     * Initialization menu
     */
    public static ArrayList<Menu> initMenu()
    {
        //Initialization menu
        ArrayList<Menu> menus=new ArrayList<>();
        //Add menu
        menus.add(new Menu(1,"View all product categories"));
        menus.add(new Menu(2,"View all products"));
        menus.add(new Menu(3,"Registered user"));
        menus.add(new Menu(4,"login"));
        menus.add(new Menu(5,"Viewing User Information"));
        menus.add(new Menu(6,"Add products to cart"));
        menus.add(new Menu(7,"View cart"));
        menus.add(new Menu(8,"Place an order"));
        menus.add(new Menu(9,"View history order"));
        menus.add(new Menu(10,"quit"));
        return menus;
    }

    /**
     * Return to the upper-level menu
     */
    private static void back()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter 0 to return to the previous menu");
        int opt=scanner.nextInt();
        if(opt==0)
        {
            showMenu();
        }
    }
}



