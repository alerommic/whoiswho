package tfg;

import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JTextArea;

public class messT extends Thread{
	
	private BufferedReader text;
	private JTextArea chat;
	private String message="";
	public messT(BufferedReader text, JTextArea chat) {
		this.text = text;
		this.chat = chat;
	}
	
	public void run() {
		while(true) {
			try {
				message=text.readLine()+ "\n";
				chat.setText(chat.getText() +" Other: "+ message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
}
