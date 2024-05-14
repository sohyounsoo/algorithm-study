package so.programmers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PM_데이터_분석 {

    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "data";
        int val_ext = 20300501;
        String sort_by = "remain";

        solution(data, ext, val_ext, sort_by);
    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer;
        List<Integer> list = new ArrayList<>();
        int index, sort;

        if(ext.equals("code")) index = 0;
        else if(ext.equals("date")) index = 1;
        else if(ext.equals("maximum")) index = 2;
        else index = 3;

        if(sort_by.equals("code")) sort = 0;
        else if(sort_by.equals("date")) sort = 1;
        else if(sort_by.equals("maximum")) sort = 2;
        else sort = 3;

        for(int i=0; i<data.length; i++) {
            if(val_ext > data[i][index]) {
                list.add(i);
            }
        }
        answer = new int[list.size()][4];

        int a = 0;
        for(int i : list) {
            for(int j=0; j<4; j++) {
                answer[a][j] = data[i][j];
            }
            a++;
        }

        Arrays.sort(answer, (o1, o2) -> {
            return o1[sort]-o2[sort];
        });

        return answer;
    }

}
