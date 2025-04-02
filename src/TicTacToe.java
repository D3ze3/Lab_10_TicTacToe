import java.util.Scanner;

public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String[ROWS][COLS];
    private static String currentPlayer = "X";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            clearBoard();
            boolean gameWon = false;
            boolean gameTie = false;
            int moveCount = 0;

            while (!gameWon && !gameTie) {
                displayBoard();
                int row, col;
                do {
                    row = SafeInput.getRangedInt(scanner, "Enter row (1-3):", 1, 3) - 1;
                    col = SafeInput.getRangedInt(scanner, "Enter column (1-3):", 1, 3) - 1;
                } while (!isValidMove(row, col));

                board[row][col] = currentPlayer;
                moveCount++;

                if (moveCount >= 5) { // Minimum moves required to win
                    gameWon = isWin(currentPlayer);
                }

                if (!gameWon && moveCount == 9) {
                    gameTie = isTie();
                }

                if (!gameWon && !gameTie) {
                    currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
                }
            }

            displayBoard();
            if (gameWon) {
                System.out.println("Player " + currentPlayer + " wins!");
            } else {
                System.out.println("It's a tie!");
            }

            playAgain = SafeInput.getYNConfirm(scanner, "Do you want to play again? (Y/N)");
        } while (playAgain);

        System.out.println("Thanks for playing!");
    }

    private static void clearBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = " ";
            }
        }
    }

    private static void displayBoard() {
        System.out.println("\n  1 2 3");
        for (int i = 0; i < ROWS; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j]);
                if (j < COLS - 1) System.out.print("|");
            }
            System.out.println();
            if (i < ROWS - 1) System.out.println("  -----");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROWS; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int j = 0; j < COLS; j++) {
            if (board[0][j].equals(player) && board[1][j].equals(player) && board[2][j].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}

//1. Initialize the board
// 2. Loop until a player wins or it's a tie:
//    a. Display the board
//    b. Get the player's move
//    c. Validate the move (ensure it's not occupied)
//    d. Record the move
//    e. Check if the player has won or if it's a tie
//    f. If game over, ask if players want to play again
//    g. Switch players
// 3. Reset the board for a new game if players want to continue
