#include<iostream>
using namespace std;
int main(){
int num;
int count=1;
cout<<"enter the number";
cin>>num;//binary me
while(num!=0){
if(num&1){++count;}
num=num>>1;     
}
cout<<"the number of 1 bit is"<<count;
}