class Solution {
    public boolean isValid(String s) {
        char[] string = s.toCharArray();
        Stack<Character> stack = new Stack<>(); // using stack to verify if the open bracket is closed by the same type

        if (string.length % 2 != 0){ // if the string has an odd length, it is false
            return false;  
        }

          for (char symbol : string) {
            if (symbol == '(' || symbol == '[' || symbol == '{') { // Verify if it is open bracket 
                stack.push(symbol); // put in the top
            } else { // If it close bracket
                if (stack.isEmpty()){  // if stack is empty, it is false
                    return false;
                }
                char top = stack.pop(); // Verify if the top bracket is the open bracket to close
                if (symbol == ')' && top != '(') return false;
                if (symbol == ']' && top != '[') return false;
                if (symbol == '}' && top != '{') return false;
            }
        }
        
        return stack.isEmpty(); // if the stack is empty, will return true
    }
}
