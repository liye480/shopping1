import java.util.ArrayList;
import java.util.Scanner;
/**
 * User class
 */
public class User {

    //Used for storing information
    private static ArrayList<User> users=new ArrayList<>();

    //Used for log in current user
    public static User currentUser;


    /**
     * Login account
     */
    private String username;

    /**
     * Password
     */
    private String password;

    /**
     * Account balance
     */
    private double balance;
    public User()
    {
    }
    public User(String username,String password,double balance)
    {
        this.username=username;
        this.password=password;
        this.balance=balance;
    }
    public String getUsername()
    {

        return username;
    }
    public void setUsername(String username)
    {

        this.username=username;
    }
    public String getPassword()
    {

        return password;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public double getBalance()
    {

        return balance;
    }
    public void setBalance(double balance)
    {

        this.balance=balance;
    }

    /**
     * Register an account
     */
    public static void reg()
    {
        Scanner scanner=new Scanner(System.in);
        String username=null;
        String password=null;
        System.out.println("----------My market-registeration----------");
        do {
            System.out.print("Account：");
            username=scanner.next();
            System.out.print("Password：");
            password=scanner.next();
        }
        while(checkReg(username));

        //注册用户
        users.add(new User(username,password,200000));
        System.out.println("Congratulations,registration successful!");
    }

    public static void login()
    {
        //Determine the number of login attempts.
        //If it exceeds three,return to the main menu.
        int count=0;

        Scanner scanner=new Scanner(System.in);
        String username=null;
        String password=null;
        System.out.println("----------My Market-login----------");
        do{
            //Exit the loop
            if(count>=3)
            {
                System.out.println("The account does not exist, please log in again");
                break;
            }
            System.out.println("Please enter your account：");
            username=scanner.next();
            System.out.println("Please enter your password：");
            password=scanner.next();
            currentUser=checkLogin(username, password);
            count++;
        }
        while(currentUser==null);

    }


    /**
     * Display the information of the currently logged in user
     */
    public static void showInformation()
    {
        System.out.println("----------My market-Account information----------");
        if(currentUser==null)
        {
            System.out.println("User not logged in, please log in");
        }else{
            System.out.println("Login Account\tAccount Balance");
            System.out.println(currentUser.getUsername()+"\t\t"+currentUser.getBalance());
        }
    }

    /**
     * Use login account to determine if the user exists
     * @param username   enter the login
     * @return true exist/false not exist
     */
    private static boolean checkReg(String username)
    {
        boolean flag=false;
        for(User user:users)
        {
            if(username.equals(user.getUsername()))
            {
                flag=true;
                System.out.println("Account\""+username+"\"existed，please re-enter：");
            }

        }
        return flag;
    }

    /**
     * Verify if the account password is correct
     *
     * @param username account
     * @param password password
     * @return true /false
     */
    private static User checkLogin(String username, String password)
    {
        for(User user:users)
        {
            if(username.equals(user.getUsername())&&password.equals(user.getPassword()))
            {
                System.out.println("Account\""+username+"\"login successfully！");
                return user;
            }

        }
        System.out.println("The username or password is incorrect, please re-enter：");
        return null;
    }
}



