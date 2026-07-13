class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;

        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 2;

        int head = 2;
        int tail = 3;
        int num = 1;
        int countOnes = 1;

        while (tail < n) {
            for (int i = 0; i < arr[head] && tail < n; i++) {
                arr[tail] = num;
                if (num == 1) {
                    countOnes++;
                }
                tail++;
            }
            num = (num == 1) ? 2 : 1;
            head++;
        }

        return countOnes;
    }
}