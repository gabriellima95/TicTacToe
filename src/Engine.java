import java.util.Scanner;

public class Engine {

	void startGame() {
		Board b = new Board();
		Player p1 = new Player();
		AI p2 = new AI();
		System.out.print("Digite sua jogada: ");
		p1.move(b);
		b.write();
		while(!b.checkGameOver()) {
			p2.move(b);
			System.out.println("Jogada do AI");
			b.write();
			if(b.somebodyWon()) {
				System.out.println("Você perdeu");
				break;
			}
			System.out.print("Digite sua jogada: ");
			p1.move(b);
			b.write();
			if(b.somebodyWon()) {
				System.out.println("Você venceu");
				break;
			}
		}
		if(b.checkGameOver() && !b.somebodyWon())System.out.println("Empate");
		System.out.println("Jogar novamente(s/n): ");
		Scanner scanner = new Scanner(System.in);  
		String prox = scanner.nextLine();
		if(prox.equals("s")) this.startGame();
		}
}
