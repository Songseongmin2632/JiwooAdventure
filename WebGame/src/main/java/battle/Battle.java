package battle;

import java.util.Scanner;
import character.Monster;
import character.Player;
import main.Color;

public class Battle {
	
	public void battleSet(Player p, Monster m, Color c) { //스테이지 선택 및 각 스테이지에 따른 설정 결정
		Scanner sc = new Scanner(System.in);		
		System.out.println("stage(1~30)를 선택하세요");
		int input = sc.nextInt();
		int skillInput;
		int[] stage = new int[30];
		
		for(int i=0; i < stage.length; i++) {
			stage[i] = i+1;
		}

		for(int i=0; i < 30; i++) {
			if(stage[i]==input) {
				System.out.println(stage[i]+"stage입니다.\n");
				System.out.println("전투시작!");
				p.hpSetting(); //초기 체력 설정
				m.monsterAbilitiesSet(i); //몬스터 능력수치 결정
				p.clearReward(i); //클리어 보상
			}
		}

		while (true) {
			if(p.getAttackSpeed() >= m.getAttackSpeed()) {	//플레이어 선공격
			   	System.out.println(); //플레이어 공격
			   	System.out.println("-------------------------------------------------------------------------");
				System.out.println("당신의 턴입니다");							
				System.out.println("스킬을 선택하세요.");
				System.out.println("현재 hp : "+c.RED+String.format("%.2f",(p.getHp()))+c.RESET+"   "+"현재 mp : "+c.BLUE+p.getMp()+c.RESET);
				System.out.println();
				System.out.println("박치기(1)-마나소모량 : "+c.B_BLUE+"10"+c.RESET+"피해량 : "+c.B_RED+p.getPower()+c.RESET);
				System.out.println();
				System.out.println("발차기(2)-마나소모량 : "+c.B_BLUE+"15"+c.RESET+"피해량 : "+c.B_RED+(p.getPower() * 1.5)+c.RESET);
				System.out.println();
				System.out.println("피카츄 던지기(3)-마나소모량 : "+c.B_BLUE+"15"+c.RESET+"피해량 : "+c.B_RED+(p.getPower() * 0.5)+c.RESET+" 상태이상 : "+c.B_PURPLE+"<감전>"+c.RESET);
				System.out.println();
				System.out.println("마나회복(4)-마나소모량 : "+c.B_BLUE+"0"+c.RESET+"마나회복"+c.B_BLUE+"30"+c.RESET);
				System.out.println();
				System.out.println("도망가기(5)");
				System.out.println();
				System.out.println(m.getName()+"의 현재 hp : "+c.RED+m.getHp()+c.RESET);
				System.out.println("-------------------------------------------------------------------------");
				skillInput = sc.nextInt();

				if(skillInput==1) {
					if(p.getMp() < 10) {
						System.out.println("마나가 부족합니다.");	
						continue;
					}
					else {
						System.out.println();
						System.out.println(c.BRED+"지우의 박치기!!"+c.RESET);
						System.out.println();
						p.firstSkill(m);
						System.out.println(p.getName()+"가 상대에게 "+c.B_RED+p.getPower()+c.RESET+" 피해를 입혔습니다.");
						System.out.println(m.getName()+"의 현재 hp : "+c.RED+m.getHp()+c.RESET);										
					}
				}

				if(skillInput==2) {
					if(p.getMp() < 15) {
						System.out.println("마나가 부족합니다.");
						continue;
					}
					else {
						System.out.println();
						System.out.println(c.BRED+"지우의 발차기!!"+c.RESET);
						System.out.println();
						p.secondSkill(m);
						System.out.println(p.getName()+"가 상대에게 "+c.B_RED+(p.getPower() * 1.5)+c.RESET+" 피해를 입혔습니다.");
						System.out.println(m.getName()+"의 현재 hp : "+c.RED+m.getHp()+c.RESET);									
					}
				}

				if(skillInput==3) {
					if(p.getMp() < 15) {
						System.out.println("마나가 부족합니다.");
						continue;
					}
					else {
						System.out.println();
						System.out.println(c.BRED+"지우의 피카츄 던지기!!"+c.RESET);
						System.out.println();
						p.thirdSkill(m);
						System.out.println(p.getName()+"가 상대에게 "+c.B_RED+(p.getPower() * 1.5)+c.RESET+" 피해를 입혔습니다.");
						System.out.println("상대가 상태이상 "+c.B_PURPLE+"<감전>"+c.RESET+" 에 걸렷습니다!");
						System.out.println(m.getName()+"의 현재 hp : "+c.RED+m.getHp()+c.RESET);
						continue;
					}
				}

				if(skillInput==4) {
					System.out.println();
					System.out.println(c.BRED+"지우의 마나회복!!"+c.RESET);
					System.out.println();
					p.fourthSkill(m);
					System.out.println("mp를 "+c.BLUE+"30"+c.RESET+" 회복했습니다.");
					System.out.println("현재 mp : "+c.BLUE+p.getMp()+c.RESET);
				}

				if(skillInput==5) {
					int run = (int) (Math.random()*2)+1;

					if(run==1) {
						System.out.println();
						System.out.println("도망에 성공하였습니다!");
						System.out.println();
						break;
					}

					if(run==2) {
						System.out.println("도망에 실패했습니다..");
					}
				}

				if(m.getHp() <= 0) {							
					p.winningTheBattle(input - 1);
					System.out.println();
					break;
				}																	

				while (true) { //몬스터 공격
					System.out.println();
					System.out.println("-------------------------------------------------------------------------");
					System.out.println("상대 턴입니다.");
					int skillNum = (int) (Math.random()*4)+1;

					if(skillNum==1) {
						System.out.println();
						System.out.println(c.BBLUE+"이슬이의 등짝스매시!!"+c.RESET);
						System.out.println();
						m.firstSkill(p);
						System.out.println(m.getName()+"에게 "+c.B_RED+(Math.round(m.getPower() * 0.5))+c.RESET+" 피해를 입었습니다.");
						break;
					}

					if(skillNum==2) {
						System.out.println();
						System.out.println(c.BBLUE+"이슬이의 명치때리기!!"+c.RESET);
						System.out.println();
						m.secondSkill(p);
						System.out.println(m.getName()+"에게 "+c.B_RED+(Math.round(m.getPower()))+c.RESET+" 피해를 입었습니다.");
						break;
					}

					if(skillNum==3) {
						System.out.println();
						System.out.println(c.BBLUE+"이슬이의 머리채 잡기!!"+c.RESET);
						System.out.println();
						m.thirdSkill(p);
						System.out.println(m.getName()+"에게 "+c.B_RED+(Math.round(m.getPower() * 1.2))+c.RESET+" 피해를 입었습니다.");
						System.out.println("상태이상 "+c.B_PURPLE+"<속박>"+c.RESET+" 에 걸렷습니다!");
						continue;
					}

					if(skillNum==4) {
						System.out.println();
						System.out.println(c.BBLUE+"이슬이의 김치싸대귀!!"+c.RESET);
						System.out.println();
						m.fourthSkill(p);
						System.out.println(m.getName()+"에게 "+c.B_RED+(Math.round(m.getPower() * 1.5))+c.RESET+" 피해를 입었습니다.");
						break;
					}
				}

				if(p.getHp() <= 0) {
					System.out.println("전투패배..");
					System.out.println();
					break;								
				}
			} //플레이어 선공 종료

			if(p.getAttackSpeed() < m.getAttackSpeed()) { //몬스터 선공격
				while (true) { //몬스터 공격
					System.out.println();
					System.out.println("-------------------------------------------------------------------------");
					System.out.println("상대 턴입니다.");
					int skillNum = (int) (Math.random()*4)+1;

					if(skillNum==1) {
						System.out.println();
						System.out.println(c.BBLUE+"이슬이의 등짝스매시!!"+c.RESET);
						System.out.println();
						m.firstSkill(p);
						System.out.println(m.getName()+"에게 "+c.B_RED+(Math.round(m.getPower() * 0.5))+c.RESET+" 피해를 입었습니다.");
						break;
					}

					if(skillNum==2) {
						System.out.println();
						System.out.println(c.BBLUE+"이슬이의 명치때리기!!"+c.RESET);
						System.out.println();
						m.secondSkill(p);
						System.out.println(m.getName()+"에게 "+c.B_RED+(Math.round(m.getPower()))+c.RESET+" 피해를 입었습니다.");
						break;
					}

					if(skillNum==3) {
						System.out.println();
						System.out.println(c.BBLUE+"이슬이의 머리채 잡기!!"+c.RESET);
						System.out.println();
						m.thirdSkill(p);
						System.out.println(m.getName()+"에게 "+c.B_RED+(Math.round(m.getPower() * 1.2))+c.RESET+" 피해를 입었습니다.");
						System.out.println("상태이상 "+c.B_PURPLE+"<속박>"+c.RESET+" 에 걸렷습니다!");
						continue;
					}

					if(skillNum==4) {
						System.out.println();
						System.out.println(c.BBLUE+"이슬이의 김치싸대귀!!"+c.RESET);
						System.out.println();
						m.fourthSkill(p);
						System.out.println(m.getName()+"에게 "+c.B_RED+(Math.round(m.getPower() * 1.5))+c.RESET+" 피해를 입었습니다.");
						break;
					}
				}

				if(p.getHp() <= 0) {
					System.out.println("전투패배..");
					System.out.println();
					break;
				}

				while (true) {
					System.out.println(); //플레이어 공격
				   	System.out.println("-------------------------------------------------------------------------");
					System.out.println("당신의 턴입니다");							
					System.out.println("스킬을 선택하세요.");
					System.out.println("현재 hp : "+c.RED+String.format("%.2f",(p.getHp()))+c.RESET+"   "+"현재 mp : "+c.BLUE+p.getMp()+c.RESET);
					System.out.println();
					System.out.println("박치기(1)-마나소모량 : "+c.B_BLUE+"10"+c.RESET+"피해량 : "+c.B_RED+p.getPower()+c.RESET);
					System.out.println();
					System.out.println("발차기(2)-마나소모량 : "+c.B_BLUE+"15"+c.RESET+"피해량 : "+c.B_RED+(p.getPower() * 1.5)+c.RESET);
					System.out.println();
					System.out.println("피카츄 던지기(3)-마나소모량 : "+c.B_BLUE+"15"+c.RESET+"피해량 : "+c.B_RED+(p.getPower() * 0.5)+c.RESET+" 상태이상 : "+c.B_PURPLE+"<감전>"+c.RESET);
					System.out.println();
					System.out.println("마나회복(4)-마나소모량 : "+c.B_BLUE+"0"+c.RESET+"마나회복"+c.B_BLUE+"30"+c.RESET);
					System.out.println();
					System.out.println("도망가기(5)");
					System.out.println("-------------------------------------------------------------------------");
					skillInput = sc.nextInt();

					if(skillInput==1) {
						if(p.getMp() < 10) {
							System.out.println("마나가 부족합니다.");	
							continue;
						}
						else {
							System.out.println();
							System.out.println(c.BRED+"지우의 박치기!!"+c.RESET);
							System.out.println();
							p.firstSkill(m);
							System.out.println(p.getName()+"가 상대에게 "+c.B_RED+p.getPower()+c.RESET+" 피해를 입혔습니다.");
							System.out.println(m.getName()+"의 현재 hp : "+c.RED+m.getHp()+c.RESET);										
						}
					}

					if(skillInput==2) {
						if(p.getMp() < 15) {
							System.out.println("마나가 부족합니다.");
							continue;
						}
						else {
							System.out.println();
							System.out.println(c.BRED+"지우의 발차기!!"+c.RESET);
							System.out.println();
							p.secondSkill(m);
							System.out.println(p.getName()+"가 상대에게 "+c.B_RED+(p.getPower() * 1.5)+c.RESET+" 피해를 입혔습니다.");
							System.out.println(m.getName()+"의 현재 hp : "+c.RED+m.getHp()+c.RESET);									
						}
					}

					if(skillInput==3) {
						if(p.getMp() < 15) {
							System.out.println("마나가 부족합니다.");
							continue;
						}
						else {
							System.out.println();
							System.out.println(c.BRED+"지우의 피카츄 던지기!!"+c.RESET);
							System.out.println();
							p.thirdSkill(m);
							System.out.println(p.getName()+"가 상대에게 "+c.B_RED+(p.getPower() * 1.5)+c.RESET+" 피해를 입혔습니다.");
							System.out.println("상대가 상태이상 "+c.B_PURPLE+"<감전>"+c.RESET+" 에 걸렷습니다!");
							System.out.println(m.getName()+"의 현재 hp : "+c.RED+m.getHp()+c.RESET);
							continue;
						}
					}

					if(skillInput==4) {
						System.out.println();
						System.out.println(c.BRED+"지우의 마나회복!!"+c.RESET);
						System.out.println();
						p.fourthSkill(m);
						System.out.println("mp를 "+c.BLUE+"30"+c.RESET+" 회복했습니다.");
						System.out.println("현재 mp : "+c.BLUE+p.getMp()+c.RESET);
					}

					if(skillInput==5) {
                        int run = (int) (Math.random()*2)+1;

						if(run==1) {
							System.out.println();
							System.out.println("도망에 성공하였습니다!");
							System.out.println();
							break;
						}

						if(run==2) {
							System.out.println("도망에 실패했습니다..");
						}
					}
				}

				if(m.getHp() <= 0) {							
					p.winningTheBattle(input - 1);
					System.out.println();
					break;
				}								
			}//몬스터 선공 종료
		} //battle while end
		p.hpInitialize();		
	} //battleSet end
}

