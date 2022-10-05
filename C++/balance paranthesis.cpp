#include <bits/stdc++.h>
using namespace std;

void balance(string s)
{
    stack<char> st;
    int l=s.length();
    int i,flag=0;
    for(i=0;i<l;i++)
    {
        if((s[i]=='(')||(s[i]=='{')||(s[i]=='['))
           st.push(s[i]);
        else if(s[i]==')')
        {
            if((!st.empty())&&(st.top()=='('))
                st.pop();
            else
            {
                flag=1;
                break;
            }
        }
        else if(s[i]=='}')
        {
            if((!st.empty())&&(st.top()=='{'))
                st.pop();
            else
            {
                flag=1;
                break;
            }
        }
        else if(s[i]==']')
        {
            if((!st.empty())&&(st.top()=='['))
                st.pop();
            else
            {
                flag=1;
                break;
            }
        }
    }
    if((flag==1)||(!st.empty()))
        cout<<"Unbalanced paranthesis"<<endl;
    else
        cout<<"Balanced paranthesis"<<endl;
}
int main()
{
    char exp[100];
    cout<<"Enter the expression:";
    cin>>exp;
    balance(exp);
    return 0;
}
