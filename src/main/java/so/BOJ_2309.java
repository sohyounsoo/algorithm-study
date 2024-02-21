package so;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_2309 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final List<String> person = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        List<Integer> answer = new ArrayList<>();
        int personCount = 9; //난쟁이 숫자

        for(int i=0; i<personCount; i++) {
            person.add(br.readLine());
        }

        boolean found = false; //한번만 찾으면 바로 for문을 종료하기 위해서

        for(int i=0; i<personCount-1 && !found; i++) {
            for(int j=1; j<personCount && !found; j++) {
                String a = person.get(i);
                String b = person.get(j);

                List<String> sevenPerson = getSevenPerson(a, b);

                int sum = sevenPerson.stream()
                        .mapToInt(Integer::parseInt)
                        .sum();

                if(sum == 100) {
                    found =true;
                    answer = sevenPerson.stream()
                            .map(Integer::parseInt)
                            .sorted()
                            .collect(Collectors.toList());
                }
            }
        }

        for (int person : answer) {
            System.out.println(person);
        }

    }

    private static List<String> getSevenPerson(final String a, final String b) {
        ArrayList<String> sevenPerson = new ArrayList<>(person);
        sevenPerson.remove(a);
        sevenPerson.remove(b);

        return sevenPerson;
    }
}
