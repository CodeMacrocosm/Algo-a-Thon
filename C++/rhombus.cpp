#include<bits/stdc++.h> //master library

using namespace std;    //scope decleration

int main()
{
    int numberofLines;
    cout<<"Enter no of lines"<<endl;
    cin>>numberofLines; //store value from user

    //for loop for print lines
    for(int i=0; i<numberofLines; i++)
    {
        //nested for loop to print space
        for(int j=numberofLines; j>i; j--)
            {
                cout<<"  ";
            }
            //nested for loop for * pattern
         for(int j=0; j<numberofLines; j++)
            {
                cout<<"* ";
            }
            //endl; for new line after loop of line
            cout<<endl;
    }
    //endl; for new line after loop of line

    return 0;
}
