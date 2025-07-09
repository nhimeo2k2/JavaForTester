package org.example;

    public class TwoSumII {
        public static int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;

            while (left < right) {
                int sum = numbers[left] + numbers[right];

                if (sum == target) {
                    // Trả về chỉ số bắt đầu từ 1
                    return new int[]{left + 1, right + 1};
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

            // Nếu không tìm thấy
            return new int[]{-1, -1};
        }

        public static void main(String[] args) {
            int[] numbers = {2, 7, 11, 15};
            int target = 9;

            int[] result = twoSum(numbers, target);
            System.out.println("Output: [" + result[0] + ", " + result[1] + "]");
        }
}
