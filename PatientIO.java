
/**
 * Write a description of class PatientApps here.
 *m
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;
public class PatientIO
{
    public static void main(String args[]) throws IOException 
    {
        try
        {
            Patient p[]=new Patient [10];
            
            String name, IdNum, date, time, pensionID, guardianName, school;
            int age;
            double appCost, treatCost, disc;
            
            //Read data from Child.txt
            BufferedReader br=new BufferedReader(new FileReader("Child.txt"));
            
            int count=0;
            StringTokenizer st=null;
            String dataRow=br.readLine();
            while (dataRow!=null)
            {
                st=new StringTokenizer(dataRow,";");
                name=st.nextToken();
                IdNum=st.nextToken();
                age=Integer.parseInt(st.nextToken());
                date=st.nextToken();
                time=st.nextToken();
                appCost=Double.parseDouble(st.nextToken());
                treatCost=Double.parseDouble(st.nextToken());
                guardianName=st.nextToken();
                school=st.nextToken();
               
                p[count]=new ChildPnt(name, IdNum, age, new Appointment(date, time,appCost, treatCost), guardianName, school);
                count++;
                dataRow=br.readLine();
            }
            
            //Read data from Senior.txt
            BufferedReader br2=new BufferedReader(new FileReader("Senior.txt"));
            
            int count2=count;
            StringTokenizer st2=null;
            String dataRow2=br2.readLine();
            while (dataRow2!=null)
            {
                st2=new StringTokenizer(dataRow2,";");
                name=st2.nextToken();
                IdNum=st2.nextToken();
                age=Integer.parseInt(st2.nextToken());
                date=st2.nextToken();
                time=st2.nextToken();
                appCost=Double.parseDouble(st2.nextToken());
                treatCost=Double.parseDouble(st2.nextToken());
                pensionID=st2.nextToken();
                disc=Double.parseDouble(st2.nextToken());
                
                p[count2]=new SeniorPnt(name, IdNum, age, new Appointment(date, time, appCost, treatCost), pensionID, disc);
                count2++;
                dataRow2=br2.readLine();
            }
            
            //Write the data into output file Child.txt for patients that have appointment on 13/7
            PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("ChildApp.txt")));
            
            pw.println("\nDetails of child patients that have appointment on 13/7:");
            for(int i=0; i<count; i++)
            {
                if(p[i] instanceof ChildPnt && p[i].getDate().equalsIgnoreCase("13/7"))
                {
                    pw.println(p[i].toString());
                }
            }
            
            PrintWriter adultPW=new PrintWriter(new BufferedWriter(new FileWriter("SeniorPrice.txt")));
            adultPW.print("Name of senior patients with price over 400: ");
            for(int i=0; i<count2; i++)
            {
                if(p[i] instanceof SeniorPnt && p[i].calcTotCharge()>400)
                {
                    adultPW.print(p[i].getName()+",");
                }
            }
            //Display the detail of patients in input file
            System.out.println("\nDetails of patients:");
            for(int i=0; i<count2; i++)
            {
                System.out.print(p[i].toString());
            }
            
            br.close();
            pw.close();
            adultPW.close();
        }
        
        catch(EOFException eof)
        {
            System.out.println("Problem: "+eof.getMessage());
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Problem: "+e.getMessage());
        }
        catch(IOException ioe)
        {
            System.out.println("Problem: "+ioe.getMessage());
        }
        finally
        {
            System.out.println("\nEnd of the program");
        }
    }
}
        
        
        
    

