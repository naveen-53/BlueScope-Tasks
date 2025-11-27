package DSA;
public class Problem_2 {
    static boolean formCircle(String[] words, int index) {
        if (index == words.length) {
            return words[index - 1].charAt(words[index - 1].length() - 1)
                    == words[0].charAt(0);
        }
        for (int i = index; i < words.length; i++) {
            swap(words, i, index);
            if (index == 0 || words[index - 1].charAt(words[index - 1].length() - 1) == words[index].charAt(0))
            {
                if (formCircle(words, index + 1))
                    return true;
            }
            swap(words, i, index);
        }
        return false;
    }
    static void swap(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        String[] words = {"chair", "height", "racket", "touch", "tunic"};
        if (formCircle(words, 0)) {
            for (String w : words) {
                System.out.print(w + " - ");
            }
            System.out.println(words[0]);
        } else {
            System.out.println("false");
        }
    }
}
