import java.util.*;
import java.io.*;

public class sep23_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int glass = sc.nextInt();
        int[] amount = new int[glass];
        for(int i = 0; i < glass; i++){
            amount[i] = sc.nextInt();
        }
        boolean[] drink = new boolean[glass];
        int[] dp = new int[glass];
        dp[0] = amount[0];
        drink[0] = true;
        dp[1] = amount[1] + dp[0];
        drink[1] = true;

        for(int i = 2; i < glass; i++){
            if(drink[i-2] && drink[i-1]){
                int way1 = amount[i-2] + amount[i-1];
                int way2 = amount[i-1] + amount[i];
                int way3 = amount[i-2] + amount[i];
                if(way2 > way1 || way3 > way1){
                    if(way3 >= way2){
                        dp[i] = dp[i-1] - amount[i-1] + amount[i];
                        drink[i] = true;
                        drink[i-1] = false;
                    }else{
                        dp[i] = dp[i-1] - amount[i-2] + amount[i];
                        drink[i] = true;
                        drink[i-2] = false;
                        if(i == 3 || i == 4){
                            if(!drink[i-3]){
                                drink[i-3] = true;
                                dp[i] = dp[i] + amount[i-3];
                            }
                        }else if(i > 5){
                            if(!drink[i-3] && !(drink[i-4]&&drink[i-5])){
                                drink[i-3] = true;
                                dp[i] = dp[i] + amount[i-3];
                            }
                        }
                    }

                }else{
                    drink[i] = false;
                    dp[i] = dp[i-1];
                }
            }else{
                dp[i] = dp[i-1] + amount[i];
                drink[i] = true;
            }
        }
        System.out.println(dp[glass-1]);
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(drink));

    }

}