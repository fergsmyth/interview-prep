package problems.simpletexteditor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        processInput();
    }

    private static void processInput() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);
        int noOfCommands = Integer.parseInt(bufferedReader.readLine());
        Deque<String> previousStates = new ArrayDeque<>();
        StringBuilder currentState = new StringBuilder();
        for (int i = 0; i < noOfCommands; i++) {
            String line = bufferedReader.readLine();
            String[] inputs = line.split(" ");
            int command = Integer.parseInt(inputs[0]);
            if (command == 1) {
                previousStates.push(currentState.toString());
                currentState.append(inputs[1]);
            } else if (command == 2) {
                previousStates.push(currentState.toString());
                int deleteFromIndex = currentState.length() - Integer.parseInt(inputs[1]);
                currentState.delete(deleteFromIndex, currentState.length());
            } else if (command == 3) {
                int printIndex = Integer.parseInt(inputs[1]) - 1;
                System.out.println(currentState.charAt(printIndex));
            } else if (command == 4) {
                currentState = new StringBuilder(previousStates.pop());
            }
        }
    }
}
