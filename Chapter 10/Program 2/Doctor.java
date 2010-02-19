public class Doctor extends MedicalWorker
{
    public void Treat()
    {
        Diagnose();
        Prescribe();
        System.out.println();
    }
    
    public void Diagnose()
    {
        System.out.print("You have this ailment. ");
    }
    
    public void Prescribe()
    {
        System.out.print("I'll prescribe you medicine. ");
    }
}