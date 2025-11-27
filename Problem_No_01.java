package DSA;
public class Problem_1 {
    public static int maxRectangle(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int maxOnes = 0;
        for (int r1 = 0; r1 < rows; r1++)
        {
            for (int c1 = 0; c1 < cols; c1++)
            {
                if (array[r1][c1] == 1)
                {
                    for (int r2 = r1; r2 < rows; r2++)
                    {
                        for (int c2 = c1; c2 < cols; c2++)
                        {
                            if (check(array, r1, c1, r2, c2))
                            {
                                int area = (r2 - r1 + 1) * (c2 - c1 + 1);
                                if (area > maxOnes)
                                {
                                    maxOnes = area;
                                }
                            }
                        }
                    }
                }
            }
        }
        return maxOnes;
    }
    private static boolean check(int[][] array, int r1, int c1, int r2, int c2) {
        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                if (array[r][c] == 0) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] array =
                {{1, 0, 0, 0},
                {1, 0, 1, 1},
                {1, 0, 1, 1},
                {0, 1, 0, 0}};
        System.out.println(maxRectangle(array));
    }
}
