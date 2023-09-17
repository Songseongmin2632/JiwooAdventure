package field;

import java.util.Scanner;

import character.Player;

public class Information {	
	public void playerInformaion(Player p) {
		while (true) {
			System.out.println(" ========================================== ");
			System.out.println("|                  캐릭터정보                 |");
			System.out.println("|                                          |");
			System.out.println("| 이름 : "+p.getName()+"                                |");
			System.out.println("|                                          |");
			System.out.println("| 레벨 : "+p.getLevel()+"                                  |");
			System.out.println("|                                          |");
			System.out.println("| 공격력 : "+p.getPower()+"                                |");
			System.out.println("|                                          |");
			System.out.println("| 공격속도 : "+p.getAttackSpeed()+"                              |");
			System.out.println("|                                          |");
			System.out.println("| 체력 : "+p.getHp()+"                                |");
			System.out.println("|                                          |");
			System.out.println("| 마나 : "+p.getMp()+"                                |");
			System.out.println("|                                          |");
			System.out.println("| 소지금 : "+p.getMoney()+"                               |");
			System.out.println("|                                          |");
			System.out.println("| 경험치 : "+p.getExperience()+"                               |");
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
				System.out.println("잘못된 입력입니다.");
			}			
		}			
	}	
}