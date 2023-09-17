package character;

public class Character {
	protected String name; //�̸�
	protected int power; //���ݷ�
	protected int attackSpeed; //���ݼӵ�
	protected double hp; //ü��
	
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