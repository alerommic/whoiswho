package tfg;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MessT2 extends Thread{
	
	private BufferedReader text;
	private String character="";
	private JPanel panel;
	private PrintStream output2;
	private Player player;
	private Player perdedor;
	private String RivalCharacter;
	private String RivalName;
	private boolean pierde;
	private DataBase Whoiswho;
	private ArrayList<JButton> botonesRes;
	public MessT2(BufferedReader text, String character,JPanel panel, Player player, boolean estado, DataBase Whoiswho, PrintStream output2, ArrayList<JButton> botonesRes ) throws ClassNotFoundException {

		this.text = text;
		this.character = character;
		this.panel = panel;
		this.player=player;
		this.pierde=estado;
		this.output2=output2;
		this.Whoiswho=Whoiswho;
		this.botonesRes=botonesRes;
	}

	public void run() {
		while(true) {
			try {


				String textr=text.readLine();
				if(textr.equals(character)) {

					JOptionPane.showMessageDialog(
							panel, "HAS PERDIDO", "",
							JOptionPane.INFORMATION_MESSAGE);

					output2.println("%%%%3920fkfkfkfdspfdsk@#~đðßđðłßæþðæþðđ@ł€đ#}#~đ|#đßðđ}@ðđ");
					output2.println(player.getUsername());
					output2.println(player.getCharacter()); 
					player.PartidaPerdida();


				}
				
				else if (textr.equals("%%%%3920fkfkfkfdspfdsk@#~đðßđðłßæþðæþðđ@ł€đ#}#~đ|#đßðđ}@ðđ")) {
					JOptionPane.showMessageDialog(
							panel, "HAS GANADO", "",
							JOptionPane.INFORMATION_MESSAGE);
				RivalName = text.readLine();
					RivalCharacter = text.readLine();

					pierde=false;
					player.PartidaPerdida();

				}
				
				else {
					for (JButton jButton : botonesRes) {
						jButton.setEnabled(true);
					}
				}
				
				if (!pierde) {
					perdedor = new Player(RivalName,RivalCharacter,player.getRoomId());
					Whoiswho.setFinalDePartida(player, perdedor);
					break;
				}
				
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}





		}


	}

	public Player getPerdedor() {
		return perdedor;
	}

	public void setPerdedor(Player perdedor) {
		this.perdedor = perdedor;
	}


}
