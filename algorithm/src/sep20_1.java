// https://school.programmers.co.kr/learn/courses/30/lessons/12906
import java.util.*;
import java.io.*;
public class sep20_1 {
    public static void main(String[] args) {
        sep20_1 obj = new sep20_1();
        System.out.println(Arrays.toString(obj.solution(new int[]{1, 1, 3, 3, 0, 1, 1})));

    }

    public int[] solution(int []arr) {
        List<Integer> answerList = new ArrayList<>();
        int before = -1;
        for(int num : arr){
            if(before != num){
                answerList.add(num);
            }
            before = num;
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
