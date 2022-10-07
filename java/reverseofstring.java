public class Reverse   
{    
    public static void main(String[] args) {    
        String string = "Dream big";    
        //Stores the reverse of given string    
        String reversedStr = "";    
            
        //Iterate through the string from last and add each character to variable reversedStr    
        for(int i = string.length()-1; i >= 0; i--){    
            reversedStr = reversedStr + string.charAt(i);    
        }    
            
        System.out.println("Original string: " + string);    
        //Displays the reverse of given string    
        System.out.println("Reverse of given string: " + reversedStr);    
    }    
}    
