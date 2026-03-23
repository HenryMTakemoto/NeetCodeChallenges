// In this challenge, I have to return an array where results is the number
// of the days after the ith day before a warmer day appears

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stack = new Stack<>();
    int[] result = new int[temperatures.length];

    for (int i = 0 ; i < temperatures.length ; i++){
        // While the stack has someone and the temperature today is greater than the top
        while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
            int dayOut = stack.pop(); // get the index of day out
            int time = i - dayOut; // the time of the days is current less day out
            result[dayOut] = time; 
        }
        
         stack.push(i); // I hold the index not the temperature
    }

    return result;

    }
}
