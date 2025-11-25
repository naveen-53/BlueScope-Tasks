package basic;

import java.util.Arrays;
import java.util.List;

public class CircleForm {
    public static boolean conn(String a, String b) {
        return a.charAt(a.length() - 1) == b.charAt(0);
    }

    public static boolean circle(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            boolean[] ch = new boolean[words.size()];
            String first = words.get(i);
            String curr = first;
            ch[i] = true;
            int count = 1;

            while (true) {
                boolean flag = false;

                for (int j = 0; j < words.size(); j++) {
                    if (!ch[j] && conn(curr, words.get(j))) {
                        ch[j] = true;
                        curr = words.get(j);
                        count++;
                        flag = true;
                        break;
                    }
                }

                if (!flag) break;
            }

            if (count == words.size() && conn(curr, first))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("chair", "height", "racket", "touch", "tunic");

        if (circle(words))
            System.out.println("circle formed");
        else
            System.out.println("circle cannot be formed");
    }
}
