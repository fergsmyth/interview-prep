package problems.simpletexteditor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        performant();
        nonPerformant();
    }

    /** More performant than scanner due to only reading characters instead of parsing via regex. **/
    private static void performant() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);
        int noOfCommands = Integer.parseInt(bufferedReader.readLine());
        Deque<String> previousStates = new LinkedList<>();
        StringBuilder currentState = new StringBuilder();
        for(int i = 0; i < noOfCommands; i++){
            String line = bufferedReader.readLine();
            String[] inputs = line.split(" ");
            int command = Integer.parseInt(inputs[0]);
            if(command == 1){
                previousStates.push(currentState.toString());
                currentState.append(inputs[1]);
            } else if(command == 2) {
                previousStates.push(currentState.toString());
                int deleteFromIndex = currentState.length() - Integer.parseInt(inputs[1]);
                currentState.delete(deleteFromIndex, currentState.length());
            } else if(command == 3){
                int printIndex = Integer.parseInt(inputs[1]) - 1;
                System.out.println(currentState.charAt(printIndex));
            } else if(command == 4){
                currentState = new StringBuilder(previousStates.pop());
            }
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
    private static void nonPerformant() {
        Scanner scanner = new Scanner(System.in);
        int noOfCommands = Integer.parseInt(scanner.nextLine());
        Deque<String> previousStates = new LinkedList<>();
        StringBuilder currentState = new StringBuilder();
        for(int i = 0; i < noOfCommands; i++){
            String line = scanner.nextLine();
            String[] inputs = line.split(" ");
            int command = Integer.parseInt(inputs[0]);
            if(command == 1){
                previousStates.push(currentState.toString());
                currentState.append(inputs[1]);
            } else if(command == 2) {
                previousStates.push(currentState.toString());
                int deleteFromIndex = currentState.length() - Integer.parseInt(inputs[1]);
                currentState.delete(deleteFromIndex, currentState.length());
            } else if(command == 3){
                int printIndex = Integer.parseInt(inputs[1]) - 1;
                System.out.println(currentState.charAt(printIndex));
            } else if(command == 4){
                currentState = new StringBuilder(previousStates.pop());
            }
        }
    }
}
