
public class Effects {

	// Sets target minion health to x
	public void defDown(Minion target, int x) {
		target.setDefense(x);
	}

	// Deals x damage to target
	public void dmg(Minion target, int x) {
		target.setDefense(target.getDefense() - x);
	}

	// Increases health by x
	public void hpUp(Minion target, int x) {
		target.setDefense(target.getDefense() + x);
	}

	// Heals Player by x
	public void heal(Player p, int x) {
		p.changeLife(-x);
	}

	// Increase attack of a minion by x
	public void atkUp(Minion target, int x) {
		target.setDefense(target.getDefense() + x);
	}

}
