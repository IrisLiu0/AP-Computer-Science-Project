
public class Spell extends Card
{
	private int cost;
	public Spell (String Name, int cost) {
		
		super(Name);
		
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
