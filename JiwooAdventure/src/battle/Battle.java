package battle;

import java.util.Scanner;
import character.Monster;
import character.Player;
import main.Color;

public class Battle {
	
	
	@SuppressWarnings("static-access")
	public void battleSet(Player p, Monster m, Color c) { //�������� ���� �� �� ���������� ���� ���� ����
		Scanner sc = new Scanner(System.in);		
		System.out.println("stage(1~30)�� �����ϼ���");
		int input = sc.nextInt();
		int skillInput;
				
		int[] stage = new int[30];
		for(int i=0; i < stage.length; i++) {
			stage[i] = i+1;
		}
		
		for(int i=0; i < 30; i++) {
			if(stage[i]==input) {
				System.out.println(stage[i]+"stage�Դϴ�.\n");
				System.out.println("��������!");
				p.hpSetting(); //�ʱ� ü�� ����
				m.monsterAbilitiesSet(i); //���� �ɷ¼�ġ ����
				p.clearReward(i); //Ŭ���� ����
			}
		}
					
		while (true) {
			if(p.getAttackSpeed() >= m.getAttackSpeed()) {	//�÷��̾� ������
			   	System.out.println(); //�÷��̾� ����
			   	System.out.println("-------------------------------------------------------------------------");
				System.out.println("����� ���Դϴ�");							
				System.out.println("��ų�� �����ϼ���.");
				System.out.println("���� hp : "+c.RED+String.format("%.2f",(p.getHp()))+c.RESET+"   "+"���� mp : "+c.BLUE+p.getMp()+c.RESET);
				System.out.println();
				System.out.println("��ġ��(1)-�����Ҹ� : "+c.B_BLUE+"10"+c.RESET+"���ط� : "+c.B_RED+p.getPower()+c.RESET);
				System.out.println();
				System.out.println("������(2)-�����Ҹ� : "+c.B_BLUE+"15"+c.RESET+"���ط� : "+c.B_RED+(p.getPower() * 1.5)+c.RESET);
				System.out.println();
				System.out.println("��ī�� ������(3)-�����Ҹ� : "+c.B_BLUE+"15"+c.RESET+"���ط� : "+c.B_RED+(p.getPower() * 0.5)+c.RESET+" �����̻� : "+c.B_PURPLE+"<����>"+c.RESET);
				System.out.println();
				System.out.println("����ȸ��(4)-�����Ҹ� : "+c.B_BLUE+"0"+c.RESET+"����ȸ��"+c.B_BLUE+"30"+c.RESET);
				System.out.println();
				System.out.println("��������(5)");
				System.out.println();
				System.out.println(m.getName()+"�� ���� hp : "+c.RED+m.getHp()+c.RESET);
				System.out.println("-------------------------------------------------------------------------");
				skillInput = sc.nextInt();
					
				if(skillInput==1) {
					if(p.getMp() < 10) {
						System.out.println("������ �����մϴ�.");	
						continue;
					}
					else {
						System.out.println();
						System.out.println(c.BRED+"������ ��ġ��!!"+c.RESET);
						System.out.println();
						p.firstSkill(m);
						System.out.println(p.getName()+"�� ��뿡�� "+c.B_RED+p.getPower()+c.RESET+" ���ظ� �������ϴ�.");
						System.out.println(m.getName()+"�� ���� hp : "+c.RED+m.getHp()+c.RESET);										
					}
				}
					
				if(skillInput==2) {
					if(p.getMp() < 15) {
						System.out.println("������ �����մϴ�.");
						continue;
					}
					else {
						System.out.println();
						System.out.println(c.BRED+"������ ������!!"+c.RESET);
						System.out.println();
						p.secondSkill(m);
						System.out.println(p.getName()+"�� ��뿡�� "+c.B_RED+(p.getPower() * 1.5)+c.RESET+" ���ظ� �������ϴ�.");
						System.out.println(m.getName()+"�� ���� hp : "+c.RED+m.getHp()+c.RESET);									
					}
				}
					
				if(skillInput==3) {
					if(p.getMp() < 15) {
						System.out.println("������ �����մϴ�.");
						continue;
					}
					else {
						System.out.println();
						System.out.println(c.BRED+"������ ��ī�� ������!!"+c.RESET);
						System.out.println();
						p.thirdSkill(m);
						System.out.println(p.getName()+"�� ��뿡�� "+c.B_RED+(p.getPower() * 1.5)+c.RESET+" ���ظ� �������ϴ�.");
						System.out.println("��밡 �����̻� "+c.B_PURPLE+"<����>"+c.RESET+" �� �ɷǽ��ϴ�!");
						System.out.println(m.getName()+"�� ���� hp : "+c.RED+m.getHp()+c.RESET);
						continue;
					}
				}
					
				if(skillInput==4) {
					System.out.println();
					System.out.println(c.BRED+"������ ����ȸ��!!"+c.RESET);
					System.out.println();
					p.fourthSkill(m);
					System.out.println("mp�� "+c.BLUE+"30"+c.RESET+" ȸ���߽��ϴ�.");
					System.out.println("���� mp : "+c.BLUE+p.getMp()+c.RESET);
				}
					
				if(skillInput==5) {
					int run = (int) (Math.random()*2)+1;
						
					if(run==1) {
						System.out.println();
						System.out.println("������ �����Ͽ����ϴ�!");
						System.out.println();
						break;
					}
						
					if(run==2) {
						System.out.println("������ �����߽��ϴ�..");
					}
				}
										
				if(m.getHp() <= 0) {							
					p.winningTheBattle(input - 1);
					break;
				}																	
				
				while (true) { //���� ����
					System.out.println();
					System.out.println("-------------------------------------------------------------------------");
					System.out.println("��� ���Դϴ�.");
					int skillNum = (int) (Math.random()*4)+1;
						
					if(skillNum==1) {
						System.out.println();
						System.out.println(c.BBLUE+"�̽����� ��¦���Ž�!!"+c.RESET);
						System.out.println();
						m.firstSkill(p);
						System.out.println(m.getName()+"���� "+c.B_RED+(Math.round(m.getPower() * 0.5))+c.RESET+" ���ظ� �Ծ����ϴ�.");
						break;
					}
						
					if(skillNum==2) {
						System.out.println();
						System.out.println(c.BBLUE+"�̽����� ��ġ������!!"+c.RESET);
						System.out.println();
						m.secondSkill(p);
						System.out.println(m.getName()+"���� "+c.B_RED+(Math.round(m.getPower()))+c.RESET+" ���ظ� �Ծ����ϴ�.");
						break;
					}
						
					if(skillNum==3) {
						System.out.println();
						System.out.println(c.BBLUE+"�̽����� �Ӹ�ä ���!!"+c.RESET);
						System.out.println();
						m.thirdSkill(p);
						System.out.println(m.getName()+"���� "+c.B_RED+(Math.round(m.getPower() * 1.2))+c.RESET+" ���ظ� �Ծ����ϴ�.");
						System.out.println("�����̻� "+c.B_PURPLE+"<�ӹ�>"+c.RESET+" �� �ɷǽ��ϴ�!");
						continue;
					}
						
					if(skillNum==4) {
						System.out.println();
						System.out.println(c.BBLUE+"�̽����� ��ġ�δ��!!"+c.RESET);
						System.out.println();
						m.fourthSkill(p);
						System.out.println(m.getName()+"���� "+c.B_RED+(Math.round(m.getPower() * 1.5))+c.RESET+" ���ظ� �Ծ����ϴ�.");
						break;
					}
				}

				if(p.getHp() <= 0) {
					System.out.println("�����й�..");
					break;								
				}
			} //�÷��̾� ���� ����
																												
			if(p.getAttackSpeed() < m.getAttackSpeed()) { //���� ������
				while (true) { //���� ����
					System.out.println();
					System.out.println("-------------------------------------------------------------------------");
					System.out.println("��� ���Դϴ�.");
					int skillNum = (int) (Math.random()*4)+1;
					
					if(skillNum==1) {
						System.out.println();
						System.out.println(c.BBLUE+"�̽����� ��¦���Ž�!!"+c.RESET);
						System.out.println();
						m.firstSkill(p);
						System.out.println(m.getName()+"���� "+c.B_RED+(Math.round(m.getPower() * 0.5))+c.RESET+" ���ظ� �Ծ����ϴ�.");
						break;
					}
					
					if(skillNum==2) {
						System.out.println();
						System.out.println(c.BBLUE+"�̽����� ��ġ������!!"+c.RESET);
						System.out.println();
						m.secondSkill(p);
						System.out.println(m.getName()+"���� "+c.B_RED+(Math.round(m.getPower()))+c.RESET+" ���ظ� �Ծ����ϴ�.");
						break;
					}
						
					if(skillNum==3) {
						System.out.println();
						System.out.println(c.BBLUE+"�̽����� �Ӹ�ä ���!!"+c.RESET);
						System.out.println();
						m.thirdSkill(p);
						System.out.println(m.getName()+"���� "+c.B_RED+(Math.round(m.getPower() * 1.2))+c.RESET+" ���ظ� �Ծ����ϴ�.");
						System.out.println("�����̻� "+c.B_PURPLE+"<�ӹ�>"+c.RESET+" �� �ɷǽ��ϴ�!");
						continue;
					}
						
					if(skillNum==4) {
						System.out.println();
						System.out.println(c.BBLUE+"�̽����� ��ġ�δ��!!"+c.RESET);
						System.out.println();
						m.fourthSkill(p);
						System.out.println(m.getName()+"���� "+c.B_RED+(Math.round(m.getPower() * 1.5))+c.RESET+" ���ظ� �Ծ����ϴ�.");
						break;
					}
				}
				
				if(p.getHp() <= 0) {
					System.out.println("�����й�..");
					break;
				}
				
				while (true) {
					System.out.println(); //�÷��̾� ����
				   	System.out.println("-------------------------------------------------------------------------");
					System.out.println("����� ���Դϴ�");							
					System.out.println("��ų�� �����ϼ���.");
					System.out.println("���� hp : "+c.RED+String.format("%.2f",(p.getHp()))+c.RESET+"   "+"���� mp : "+c.BLUE+p.getMp()+c.RESET);
					System.out.println();
					System.out.println("��ġ��(1)-�����Ҹ� : "+c.B_BLUE+"10"+c.RESET+"���ط� : "+c.B_RED+p.getPower()+c.RESET);
					System.out.println();
					System.out.println("������(2)-�����Ҹ� : "+c.B_BLUE+"15"+c.RESET+"���ط� : "+c.B_RED+(p.getPower() * 1.5)+c.RESET);
					System.out.println();
					System.out.println("��ī�� ������(3)-�����Ҹ� : "+c.B_BLUE+"15"+c.RESET+"���ط� : "+c.B_RED+(p.getPower() * 0.5)+c.RESET+" �����̻� : "+c.B_PURPLE+"<����>"+c.RESET);
					System.out.println();
					System.out.println("����ȸ��(4)-�����Ҹ� : "+c.B_BLUE+"0"+c.RESET+"����ȸ��"+c.B_BLUE+"30"+c.RESET);
					System.out.println();
					System.out.println("��������(5)");
					System.out.println("-------------------------------------------------------------------------");
					skillInput = sc.nextInt();
						
					if(skillInput==1) {
						if(p.getMp() < 10) {
							System.out.println("������ �����մϴ�.");	
							continue;
						}
						else {
							System.out.println();
							System.out.println(c.BRED+"������ ��ġ��!!"+c.RESET);
							System.out.println();
							p.firstSkill(m);
							System.out.println(p.getName()+"�� ��뿡�� "+c.B_RED+p.getPower()+c.RESET+" ���ظ� �������ϴ�.");
							System.out.println(m.getName()+"�� ���� hp : "+c.RED+m.getHp()+c.RESET);										
						}
					}
						
					if(skillInput==2) {
						if(p.getMp() < 15) {
							System.out.println("������ �����մϴ�.");
							continue;
						}
						else {
							System.out.println();
							System.out.println(c.BRED+"������ ������!!"+c.RESET);
							System.out.println();
							p.secondSkill(m);
							System.out.println(p.getName()+"�� ��뿡�� "+c.B_RED+(p.getPower() * 1.5)+c.RESET+" ���ظ� �������ϴ�.");
							System.out.println(m.getName()+"�� ���� hp : "+c.RED+m.getHp()+c.RESET);									
						}
					}
						
					if(skillInput==3) {
						if(p.getMp() < 15) {
							System.out.println("������ �����մϴ�.");
							continue;
						}
						else {
							System.out.println();
							System.out.println(c.BRED+"������ ��ī�� ������!!"+c.RESET);
							System.out.println();
							p.thirdSkill(m);
							System.out.println(p.getName()+"�� ��뿡�� "+c.B_RED+(p.getPower() * 1.5)+c.RESET+" ���ظ� �������ϴ�.");
							System.out.println("��밡 �����̻� "+c.B_PURPLE+"<����>"+c.RESET+" �� �ɷǽ��ϴ�!");
							System.out.println(m.getName()+"�� ���� hp : "+c.RED+m.getHp()+c.RESET);
							continue;
						}
					}
						
					if(skillInput==4) {
						System.out.println();
						System.out.println(c.BRED+"������ ����ȸ��!!"+c.RESET);
						System.out.println();
						p.fourthSkill(m);
						System.out.println("mp�� "+c.BLUE+"30"+c.RESET+" ȸ���߽��ϴ�.");
						System.out.println("���� mp : "+c.BLUE+p.getMp()+c.RESET);
					}
					
					if(skillInput==5) {
                        int run = (int) (Math.random()*2)+1;
						
						if(run==1) {
						System.out.println();
						System.out.println("������ �����Ͽ����ϴ�!");
							System.out.println();
							break;
						}
							
						if(run==2) {
							System.out.println("������ �����߽��ϴ�..");
						}
					}
				}
				
				if(m.getHp() <= 0) {							
					p.winningTheBattle(input - 1);
					break;
				}
			}//���� ���� ����
		} //battle while end
		p.hpInitialize();
	} //battleSet end
}
