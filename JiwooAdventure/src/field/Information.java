package field;

import java.util.Scanner;

import character.Player;

public class Information {	
	public void playerInformaion(Player p) {
		while (true) {
			System.out.println(" ========================================== ");
			System.out.println("|                  ĳ��������                 |");
			System.out.println("|                                          |");
			System.out.println("| �̸� : "+p.getName()+"                                |");
			System.out.println("|                                          |");
			System.out.println("| ���� : "+p.getLevel()+"                                  |");
			System.out.println("|                                          |");
			System.out.println("| ���ݷ� : "+p.getPower()+"                                |");
			System.out.println("|                                          |");
			System.out.println("| ���ݼӵ� : "+p.getAttackSpeed()+"                              |");
			System.out.println("|                                          |");
			System.out.println("| ü�� : "+p.getHp()+"                                |");
			System.out.println("|                                          |");
			System.out.println("| ���� : "+p.getMp()+"                                |");
			System.out.println("|                                          |");
			System.out.println("| ������ : "+p.getMoney()+"                               |");
			System.out.println("|                                          |");
			System.out.println("| ����ġ : "+p.getExperience()+"                               |");
			System.out.println("|                                          |");		
			System.out.println(" ========================================= ");
			System.out.println();
			System.out.println("Manu(1)");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			
			if(input==1) {
				System.out.println();
				break;
			}
			
			else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}			
		}			
	}	
}