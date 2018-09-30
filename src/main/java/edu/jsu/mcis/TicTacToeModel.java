package edu.jsu.mcis;


import java.lang.reflect.Array;

public class TicTacToeModel {
    
    private static final int DEFAULT_WIDTH = 3;
    private TicTacToeView view;
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    public Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    public int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() 
    {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */

        /* INSERT YOUR CODE HERE */
        
        grid = new Mark[width][width];
      
        
        /* Initialize grid by filling every square with empty marks */

        /* INSERT YOUR CODE HERE */
        
        
          for(int i = 0; i < width; i++)
          {
              for(int j = 0; j < width; j++)
              {
                grid[i][j] = Mark.EMPTY;
              }
            
          }
          
        
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
         
        Mark mark = getMark(row, col);
        
          if(isValidSquare(row,col) == false)
        {
         
            return false;
        }
          
        if(xTurn == true && isSquareMarked(row, col) == false)
        {
            grid[row][col] = Mark.X;
            
            xTurn = false;
            
            return true;
        }
        
        else if(xTurn == false && isSquareMarked(row, col) == false)
        {
            grid[row][col] = Mark.O;
        
            xTurn = true;
            
            return true;
        }
        
      
        if(isMarkWin(mark) == true || isSquareMarked(row, col) == true)
        {
            
            return false;
        }
        
        
        
        else
        {
           return false;
        }
        
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        /* INSERT YOUR CODE HERE */
        
        if(row < 0 || col < 0 || row >= width || col >= width)
        {
            return false;
        }
        
        else
        {
            
           
            return true;
        }
        
        
      
        

        
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
       
        /* INSERT YOUR CODE HERE */
        if ((grid[row][col] == (Mark.X)) || (grid[row][col] == (Mark.O)))
        {
            return true;
        }
        
        else
        {
            return false;
        }
       
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        /* INSERT YOUR CODE HERE */
        
        if(grid[row][col] == Mark.O)
        {
            return grid[row][col];
        
        }
        
        if(grid[row][col] == Mark.X)
        {
            return grid[row][col];
        }
        
        else
        {
            return Mark.EMPTY;
        }

            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */
        
        if(isMarkWin(Mark.X))
        {
            return Result.X;
        }
        
        if(isMarkWin(Mark.O))
        {
            return Result.O;
        }
        
        if(isTie() == true)
        {
            return Result.TIE;
        }
        
        else
        {
            return Result.NONE;
        }

    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        /* INSERT YOUR CODE HERE */
        
        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < width; y++)
            {
                
                //check col
               if(grid[x][y] == Mark.EMPTY){
                    grid[x][y] = getMark(x, y);
                }
                

                //check end conditions

                //check col
                for(int i = 0; i < width; i++){
                    if(grid[x][i] != mark)
                        break;
                    if(i == width-1){
                        return true;
                    }
                }

                //check row
                for(int i = 0; i < width; i++){
                    if(grid[i][y] != mark)
                        break;
                    if(i == width-1){
                        return true;
                    }
                }

                //check diag
                if(x == y){
                    //we're on a diagonal
                    for(int i = 0; i < width; i++){
                        if(grid[i][i] != mark)
                            break;
                        if(i == width-1){
                            return true;
                        }
                    }
                }

                //check anti diag (thanks rampion)
                if(x + y == width - 1){
                    for(int i = 0; i < width; i++){
                        if(grid[i][(width-1)-i] != mark)
                            break;
                        if(i == width-1){
                            return true;
                        }
                    }
                }


        
            }
            
        }
        
         return false;
        
    }
   
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */

        
        for(int r = 0; r < width; r++)
        {
            for(int c = 0; c < width; c++)
            {
                if(isSquareMarked(r,c) == false)
                {
                    return false;
                }
                
            }
        }
        
        return true;
        
        
        
    }

    public boolean isGameover() {
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
}