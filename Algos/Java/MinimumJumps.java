/* Given an array arr[] of non-negative integers. Each array element represents the maximum length of the jumps that can be made forward from that element. This means if arr[i] = x, then we can jump any distance y such that y ≤ x.
Find the minimum number of jumps to reach the end of the array starting from the first element. If an element is 0, then you cannot move through that element.
Note: Return -1 if you can't reach the end of the array.
Example :
Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3
Explanation:First jump from 1st element to 2nd element with value 3. From here we jump to 5th element with value 9, and from here we will jump to the last. */




public class MinimumJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		//int arr[] = {1, 4, 3, 2, 6, 7};
		int arr[]  = {0, 10, 20};
		System.out.println(minJumps(arr));

	}
	public static int minJumps(int arr[]) {
		int n = arr.length;
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;
        if(n == 1) return 0;
        else if(arr[0] == 0) return -1;
        else{
            for(int i = 1; i<n; i++){
               if(i == n-1){
                   return jump;
               }
               maxReach = Math.max(maxReach, i+arr[i]);
               step--;
               if(step == 0){
                   jump++;
                   if(i >= maxReach) return -1;
                   step = maxReach - i;
               }
            }
        }
        return jump;
	}

}
