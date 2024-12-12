import java.util.ArrayList;
/**
 * Category classification
 */
public class Category {
    /**
     * Classification number
     */
    private int id;
    /**
     * Classification name
     */
    private String name;
    public Category()
    {

    }
    public Category(int id,String name)
    {
        this.id=id;
        this.name=name;
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
    public void setName()
    {
        this.name=name;
    }

    /**
     * Use Id to get product categories
     * @param id
     * @return  Category classification
     */
    public static Category getOneId(int id)
    {
        ArrayList<Category> categories=getCategories();
        for(Category category:categories)
        {
            if(category.getId()==id)
            {
                return category;
            }
        }
        return null;
    }

    /**
     * Get all product categories
     * @return ArrayList<Category> all commodity categories
     */
    public static ArrayList<Category> getCategories()
    {
        return initCategories();
    }
    private static ArrayList<Category> initCategories()
    {
        ArrayList<Category> categories=new ArrayList<>();
        categories.add(new Category(1,"phone"));
        categories.add(new Category(2,"laptop"));
        categories.add(new Category(3,"Headphones"));
        categories.add(new Category(4,"iPad"));
        return categories;
    }
}
