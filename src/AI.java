
public class AI {

	void move(Board b) {
		//System.out.println("Entrei no move do AI");
		  Node node = new Node(b);
		  node.nodeAI();
		  //node.board.write();
	      int[] result = minimax(2, node.isPlayer, node); 
	      b.board[result[1]][result[2]]=-1;
	      System.out.println("Score escolhido: "+result[0]);
	   }
	public int[] minimax(int depth, boolean isPlayer,Node node) {
		int bestScore;
		//System.out.println("entrei com eh player "+isPlayer+" e depth "+depth);
		if(isPlayer) bestScore = 1000;
		else bestScore = -1000;
		Node aux;
		int i,j;
		int currentScore;
		int bestRow=-1;
		int bestColumn=-1;
		if(node.board.checkGameOver() || depth==0) {
			bestScore=node.board.evaluate();
		}
		else {
		for(i=0;i<3;i++)
			for(j=0;j<3;j++) {	
				if (node.board.validMove(i, j)) {
					node.board.move(i,j,node.isPlayer);
					aux=node;
				    currentScore = minimax(depth - 1, !(isPlayer), aux)[0];
				    if(isPlayer) {
				    	//bestScore = 1000;
				    	if (currentScore < bestScore) {
				    		  //System.out.println("comparando eh player "+isPlayer+" e depth "+depth+ "e seu best "+bestScore+" current"+ currentScore);
			                  bestScore = currentScore;
			                  bestRow = i;
			                  bestColumn = j;
			               }
				    }
				    else {
				    	//bestScore = -1000;
				    	if (currentScore > bestScore) {
				    		//System.out.println("comparando eh player "+isPlayer+" e depth "+depth+ "e seu best "+bestScore+" current"+ currentScore);
		                  bestScore = currentScore;
		                  bestRow = i;
		                  bestColumn = j;
		               }
				    }
				    node.board.undoMove(i,j);
				}
			}
		}
		//System.out.println("to saindo da interacao do ehPlayer "+isPlayer+" e depth "+depth+" com best: "+bestScore);
		return new int[] {bestScore,bestRow,bestColumn};
	}
}
