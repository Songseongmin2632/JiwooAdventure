package field;

import java.util.Scanner;

import character.Player;

public class Shop {
	
	public void mainShop(Player p) { //���� ����
		while (true) {
		    System.out.println("��ȭ�� �ɷ�ġ�� �����ϼ���.\n"+"���ݷ�(1)\n"+"���ݼӵ�(2)\n"+"ü��(3)\n"+"Manu(4)");
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
	
	public void powerEnhancement(Player p) { //���ݷ� ��ȭ
		System.out.println("���ݷ��� ��ȭ�Ͻðڽ��ϱ�?\n"+"��(1)\n"+"�ƴϿ�(2)");
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
				System.out.println("���̻� ��ȭ�� �� �����ϴ�.");
			}
			
			for(int i=0; i<10; i++) {
				if(enhancementLevel[i]==count) {
					p.moneyDeducted(i);
					if(p.getMoney() >= 0) {
						p.powerEnhancement();
						count++;						
						System.out.println("��ȭ ����!!\n"+"���� ���ݷ� ��ȭ ��ġ : "+count+"���� ���ݷ� : "+p.getPower());
						System.out.println();
					}
					else {						
						System.out.println("��ȭ ����...\n"+(p.getMoney() * -1)+"���� �����մϴ�.");
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
	
	public void attackSpeedEnhancement(Player p) {//���ݼӵ� ��ȭ
		System.out.println("���ݼӵ��� ��ȭ�Ͻðڽ��ϱ�?\n"+"��(1)\n"+"�ƴϿ�(2)");
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
				System.out.println("���̻� ��ȭ�� �� �����ϴ�.");
			}
			
			for(int i=0; i<10; i++) {
				if(enhancementLevel[i]==count) {
					p.moneyDeducted(i);
					if(p.getMoney() >= 0) {
						p.attackSpeedEnhancement();
						count++;						
						System.out.println("��ȭ ����!!\n"+"���� ���ݼӵ� ��ȭ ��ġ : "+count+"���� ���ݼӵ� : "+p.getAttackSpeed());
						System.out.println();
					}
					else {
						System.out.println("��ȭ ����...\n"+(p.getMoney() * -1)+"���� �����մϴ�.");
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
	
	public void hpEnhancement(Player p) {//ü�� ��ȭ
		System.out.println("ü���� ��ȭ�Ͻðڽ��ϱ�?\n"+"��(1)\n"+"�ƴϿ�(2)");
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
				System.out.println("���̻� ��ȭ�� �� �����ϴ�.");
			}
			
			for(int i=0; i<10; i++) {
				if(enhancementLevel[i]==count) {
					p.moneyDeducted(i);
					if(p.getMoney() >= 0) {
						p.hpEnhancement();
						count++;						
						System.out.println("��ȭ ����!!\n"+"���� ü�� ��ȭ ��ġ : "+count+"���� ü�� : "+p.getHp());
						System.out.println();
					}
					else {						
						System.out.println("��ȭ ����...\n"+(p.getMoney() * -1)+"���� �����մϴ�.");
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
