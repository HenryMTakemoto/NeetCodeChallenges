// In this challenge have n cars travelling to the same destination on a one-lane highway
// I have to discover how many fleets exists in this highway

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length; 
        int[][] cars = new int[n][2];
        Stack<Double> fleets = new Stack<>();


        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0])); // Instantiate an ordered array of the cars

        for (int i = n - 1 ; i >= 0 ; i--){
            double time = (double) (target - cars[i][0]) / cars[i][1]; // Verify how long does it take to arrive

        if (fleets.isEmpty() || time > fleets.peek()) {
                fleets.push(time); // If the stack is empty or the time is greater than the top, add in stack
            }

        }

        return fleets.size(); // return the size of stack, is the quantity of fleets
 
    }
}
