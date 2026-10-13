class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<Integer>();
        Stack<String> stringStack = new Stack<String>();
        String current = "";
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                // Build the number (handles values like 12 or 100)
                number = number * 10 + (ch - '0');
            } 
            else if (ch == '[') {
                // Save the repeat count and current string
                countStack.push(number);
                stringStack.push(current);
                // Start building the string inside brackets
                number = 0;
                current = "";
            } 
            else if (ch == ']') {
                // Get the repeat count and previous string
                int count = countStack.pop();
                String previous = stringStack.pop();
                StringBuilder repeated = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    repeated.append(current);
                }
                current = previous + repeated.toString();
            } 
            else {
                // Normal character
                current = current + ch;
            }
        }

        return current;
    }
}
