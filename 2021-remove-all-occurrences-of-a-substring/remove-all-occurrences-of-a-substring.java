class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder res = new StringBuilder(s);
        while(true) {
            int ind = res.indexOf(part);
            if(ind < 0)
                break;
            res.delete(ind, ind + part.length());
        }

        return res.toString();

    }
}