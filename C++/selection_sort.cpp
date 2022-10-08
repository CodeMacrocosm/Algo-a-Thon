#include<iostream>
#include<vector>
using namespace std;
//implent selection sort
void selection_sort(vector<int> &arr,int n){
    for(int i=0;i<n-1;i++){
        int min_index=i;
        for(int j=i+1;j<n;j++){
            if(arr[j]<arr[min_index]){
                min_index=j;
            }
        }
        swap(arr[i],arr[min_index]);
    }
}
 //driver code
int main(){
    vector<int>arr={6,7,2,1,4};
    int n=arr.size();
    selection_sort(arr,n);
    for(int i=0;i<5;i++){
        cout<<arr[i]<<" ";
    }
    return 0;
}