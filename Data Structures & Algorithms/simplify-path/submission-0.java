
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] parts = path.split("/");
        for (String part : parts) {
            // Ignore empty parts and current directory
            if (part.equals("") || part.equals(".")) {
                continue;
            }
            // Move to parent directory
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Valid directory or file name
                stack.push(part);
            }
        }
        // Build the canonical path
        StringBuilder result = new StringBuilder();
        for (String directory : stack) {
            result.append("/");
            result.append(directory);
        }
        // Empty stack means root directory
        if (result.length() == 0) {
            return "/";
        }
        return result.toString();
    }
}
