import java.util.*;
import java.io.*;
public class sep20_2 {
    public static void main(String[] args) {
        sep20_2 obj = new sep20_2();
        System.out.println(Arrays.toString(obj.solution(new int[]{93, 30, 55},new int[]{1, 30, 5})));
    }
    public int[] solution(int[] progresses, int[] speeds) {
        int period = 0;
        int cnt = 1;
        List<Integer> answerList = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++){
            int this_period = (int)Math.ceil((double)(100-progresses[i])/speeds[i]);
            if(period == 0) period = this_period;
            else if(period < this_period){
                period = this_period;
                answerList.add(cnt);
                cnt = 1;
            }else {
                cnt++;
            }
        }
        answerList.add(cnt);
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answer.length ; i++ ){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
