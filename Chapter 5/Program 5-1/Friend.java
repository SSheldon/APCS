public class Friend
{
    private String name;
    private String address;
    private String telephoneNumber;
    private int classYear;
    
    public Friend(String name, String address, 
        String telephoneNumber, int classYear)
    {
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.classYear = classYear;
    }
    
    public void Print()
    {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Telephone Number: " + telephoneNumber);
        System.out.println("Class of: " + classYear);
    }
}
