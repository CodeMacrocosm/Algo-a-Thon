#include<iostream>
#include<vector>
using namespace std;
int binary_search(vector<int> &arr,int l,int r,int key){
    if(l<=r){
        int mid=(l+r)/2;
        if(arr[mid]==key){
            return mid;
        }
        else if(arr[mid]>key){
            return binary_search(arr,l,mid-1,key);
        }
        else{
            return binary_search(arr,mid+1,r,key);
        }
    }
    return -1;
}
int exponential_search(vector<int> &arr,int n,int key){
    if(arr[0]==key){
        return 0;
    }
    int i=1;
    while(i<n && arr[i]<=key){
        i=i*2;
    }
    return binary_search(arr,i/2,min(i,n-1),key);
}

int main(){
    vector<int>arr={1,2,3,4,5,6,7,8,9,10};
    int n=arr.size();
    int key=5;
    cout<<exponential_search(arr,n,key);
    return 0;