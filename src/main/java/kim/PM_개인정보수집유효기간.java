package kim;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PM_개인정보수집유효기간 {



    static List<Integer> solution(String toDay, String[] terms, String[] privacies) {
        List<Integer> answers = new ArrayList<>();

        LocalDate now_date = LocalDate.parse(toDay.replace(".","-"));

        for (int i = 0 ; i < privacies.length ; i++){
            String[] split = privacies[i].split(" ");
            String after = Arrays.stream(terms)
                            .filter(n -> n.indexOf(split[1]) != -1)
                            .findFirst().orElse("0 0");

            LocalDate compare_date = LocalDate.parse(split[0].replace(".","-"))
                    .plusMonths(Integer.parseInt(after.split(" ")[1])).minusDays(1); // 약관일을 포함하지 않기 떄문에 -1일

            if (now_date.isAfter(compare_date)) answers.add(i + 1);
        }
        return answers;
    }


    public static void main(String[] args) {
        String toDay = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        solution(toDay, terms, privacies);
    }


}
