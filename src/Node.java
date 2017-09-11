
public class Node {
	Board board;
	boolean isPlayer;
	public Node(Board _board) {
		//System.out.println("entrei no inicializador do node");
		board=_board;
	}
	void nodePlayer() {
		isPlayer=true;
	}
	void nodeAI() {
		isPlayer=false;
	}
}
