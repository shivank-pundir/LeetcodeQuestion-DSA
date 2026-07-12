class Solution {
    public int findComplement(int num) {
        int mask = 1;

        // Create a mask like 111... (same length as num)
        while (mask < num) {
            mask = (mask << 1) | 1;
        }

        return num ^ mask;
    }
}