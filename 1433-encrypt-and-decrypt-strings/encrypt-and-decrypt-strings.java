class Encrypter {
    Map<Character,String> encryptionMap;
    Map<String,Integer> wayToDecrypt;
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        encryptionMap=new HashMap<>();
        for(int i=0;i<keys.length;i++){
            encryptionMap.put(keys[i],values[i]);
        }
        wayToDecrypt=new HashMap<>();
        for(String w:dictionary){
            String encryptedStr=encrypt(w);
            wayToDecrypt.put(encryptedStr,wayToDecrypt.getOrDefault(encryptedStr,0)+1);
        }
    }
    
    public String encrypt(String word1) {
        StringBuilder encryptedStr=new StringBuilder();
        for(int i=0;i<word1.length();i++)
            encryptedStr.append(encryptionMap.getOrDefault(word1.charAt(i),"#"));
        return encryptedStr.toString();
    }
    
    public int decrypt(String word2) {
        return wayToDecrypt.getOrDefault(word2,0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */