import java.util.*;
import java.io.*;

public class sep23_1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int houseCnt = sc.nextInt();
        int[][] cost = new int[houseCnt][3];

        for(int i = 0; i < houseCnt; i++){
            for(int j = 0; j < 3; j++){
                cost[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[houseCnt][3];

        for(int i = 0; i < 3; i++){
            dp[0][i] = cost[0][i];
        }

        for(int i = 1; i < houseCnt; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
        }
        int minCost = Math.min(dp[houseCnt-1][0],Math.min(dp[houseCnt-1][1],dp[houseCnt-1][2]));
        System.out.println(minCost);
    }


}