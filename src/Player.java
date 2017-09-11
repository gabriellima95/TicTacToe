import java.util.Scanner;

public class Player {

	Scanner scanner = new Scanner(System.in);  
	void move(Board b) {
		int i = scanner.nextInt();
		int j = scanner.nextInt();
		if(b.validMove(i, j))
			b.board[i][j]=1;
		else {
			System.out.println("Jogada Invalida, escolha outra:");
			this.move(b);
		}
	}
}
