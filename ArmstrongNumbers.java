import java.lang.Math;

public class ArmstrongNumbers {
    public static void main(String[] args) {
        for(int i = 1; i < 1000; i++) {
            int sum = 0;
            String s = Integer.toString(i);
            int[] digits = new int[s.length()];
            for(int j = 0; j < digits.length; j++) {
                digits[j] = Integer.parseInt(s.substring(j, j + 1));
                digits[j] = (int) Math.pow(digits[j], s.length());
                sum += digits[j];
            }
            if(sum == i)
                System.out.println("True, " + i + ", " + sum);
        }
    }
}