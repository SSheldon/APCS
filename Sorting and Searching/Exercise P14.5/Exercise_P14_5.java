public class Exercise_P14_5
{
    public static void main(String[] args)
    {
        int[] numbers = new int[1000];
        for (int i = 0; i < 1000; i++)
            numbers[i] = (int)(Math.random() * 10000000);
        String[] names = new String[1000];
        for (int i = 0; i < 1000; i++) names[i] = RandomName();
        int number = numbers[0];
        String name = names[0];
        System.out.println(name + "'s phone number is " + number + ".");
        Phonebook p = new Phonebook(numbers, names);
        System.out.println("Looking up " + name +
            " in the phonebook returns the number " + p.Lookup(name) + ".");
        System.out.println("In the phonebook, " + number + " is " + 
            p.ReverseLookup(number) + "'s phone number.");
    }
    
    private static String RandomName()
    {
        String name = "";
        for (int i = 5 + (int)(Math.random()*4); i >= 0; i--)
        {
            name += (char)((int)(Math.random() * 26) + 65);
        }
        return name;
    }
}
