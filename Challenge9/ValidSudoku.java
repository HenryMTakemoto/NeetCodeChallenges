class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Allocating arrays to hold references to HashSets 
        HashSet<Character>[] rows = new HashSet[9]; 
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[] squares = new HashSet[9];

    for (int i = 0; i < 9; i++) {
        rows[i] = new HashSet<>(); // Instantiate the HashSet for each index
        columns[i] = new HashSet<>();   
        squares[i] = new HashSet<>(); 
    }

        for (int i = 0 ; i < 9 ; i++ ){
            for (int j=0 ; j < 9; j++ ){
                char current = board[i][j]; // Get the number of the current position
                if (current == '.'){ // Verify if it is empty 
                    continue; // Skip if it is empty
                }
                if (rows[i].contains(current)){ // If the current row already contains the current number
                    return false; // It is invalid
                }
                rows[i].add(current); // If it isn't invalid, add the current value
                if (columns[j].contains(current)){ // If the current column already constains the current number
                    return false;  // It is invalid
                }
                columns[j].add(current); // If it isn't, add the number
                int squareIndex = (i / 3) * 3 + (j / 3); // Formula to discover the index of current sub matrix
                if (squares[squareIndex].contains(current)) { // If the current sub matrix already has the number
                return false; // It's invalid
                }   
                squares[squareIndex].add(current); // If it isn't add the number
            }
        }
        return true; // After the loop, if false was not returned it is true
    }
}
