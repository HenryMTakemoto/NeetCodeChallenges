// In this challenge, I have to find a target in a Matrix 2D, returns if the target 
// are in the matrix or not. 

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) { // if the matrix is empty, return false
            return false; 
        }
        int left = 0; // left pointer
        int numLines = matrix.length;
        int numColumns = matrix[0].length;
        int right = numLines * numColumns - 1;  // right pointer at the end of matrix, Im simulating that matrix is a array, because this matrix is ordered

        while (left <= right){
            int mid = left + (right - left)/2; // calculating the mid of the array
            int line = mid / numColumns; // finding the line in the matrix, simulating an array 1D
            int column = mid % numColumns; // finding the column in the matrix

            if (matrix[line][column] == target ){
                return true;
            }
            else if(matrix[line][column] > target){ // adjusting the pointer 
                right = mid - 1;
            }
            else{ // adjusting the pointer
                left = mid + 1;
            }
       
        }
        return false;
        }


    }
