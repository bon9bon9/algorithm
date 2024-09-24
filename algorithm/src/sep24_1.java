// https://www.acmicpc.net/problem/1463

import java.util.*;
import java.io.*;

public class sep24_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        int[] dp = new int[num+1];
        dp[1] = 0;
        for(int i = 2; i < num+1; i++){
            dp[i] = dp[i-1] + 1;
            if(i % 3 == 0 && dp[i/3] < dp[i]-1){
                dp[i] = dp[i/3] + 1;
            }
            if( i % 2 == 0 && dp[i/2] < dp[i]-1){
                dp[i] = dp[i/2] + 1;
            }
        }
        System.out.println(dp[num]);
    }
}
