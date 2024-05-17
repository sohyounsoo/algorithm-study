package kim;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PM_데이터분석 {

    static int find_val(String ext){
        switch (ext){
            case "date"
                :return 1;
            case "maximum"
                :return 2;
            case "remain"
                :return 3;
            case "code"
                :return 0;
        }
        return 0;
    }

    static List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by){

        List<int[]> answer = Arrays.stream(data).filter(n -> {
            if (val_ext > n[find_val(ext)]) return true;
            return false;
        }).sorted((n, m) -> {
            return n[find_val(sort_by)] - m[find_val(sort_by)];
        }).collect(Collectors.toList());

        return answer;
    }



    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        solution(data, ext, val_ext, sort_by);
    }
}
