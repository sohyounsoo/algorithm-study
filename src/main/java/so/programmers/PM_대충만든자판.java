package so.programmers;

import java.util.HashMap;
import java.util.Map;

public class PM_대충만든자판 {

    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};
        for (int i : solution(keymap, targets)) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();

        for(String k : keymap) {
            for(int i=0; i<k.length(); i++) {
                char c = k.charAt(i);
                // System.out.println("c= " + c);
                if(!map.containsKey(c) || i < map.get(c)) {
                    map.put(c, i+1);
                }
            }
        }

        int index = 0;
        for(String t : targets) {
            for(int i=0; i<t.length(); i++) {
                char c = t.charAt(i);
                if(map.getOrDefault(c, -1) == -1) {
                    answer[index] = -1;
                }else {
                    answer[index] += map.get(c);
                }
            }
            index++;
        }

        return answer;
    }

}
