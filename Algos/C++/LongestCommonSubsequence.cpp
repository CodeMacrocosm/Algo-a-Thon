#include<bits/stdc++.h>
using namespace std;

// Recursive - Top Down - Memoization
int lcs_recursion(string s1, string s2, int m, int n, vector< vector<int> > &dp) {
    if(dp[m][n] != -1)
        return dp[m][n];
    if(m == 0 || n == 0)
        return 0;
    if(s1[m-1] == s2[n-1])
        return dp[m][n] = 1 + lcs_recursion(s1, s2, m-1, n-1, dp);
    else
        return dp[m][n] = max(lcs_recursion(s1, s2, m-1, n, dp), lcs_recursion(s1, s2, m, n-1, dp));
}

// Iterative - Bottom Up - Tabulation
int lcs_iterative(string s1, string s2, int m, int n) {
    vector< vector <int> > dp(m+1, vector<int>(n+1, 0));

    for(int i=1; i<=m; i++) {
        for(int j=1; j<=n; j++) {
            if(s1[i-1] == s2[j-1])
                dp[i][j] = 1 + dp[i-1][j-1];
            else
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);    
        }
    }

    return dp[m][n];
}

int main()
{
    string s1 = "AGGTAB";
    string s2 = "GXTXAYB";

    int m = s1.size(), n = s2.size();

    vector< vector<int> > dp(m+1, vector<int>(n+1, -1));

    cout<<"The longest common subsequence is of length (memoization): "<<lcs_recursion(s1, s2, m, n, dp)<<endl;
    cout<<"The longest common subsequence is of length (tabulation): "<<lcs_iterative(s1, s2, m, n)<<endl;
    return 0;
}
