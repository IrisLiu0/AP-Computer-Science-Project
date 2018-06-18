
public class Gaem {

	private Player player;
	private Enemy enemy;
	private int turn;
	public static int CONTINUE = 0, WIN = 1, LOSE = 2;

	public Gaem(Player p, Enemy e) {
		turn = 0;
		player = p;
		enemy = e;

		player.startGame();
		enemy.startGame();

	}

	public int gameLoop() {
		turn++;
		player.startTurn();
		enemy.startTurn();
		return this.checkWin();
	}

	public int checkWin() {
		if (enemy.isDead())
			return WIN;
		if (player.getLife() <= 0)
			return LOSE;
		return CONTINUE;
	}

}
