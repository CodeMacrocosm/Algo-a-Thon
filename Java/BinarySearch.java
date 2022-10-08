public class BinarySearch {
    public static void main(String[] args) {
        //Executing binary search algorithm
        int[] a={1,2,3,4,6,7,8,9,10};
        int key=4;
        System.out.println("Element found at index "+binary(a,key));


    }
    static int binaryS(int[] arr,int key){
        int start=0;
        int end=arr.length-1;

        while (start<=end){
            int mid=start+(end-start)/2;
            if (arr[mid]==key){
                return mid;
            }
            if(arr[mid]>key){
                end=mid-1;
            }
            if (arr[mid]<key){
                start=mid+1;
            }
            }
        return -1;

        }


}
