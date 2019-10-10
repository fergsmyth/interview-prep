package problems.palendrome;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeChecker {

    public static void main(String[] args) {
        char[] sentence = {'a','B','P','b','c','p','_','f','p','c','b','b','a'};
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        boolean isPalindrome = palindromeChecker.checkPerformant(sentence);
        System.out.println(isPalindrome);
    }

    public boolean checkBasic(char[] sentence){
        boolean isPalindrome = true;
        Deque<Character> characters = new ArrayDeque<>();
        boolean uneven = sentence.length % 2 == 1;
        int midpointIndex = uneven ? sentence.length / 2 : (sentence.length - 1) / 2;
        for(int i = 0; i < sentence.length; i++){
            if(i < sentence.length / 2){
                characters.push(sentence[i]);
            } else if(uneven && (midpointIndex == i)){
                continue;
            } else if(!characters.pop().equals(sentence[i])) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public boolean checkPerformant(char[] sentence){
        boolean isPalindrome = true;
        int front = 0 ;
        int back = sentence.length - 1;
        while(back > front){
            if(!Character.isAlphabetic(sentence[front])){
                front++;
                continue;
            }
            if(!Character.isAlphabetic(sentence[back])){
                back--;
                continue;
            }
            if(Character.toLowerCase(sentence[front]) == Character.toLowerCase(sentence[back])){
                front++;
                back--;
                continue;
            }
            isPalindrome = false;
            break;
        }
        return isPalindrome;
    }

}
