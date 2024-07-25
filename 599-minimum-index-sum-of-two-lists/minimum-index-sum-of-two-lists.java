class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map=new HashMap<>();
        List<String> list=new ArrayList<>();
        for(int i=0;i<list1.length;i++){
            String word= list1[i];
            if(!map.containsKey(word)) map.put(word,i);
        }
        int last=Integer.MAX_VALUE;
        for(int i=0;i<list2.length;i++){
            String word=list2[i];
            if(map.containsKey(word)){
                int sum=i+map.get(word);
                if(last> sum)list.clear();
                if(last>=sum){
                    list.add(word);
                    last=sum;
                }
            }
        }
        return list.toArray(String[]:: new);
    }
}