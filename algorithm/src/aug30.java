import java.util.*;
import java.io.*;
public class aug30 {
    public static void main(String[] args) {
        aug30 aug30 = new aug30();
        System.out.println(aug30.solution(new int[]{0,0}));
    }

    public String solution(int[] numbers) {
        List<String> str = new ArrayList<>();
        for (int number : numbers){
            str.add(number+"");
        }
        str.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        String answer = String.join("",str);
        return answer.substring(0,1).equals("0") ? "0" : answer;
    }

}
