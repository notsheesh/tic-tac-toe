public class MainGame {
    //field that represents
    private char[][] board = new char[3][3]; //board state
    private char currentPlayer; //current player X or O

    public void initializeBoard(){
        System.out.println("Welcome to TicTacToe");
        currentPlayer = 'X'; //default
        System.out.println("Player " + currentPlayer + " will start.");
        for (int m = 0; m < 3; m++)
        {for (int n = 0; n < 3; n++){board[m][n] = '-';}}
        updateBoard();
    }//initialize board

    public void updateBoard() {
        //update here
        //
        System.out.print(" — — — — — — ");
        for (int i = 0; i < 3; i++) {
            System.out.print("\n| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.print("\n — — — — — — ");
        }
    }//update board

    public char getCurrentPlayer(){
        return currentPlayer;
    }

    public void changePlayer(){
        if(currentPlayer == 'X'){currentPlayer = 'O';}
        else{currentPlayer = 'X';}
    }

    public void Marker(){

    }

    public boolean isBoardFull(){
        boolean isFull = true;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == '-'){isFull = false;}
            }
        }
        return isFull;
    }

    public boolean isWinner(){
        return (checkCol()||checkDiag()||checkRow());
    }

    private boolean checkRow(){
        boolean[] row = new boolean[3];
        for (int i = 0; i < 3; i++){row[i] = true;}

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if(board[i][j]=='-'){row[i] = false;}
            }
        }
        return (row[0]||row[1]||row[2]);
    }

    private boolean checkCol(){
        boolean[] col = new boolean[3];
        for(int j = 0; j < 3; j++){col[j] = true;}

        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 3; i++){
                if(board[i][j]=='-'){col[j] = false;}
            }
        }
        return (col[0]||col[1]||col[2]);
    }

    private boolean checkDiag(){
        boolean[] dia = new boolean[3];
        for(int i = 0; i < 3; i++){dia[i] = true;}
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i==j){if(board[i][j]=='-'){dia[i] = false;}}
            }
        }
        return (dia[0]||dia[1]||dia[2]);
    }

    //main
    public static void main(String[] args) {
        MainGame game = new MainGame();
        game.initializeBoard();
//        game.updateBoard();
    }
}
