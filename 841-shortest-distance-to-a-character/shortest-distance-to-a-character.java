class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
            char[] chars = s.toCharArray();
            for(int i = 0; i < chars.length; i++){

                if(chars[i] == c){
                    DFS(result, chars, c, i + 1, i);
                    DFS(result, chars, c, i - 1, i);
                }
            }

            return result;
    }
    private void DFS(int[] result, char[] chars, char c, int i, int pos) {
            if(i < 0 || i >= result.length) return;
            if(chars[i] == c) return;
            int abs = Math.abs(pos - i);
            if(result[i] != 0 && result[i] <= abs) return;

            result[i] = abs;
            DFS(result, chars, c, i + 1, pos);
            DFS(result, chars, c, i - 1, pos);
        }
}

/*class Solution {
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
*/