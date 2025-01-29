/**
This Program is solution for LeetCode coding problem 1426 Counting Elements. 
Problem Description - Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr. If there are duplicates in arr, count them separately.
Solution Time Complexity  O(n), Space Complexity = O(n)
**/
class LeetCode14 {
    public int countElements(int[] arr) {
        Set<Integer> numbersSet = new HashSet<Integer>();
        
        for (int n: arr) {
            numbersSet.add(n);
        }
        
        int output = 0;
        
        for (int n: arr) {
            if (numbersSet.contains(n+1)) {
                output++;
            }
        }
        
        return output;
        
    }
}
