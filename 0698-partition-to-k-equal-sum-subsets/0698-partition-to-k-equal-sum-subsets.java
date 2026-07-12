class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        // If total sum is not divisible by k
        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;

        // Sort in descending order for better pruning
        Arrays.sort(nums);
        reverse(nums);

        // If the largest element is greater than target
        if (nums[0] > target) {
            return false;
        }

        int[] buckets = new int[k];

        return backtrack(nums, 0, buckets, target);
    }

    private boolean backtrack(int[] nums, int index, int[] buckets, int target) {
        if (index == nums.length) {
            return true;
        }

        int num = nums[index];

        for (int i = 0; i < buckets.length; i++) {

            // Skip if adding exceeds target
            if (buckets[i] + num > target) {
                continue;
            }

            buckets[i] += num;

            if (backtrack(nums, index + 1, buckets, target)) {
                return true;
            }

            buckets[i] -= num;

            // Pruning:
            // If current bucket was empty, don't try other empty buckets.
            if (buckets[i] == 0) {
                break;
            }
        }

        return false;
    }

    private void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}