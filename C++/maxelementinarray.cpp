#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    int ar[n];
    for(int i = 0; i < n; i++) {
        cin >> ar[i];
    }
    int ans = ar[0];
    for(int i = 1; i < n; i++) {
        ans = max(ans, ar[i]);
    }
    cout << ans << endl;
    return 0;
}
