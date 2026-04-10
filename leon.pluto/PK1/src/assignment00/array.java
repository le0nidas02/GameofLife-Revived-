package assignment00;
public class array 
{
    public static void main(String[] args){
   //descend(15);
        System.out.println(getFactorial(7));
        System.out.println(getFactorialrec(7));
        System.out.println(power(7, 5));

    }


//-----------------------------------------------------------------------------------

public static void descend(int n)
{
System.out.println(n);
descend(n - 1);
}
//-----------------------------------------------------------------------------------
public static int getFactorial(int factorial)
{
 int result = 1;
 while(factorial > 0)
 {
 result = result * factorial;
 factorial--;
 }
 
 return result;
}






//-----------------------------------------------------------------------------------

public static int getFactorialrec(int factorial)
{
if(factorial > 0)
{
return factorial * getFactorialrec(factorial-1);
}
else
{
return 1;
}
}



public static int power(int x, int y)
{
 int assistantResult;
 if(y == 0)
 {
 return 1;
 }
 else
 {
 assistantResult = power(x, y-1);
 return x * assistantResult;
 }
}

}
