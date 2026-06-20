class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }
        Stack<Character> st = new Stack();
        for ( char c : s.toCharArray()) {
            if (!st.isEmpty() && c == ']' && st.peek() == '[') {
                st.pop();
                continue;
            }
            if (!st.isEmpty() && c == '}' && st.peek() == '{') {
                st.pop();
                continue;
            }
            if (!st.isEmpty() && c == ')' && st.peek() == '(') {
                st.pop();
                continue;
            }
            st.add(c);
        } 
        return st.size() == 0 ? true : false;
        
    }
}
