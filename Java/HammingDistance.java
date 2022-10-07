// Hamming distance is a metric for comparing two binary data strings
class Solution {
    public int hammingDistance(int x, int y) {
        int ans = x ^ y;
        int SetBits = 0;
        while(ans > 0){
            SetBits += ans & 1;
            ans >>= 1;
        }
        return SetBits;
    }
}
