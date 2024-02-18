public class Main {
    public static void main(String[] args) {
        char[][] grid = new char[20][20];
        
        int left = 0;
        int right = grid.length - 1;
        int top = 0;
        int bottom = grid.length - 1;
        
        while (left < right && top < bottom){
            for (int i = right; i >= left; i--){
                if (i > 1 && grid[top][i-1] == '#'){
                    break;
                }
                grid[top][i] = '#';
            }
            
            
            for (int i = top; i <= bottom; i++){
                if (i < 19 && grid[i+1][left] == '#'){
                    break;
                }
                grid[i][left] = '#';
            }
            
            
            for (int i = left; i <= right; i++){
                if (i < 19 && grid[bottom][i+1] == '#'){
                    break;
                }
                grid[bottom][i] = '#';
            }
            
            for (int i = bottom; i >= top; i--){
                if (i > 1 && grid[i-1][right] == '#'){
                    break;
                }
                grid[i][right] = '#';
            }
            
            right -= 2;
            top += 2;
            left += 2;
            bottom -= 2;
        }
        
        System.out.println("Safely executed!");
        
        for (char[] row : grid){
            String str = "";
            for (char c : row){
                if (c == '#'){
                    str += '#';
                }
                else{
                    str += ' ';
                }
            }
            System.out.println(str);
        }
    }
}
