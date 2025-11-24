public class KaprekarNumber {
    public static int kaprekarSteps(int n) {
        int steps = 0;  
        while (n != 6174) {       
            String padded = String.format("%04d", n);          
            char[] digits = padded.toCharArray();
            java.util.Arrays.sort(digits);
           String ascendingString = new String(digits);    
            int small = Integer.parseInt(ascendingString);      
            StringBuilder descendingBuilder = new StringBuilder(ascendingString);
            descendingBuilder.reverse();
            String descendingString = descendingBuilder.toString();
            int large = Integer.parseInt(descendingString);
            n = large - small;
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(kaprekarSteps(7487)); 
    }
}

