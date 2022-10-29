#include <bits/stdc++.h>
using namespace std;

int find_LongestConsecutiveSubsequence(vector<int> arr, int N)
{
    unordered_set<int> S;
    int res = 0;
    for (int i = 0; i < N; i++)
    {
        S.insert(arr[i]);
    }
    for (int i = 0; i < N; i++)
    {
        if (S.find(arr[i] - 1) == S.end())
        {
            int j = arr[i];
            while (S.find(j) != S.end())
                j++;
            res = max(j - arr[i], res);
        }
    }
    return res;
}

int main()
{
    int N;
    cin >> N;
    vector<int> arr(N);
    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }
    cout << find_LongestConsecutiveSubsequence(arr, N) << endl;
    return 0;
}