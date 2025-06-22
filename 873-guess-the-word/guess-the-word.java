/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution{
	public void findSecretWord(String[] words, Master master){
			int last = words.length-1;
			while(true){
				int count = master.guess(words[0]);
				if(count==6) return;
                int i = 1;
				while(i <= last){
					int c = 0;
					for(int j = 0; j < 6; j++) if(words[i].charAt(j)==words[0].charAt(j)) c++;
					if(c!=count) words[i]=words[last--];
					else i++;
				}
				words[0]=words[last--];
			}
		}
	}