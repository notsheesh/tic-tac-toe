import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        int row, col; 

        MainGame game = new MainGame();
        game.initializeBoard();
        
        Scanner read = new Scanner(System.in);

        do 
        {
            System.out.println("Player " + game.getCurrentPlayer() + "'s turn");
            do{
                System.out.print("Enter a row index: ");
                row = read.nextInt()-1;

                System.out.print("Enter a column index: ");
                col = read.nextInt()-1;

            } while(!game.placeMarker(row, col));

            game.placeMarker(row, col);
            game.updateBoard();
            game.changePlayer();

        } while(!game.isWinner()&&!game.isBoardFull());

        game.changePlayer();
        System.out.println("Game over! Player " + game.getCurrentPlayer() + " wins");
        
    }
}
