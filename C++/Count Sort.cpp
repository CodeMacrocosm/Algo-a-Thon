#include <bits/stdc++.h>
using namespace std;

void input_array(vector<int> &arr)
{
    int N; cin >> N;
    for(int i=0; i<N; i++){
        int inp; cin >> inp;
        arr.push_back(inp);
    }
}

void count_sort(vector<int> &arr)
{
    int N = arr.size();
    int max_ele = *max_element(arr.begin(), arr.end());
    int min_ele = *min_element(arr.begin(), arr.end());
    int range = max_ele - min_ele + 1;

    vector<int> res(N);
    vector<int> count(range);

    for (int i = 0; i < N; i++)
        count[arr[i] - min_ele]++;

    for (int i = 1; i < range; i++)
        count[i] += count[i - 1];

    for (int i = N - 1; i >= 0; i--)
    {
        res[count[arr[i] - min_ele] - 1] = arr[i];
        count[arr[i] - min_ele]--;
    }

    for (int i = 0; i < N; i++)
        arr[i] = res[i];
}

void print_array(vector<int> &arr)
{
    for (int i = 0; i < arr.size(); i++)
        cout << arr[i] << " ";
    cout << endl;
}

int main()
{
    vector<int> arr;
    input_array(arr);
    count_sort(arr);
    print_array(arr);
    return 0;
}