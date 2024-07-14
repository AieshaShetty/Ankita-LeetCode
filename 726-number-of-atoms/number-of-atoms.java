class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        
        Stack<Map<String, Integer>> st = new Stack<>();
        st.push(new HashMap<>());
        
        int i = 0;
        while (i < n) {
            if (formula.charAt(i) == '(') {
                st.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> curr = st.pop();
                i++;
                
                StringBuilder mult = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    mult.append(formula.charAt(i));
                    i++;
                }
                
                if (mult.length() > 0) {
                    int multInteger = Integer.parseInt(mult.toString());
                    for (String element : curr.keySet()) {
                        int count = curr.get(element);
                        curr.put(element, count * multInteger);
                    }
                }
                
                Map<String, Integer> top = st.peek();
                for (String element : curr.keySet()) {
                    int count = curr.get(element);
                    top.put(element, top.getOrDefault(element, 0) + count);
                }
                
            } else {
                StringBuilder currElement = new StringBuilder();
                currElement.append(formula.charAt(i));
                i++;
                
                while (i < n && Character.isLetter(formula.charAt(i)) && Character.isLowerCase(formula.charAt(i))) {
                    currElement.append(formula.charAt(i));
                    i++;
                }
                
                StringBuilder currCount = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    currCount.append(formula.charAt(i));
                    i++;
                }
                
                int currCountInteger = (currCount.length() > 0) ? Integer.parseInt(currCount.toString()) : 1;
                Map<String, Integer> top = st.peek();
                top.put(currElement.toString(), top.getOrDefault(currElement.toString(), 0) + currCountInteger);
            }
        }
        
        TreeMap<String, Integer> sortedMap = new TreeMap<>(st.peek());
        StringBuilder result = new StringBuilder();
        
        for (String element : sortedMap.keySet()) {
            result.append(element);
            int count = sortedMap.get(element);
            if (count > 1) {
                result.append(count);
            }
        }
        
        return result.toString();
    }
}
