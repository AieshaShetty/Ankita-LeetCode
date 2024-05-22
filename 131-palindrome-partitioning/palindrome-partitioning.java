class Solution {
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        res=new ArrayList<>();
        partition(s, new LinkedList<String>());
        return res;
    }
    private void partition(String str, Deque<String> lst){
        if(str.length()==0){
            res.add(new ArrayList<>(lst));
            return;
        }
        if(str.length()==1){
            lst.offer(str);
            res.add(new ArrayList<>(lst));
            lst.pollLast();
            return;
        }
        for(int i=1;i<=str.length();i++){
            String leftPart = str.substring(0,i);
            if(isPalindrome(leftPart)){
                lst.offer(leftPart);
                partition(str.substring(i),lst);
                lst.pollLast();
            }

        }
    }

    private boolean isPalindrome(String str){
        int i=0, j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))  return false;
            i++;j--;
        }
        return true;
    }
}