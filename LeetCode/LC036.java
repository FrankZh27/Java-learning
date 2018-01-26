class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for (int row = 0; row < board.length; row++){
            int[] test = new int[10];
            for (int col = 0; col < board[0].length; col++){
                if (board[row][col] == '.') continue;
                else {
                    int index = Character.getNumericValue(board[row][col]);
                    if (test[index] == 0) test[index] = 1;
                    else return false;
                }
            }
        }
       
        for (int col = 0; col < board[0].length; col++){
            int[] test = new int[10];
            for (int row = 0; row < board.length; row++){
                if (board[row][col] == '.') continue;
                else {
                    int index = Character.getNumericValue(board[row][col]);
                    if (test[index] == 0) test[index] = 1;
                    else return false;
                }
            }
        }
     
      for (int i = 0; i < board.length-2; i=i+3){
            for (int j = 0; j < board[0].length-2; j=j+3){
                HashMap<Character, Integer> map = new HashMap<Character, Integer>();
                for (int row = i; row < i+3; row++){
                    for (int col = j; col < j+3; col++){
                        if (board[row][col] == '.') continue;
                        else {
                            if (map.containsKey(board[row][col])) return false;
                            else map.put(board[row][col], 1);
                        }
                    }
                }
            }
        }
        return true;
        
    }
}
