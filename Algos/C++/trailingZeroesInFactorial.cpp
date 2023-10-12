#include<iostream>
using namespace std;
 
int countTrailingZeros(int num)
{
    if (num < 0)
        return -1;
 
    int count = 0;

    for (int i = 5; num / i >= 1; i *= 5)
        count += num / i;
 
    return count;
}
 
int main()
{
    int num;
    cin>>num;
    cout<<"Number of trailing 0s in "<<num<< "! is "<< countTrailingZeros(num)<<endl;
    return 0;
}