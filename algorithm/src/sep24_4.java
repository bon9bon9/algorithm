import java.util.*;
import java.io.*;

public class sep24_4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int layer = sc.nextInt();
        int[][] num = new int[layer+1][layer+1];
        int[][] dp = new int[layer+1][layer+1];


        for(int i = 1; i <= layer; i++ ){
            for(int j = 1; j <= i; j++){
                num[i][j] = sc.nextInt();
                if( i == 1 && j == 1) dp[i][j] = num[i][j];
                else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + num[i][j];
            }
        }
        int maxNum = 0;
        for(int i : dp[layer]){
            maxNum = Math.max(maxNum,i);
        }
        System.out.println(maxNum);

    }
}