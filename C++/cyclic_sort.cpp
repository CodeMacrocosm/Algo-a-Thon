#include<iostream>
#include<vector>
using namespace std;
//implent cyclic sort
void cyclic_sort(vector<int> &arr,int n){
    int i=0;
    while(i<n){
        int correct=arr[i]-1;
        if(arr[i]!=arr[correct]){
            swap(arr[i],arr[correct]);
        }
        else{
            i++;
        }
    }
}
 //driver code
int main(){
    vector<int>arr={3,5,2,1,4};
    int n=arr.size();
    cyclic_sort(arr,n);
    for(int i=0;i<5;i++){
        cout<<arr[i]<<" ";
    }
    return 0;
}