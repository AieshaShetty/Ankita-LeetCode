class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        
        Deque<Integer> queue=new LinkedList<>();
        Arrays.sort(deck);
        for(int i=deck.length-1;i>=0;i--){
            int card=deck[i];
            if(queue.isEmpty()){
                queue.offer(card);
                continue;
            }
            queue.offerFirst(queue.pollLast());
            queue.offerFirst(card);
        }
        int index=deck.length-1;
        while(!queue.isEmpty()){
            deck[index--]=queue.pollLast();
        }
        return deck;
    }
}