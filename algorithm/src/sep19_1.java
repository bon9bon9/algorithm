// https://school.programmers.co.kr/learn/courses/30/lessons/1845
import java.util.*;
import java.io.*;
public class sep19_1 {
    public static void main(String[] args) {
        sep19_1 sep19_1 = new sep19_1();
        System.out.println(sep19_1.solution(new int[]{3, 3, 3, 2, 2, 4}));
    }

    public int solution(int[] nums) {
        Set<Integer> answer = new HashSet<>();
        int maxLength = nums.length / 2;
        for(int num : nums){
            answer.add(num);
            if(answer.size() == maxLength) break;
        }
        return answer.size();
    }
}
