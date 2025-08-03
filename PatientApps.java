
/**
 * Write a description of class PatientApps2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class PatientApps
{
    public static void main(String args[])
    {
        String name, IdNum, date, time, pensionID, guardianName, school;
        int age;
        double appCost, treatCost, disc;
        
        Scanner inputText=new Scanner(System.in);
        Scanner inputNum=new Scanner(System.in);
        Scanner input=new Scanner(System.in);
        
        //array declaration
        Patient p[]=new Patient[2];
        
        System.out.println("ToothFairy Rescue Dental Management System");
        
        String category=" ";
        //Loop 
        for(int i=0; i<p.length; i++)
        {
            boolean correctCategory=false;
            //Loop until correct category
            while(!correctCategory)
            {
                System.out.print("\nEnter the category of patient (Child/Senior): ");
                category=inputText.nextLine();
                
                if(category.equalsIgnoreCase("Child"))
                {
                    correctCategory=true;
                }
                else if(category.equalsIgnoreCase("Senior"))
                {
                    correctCategory=true;
                }
                else
                {
                    System.out.println("Sorry, incorrect code. Please enter either 'Child' or 'Senior'.");
                }
            }
            
            System.out.println("\nDetails of Patient "+(i+1)+":");
            System.out.print("Enter patient name:");
            name=inputText.nextLine();
            System.out.print("Enter patient ID: ");
            IdNum=inputText.nextLine();
            System.out.print("Enter patient age: ");
            age=inputNum.nextInt();
            System.out.print("Enter appointment date (Ex:19/7): ");
            date=inputText.nextLine();
            System.out.print("Enter appointment time (Ex:12.00pm): ");
            time=inputText.nextLine();
            System.out.print("Enter appointment cost: RM");
            appCost=inputNum.nextDouble();
            System.out.print("Enter treatment cost: RM");
            treatCost=inputNum.nextDouble();
            
            Appointment a=new Appointment(date, time, appCost, treatCost);
            if(category.equalsIgnoreCase("Child"))
            {
                System.out.print("Enter patient's guardian name: ");
                guardianName=inputText.nextLine();
                System.out.print("Enter patients's school: ");
                school=inputText.nextLine();
                //array element assignment
                p[i]=new ChildPnt(name, IdNum, age, a, guardianName, school);
            }
            else if(category.equalsIgnoreCase("Senior"))
            {
                System.out.print("Enter pension ID: ");
                pensionID=inputText.nextLine();
                System.out.print("Enter discount (Ex:40%=0.4): ");
                disc=inputNum.nextDouble();
                p[i]=new SeniorPnt(name, IdNum, age, a, pensionID, disc);
            }
        }
        
        //coding example to call method in superclass for all subclasses
        int childCount=0;
        for(int i=0; i<p.length; i++)
        {
            if(p[i] instanceof ChildPnt)
            {
                System.out.println("\nNames of child patients: "+p[i].getName());
                childCount++;
            }
        }
        System.out.print("\nNumber of child patients: "+childCount);
        
        //coding example to call method in subclass
        boolean answer=false;
        boolean correctAnswer=false;
        while(!correctAnswer)
        {
            System.out.print("\nDo you want to find details of senior patient with pension ID? (True/False):");
            answer=input.nextBoolean();
                
            if(answer==true)
            {
                correctAnswer=true;
            }
            else if(answer==false)
            {
                correctAnswer=true;
                break;
            }
            else
            {
                System.out.print("Sorry, invalid answer. Please answer with true or false only.");
            }
        }
        
        
        if(answer==true)
        {
            boolean patientFound=false;
            while(!patientFound)
            {
                System.out.println("\nEnter pension ID: ");
                pensionID=inputText.nextLine();
                
                for(int i=0; i<p.length; i++)
                {
                    if(p[i] instanceof SeniorPnt && ((SeniorPnt) p[i]).getPensionID().equals(pensionID))
                    {
                        System.out.print("\nDetails of senior patient: "+p[i].toString());
                        patientFound=true;
                        break;
                    }
                }
                
                if(!patientFound)
                {
                    System.out.println("\nIncorrect ID. Please try again.");
                }
            }
        }
        
        //Coding example call abstract method
        //Calculate and display the total price for senior patients
        double totPrice=0;
        for (int i=0; i<p.length; i++)
        {
            if(p[i] instanceof SeniorPnt)
            {
                totPrice+=p[i].calcTotCharge();
            }
        }
        
        System.out.print("\nThe total price for senior patients: RM"+totPrice);
        
        //Coding example call method in superclass that filter for child patients
        //Find average age for child patients
        double sum=0, avg;
        int count=0;
        for(int i=0; i<p.length; i++)
        {
            if (p[i] instanceof ChildPnt)
            {
                sum=sum+p[i].getAge();
                count++;
            }
        }
        avg=sum/count;
        System.out.print("\nAverage age for child patients: "+avg);
    }
}
