class Solution {
    public boolean isValid(String s) {
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
            System.out.println(" Stack " + st);
        } 
        return st.size() == 0 ? true : false;
        
    }
}
