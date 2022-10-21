#include<stdio.h>
#include<stdlib.h>

int search(int arr[], int key, int size) {
    int low = 0,high = size-1,mid;
    
    while(low <= high) {
        mid = (low+high)/2;
        
        if(key == arr[mid]) return mid;
        else if(key < arr[mid]){
            high = mid-1;
        }
        else if(key > arr[mid]) {
            low = mid+1;
        }
    } 
    return 0;
    
}


int main() {
    
    printf("\nBinary search : ");
    int arr[] = {1,2,3,4,5,6,7,8,9};
    int size = sizeof(arr)/sizeof(arr[0]);

    //Enter the number to search in the Array using Binary Search Algorithm
    //(for example 4)
    int ret = search(arr,4,size);
    
    if(ret) printf("\nTarget found at index %d.",ret);
    else printf("\nTarget not found.");
    return 0;
}
