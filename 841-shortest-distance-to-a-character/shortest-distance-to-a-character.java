class Solution {
    public int[] shortestToChar(String s, char c) {
        List<CharacterIndex> letters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            letters.add(new CharacterIndex(i, s.charAt(i)));
        }

        List<Integer> cIndexes = new ArrayList<>();
        for (CharacterIndex letter : letters) {
            if (letter.character == c) {
                cIndexes.add(letter.index);
            }
        }

        int[] result = new int[s.length()];
        for (CharacterIndex letter : letters) {
            int minDistance = Integer.MAX_VALUE;
            for (int cIndex : cIndexes) {
                int distance = Math.abs(letter.index - cIndex);
                minDistance = Math.min(minDistance, distance);
            }
            result[letter.index] = minDistance;
        }

        return result;
    }

    static class CharacterIndex {
        int index;
        char character;

        CharacterIndex(int index, char character) {
            this.index = index;
            this.character = character;
        }
    }
}
