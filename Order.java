import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Order class
 */
public class Order {

    /**
     * Order status: Unpaid
     */
    private static final int ORDER_STATUS_UNPAID=0;

    /**
     *Order status: paid
     */
    private static final int ORDER_STATUS_PAIDED=1;

    public static ArrayList<Order> orders=new ArrayList<>();

    /**
     * Order number
     */
    private int id;

    /**
     * Creation time
     */
    private Date createTime;

    /**
     * Order status：0-unpaid  1-paid 2-Waiting for shipment
     */
    private int status;

    /**
     *
     */
    private ArrayList<Product> products;
    private double totalPrice;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public Date getCreatTime()
    {
        return createTime;
    }
    public void setCreatTime(Date createTime)
    {
        this.createTime=createTime;
    }
    public int getStatus()
    {
        return status;
    }
    public void setStatus(int status)
    {
        this.status=status;
    }
    public ArrayList<Product> getProducts()
    {
        return products;
    }
    public void setProducts(ArrayList<Product> products)
    {
        this.products= products;
    }
    public double getTotalPrice()
    {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice=totalPrice;
    }
    public static void buy(ArrayList<Product> products)
    {
        Order order=new Order();
        order.setId(1);
        order.setProducts(products);
        order.setCreatTime(new Date());
        order.setStatus(0);
        order.setStatus(ORDER_STATUS_UNPAID);
        order.setTotalPrice(calculateTotalPrice(products));
        System.out.println("Total order amount："+order.getTotalPrice());
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Y for settlement:");
        String next=scanner.next();
        if(next.equalsIgnoreCase("y"))
        {
            //Determine whether the user is logged in
            if(User.currentUser==null)
            {
                System.out.println("Not logged in yet, please log in");
            }else {
                //User consumption amount
                double price=User.currentUser.getBalance()-order.getTotalPrice();
                if(price>=0)
                {
                    order.setStatus(ORDER_STATUS_PAIDED);
                    User.currentUser.setBalance(price);
                    System.out.println("Congratulations! Payment successful!");

                    //Create order list
                    orders.add(order);
                    order.setId(orders.size());
                }else{
                    System.out.println("Your balance is insufficient");
                }
            }
            order.setStatus(ORDER_STATUS_PAIDED);
        }
    }

    /**
     * Calculate the total amount
     * @param products products Product list
     * @return Total amount
     */
    private static double calculateTotalPrice(ArrayList<Product> products)
    {
        double totalPrice=0;
        for(Product product:products)
        {
            totalPrice+=product.getPrice();
        }
        return totalPrice;
    }
}

