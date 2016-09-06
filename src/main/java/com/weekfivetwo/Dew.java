package com.weekfivetwo;

import java.sql.*;
import java.util.ArrayList;


public class Dew {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "root";
	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;

	public static ArrayList<Player> charList = new ArrayList<>();
	
	public static void connToDB() {
		try {

			Class.forName(JDBC_DRIVER);

			System.out.println("Trying to connect to the DB...");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to DB.");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
	}

	public static void readFromDB() {
		connToDB();
		
		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM game.character;");
			while (RES_SET.next()) {
				
				Player charInDB = new Player();

				charInDB.setCharID(RES_SET.getInt("char_ID"));
				charInDB.setCharName(RES_SET.getString("char_name"));
				charInDB.setCharRace(RES_SET.getString("race"));
				charInDB.setCharProfession(RES_SET.getString("profession"));
				charInDB.setAttack(RES_SET.getInt("attack"));
				charInDB.setDefense(RES_SET.getInt("defense"));
				charInDB.setHitPoints(RES_SET.getInt("hitpoints"));
				
				charList.add(charInDB);
			}
			for (Player player : charList) {
				System.out.println(player);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // read from DB

	public static void writeToDatabase(Player player) {
		Player charToAdd = new Player();
		charToAdd = player;
		try {
			connToDB();
			PREP_STMT = CONN.prepareStatement(insertIntoTable);
			
			PREP_STMT.setInt(1, charToAdd.getCharID());
			PREP_STMT.setString(2, charToAdd.getCharName());
			PREP_STMT.setString(3, charToAdd.getCharRace());
			PREP_STMT.setString(4, charToAdd.getCharProfession());
			PREP_STMT.setInt(5, charToAdd.getAttack());
			PREP_STMT.setInt(6, charToAdd.getDefense());
			PREP_STMT.setInt(7, charToAdd.getHitPoints());

			System.out.println(PREP_STMT);
			PREP_STMT.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // write from DB
	
	public static void deleteFromDB(Player deleteDB) {

		

		readFromDB();

		

		try {
			PREP_STMT = CONN.prepareStatement("DELETE FROM `game`.`character` WHERE char_ID = ?");
			 PREP_STMT.setInt(1, deleteDB.getCharID());
			PREP_STMT.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	} // delete

	private static String insertIntoTable = "INSERT INTO `game`.`character`"
			+ "(char_ID, char_name, race, profession, attack, defense, hitpoints)" + " VALUES "
			+ "(?, ?, ?, ?, ?, ?, ?)";



	private static String updateDB = ("UPDATE `game`.`character` SET `char_name` = ?,    `race` = ?, `profession` = ?,`attack` = ?, `defense` = ?, `hitpoints` = ?, WHERE `char_id` = ?");

	public static void updateDB(Player charToUpdate2) {
       
        
        Player charToUpdate = charToUpdate2;
       
        
        connToDB();
        try {
            PREP_STMT = CONN.prepareStatement(updateDB);
            
            PREP_STMT.setString(2, charToUpdate.getCharName());
            PREP_STMT.setString(3, charToUpdate.getCharRace());
            PREP_STMT.setString(4, charToUpdate.getCharProfession());
            PREP_STMT.setInt(5, charToUpdate.getAttack());
            PREP_STMT.setInt(6, charToUpdate.getDefense());
            PREP_STMT.setInt(7, charToUpdate.getHitPoints());
            
            PREP_STMT.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
       
    }
    
	
	
	
	
	
	
	
}
