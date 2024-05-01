class Solution {
    public String reversePrefix(String word, char ch) {
        int i=0;
        String answer="";
        for(i=0;i<word.length();i++){
            if(word.charAt(i)==ch) break;
        }
        if(i==word.length()) return word;
        
        for(int j=0;j<=i;j++){
            answer=word.charAt(j)+answer;
        }
            
            return answer+word.substring(i+1,word.length());
        
        
    }
}