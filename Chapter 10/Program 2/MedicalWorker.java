public abstract class MedicalWorker extends Employee
{
    public abstract void Treat();
    
    public void Work()
    {
        Treat();
    }
}