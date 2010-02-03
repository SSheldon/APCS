public class Program_2
{
    public static void main(String[] args)
    {
        Inventory hardware = new Inventory();
        
        hardware.addNewProduct("hammer", 15.95, 100);
        hardware.addNewProduct("saw", 24.50, 15);
        hardware.addNewProduct("drill", 139.75, 25);
        hardware.addNewProduct("vise", 87.65, 10);
        
        hardware.displayProducts();
        
        System.out.println(hardware.mustOrder());
    }
}
