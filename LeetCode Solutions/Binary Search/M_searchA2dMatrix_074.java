class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = 0;

        while (matrix.length != 1 && row < matrix.length && matrix[row+1][col] <= target){
            row++;
            if (row + 1 == matrix.length){
                break;
            }
        }

        while (matrix[0].length != 1 && col < matrix[0].length && matrix[row][col] < target){
            col++;
            if (col + 1 == matrix[0].length){
                break;
            }
        }
        
        if (matrix[row][col] == target){
            return true;
        }

        return false;
    }
}
