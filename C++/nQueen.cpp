#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<vector<int>> ans;
    bool isSafe(vector<vector<int>> b, int row, int col, int n)
    {
        int i, j;
        for (i = 0; i < col; i++)
            if (b[row][i])
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (b[i][j])
                return false;

        for (i = row, j = col; j >= 0 && i < n; i++, j--)
            if (b[i][j])
                return false;

        return true;
    }

    bool solve(vector<vector<int>> &b, int col, int n)
    {

        if (col == n)
        {
            vector<int> v;
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (b[i][j] == 1)
                        v.push_back(j + 1);
                }
            }
            ans.push_back(v);
            return true;
        }
        bool res = false;
        for (int i = 0; i < n; i++)
        {

            if (isSafe(b, i, col, n))
            {

                b[i][col] = 1;
                if (solve(b, col + 1, n) == true)
                {
                    res = true;
                }
                b[i][col] = 0;
            }
        }

        return res;
    }

    vector<vector<int>> nQueen(int n) {
        // code here
        vector<vector<int> > board(n, vector<int>(n, 0));
        solve(board, 0 , n);
        sort(ans.begin(),ans.end());
        return ans;

    }
};

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;

        Solution ob;
        vector<vector<int>> ans = ob.nQueen(n);
        if (ans.size() == 0)
            cout << -1 << "/n";
        else
        {
            for (int i = 0; i < ans.size(); i++)
            {
                cout << "[";
                for (int u : ans[i])
                    cout << u << " ";
                cout << "]";
            }
            cout << endl;
        }
    }
    return 0;
}
