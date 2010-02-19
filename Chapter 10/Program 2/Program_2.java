public class Program_2
{
    public static void main(String[] args)
    {
        Employee[] staff = new Employee[6];
        staff[0] = new Nurse();
        staff[1] = new Doctor();
        staff[2] = new Surgeon();
        staff[3] = new Administrator();
        staff[4] = new Receptionist();
        staff[5] = new Janitor();
        for (Employee e : staff)
        {
            e.Work();
        }
    }
}