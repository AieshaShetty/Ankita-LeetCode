class Solution {
    public String[] findWords(String[] words) {
        HashMap<Character, Integer> map = new HashMap();
        HashMap<Character, Integer> map2 = new HashMap();
        HashMap<Character, Integer> map3 = new HashMap();
        String a = "qwertyuiopQWERTYUIOP";
        String b = "asdfghjklASDFGHJKL";
        String c = "zxcvbnmZXCVBNM";
        for(int i=0; i<a.length(); i++){
            map.put(a.charAt(i), i);
        }
        for(int i=0; i<b.length(); i++){
            map2.put(b.charAt(i), i);
        }
        for(int i=0; i<c.length(); i++){
            map3.put(c.charAt(i), i);
        }
        List<String> arr2 = new ArrayList();
        for(int i=0; i<words.length; i++){
            String temp = words[i];
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;
            for(int j=0; j<temp.length(); j++){
                if(map.get(temp.charAt(j)) != null) count1++;
                else if(map2.get(temp.charAt(j)) != null) count2++;
                else if(map3.get(temp.charAt(j)) != null) count3++;
            }
            if(count1 != 0 && count2 == 0 && count3 == 0) arr2.add(temp);
            else if(count1 == 0 && count2 != 0 && count3 == 0) arr2.add(temp);
            else if(count1 == 0 && count2 == 0 && count3 != 0) arr2.add(temp);
        }
        return arr2.toArray(new String[0]);
    }
}