package kim;

import java.util.*;

public class PM_성격유형검사하기 {


    static int get_choice_point(int choice){
        int point = 0;

        switch (choice){
            case 1:
            case 7:
                point = 3;
                break;
            case 2:
            case 6:
                point = 2;
                break;
            case 3:
            case 5:
                point = 1;
        }

        return point;
    }

    static String solution(String[] survey, int[] choices){
        Map<Character,Integer> choice_map = new HashMap<>();

        for (int i = 0; i< survey.length ; i++){
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);

            choice_map.put(first,choice_map.getOrDefault(first,0));
            choice_map.put(second,choice_map.getOrDefault(second,0));

            if (choices[i] <= 3){
                choice_map.put(first,choice_map.get(first) + get_choice_point(choices[i]));
            }else if(choices[i] > 4){
                choice_map.put(second,choice_map.get(second) + get_choice_point(choices[i]));
            }
        }

        return new StringBuffer()
                .append(choice_map.getOrDefault('R',0) >= choice_map.getOrDefault('T',0) ? 'R' : 'T')
                .append(choice_map.getOrDefault('C',0) >= choice_map.getOrDefault('F',0) ? 'C' : 'F')
                .append(choice_map.getOrDefault('J',0) >= choice_map.getOrDefault('M',0) ? 'J' : 'M')
                .append(choice_map.getOrDefault('A',0) >= choice_map.getOrDefault('N',0) ? 'A' : 'N')
                .toString();
    }

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        System.out.println(solution(survey, choices));
    }
}
