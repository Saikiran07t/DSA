class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int index=0;index<s.length();index++){
            char character=s.charAt(index);
            if(character=='(' || character=='{' || character=='['){
                st.push(character);
            }
            else{
                if(st.isEmpty()) return false;
                
                char temp = st.pop();
                if((temp=='(' && character== ')') || (temp=='{' && character== '}')  ||     (temp=='[' && character== ']'  ) ){  
                    continue;
                }
                else return false;
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
    //with constant space :- then use a flag variable and 
}