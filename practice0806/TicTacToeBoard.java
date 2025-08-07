public class TicTacToeBoard {

    private static final char EMPTY = '.';
    private static final int SIZE = 3;
    private char[][] board;

    public TicTacToeBoard() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = EMPTY;
    }

    public boolean placeMark(int row, int col, char player) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            System.out.println("Invalid position.");
            return false;
        }
        if (board[row][col] != EMPTY) {
            System.out.println("Cell already occupied.");
            return false;
        }
        board[row][col] = player;
        return true;
    }

    public boolean checkWin(char player) {
        for (int i = 0; i < SIZE; i++)
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || 
                (board[0][i] == player && board[1][i] == player && board[2][i] == player))
                return true;

        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player))
            return true;

        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == EMPTY)
                    return false;
        return true;
    }

    public void printBoard() {
        System.out.println("Current board:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TicTacToeBoard game = new TicTacToeBoard();
        game.placeMark(0, 0, 'X');
        game.placeMark(0, 1, 'O');
        game.placeMark(0, 2, 'X');
        game.placeMark(1, 1, 'X');
        game.placeMark(2, 2, 'X');

        game.printBoard();

        if (game.checkWin('X')) {
            System.out.println("Player X wins!");
        } else if (game.checkWin('O')) {
            System.out.println("Player O wins!");
        } else if (game.isDraw()) {
            System.out.println("It's a draw!");
        } else {
            System.out.println("Game in progress...");
        }
    }
}
