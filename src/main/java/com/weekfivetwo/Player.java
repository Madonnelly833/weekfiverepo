package com.weekfivetwo;

public class Player {
	
	private int charID = 0;
	private String charName = null;
	private String charRace = null;
	private String charProfession = null;
	private int attack = 0;
	private int defense = 0;
	private int hitPoints = 0;
	
	public Player(int charID, String charName, String charRace, String charProfession, int attack, int defense,
			int hitPoints) {
		super();
		this.charID = charID;
		this.charName = charName;
		this.charRace = charRace;
		this.charProfession = charProfession;
		this.attack = attack;
		this.defense = defense;
		this.hitPoints = hitPoints;
	}

	public Player() {
		super();
	}


	public int getCharID() {
		return charID;
	}

	public void setCharID(int charID) {
		this.charID = charID;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public String getCharRace() {
		return charRace;
	}

	public void setCharRace(String charRace) {
		this.charRace = charRace;
	}

	public String getCharProfession() {
		return charProfession;
	}

	public void setCharProfession(String charProfession) {
		this.charProfession = charProfession;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	@Override
	public String toString() {
		return "Character [CharID=" + charID + ", CharName=" + charName + ", charRace=" + charRace + ", CharProfession="
				+ charProfession + ", attack=" + attack + ", defense=" + defense + ", hitPoints=" + hitPoints + "]";
	}
	
	
	
	

}
