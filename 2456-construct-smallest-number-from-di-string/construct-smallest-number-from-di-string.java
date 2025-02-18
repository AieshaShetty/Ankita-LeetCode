class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        for(int i=9;i>=1;i--){
            stack1.push(i);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<pattern.length();i++){
            char curr=pattern.charAt(i);
            if(curr=='I'){
                sb.append(stack1.pop());
            }else{
                int count=0;
                int temp=i;
                while(temp<pattern.length() && pattern.charAt(temp)!='I'){
                    stack2.push(stack1.pop());
                    temp+=1;
                }
                sb.append(stack1.pop());
                while(!stack2.isEmpty()){
                    sb.append(stack2.pop());
                    i+=1;
                }
            }
        }
        if(pattern.charAt(pattern.length()-1)=='I'){
            sb.append(stack1.pop());
        }
        return sb.toString();
    }
}