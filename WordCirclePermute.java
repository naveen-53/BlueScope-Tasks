import java.util.*;

public class WordCirclePermute {
    static void permute(List<String> arr, int idx, List<List<String>> res) {
        if (idx  == arr.size()) {
            res.add(new ArrayList<>(arr));
            return;
        }
        for (int i = idx; i < arr.size(); i++) {
            Collections.swap(arr, i, idx);
            permute(arr, idx + 1, res);
            Collections.swap(arr, i, idx); // backtrack
        }
    }
    static boolean isCircle(List<String> words) {
        int n = words.size();

        for (int i = 0; i < n - 1; i++) {
            char last = words.get(i).charAt(words.get(i).length() - 1);
            char nextStart = words.get(i + 1).charAt(0);

            if (last != nextStart)
                return false;
        }
        char last = words.get(n - 1).charAt(words.get(n - 1).length() - 1);
        char firstStart = words.get(0).charAt(0);

        return last == firstStart;
    }
    static boolean canFormCircle(List<String> words) {
        List<List<String>> allPermutations = new ArrayList<>();
        permute(words, 0, allPermutations);

        for (List<String> perm : allPermutations) {
            if (isCircle(perm)) {
                System.out.println("Valid Circle Found: " + perm);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        List<String> words = Arrays.asList("chair", "height", "racket", "touch", "tunic");
        boolean ans = canFormCircle(words);
        System.out.println(ans);
    }
}
