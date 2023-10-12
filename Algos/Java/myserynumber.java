import java.util.Scanner;  
public class MysteryNumberExample1  
{    
static int reverse(int x)  
{        
String str = Integer.toString(x);  
String string="";  
for(int i=str.length()-1;i>=0;i--)  
{        
string=string+str.charAt(i);  
}    
int rev=Integer.parseInt(str);  
//returns the reverse number  
return rev;  
}    
static boolean isMysteryNo(int num)  
{  
for (int i=1; i <= num/2; i++)  
{  
int j = reverse(i);  
if (i + j == num)  
{     
System.out.println( i + " " + j);  
System.out.println(num+ " is a mystery number.");  
//returns a boolean value if pair is found  
return true;  
}  
}  
System.out.println("The given number is not a mystery number.");    
return false;  
}    
public static void main(String args[])  
{  
Scanner sc=new Scanner(System.in);  
System.out.print("Enter a number: ");  
int num = sc.nextInt();    
isMysteryNo(num);  
}  
}  
