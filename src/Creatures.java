
public class Creatures extends Card
{
	private int atk,def,cost;

	public Creatures(String Name, int cost, int attack, int defense)
	{
		super(Name);
		
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	
	

}