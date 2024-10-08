/*Given a sorted array arr[] of positive integers, find the smallest positive integer such that it cannot be represented as the sum of elements of any subset of the given array set.

Input: arr[] = [1, 2, 3]
Output: 7

Input: arr[] = [3, 6, 9, 10, 20, 28]
Output: 1 */


public class NotASubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[] = {1, 2, 3};
		int arr[] = {3, 6, 9, 10, 20, 28};
		int ans = findSmallest(arr);
		System.out.println(ans);
	}
	public static int findSmallest(int[] arr) {
		int ans = 1;
        int n = arr.length;
        for(int i = 0; i<n; i++){
           if(arr[i] > ans) return ans;
           else ans+=arr[i];
        }
        return ans;
	}

}
