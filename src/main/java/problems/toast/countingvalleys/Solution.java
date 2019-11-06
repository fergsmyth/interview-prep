package problems.toast.countingvalleys;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int numOfValleys = 0;

        for(int i = 0, currentPosition = 0; i < n; i++){
            char direction = s.charAt(i);
            if(direction == 'D'){
                currentPosition--;
            } else {
                currentPosition++;
                if(currentPosition == 0){
                    numOfValleys++;
                }
            }
        }
        return numOfValleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
