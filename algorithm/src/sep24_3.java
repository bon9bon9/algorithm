// https://www.acmicpc.net/problem/2156

import java.util.Scanner;

public class sep24_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] amount = new int[n];

        // 포도주 잔에 들어있는 양 입력
        for (int i = 0; i < n; i++) {
            amount[i] = sc.nextInt();
        }

        // dp 배열 선언
        int[] dp = new int[n];

        // 초기값 설정
        dp[0] = amount[0];  // 첫 번째 잔
        if (n > 1) {
            dp[1] = amount[0] + amount[1]; // 첫 번째 + 두 번째 잔
        }
        if (n > 2) {
            dp[2] = Math.max(amount[0] + amount[2], Math.max(amount[1] + amount[2], dp[1]));
        }

        // DP 전이식 적용
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], // i번째 잔을 마시지 않음
                    Math.max(dp[i - 2] + amount[i], // i번째 잔을 마시고 i-1번째 잔은 마시지 않음
                            dp[i - 3] + amount[i - 1] + amount[i])); // i번째와 i-1번째 잔을 마시고 i-2번째 잔은 마시지 않음
        }

        // 결과 출력
        System.out.println(dp[n - 1]);
    }
}