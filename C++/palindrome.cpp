#include<iostream>
using namespace std;
int main(){int number,n;
cin>>number;
int arr[10];
int count=0;
while(number!=0){arr[count]=number%10;
number=number/10;
++count;
}
n=count;

int c2=0;
for(int i=0;i<n/2;i++){if( arr[i]==arr[n-1-i]){
c2++;
}}
if(c2==n/2){cout<<"yes palindrome";}
else{cout<<"no";}
return 0;
}