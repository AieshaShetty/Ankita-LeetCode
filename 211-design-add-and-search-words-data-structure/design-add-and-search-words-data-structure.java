class WordDictionary {
    class TrieNode{
        boolean endOfWord;
        TrieNode[] next=new TrieNode[26];
    }
    TrieNode root=null;

    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node=root;
        for(char c: word.toCharArray()){
            if(node.next[c-'a']==null){
                node.next[c-'a']=new TrieNode();
            }
            node =node.next[c-'a'];
        }
        node.endOfWord=true;
    }
    private boolean search(String word,int idx,TrieNode node){

        if(node==null){
            return false;
        }
        if(idx==word.length()){
            return node.endOfWord;
        }
        
        char c=word.charAt(idx);
        if(c!='.'){
            return search(word,idx+1,node.next[c-'a']);
        }
        else{
            for(int i=0;i<26;i++){
                if(search(word,idx+1,node.next[i])) return true;
            }
        }
        return false;
    }
    public boolean search(String word) {
        return search(word,0,root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */