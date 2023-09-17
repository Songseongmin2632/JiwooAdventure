package character;

public class Character {
	protected String name; //이름
	protected int power; //공격력
	protected int attackSpeed; //공격속도
	protected double hp; //체력
	
	public Character(String name, int power, int attackSpeed, double hp) {
		this.name = name;
		this.power = power;
		this.attackSpeed = attackSpeed;
		this.hp = hp;		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	
	public void setHp(double hp) {
		this.hp = hp;
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getPower() {
		return power;
	}
	
	public int getAttackSpeed() {
		return attackSpeed;		
	}
	
	public double getHp() {
		return hp;
	}
}