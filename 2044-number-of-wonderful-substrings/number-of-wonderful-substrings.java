class Solution {
    public long wonderfulSubstrings(String word) {
        // Initialize a count array to keep track of the frequency of each character
        int[] count = new int[1024]; // Since there are only 10 lowercase English letters, we can use a bitmask of length 10
        
        // Initialize variables to track the count of wonderful substrings and the current bitmask
        long wonderfulSubstringsCount = 0;
        int bitmask = 0;
        
        // Set the initial bitmask to 1 (representing the empty string)
        count[0] = 1;
        
        // Loop through each character in the word
        for (char c : word.toCharArray()) {
            // Toggle the bit corresponding to the current character
            bitmask ^= 1 << (c - 'a');
            
            // Increment the count of wonderful substrings by the count of substrings where at most one letter appears an odd number of times
            wonderfulSubstringsCount += count[bitmask];
            
            // Increment the count of substrings with the same bitmask
            for (int i = 0; i < 10; i++) {
                wonderfulSubstringsCount += count[bitmask ^ (1 << i)];
            }
            
            // Increment the count of substrings with the same bitmask
            count[bitmask]++;
        }
        
        // Return the total count of wonderful substrings
        return wonderfulSubstringsCount;
    }
}