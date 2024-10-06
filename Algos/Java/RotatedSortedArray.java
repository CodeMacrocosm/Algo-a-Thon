import java.util.*;
public class JavaQuizes {
    public static void main(String[] args) {
        int[] arr={3,1,2,3,3,3,3};
        int l=0;
        int h=arr.length-1;
        int t=10;
        int flag=0;
        while(l<=h){
            int m=(l+h)/2;
            if(arr[m]==t){
                System.out.println("TRUE");
                flag=1;
                break;
            }
            if(arr[l]==arr[m] && arr[m]==arr[h]){
                l=l+1;
                h=h-1;
                continue;
            }
            if(arr[m]>=arr[l]){
                if(arr[l]<=t && t<=arr[m]){
                    h=m-1;
                }else{
                    l=m+1;
                }
            }
            else{
                if(arr[m]<=t && t<=arr[h]){
                    l=m+1;
                }else{
                    h=m-1;
                }
            }
        }
        if(flag==0){
            System.out.println("FALSE");
        }
    }
    }



