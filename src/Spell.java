
public class Spell extends Card 
{
	
	public Spell(String name, int cost, int id) 
	{
		super(name, cost, id);
		init(id);
	}
	
	private void init(int id)
	{
		switch (id)
		{
		case 0:
			super.setImg("Pictures//Weaken.png");
			break;
		case 4:
			super.setImg("Pictures//Drain Life (1).png");
			break;
		case 5:
			super.setImg("Pictures//Deadly Shot.png");
			break;
		case 8:
			super.setImg("Pictures//Panem et Circenses.png");
			break;
		}
	}

}
