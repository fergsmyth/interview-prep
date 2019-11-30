package problems.zalando.anagram;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public Integer sqrt(int squareNumber) {
        Integer squareRoot = null;
        for(squareRoot = 1; squareRoot < squareNumber; squareRoot++){
            Integer currentSquareNumber = squareRoot * squareRoot;
            if(currentSquareNumber.equals(squareNumber)){
                return squareRoot;
            }
        }
        return squareRoot;
    }

    public Integer sqrtBinary(int squareNumber) {
        Integer squareRoot = null;
        Integer squareNumberHalfway = squareNumber / 2;
        Integer currentSquareNumber = squareNumberHalfway / 2;
        findSquareRoot(currentSquareNumber, squareNumberHalfway, squareNumber);
        return squareRoot;
    }

    public Integer findSquareRoot(Integer numberToSquare, Integer squareNumberHalfway, Integer squareNumber) {
        Integer currentSquareNumber = numberToSquare * numberToSquare;
        Integer perfectSquare = null;
        if(currentSquareNumber.equals(squareNumber)){
            perfectSquare = numberToSquare;
        } else if(currentSquareNumber < squareNumber){
            perfectSquare = findSquareRoot((numberToSquare + squareNumberHalfway) / 2, squareNumberHalfway, squareNumber);
        } else if(currentSquareNumber > squareNumber) {
            perfectSquare = findSquareRoot(numberToSquare / 2, numberToSquare, squareNumber);
        }
        return perfectSquare;
    }

    public boolean checkIsAnagram(String firstString, String secondString){
        if(firstString.length() != secondString.length()){
            return false;
        }

        Map<Character, Integer> characterToCount = new HashMap<>();
        for(char character : firstString.toCharArray()){
            Integer characterCount = characterToCount.get(character);
            if(characterCount == null){
                characterCount = Integer.valueOf(1);
            } else {
                characterCount = characterCount + 1;
            }
            characterToCount.put(character, characterCount);
        }

        for(char character : secondString.toCharArray()){
            Integer characterCount = characterToCount.get(character);
            if(characterCount == null){
                return false;
            } else {
                characterCount = characterCount - 1;
                if(characterCount.equals(0)){
                    characterToCount.remove(character);
                } else {
                    characterToCount.put(character, characterCount);
                }
            }
        }
        return !characterToCount.isEmpty();
    }

}
