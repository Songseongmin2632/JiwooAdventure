package field;

import java.util.Scanner;

import character.Player;

public class Shop {
	
	public void mainShop(Player p) { //메인 상점
		while (true) {
		    System.out.println("강화할 능력치를 선택하세요.\n"+"공격력(1)\n"+"공격속도(2)\n"+"체력(3)\n"+"Manu(4)");
		    Scanner scanner = new Scanner(System.in);
		    int input = scanner.nextInt();
		
		    if(input==1) {			
				powerEnhancement(p);
			}
			
			if(input==2) {
				attackSpeedEnhancement(p);
			}
			
			if(input==3) {
				hpEnhancement(p);
			}
			
			if(input==4) {
				break;
			}			
		}				
	}
	
	public void powerEnhancement(Player p) { //공격력 강화
		System.out.println("공격력을 강화하시겠습니까?\n"+"예(1)\n"+"아니요(2)");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
				
		if(input==1) {										
			int[] needMoney = new int[10];
			for(int i=0; i < needMoney.length; i++) {
				needMoney[i] = 150 + (i * 150);
			}
			int[] enhancementLevel = new int[10];
			for(int i=0; i<enhancementLevel.length; i++) {
				enhancementLevel[i] = i+1;
			}
			int count = 1;
			
			if(count==11) {
				System.out.println("더이상 강화할 수 없습니다.");
			}
			
			for(int i=0; i<10; i++) {
				if(enhancementLevel[i]==count) {
					p.moneyDeducted(i);
					if(p.getMoney() >= 0) {
						p.powerEnhancement();
						count++;						
						System.out.println("강화 성공!!\n"+"현재 공격력 강화 수치 : "+count+"현재 공격력 : "+p.getPower());
						System.out.println();
					}
					else {						
						System.out.println("강화 실패...\n"+(p.getMoney() * -1)+"원이 부족합니다.");
						System.out.println();
						p.payback(i);
					}
				}				
			}
		}
		
		if(input==2) {
			System.out.println();
		}		
	}
	
	public void attackSpeedEnhancement(Player p) {//공격속도 강화
		System.out.println("공격속도을 강화하시겠습니까?\n"+"예(1)\n"+"아니요(2)");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
				
		if(input==1) {										
			int[] needMoney = new int[10];
			for(int i=0; i < needMoney.length; i++) {
				needMoney[i] = 150 + (i * 150);
			}
			int[] enhancementLevel = new int[10];
			for(int i=0; i<enhancementLevel.length; i++) {
				enhancementLevel[i] = i+1;
			}
			int count = 1;
			
			if(count==11) {
				System.out.println("더이상 강화할 수 없습니다.");
			}
			
			for(int i=0; i<10; i++) {
				if(enhancementLevel[i]==count) {
					p.moneyDeducted(i);
					if(p.getMoney() >= 0) {
						p.attackSpeedEnhancement();
						count++;						
						System.out.println("강화 성공!!\n"+"현재 공격속도 강화 수치 : "+count+"현재 공격속도 : "+p.getAttackSpeed());
						System.out.println();
					}
					else {
						System.out.println("강화 실패...\n"+(p.getMoney() * -1)+"원이 부족합니다.");
						System.out.println();
						p.payback(i);
					}
				}				
			}
		}
		
		if(input==2) {
			System.out.println();
		}		
	}
	
	public void hpEnhancement(Player p) {//체력 강화
		System.out.println("체력을 강화하시겠습니까?\n"+"예(1)\n"+"아니요(2)");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
				
		if(input==1) {										
			int[] needMoney = new int[10];
			for(int i=0; i < needMoney.length; i++) {
				needMoney[i] = 150 + (i * 150);
			}
			int[] enhancementLevel = new int[10];
			for(int i=0; i<enhancementLevel.length; i++) {
				enhancementLevel[i] = i+1;
			}
			int count = 1;
			
			if(count==11) {
				System.out.println("더이상 강화할 수 없습니다.");
			}
			
			for(int i=0; i<10; i++) {
				if(enhancementLevel[i]==count) {
					p.moneyDeducted(i);
					if(p.getMoney() >= 0) {
						p.hpEnhancement();
						count++;						
						System.out.println("강화 성공!!\n"+"현재 체력 강화 수치 : "+count+"현재 체력 : "+p.getHp());
						System.out.println();
					}
					else {						
						System.out.println("강화 실패...\n"+(p.getMoney() * -1)+"원이 부족합니다.");
						System.out.println();
						p.payback(i);
					}
				}				
			}
		}
		if(input==2) {
			System.out.println();
		}		
	}
}
