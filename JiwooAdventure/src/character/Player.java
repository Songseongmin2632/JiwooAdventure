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

	
	public void levelUp() { //레벨 업!		
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
	
	public void clearReward(int num) { //클리어보상
		@SuppressWarnings("unused")
		int clearMoney = 0;
		@SuppressWarnings("unused")
		int getExperience = 0;
		clearMoney = 20 + (num * 20); //던전 클리어시 획득하는 재화량
		getExperience = 30 + (num * 30); //던전 클리어시 획득하는 경험치
	}
			
	public void winningTheBattle(int inputNum) { //전투승리
		int clearMoney = 0;
		int getExperience = 0;
		clearMoney = 20 + (inputNum * 20); //던전 클리어시 획득하는 재화량
		getExperience = 30 + (inputNum * 30); //던전 클리어시 획득하는 경험치
		money = money + clearMoney;
		experience = experience + getExperience;
		System.out.println();
		System.out.println("전투승리!!\n"+clearMoney+"원을 획득했다!\n"+"현재 소지금 : "+getMoney());
		levelUp();
	}
	
	public void hpInitialize() { //체력 초기화
		hp = maxHp;
		mp = maxMp;
	}			
}