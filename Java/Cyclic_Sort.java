import java.util.*;

public class Cyclic_Sort {

	public static void main(String[] args) 
	{
		int[] arr1 = {5, 3, 4, 1, 2};
		int[] arr2 = {1 ,3 ,5 ,2 ,4};
		cyclicSortingAscending(arr1);
	  cyclicSortingDecending(arr2);
	  System.out.println("In Ascending Order: " + Arrays.toString(arr1));
	  System.out.println("In Descending Order: " + Arrays.toString(arr2));
	}
	
  //sort an array in ascending order
	public static void cyclicSortingAscending(int[] arr) 
	 {
		 int i = 0;
	     while (i < arr.length) {
	    	 int correct = arr[i] - 1;
	         if (arr[i] != arr[correct]) {
	        	 swap(arr, i , correct);
	            } 
	         else
	        	 i++;
	        }
	    }
  
  //sort an array in decending order
	public static void cyclicSortingDecending(int[] arr) 
	 {
		 int i = 0;
		 while (i < arr.length) {
			 int correct = i + arr[i];
				if (correct != arr.length) {
					swap(arr,i,correct);
				}
				else
					i++;
			}
		}
  
	  public static void swap(int[] arr, int first, int second) 
	    {
	        int temp = arr[first];
	        arr[first] = arr[second];
	        arr[second] = temp;
	    }
}
