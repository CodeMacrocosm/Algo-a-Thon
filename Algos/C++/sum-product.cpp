#include<iostream>
using namespace std;
int main(){
int num;
cout<<"enter the number";
cin>>num;
int sum=0;
int prdt=1;
while(num!=0){
sum=sum+(num%10);
prdt=prdt*(num%10);
num=num/10;

}

cout<<"sum is:"<<sum;
cout<<"prdt is:"<<prdt;





return 0;
}