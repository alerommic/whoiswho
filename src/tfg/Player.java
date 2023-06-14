package tfg;

import java.io.Serializable;

public class Player implements Serializable{
	
	private String username;
	private String character;
	private int roomId;
	private int partidasGanadas=0;
	private int partidasPerdidas=0;

	
	public Player(String username, String character, int roomId) {
		super();
		this.username = username;
		this.character = character;
		this.roomId = roomId;
	}
	public String getUsername() {
		return username;
	}
	public String getCharacter() {
		return character;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getPartidasGanadas() {
		return partidasGanadas;
	}
	public int getPartidasPerdidas() {
		return partidasPerdidas;
	}
	public void PartidaGanada() {
		this.partidasGanadas++;
	}
	public void PartidaPerdida() {
		this.partidasPerdidas++;
	}
	
	

}
