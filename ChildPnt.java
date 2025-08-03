
/**
 * Write a description of class ChildPnt here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ChildPnt extends Patient
{
    private String guardianName, school;
    
    public ChildPnt(String name, String IdNum, int age, Appointment a, String guardianName, String school)
    {
        super(name, IdNum, age, a);
        this.guardianName=guardianName;
        this.school=school;
    }
    
    public double calcTotCharge()
    {
        double totCharge=0;
        totCharge=getTreatCost()+getAppCost();
        return totCharge;
    }
    
    public String toString()
    {
        return(super.toString()+"\nGuardian name: "+guardianName+"\nSchool: "+school);
    }
}
