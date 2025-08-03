
/**
 * Write a description of class Patient here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Patient
{
    private String name, IdNum;
    private int age;
    private Appointment a;
    
    public Patient(String name, String IdNum, int age, Appointment a)
    {
        this.name=name;
        this.IdNum=IdNum;
        this.age=age;
        this.a=a;
    }
    
    public void setName(String name){this.name=name;}
    public void setIdNum(String IdNum){this.IdNum=IdNum;}
    public void setAge(int age){this.age=age;}
    public void setDate(String date){a.setDate(date);}
    public void setTime(String time){a.setTime(time);}
    public void setAppCost(double appCost){a.setAppCost(appCost);}
    public void setTreatCost(double treatCost){a.setTreatCost(treatCost);}
    
    public String getName(){return name;}
    public String getIdNum(){return IdNum;}
    public int getAge(){return age;}
    public String getDate(){return a.getDate();}
    public String getTime(){return a.getTime();}
    public double getAppCost(){return a.getAppCost();}
    public double getTreatCost(){return a.getTreatCost();}
    
    //have no body
    //implemented by the subclasses of abstract class that declares it
    public abstract double calcTotCharge();
    
    public String toString()
    {
        return("\nName: "+name+"\nID: "+IdNum+"\nAge: "+age+
        "\nAppointment date: "+a.getDate()+"\nAppointment time: "+a.getTime());
    }
}
