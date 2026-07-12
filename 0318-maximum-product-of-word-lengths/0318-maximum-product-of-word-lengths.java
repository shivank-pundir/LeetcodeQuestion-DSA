class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[n];

        // Create bitmask for each word
        for (int i = 0; i < n; i++) {
            int bitMask = 0;
            for (char ch : words[i].toCharArray()) {
                bitMask |= (1 << (ch - 'a'));
            }
            mask[i] = bitMask;
        }

        int maxProduct = 0;

        // Compare every pair of words
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    int product = words[i].length() * words[j].length();
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }

        return maxProduct;
    }
}