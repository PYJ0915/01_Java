package edu.kh.oop.practice.model.vo;

public class Hero {

	private String nickname; // 닉네임
	private String job; 	 // 직업
	private int hp;			 // 체력
	private int mp;			 // 마력
	private int level;		 // 레벨
	private double exp;		 // 경험치
	
	public Hero() {
		
	}
	
	public Hero(String nickname, String job, int hp, int mp, int level, double exp) {
		this.nickname = nickname;
		this.job = job;
		this.hp = hp;
		this.mp = mp;
		this.level = level;
		this.exp = exp;
	}
	
	public void attack(double exp) {
		// 공격시에 경험치 +
		this.exp += exp;
		
		System.out.println( "\'" + nickname + "\' " + "은/는 공격을 했다!!! 현재 경험치: " + this.exp);
		
		if (this.exp >= 300 * level) {
			level++;
			System.out.println("레벨이 올랐습니다!! 현재 레벨: " + level);
		}
	}
	
	public void dash() {
		// 마력 -
		if(mp >= 10) {
			mp -= 10;
			System.out.println( "\'" + nickname + "\' " + "의 엄청 빠른 대시!! 남은 마력: " + mp);
		} else {
			System.out.println("[마력부족]으로 더 이상 대시 할 수 없어요~!");
		}
		
	}
	
	@Override
	public String toString() {
		return "현재 레벨 : " + level + "\n현재 hp : " + hp + "\n현재 mp : " + mp + "\n현재 경험치 : " + exp;
	}

	
	
}
