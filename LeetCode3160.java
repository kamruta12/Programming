/**
This class contains the solution for Leetcode Problem 3160 - Find the number of distinct colors among the balls
Solution is implemented in Time Complexity = O(n), Space Complexity = O(n)

**/

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        Map<Integer, Integer> ballMap = new HashMap<>();
        Map<Integer, Integer> colorMap = new HashMap<>();
        int numOfBalls = limit + 1;

        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            int label = query[0];
            int color = query[1];
            if (ballMap.containsKey(label)) {
                int prevColor = ballMap.get(label);
                if (colorMap.containsKey(prevColor)) {
                    colorMap.put(prevColor, colorMap.get(prevColor)-1);
                    if (colorMap.get(prevColor) == 0) {
                        colorMap.remove(prevColor);
                    }
                }
            }   
            ballMap.put(label, color);
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            result[i] = colorMap.size();         
        }

        return result;
        
    }
}
