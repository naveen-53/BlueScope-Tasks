import java.util.*;

public class MaxRectangle {

    private static int largestHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static int maxRectangle(int[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int[] height = new int[matrix[0].length];
        int maxArea = 0;

        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                height[i] = row[i] == 0 ? 0 : height[i] + 1;
            }
            maxArea = Math.max(maxArea, largestHistogram(height));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 0, 0, 0 },
                { 1, 0, 1, 1 },
                { 1, 0, 1, 1 },
                { 0, 1, 0, 0 }
        };
        System.out.println("Largest Rectangle Area = " + maxRectangle(matrix));
    }
}
