/**
 This class contains solution to LeetCode 268 problem - Missing Number. Problem description is - 
 Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 The implemented approach has Time complexity = O(n) and Space Complexity = O(1)
**/
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
