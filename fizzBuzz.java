import java.util.*;

public class fizzBuzz
{
    /***************************************************************************************************
    ** fizzBuzz:
    **
    **  This program inputs two integers that are considered factors.
    **  You can run this program with a default range of integers 1 to 100 or
    **  enter your own range.  Once this input is complete the program
    **  will print a list of the integers in the range however, when the
    **  integer is a multiple of the first factor the program will print
    **  "fizz".  When the integer is a multiple of the second factor the
    **  program will print "buzz".  If the integer is a multiple of both
    **  the first and the second factors then the program will print "fizzbuzz".
    **
    ***************************************************************************************************/
    
    // Define the input scanner to input our values.
    static Scanner inputScanner = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        int beginRange;
        int endRange;
        
        System.out.print("Enter first factor: ");
        int firstFactor = InputInteger();
        
        System.out.print("Enter second factor: ");
        int secondFactor = InputInteger();
        
        System.out.print("Enter 0 for default range [1, 100], or any other integer for a new range: ");
        int rangeChange = InputInteger();
        if (rangeChange == 0)
        {
            beginRange = 1;
            endRange = 100;
        }
        else
        {
            System.out.print("Enter start of range: ");
            beginRange = InputInteger();
            System.out.print("Enter end of range: ");
            endRange = InputInteger();
        }
    
        // Create the object that will check if we have multiples.
        IsMultiple multiple = new IsMultiple();
        multiple.setFirst(firstFactor);
        multiple.setSecond(secondFactor);
        
        String retString = "";
        for (int i = beginRange; i <= endRange; i++)
        {
            retString = multiple.checkIfFactor(i);
            System.out.println(" [" + i + "]: " + retString);
        }
    }
    
    // Routine to input an integer value.
    public static int InputInteger()
    {
        while (!inputScanner.hasNextInt())
        {
            inputScanner.nextLine();
            System.out.println("Not an integer, please enter an integer: ");
        }
        return inputScanner.nextInt();
    }        
}

// The class to handle checking if two factors are multiples.
class IsMultiple
{
    private int firstFactor;
    public int getFirst()
    {
        return firstFactor;
    }
    public void setFirst(int f)
    {
        firstFactor = f;
    }
    
    private int secondFactor;
    public int getSecond()
    {
        return secondFactor;
    }
    public void setSecond(int s)
    {
        secondFactor = s;
    }
    
    public String checkIfFactor(int integerToCheck)
    {
        if (integerToCheck % firstFactor == 0)
        {
            if (integerToCheck % secondFactor == 0)
            {
                return "FizzBuzz";
            }
            else
            {
                return "Fizz";
            }
        }
        else
        {
            if (integerToCheck % secondFactor == 0)
            {
                return "Buzz";
            }
            else
            {
                return Integer.toString(integerToCheck);
            }
        }
    }
}