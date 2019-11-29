package problems.zalando.binarynumber;

/**
 * Given a number as a binary string, count the number of steps to zero.
 * Only operations allowed are divided by 2 for even numbers and subtract 1 for odd numbers.
 */
public class Solution {

    // From codility site
    public static int solution(String S) {

        int countOperations = 0;
        int i;

        // Move index to ignore leading zeros
        for(i = 0;i < S.length() && S.charAt(i) == '0'; i++);

        // Special case for binary 1
        if(i < S.length() && S.charAt(i) == '1'){
            countOperations++;
            i++;
        }

        for(; i < S.length();i++){
            // Division operation
            countOperations++;
            if(S.charAt(i) == '1'){
                // Subtraction operation
                countOperations++;
            }
        }

        return countOperations;
    }

    public static void main(String[] args) {
        String binaryNumber = "011100";
        System.out.println(solution(binaryNumber));
    }
}
