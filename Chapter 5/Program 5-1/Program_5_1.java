import java.util.Scanner;

public class Program_5_1
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter friend's name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter friend's address: ");
        String address = scanner.nextLine().trim();
        System.out.print("Enter friend's telephone number: ");
        String telephoneNumber = scanner.nextLine().trim();
        System.out.print("Enter friend's class: ");
        int year = scanner.nextInt();
        Friend friend = new Friend(name, address, telephoneNumber, year);
        friend.Print();
    }
}
