/**
This program is solution to Problem 1726 - Tuple with Same Product
Problem statement - Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d.
Solution Time Complexity = O(n2), Space Complexity = O(n2)

Editorial from Leetcode - 
We are given an array nums containing n distinct positive integers. The goal is to find the number of tuples (a, b, c, d) such that:

a, b, c, and d are distinct elements of the nums array, and
The condition a * b == c * d is satisfied.
Note, that a tuple refers to an ordered list of 4 elements. This means the tuples (2, 3, 1, 6) and (3, 2, 1, 6) are considered distinct and counted separately.

In fact, if we have two pairs of numbers {a, b} and {c, d} that satisfy a * b == c * d, we can generate multiple distinct tuples by varying the order of the elements and the pairs:

(a, b, c, d)
(b, a, c, d)
(a, b, d, c)
(b, a, d, c)
(c, d, a, b)
(c, d, b, a)
(d, c, a, b)
(d, c, b, a)
To understand this, observe that for every two pairs of distinct numbers {a, b} and {c, d}, there are three independent ways to reorder the elements and pairs:

Within each pair:
The order of elements in {a, b} can be (a, b) or (b, a) (2 options).
Similarly, the order in {c, d} can be (c, d) or (d, c) (2 options).
Between the pairs:
The order of the two pairs can be ({a, b}, {c, d}) or ({c, d}, {a, b}) (2 options).
Since these choices are independent, the total number of distinct tuples is the product of these options: 2×2×2=8.

**/

class Solution {
    public int tupleSameProduct(int[] nums) {
        int output = 0;

        // Delcare and initialize map to store frequency of each product of pairs
        Map<Integer, Integer> productFrequency = new HashMap<>();

        // Iterate thru each pair and store frequency of its product in HashMap
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j++) {
                int num1 = nums[i];
                int num2 = nums[j];
                int numProd = num1 * num2;

                if (productFrequency.containsKey(numProd)) {
                    productFrequency.put(numProd, productFrequency.get(numProd) + 1);
                } else {
                    productFrequency.put(numProd, 1);
                }
            }
        }

        // Iterate on product frequency values and calculate the number of tuples for each frequency using formula = numberOfTupleForPair = productFreq * (productFreq-1) * 4
        for (Map.Entry<Integer, Integer> entry: productFrequency.entrySet()) {
            int count = entry.getValue();
            output += count * (count-1) * 4; 
       }
        return output;
    }
}
