// https://www.acmicpc.net/problem/9095

import java.util.*;
import java.io.*;

public class sep24_2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] num = new int[count];
        int maxNum = 0;
        for(int i = 0; i < count; i++){
            num[i] = sc.nextInt();
            maxNum = Math.max(num[i], maxNum);
        }
        int[] dp = new int[maxNum+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < maxNum+1; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        for(int i = 0; i < count; i++){
            System.out.println(dp[num[i]]);
        }

    }
}