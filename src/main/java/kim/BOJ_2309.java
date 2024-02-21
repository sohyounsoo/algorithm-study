package kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> dwarf_list= new ArrayList<>();
        int total_sum = 0;

        for(int i = 0 ; i < 9 ; i++){
            dwarf_list.add(Integer.valueOf(br.readLine()));
            total_sum += dwarf_list.get(i);
        }

        loop:
        for(int i = 0 ; i < dwarf_list.size()-1 ; i++){
            for(int j = i + 1 ; j < dwarf_list.size() ; j++){
                if(total_sum - dwarf_list.get(i) - dwarf_list.get(j) == 100 ){
                    Integer remove_dwarf = dwarf_list.get(j);
                    dwarf_list.remove(dwarf_list.get(i));
                    dwarf_list.remove(remove_dwarf);
                    break loop;
                }
            }
        }

        Collections.sort(dwarf_list);

        for (Integer dwarf_height : dwarf_list){
            System.out.println(dwarf_height);
        }
    }
}
