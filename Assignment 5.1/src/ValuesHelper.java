import java.util.Scanner;

class ValuesHelper
{
    enum DaysOfWeek {SUN, MON, TUE, WED, THRS, FRI, SAT}

    public static void main (String [] args)
    {
    	//unrelated printf test
    	System.out.printf("%.2f \n", 1290.098);
    	System.out.printf("%,.2f \n", 4561290.098);
    	
        DaysOfWeek [] d = DaysOfWeek.values();

        Scanner keyboard = new Scanner (System.in);
        double sum = 0.0;

        for (DaysOfWeek oneDay : d)
        {
            System.out.print ("How many hours did you work on " +
                               oneDay + ":  ");
            sum += keyboard.nextDouble();
        }
        System.out.println ("You worked a total of ... " + sum + " hours");
    }
}