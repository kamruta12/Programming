public class LeetCode268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        // Find sum of first n natural numbers using formula n*(n+1)/2
        int sumOfFirstNaturalNumbers = (n * (n + 1))/2;
        int sum = 0;
        for (int i: nums) {
            sum += i;
        }
        // Since array contains unique number, missing number is difference of sum of first n natural numbers and sum of numbers from the array 
        int output =  sumOfFirstNaturalNumbers - sum;
        return output;        
    }
}
