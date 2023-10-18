package character;

public class Monster extends Character {
	public Monster(String name, int power, int attackSpeed, double hp) {
		super(name, power, attackSpeed, hp);
		this.name = name;
		this.power = power;
		this.attackSpeed = attackSpeed;
		this.hp = hp;
	}


	public void monsterAbilitiesSet(int num) { //¸ó½ºÅÍ ´É·Â¼öÄ¡
		power = 10 + (num * 8);
		attackSpeed = 8 + num;
		hp = 100 + (num * 300);
	}

	public void firstSkill(Player p) {
		p.hp = p.hp - (power * 0.5);
	}

	public void secondSkill(Player p) {
		p.hp = p.hp - power;
	}

	public void thirdSkill(Player p) {
		p.hp = p.hp - (power * 1.2);
	}

	public void fourthSkill(Player p) {
		p.hp = p.hp - (power * 1.5);
	}
}

