class Solution {
    public int evalRPN(String[] tokens) {
        if ( tokens.length == 0) {
             return 0;
        }
        Stack<Integer> st = new Stack();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*" )) {
                int first = st.pop();
                int second = st.pop();
                if (s.equals("+" )) {
                    st.add(first+second);
                }
                if (s.equals( "-" ) ){
                    st.add(second-first);
                } 
                if (s.equals("/" )) {
                    st.add(second/first);
                } 
                if (s.equals("*" )) {
                    st.add(second*first);
                } 
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
        
    }
}
