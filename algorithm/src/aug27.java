import java.util.*;
import java.io.*;
public class aug27 {

    public static void main(String[] args) {
        aug27 obj = new aug27(); // 클래스의 인스턴스 생성
        int[] result = obj.aug27(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        System.out.println(Arrays.toString(result)); // 결과 출력
    }
    public int[] aug27(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int[] curr_array = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(curr_array);
            answer[i] = curr_array[commands[i][2]-1];
        }
        return answer;
    }
}
