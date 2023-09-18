package main;

import java.util.Scanner;
import battle.Battle;
import character.Monster;
import character.Player;
import field.Field;
import field.Information;
import field.Shop;

public class Main {

	public static void main(String[] args) {
		Color color = new Color();
		Player player = new Player("����", 1, 100, 100, 10, 10, 100, 100, 100, 0);
		Monster monster = new Monster("�̽���", 10, 1, 100);
		Shop shop = new Shop(1);
		Information infotmation = new Information();
		Battle battle = new Battle(); 
		while (true) {
			Field field = new Field();
			field.start();
			
			Scanner scanner = new Scanner(System.in);
			int input = scanner.nextInt();
			
			if(input==1) { //����
				shop.mainShop(player);
			}
			
			if(input==2) { //����â
				infotmation.playerInformaion(player);
			}
			
			if(input==3) { //����
				battle.battleSet(player, monster, color);
			}
			
			if(input==4) { //��������
				System.out.println("The end");
				break;
			}			
		} //game while end
	}
}
