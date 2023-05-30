class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> hmap = new HashMap<>();
        int size=s.length();
        for(int index=0;index<size;index++){
            hmap.put(s.charAt(index),hmap.getOrDefault(s.charAt(index),0)+1);
        }
        
        for(int index=0;index<size;index++){
            if(hmap.get(s.charAt(index))==1) return index;
        }
        return -1;
    }
}