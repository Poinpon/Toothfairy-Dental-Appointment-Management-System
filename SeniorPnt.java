
/**
 * Write a description of class SeniorPnt here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SeniorPnt extends Patient
{
    private String pensionID;
    private double disc;
    
    public SeniorPnt(String name, String IdNum, int age, Appointment a, String pensionID, double disc)
    {
        super(name, IdNum, age, a);
        this.pensionID=pensionID;
        this.disc=disc;
    }
    
    public String getPensionID(){return pensionID;}
    
    public void setPensionID(String pensionID){this.pensionID=pensionID;}
    
    public String toString()
    {
        return(super.toString()+"\nPension ID: "+pensionID+"\nDiscount: "+disc);
    }
    
    public double calcTotCharge()
    {
        double totCharge=getAppCost()+getTreatCost();
        double totDisc=totCharge*disc;
        double totPrice=totCharge-totDisc;
        return totPrice;
    }
}
