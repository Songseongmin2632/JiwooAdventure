package character;

public class Player extends Character {
	protected int level;
	protected double maxHp;
	protected int maxMp;
	protected int mp;
	protected int money;
	protected int experience;
	
	public Player(String name, int level, double maxHp, int maxMp, int power, int attackSpeed, double hp, int mp, int money, int experience) {
		super(name, power, attackSpeed, hp);
		this.name = name;
		this.power = power;
		this.attackSpeed = attackSpeed;
		this.hp = hp;
		this.level = level;				
		this.maxHp = maxHp;
		this.maxMp = maxMp;		
		this.mp = mp;
		this.money = money;
		this.experience = experience;
		
	}
	
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void setMaxHp(double maxHp) {
		this.maxHp = maxHp;
	}
	
	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
	}
		
	public void setHp(double hp) {
		this.hp = hp;
	}
	
	public void setMp(int mp) {
		this.mp = mp;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	
	public int getLevel() {
		return level;
	}
	
	public double getMaxHp() {
		return maxHp;
	}
	
	public int getMaxMp() {
		return maxMp;
	}
		
	
	public int getMp() {
		return mp;
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getExperience() {
		return experience;
	}

	
	public void levelUp() { //���� ��!		
		for(int i=0; i < 29; i++) {
			if(level == i+1) {
				if(experience >= 100 + (i * 100)) {
					System.out.println("Level Up!!");
					power += 10;
					attackSpeed += 1;
					maxHp += 30;
					level += 1;
					experience -= 100 + (i * 100);
				}
			}
		}
	}
	
	
	public void hpSetting() {
		hp = maxHp;
	}
	
	public void moneyDeducted(int num) {
		int[] needMoney = new int[10];
		for(int i=0; i < needMoney.length; i++) {
			needMoney[i] = 150 + (i * 150);
		}
		money = money - needMoney[num];
	}
	
	public void powerEnhancement() {
		power = power + 20;
	}
	
	public void attackSpeedEnhancement() {
		attackSpeed = attackSpeed + 1;
	}
	
	public void hpEnhancement() {
		maxHp = maxHp + 100;
	}
	
	public void payback(int num) {
		int[] needMoney = new int[10];
		for(int i=0; i < needMoney.length; i++) {
			needMoney[i] = 150 + (i * 150);
		}
		money = money + needMoney[num];
	}
	
	public void firstSkill(Monster m) {
		m.hp = m.hp - power;
		mp = mp -10;
	}
	
	public void secondSkill(Monster m) {
		m.hp = m.hp - (power * 1.5);
		mp = mp - 15;
	}
	
	public void thirdSkill(Monster m) {
		m.hp = m.hp - (power * 0.5);
		mp = mp - 15;
	}
	
	public void fourthSkill(Monster m) {
		mp = mp + 30;
	}
	
	public void clearReward(int num) { //Ŭ�����
		@SuppressWarnings("unused")
		int clearMoney = 0;
		@SuppressWarnings("unused")
		int getExperience = 0;
		clearMoney = 20 + (num * 20); //���� Ŭ����� ȹ���ϴ� ��ȭ��
		getExperience = 30 + (num * 30); //���� Ŭ����� ȹ���ϴ� ����ġ
	}
			
	public void winningTheBattle(int inputNum) { //�����¸�
		int clearMoney = 0;
		int getExperience = 0;
		clearMoney = 20 + (inputNum * 20); //���� Ŭ����� ȹ���ϴ� ��ȭ��
		getExperience = 30 + (inputNum * 30); //���� Ŭ����� ȹ���ϴ� ����ġ
		money = money + clearMoney;
		experience = experience + getExperience;
		System.out.println();
		System.out.println("�����¸�!!\n"+clearMoney+"���� ȹ���ߴ�!\n"+"���� ������ : "+getMoney());
		levelUp();
	}
	
	public void hpInitialize() { //ü�� �ʱ�ȭ
		hp = maxHp;
		mp = maxMp;
	}			
}