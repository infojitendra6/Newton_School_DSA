package Optimus.DynamicProgramming;

public class ZeroOneKnapsack {
    static int getMaximumValue(int n, int weight[], int value[], int W) {

        //        int []dp = new int[W + 1];
//
//// gfg code
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = W; j>= 0; j--) {
//
//                if (weight[i - 1] <= j)
//                    dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
//            }
//        }
//        return dp[W];





        int maximumValue = 0;
        int knapsack[][] = new int[n + 1][W + 1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= W; j++) {
                if(i == 0 || j == 0) {
                    knapsack[i][j] = 0;
                }
                else if(weight[i - 1] <= j) {
                    knapsack[i][j] = Math.max(
                            value[i - 1] + knapsack[i - 1][j - weight[i - 1]],
                            knapsack[i - 1][W]
                    );
                }
                else {
                    knapsack[i][j] = knapsack[i - 1][j];
                }
            }
        }
        maximumValue = knapsack[n][W];

        System.out.println("knapsack array: ");
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= W; j++) {
                System.out.printf("%2d ", knapsack[i][j]);
            }
            System.out.println();
        }

        return maximumValue;
    }

    public static void main(String[] args) {
        int n = 3;
        int weight[] = {1, 2, 3};
        int value[] = {10, 15, 40};
        int W = 6;

        int maximumValue = getMaximumValue(n, weight, value, W);

        System.out.println("Maximum Value: " + maximumValue);
    }
}
