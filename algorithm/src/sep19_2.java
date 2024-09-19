import java.util.*;
import java.io.*;

public class sep19_2 {
    public static void main(String[] args) {
        sep19_2 sep19_2 = new sep19_2();
        System.out.println(sep19_2.solution(new String[]{"leo", "kiki", "eden"},
                new String[]{"eden", "kiki"}));
    }
    public String solution(String[] participate, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        String answer = "";
        for(String comp : completion){
            map.put(comp, map.getOrDefault(comp, 0) + 1);
        }
        for(String part : participate){
            Integer cnt = map.get(part);
            if(cnt == null){
                answer = part;
                break;
            }
            if(cnt == 1) map.remove(part);
            else map.put(part, cnt - 1);
        }
        return answer;
    }
}
