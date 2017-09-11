
public class Board {

	//boolean gameOver;
	public int[][] board = new int[3][3];
	public Board(){
		int i,j;
		for (i=0;i<3;i++)
			for(j=0;j<3;j++) {
				board[i][j]=0;
			}
	}
	boolean checkGameOver() {
		int i,j;
		boolean gameOver=true;
		for (i=0;i<3;i++)
			for(j=0;j<3;j++) {
				if(board[i][j]==0) gameOver=false;
			}
		return gameOver;
	}
	
	void move(int i, int j, boolean isPlayer) {
		if(validMove(i,j)) {
		if(isPlayer)
			board[i][j]=1;
		else board[i][j]=-1;
		}
		else move(i, j , isPlayer);
	}
	
	void undoMove(int i, int j) {
		board[i][j]=0;
	}
	
	boolean validMove(int i, int j) {
		if (board[i][j]!=1 && board[i][j]!=-1)
			return true;
		else return false;
	}
	
	int evaluate() {
	      int score = 0;
	      // Evaluate score for each of the 8 lines (3 rows, 3 columns, 2 diagonals)
	      score += evaluateLine(0, 0, 0, 1, 0, 2);  // row 0
	      score += evaluateLine(1, 0, 1, 1, 1, 2);  // row 1
	      score += evaluateLine(2, 0, 2, 1, 2, 2);  // row 2
	      score += evaluateLine(0, 0, 1, 0, 2, 0);  // col 0
	      score += evaluateLine(0, 1, 1, 1, 2, 1);  // col 1
	      score += evaluateLine(0, 2, 1, 2, 2, 2);  // col 2
	      score += evaluateLine(0, 0, 1, 1, 2, 2);  // diagonal
	      score += evaluateLine(0, 2, 1, 1, 2, 0);  // alternate diagonal
	      return score;
	   }
	
	
	int evaluateLine(int row1, int col1, int row2, int col2, int row3, int col3) {
	      int score = 0;
	 
	      // First cell
	      if (board[row1][col1]==-1) {
	         score = 1;
	      } else if (board[row1][col1]==1) {
	         score = -1;
	      }
	 
	      // Second cell
	      if (board[row2][col2]==-1) {
	         if (score == 1) {   // cell1 is mySeed
	            score = 10;
	         } else if (score == -1) {  // cell1 is oppSeed
	            return 0;
	         } else {  // cell1 is empty
	            score = 1;
	         }
	      } else if (board[row2][col2]==1) {
	         if (score == -1) { // cell1 is oppSeed
	            score = -10;
	         } else if (score == 1) { // cell1 is mySeed
	            return 0;
	         } else {  // cell1 is empty
	            score = -1;
	         }
	      }
	 
	      // Third cell
	      if (board[row3][col3]==-1) {
	         if (score > 0) {  // cell1 and/or cell2 is mySeed
	            score *= 10;
	         } else if (score < 0) {  // cell1 and/or cell2 is oppSeed
	            return 0;
	         } else {  // cell1 and cell2 are empty
	            score = 1;
	         }
	      } else if (board[row3][col3]==1) {
	         if (score < 0) {  // cell1 and/or cell2 is oppSeed
	            score *= 10;
	         } else if (score > 1) {  // cell1 and/or cell2 is mySeed
	            return 0;
	         } else {  // cell1 and cell2 are empty
	            score = -1;
	         }
	      }
	      return score;
	   }
	
	void write() {
		int i,j;
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				if(board[i][j]==0) System.out.print("|   |");
				if(board[i][j]==1) System.out.print("| X |");
				if(board[i][j]==-1) System.out.print("| O |");
			}
			System.out.println("");
		}
	}
	
	boolean somebodyWon(){
		if ((board[0][0]==1 && board[0][1]==1 && board[0][2]==1)
				|| (board[1][0]==1 && board[1][1]==1 && board[1][2]==1) 
				|| (board[2][0]==1 && board[2][1]==1 && board[2][2]==1)) return true;
		if ((board[0][0]==-1 && board[0][1]==-1 && board[0][2]==-1)
				|| (board[1][0]==-1 && board[1][1]==-1 && board[1][2]==-1) 
				|| (board[2][0]==-1 && board[2][1]==-1 && board[2][2]==-1)) return true;
		if ((board[0][0]==-1 && board[1][0]==-1 && board[2][0]==-1)
				|| (board[0][1]==-1 && board[1][1]==-1 && board[2][1]==-1) 
				|| (board[0][2]==-1 && board[1][2]==-1 && board[2][2]==-1)) return true;
		if ((board[0][0]==1 && board[1][0]==1 && board[2][0]==1)
				|| (board[0][1]==1 && board[1][1]==1 && board[2][1]==1) 
				|| (board[0][2]==1 && board[1][2]==1 && board[2][2]==1)) return true;
		if ((board[0][0]==1 && board[1][1]==1 && board[2][2]==1)
				|| (board[0][2]==1 && board[1][1]==1 && board[2][0]==1)) return true;
		if ((board[0][0]==-1 && board[1][1]==-1 && board[2][2]==-1)
				|| (board[0][2]==-1 && board[1][1]==-1 && board[2][0]==-1)) return true;
		return false;
	}	
}
