#include<iostream>
using namespace std;
int pivot(int nums[],int k) {int sum=0;
int i;
    for( i=0;i<k;i++){
sum+=nums[i];}
int current =0;                                         
 for(int j=0;j<k;j++){
  if(current==sum-nums[j]-current){ return j;}// traversing the array to find index.
    else{current+=nums[j];}}
        return -1;




}


int main(){
int k;
cin>>k;//array size
int nums[k];//array declaration 
for(int i=0;i<k;i++){
cin>>nums[i];
}//taking input 
cout<<pivot(nums,k);






}