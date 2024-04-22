import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        // Count the frequency of each letter in the provided letters
        int[] letterFreq = new int[26];
        for (char letter : letters) {
            letterFreq[letter - 'a']++;
        }
        
        // Initialize an array to keep track of the score of each word
        int[] wordScores = new int[words.length];
        
        // Calculate the score for each word
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int wordScore = 0;
            // Count the frequency of each letter in the word
            int[] wordFreq = new int[26];
            for (char letter : word.toCharArray()) {
                wordFreq[letter - 'a']++;
            }
            // Calculate the score for the word
            for (int j = 0; j < 26; j++) {
                if (wordFreq[j] > letterFreq[j]) {
                    wordScore = 0; // Word cannot be formed, set score to 0
                    break;
                }
                wordScore += score[j] * wordFreq[j];
            }
            wordScores[i] = wordScore;
        }
        
        // Recursive function to find the maximum score
        return getMaxScore(words, wordScores, letterFreq, score, 0, 0);
    }
    
    private int getMaxScore(String[] words, int[] wordScores, int[] letterFreq, int[] score, int index, int totalScore) {
        if (index == words.length) {
            return totalScore;
        }
        
        // Exclude current word
        int maxScore = getMaxScore(words, wordScores, letterFreq, score, index + 1, totalScore);
        
        // Include current word if possible
        int wordScore = wordScores[index];
        boolean canFormWord = true;
        int[] wordFreq = new int[26];
        for (char letter : words[index].toCharArray()) {
            wordFreq[letter - 'a']++;
            if (wordFreq[letter - 'a'] > letterFreq[letter - 'a']) {
                canFormWord = false;
                break;
            }
        }
        if (canFormWord) {
            for (int j = 0; j < 26; j++) {
                letterFreq[j] -= wordFreq[j];
                totalScore += score[j] * wordFreq[j];
            }
            maxScore = Math.max(maxScore, getMaxScore(words, wordScores, letterFreq, score, index + 1, totalScore));
            for (int j = 0; j < 26; j++) {
                letterFreq[j] += wordFreq[j];
            }
        }
        
        return maxScore;
    }
}

