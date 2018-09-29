package edu.jsu.mcis;


public class TicTacToeView {

    private TicTacToeModel model;
   
    
    
    
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
        
        
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
        /* INSERT YOUR CODE HERE */
        
        System.out.print("  ");
        
        for(int n = 0; n < model.width; n++)
        {
            System.out.print(n);
        }
        
        System.out.println("\n");
        
        
          for(int i = 0; i < model.width; i++)
          {
              System.out.print(i + " ");
              
              for(int j = 0; j < model.width; j++)
              {
                  
                  System.out.print(model.grid[i][j]);
                  
              }
                  
              System.out.println("");
              
          } 
             
        
        
       

    }

    public void showNextMovePrompt() {

        
        /* Display a prompt for the player's next move (see examples) */

        /* INSERT YOUR CODE HERE */
        if (model.isXTurn() == true)
        {
            System.out.print("\nPlayer 1 (X) Move:");
            System.out.print("\nEnter the row and column numbers, seperated by a space: ");
            
            
        }
        
        
        
        else if (model.isXTurn() == false)
        {
            System.out.print("\nPlayer 2 (Y) Move: ");
            System.out.print("\nEnter the row and column numbers, seperated by a space: ");
            
        }
        
            
        

    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE */
        
       
        System.out.println("\nError: either the mark is out of bounds or the square is already taken.\n"
                + "Please enter another valid input.\n");
        
        
    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}