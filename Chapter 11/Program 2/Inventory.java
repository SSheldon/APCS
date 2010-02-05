import java.util.ArrayList;

class Inventory
{
    private ArrayList<Product> products;
    
    public Inventory()
    {
        products = new ArrayList<Product>();
    }
    
    public void addNewProduct(String name, double cost, int amount)
    {
        int i;
        for (i = 0; i < products.size() && 
            name.compareTo(products.get(i).getItem()) > 0; i++);
        products.add(i, new Product(name, cost, amount));
    }
    
    public ArrayList<String> mustOrder()
    {
        ArrayList<String> lowQuantity = new ArrayList<String>();
        for (Product product : products)
        {
            if (product.getQuantity() < 20)
                lowQuantity.add(product.getItem());
        }
        return lowQuantity;
    }
    
    public void displayProducts()
    {
        for (Product product : products)
        {
            System.out.println(product);
            System.out.println();
        }
    }
}
