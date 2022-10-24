#include<bits/stdc++.h>
using namespace std;

int main() {
    vector<int> v = {5, 7, 13, 7, 5, 4, 3, 5, 6, 7, 8, 9, 2, 3};
    vector<int> result(v.size(), 1);
    stack<int> s;

    s.push(0);

    for(int i=1; i<v.size(); i++) {
        while(!s.empty() && v[s.top()] < v[i])
            s.pop();

        if(s.empty())
            result[i] = i + 1;
        else
            result[i] = i - s.top();
        s.push(i);
    }

    for(int i=0; i<v.size(); i++)
        cout<<result[i]<<" ";

    return 0;
}
