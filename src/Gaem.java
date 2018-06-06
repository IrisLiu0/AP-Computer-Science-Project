
public class Gaem
{
	
	private int turn;
	private static int CONTINUE = 0, WIN = 1, LOSE = 2;
	
	public Gaem()
	{
		turn = 0;
	}
	
	public void gameLoop()
	{
		Player player = new Player();
		Enemy enemy = new Enemy();
		
		player.startGame();
		enemy.startGame();
		while(this.checkWin() == CONTINUE)
		{
			turn++;
			player.startTurn();
		}
	}
	
	
	public int checkWin();
	{
		return CONTINUE;
	}

}
