class Solution {
    private static void dfs(char[][]board ,int i,int j){
        if(i>=board.length || j>=board[0].length || i< 0 || j<0 ){
            return;
        }
        if(board[i][j]=='X' || board[i][j]=='M'){
            return;
        }
        board[i][j]='M';
        dfs(board,i-1,j);
        dfs(board ,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || j==m-1 || i==n-1 ){
                    if(board[i][j]=='O'){
                        dfs(board,i,j);
                     
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='M'){
                    board[i][j]='O';
                }else{
                    board[i][j]='X';
                }
            }
        }
    }
}