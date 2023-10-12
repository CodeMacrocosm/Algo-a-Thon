#include<iostream>
#include<vector>
using namespace std;
int binarySearch(vector<int>arr,int key){
    int start=0;
    int end=arr.size()-1;
    while(start<=end){
        int mid=(start+end)/2;
        if(arr[mid]==key){
            return mid;
        }
        else if(arr[mid]>key){
            end=mid-1;
        }
        else{
            start=mid+1;
        }
    }
    return -1;
}
int main(){
    vector<int>arr={1,2,3,4,5,6,7,8,9,10};
    int key;
    cin>>key;
    cout<<binarySearch(arr,key);
    return 0;
}