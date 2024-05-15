package kim;

import java.util.ArrayList;
import java.util.List;

public class PM_대충만든자판 {

    static int find_keymap(char c, String[] keymap){
        int index = -1;
        int compare_value = Integer.MAX_VALUE;

        for(int i = 0 ; i < keymap.length ; i++){
            if(compare_value > keymap[i].indexOf(c) && keymap[i].indexOf(c) != -1) {
                index = i;
                compare_value = keymap[i].indexOf(c);
            }
        }

        if (index == -1) return -1;

        return keymap[index].indexOf(c);
    }

    static List<Integer> solution(String[] keymap, String[] targets){
        List<Integer> answer = new ArrayList<>();

        for (String target : targets){
            int count = 0;
            for(char c : target.toCharArray()){
                int index = find_keymap(c,keymap) + 1;
                if (index == 0) {
                    count = 0;
                    break;
                }
                count += index;
            }
            if (count > 0) answer.add(count);
            else answer.add(-1);
        }


        return answer;
    }

    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"DG"};

        System.out.println(solution(keymap, targets));
    }
}
