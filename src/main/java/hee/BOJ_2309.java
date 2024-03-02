package hee;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class BOJ_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int sum = 0 ;

        for(int i=0; i< 9; i++){
            list.add(Integer.valueOf(br.readLine()));
            sum += list.get(i);
        }

        loop:
        for (int i = 0; i < list.size()-1; i++) {
            for(int j= 1; j<list.size(); j++){
                if((sum - list.get(i) - list.get(j)) == 100){
                    list.remove(list.get(j));
                    list.remove(list.get(i));

                    list.sort(Comparator.naturalOrder());
                    System.out.println(list.toString());
                    break loop;

                }
            }
        }

    }
}
