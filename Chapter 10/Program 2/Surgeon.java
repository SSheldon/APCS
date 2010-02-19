public class Surgeon extends Doctor
{
    public void Treat()
    {
        Diagnose();
        Prescribe();
        System.out.println("I'll cure it with surgery.");
    }
}