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

    public static List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        String[] s = {"code", "date", "maximum", "remain"};
        int extIdx=0, sortIdx=0;

        for(int i=0; i<4; i++) {
            if(ext.equals(s[i])) extIdx = i;
            if(sort_by.equals(s[i])) sortIdx = i;
        }

        for(int i=0; i<data.length; i++) {
            if(val_ext > data[i][extIdx]) list.add(data[i]);
        }

        final int si = sortIdx;
        Collections.sort(list, (o1, o2) -> o1[si]-o2[si]);

        return list;
    }

}
