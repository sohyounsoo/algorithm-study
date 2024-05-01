package so.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PM_개인정보_수집_유효기간 {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        solution(today, terms, privacies);
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(String s : terms) {
            String[] temp = s.split(" ");
            map.put(temp[0], Integer.valueOf(temp[1]));
        }

        String[] day = today.split("\\.");

        for(int i=0; i<privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            String[] date = temp[0].split("\\.");

            int yy = Integer.valueOf(date[0]);
            int mm = Integer.valueOf(date[1]);
            int dd = Integer.valueOf(date[2]);

            if(dd == 1) { // 유효기간 날짜
                mm -= 1;
                dd = 28;
            }else {
                dd -= 1;
            }

            mm = map.get(temp[1]) + mm;
            if(mm > 12)  {
                yy += mm/12;
                mm = mm % 12;
            }

            if(mm == 0) {
                mm = 12;
                yy -= 1;
            }

            if(Integer.valueOf(day[0]) > yy) list.add(i+1);
            else if(Integer.valueOf(day[0]) == yy) {
                if(Integer.valueOf(day[1]) > mm) list.add(i+1);

                if((Integer.valueOf(day[1]) == mm)) {
                    if(Integer.valueOf(day[2]) > dd) list.add(i+1);
                }
            }

        }

        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}
