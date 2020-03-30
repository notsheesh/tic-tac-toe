public class MainGame {
    //field that represents
    private char[][] board = new char[3][3]; //board state
    private char currentPlayer; //current player X or O
    private boolean want = false;

//    private void wantInstructions(){
//        if(want == "yes"){
//            System.out.println("Instructions");
//        }
//    }

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
        System.out.println("  1   2   3");
        System.out.print(" — — — — — — ");
        for (int i = 0; i < 3; i++) {
            System.out.print("\n| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.print((i+1) + " \n — — — — — — ");
        }
        System.out.println("\n");
    }//update board

    public char getCurrentPlayer(){
        return currentPlayer;
    }

    public void changePlayer(){
        if(currentPlayer == 'X'){currentPlayer = 'O';}
        else{currentPlayer = 'X';}
    }

    public boolean placeMarker(int row, int col){
        if((row >= 0) && (row <= 3) && (board[row][col]=='-')){
            if((col >= 0) && (col <= 3)){
                if(board[row][col]=='-'){
                    board[row][col] = currentPlayer;
                    return true;
                }
            }
        }
        else{
            System.out.println("================================");
            System.out.println("Invalid move, please try again!");
            System.out.println("================================");
            updateBoard();
        }
        return false;
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
//        return (checkCol()||checkRow()||checkDiag());
        return (checkRow()||checkCol()||checkDiag());
    }

    public boolean checkRow(){
        boolean[] row = new boolean[3];
        for (int i = 0; i < 3; i++){
            row[i] = true;
        }
        char a, b, c;
        for(int i = 0; i < 3; i++){
            a = board[i][0];
            b = board[i][1];
            c = board[i][2];
            row[i] = checkChar(a,b,c);
        }
        return (row[0]||row[1]||row[2]);
    }

    public boolean checkCol(){
        boolean[] col = new boolean[3];
        for(int i = 0; i < 3; i++){
            col[i] = true;
        }
        char a,b,c;
        for(int i = 0; i < 3;i ++){
            a = board[0][i];
            b = board[1][i];
            c = board[2][i];
            col[i] = checkChar(a,b,c);
        }
        return (col[0]||col[1]||col[2]);
    }

    public boolean checkDiag(){
        char a,b,c;
        //backslash
        a = board[0][0];
        b = board[1][1];
        c = board[2][2];
        boolean diagBack = checkChar(a,b,c);
        //forward slash
        a = board[0][2];
        b = board[1][1];
        c = board[2][0];
        boolean diagFront = checkChar(a,b,c);
        return (diagFront||diagBack);
    }

    public boolean checkChar(char a, char b, char c){
        boolean same = false;
        if((a==b)&&(b==c)){
            if(a!='-'){same=true;}
        }
        return same;
    }


        //main
//    public static void main(String[] args) {
//        MainGame game = new MainGame();
//        game.initializeBoard();
//        game.updateBoard();
//    }
    }
