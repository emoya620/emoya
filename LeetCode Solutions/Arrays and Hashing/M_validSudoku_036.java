class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rowSet = new HashSet<>();
        for (int i = 0; i < board.length; i++){
            char[] row = board[i];
            for (int x = 0; x < 9; x++){
                if (row[x] == '.'){
                    continue;
                }
                else{
                    if (rowSet.contains(row[x])){
                        return false;
                    }
                    rowSet.add(row[x]);
                }
            }
            rowSet.clear();
        }

        HashSet<Character> column = new HashSet<>();
        for (int i = 0; i < 9; i++){
            for (int x = 0; x < 9; x++){
                if (board[x][i] == '.'){
                    continue;
                }
                else{
                    if (column.contains(board[x][i])){
                        return false;
                    }
                    column.add(board[x][i]);
                }
            }
            column.clear();
        }

        for (int i = 0; i < 9; i += 3){
            for (int x = 0; x < 9; x += 3){
                if (checkSquare(board, i, x) == false){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkSquare(char[][] board, int row, int col) {
        HashSet<Character> set = new HashSet<>();
        for (int i = row; i < row + 3; i++){
            for (int x = col; x < col + 3; x++){
                if (board[i][x] == '.'){
                    continue;
                }
                
                if (set.contains(board[i][x])){
                    return false;
                }
                set.add(board[i][x]);
            }
        }
        return true;
    }
}
