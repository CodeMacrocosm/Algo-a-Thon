#include<bits/stdc++.h>
using namespace std;
string solve(int n, vector<int> A, vector<int> B){
   int d = 0;
   int e = 0;
   for(int i = 0; i<A.size(); i++){
      int f = A[i];
      if (d < f)
         d = f;
   }
   for(int i = 0; i<A.size(); i++){
      int f = A[i];
      if(e < f)
         e = f;
   }
   if (d > e)
      return "Amal";
   else
      return "Bimal";
}
int main(){
   int n = 5;
   vector<int> A = {3, 2};
   vector<int> B = {5, 1, 4};
   cout << solve(n, A, B) << endl;
}
