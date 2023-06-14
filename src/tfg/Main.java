package tfg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField ChatWrite;
	 private final static int PORT =5005;
	 private final static int PORT2 =5004;
	   private Socket socket = null;
	   private Socket socket2 = null;
	    private final static String SERVER = "127.0.0.1";
	    private   Socket client = null;
	    private   Socket client2 = null;	    
	    private  ServerSocket server = null;
	    private  ServerSocket server2 = null;
	    private  String message="";
	    private   BufferedReader input;
	   private PrintStream output;
	   private   BufferedReader input2;
	   private PrintStream output2;
	   private messT m;
	   private MessT2 m2;
	   private JLabel choose=null;
	   private String  answer;
	   private static String character;
	   private static String username;
	   private static int roomId;
		private static ArrayList<Character> Personajes = new ArrayList<Character>();
		private static Main frame;
		private static ArrayList<JButton> botones = new ArrayList<JButton>();
		private static ArrayList<JButton> botonesRes = new ArrayList<JButton>();
		
		private static ArrayList<JLabel> jLabelimg = new ArrayList<JLabel>();
		private  Player player;
		private boolean pierde=true;
		private DataBase whoiswho;
		private JLabel lblUsuario;
		private JLabel lblVictorias;
		private JLabel lblDerrotas;
		private JLabel lblPersonajeMasUsado;
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Main(character,username,Personajes);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Main(String character, String username, ArrayList<Character> Personajes) throws IOException {
		
		Main.character=character;
		Main.username=username;
		Main.Personajes=Personajes;

		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1074, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Cards = new JPanel();
		Cards.setBounds(5, 5, 671, 533);
		contentPane.add(Cards);
		Cards.setLayout(null);
		
		
		JPanel Arriba = new JPanel();
		Arriba.setBounds(0, 0, 671, 275);
		Cards.add(Arriba);
		
		BufferedImage imgPeterjpeg = ImageIO.read(new File("./img/Peter.jpeg"));
		Arriba.setLayout(null);
		
		JLabel PeterImg =  new JLabel(new ImageIcon(imgPeterjpeg.getScaledInstance(110, 170, DO_NOTHING_ON_CLOSE)));
		PeterImg.setBounds(11, 26, 105, 163);
		Arriba.add(PeterImg);
		
		BufferedImage imgBabsjpeg = ImageIO.read(new File("./img/Babs.jpeg"));

		JLabel BabsImg = new JLabel(new ImageIcon(imgBabsjpeg.getScaledInstance(110, 170, DO_NOTHING_ON_CLOSE)));
		BabsImg.setBounds(121, 26, 105, 163);
		Arriba.add(BabsImg);
		
		BufferedImage imgBrianjpeg = ImageIO.read(new File("./img/Brian.jpeg"));
		
		JLabel BrianImg = new JLabel(new ImageIcon(imgBrianjpeg.getScaledInstance(110, 170, DO_NOTHING_ON_CLOSE)));
		BrianImg.setBounds(231, 26, 105, 163);
		Arriba.add(BrianImg);
		
		BufferedImage imgChrisjpeg = ImageIO.read(new File("./img/Chris.jpeg"));

		JLabel ChrisImg = new JLabel(new ImageIcon(imgChrisjpeg.getScaledInstance(110, 170, DO_NOTHING_ON_CLOSE)));
		ChrisImg.setBounds(341, 26, 105, 163);
		Arriba.add(ChrisImg);
		
		BufferedImage imgHerbertjpeg = ImageIO.read(new File("./img/Herbert.jpeg"));
		

		JLabel HerbertImg = new JLabel(new ImageIcon(imgHerbertjpeg.getScaledInstance(110, 170, DO_NOTHING_ON_CLOSE)));
		HerbertImg.setSize(105, 163);
		HerbertImg.setLocation(451, 26);
		Arriba.add(HerbertImg);
		
		BufferedImage imgJoejpeg = ImageIO.read(new File("./img/Joe.jpeg"));

		JLabel JoeImg = new JLabel(new ImageIcon(imgJoejpeg.getScaledInstance(110, 170, DO_NOTHING_ON_CLOSE)));
		JoeImg.setBounds(561, 26, 105, 163);
		Arriba.add(JoeImg);
		

		JButton btnPeter = new JButton("Hide");
		
		btnPeter.setBounds(11, 209, 105, 27);
		Arriba.add(btnPeter);
		
			JButton btnPeterResponse = new JButton("Guess");
		
			btnPeterResponse.setBounds(11, 209, 105, 27);
			Arriba.add(btnPeterResponse);
			btnPeterResponse.setVisible(false);
		
		JButton btnBabs = new JButton("Hide");
		btnBabs.setBounds(121, 209, 105, 27);
		Arriba.add(btnBabs);
		
			JButton btnBabsResponse = new JButton("Guess");
		
			btnBabsResponse.setBounds(121, 209, 105, 27);
			Arriba.add(btnBabsResponse);
			btnBabsResponse.setVisible(false);
		
		JButton btnBrian = new JButton("Hide");
		btnBrian.setBounds(231, 209, 105, 27);
		Arriba.add(btnBrian);
		
			JButton btnBrianResponse = new JButton("Guess");
		
			btnBrianResponse.setBounds(231, 209, 105, 27);
			Arriba.add(btnBrianResponse);
			btnBrianResponse.setVisible(false);
		
		JButton btnChris = new JButton("Hide");
		btnChris.setBounds(341, 209, 105, 27);
		Arriba.add(btnChris);
		
			JButton btnChrisResponse = new JButton("Guess");
		
			btnChrisResponse.setBounds(341, 209, 105, 27);
			Arriba.add(btnChrisResponse);
			btnChrisResponse.setVisible(false);
		
		JButton btnHerbert = new JButton("Hide");
		btnHerbert.setBounds(451, 209, 105, 27);
		Arriba.add(btnHerbert);
		
			JButton btnHerbertResponse = new JButton("Guess");
		
			btnHerbertResponse.setBounds(451, 209, 105, 27);
			Arriba.add(btnHerbertResponse);
			btnHerbertResponse.setVisible(false);
		
		JButton btnJoe = new JButton("Hide");
		btnJoe.setBounds(561, 209, 105, 27);
		Arriba.add(btnJoe);
		
			JButton btnJoeResponse = new JButton("Guess");
		
			btnJoeResponse.setBounds(561, 209, 105, 27);
			Arriba.add(btnJoeResponse);
			btnJoeResponse.setVisible(false);
		
		
		JPanel Abajo = new JPanel();
		Abajo.setBounds(0, 273, 671, 264);
		Cards.add(Abajo);
		Abajo.setLayout(null);
		
		BufferedImage imgStewiejpeg = ImageIO.read(new File("./img/Stewie.jpeg"));

		
		JLabel StewieImg = new JLabel(new ImageIcon(imgStewiejpeg.getScaledInstance(110, 170, DO_NOTHING_ON_CLOSE)));
		StewieImg.setBounds(452, 38, 105, 163);
		Abajo.add(StewieImg);
		
		BufferedImage imgMegjpeg = ImageIO.read(new File("./img/Meg.jpeg"));
		
		JLabel MegImg = new JLabel(new ImageIcon(imgMegjpeg.getScaledInstance(110, 170, DO_NOTHING_ON_CLOSE)));
		MegImg.setBounds(232, 38, 105, 163);
		Abajo.add(MegImg);
		
		BufferedImage imgQuagmirejpeg = ImageIO.read(new File("./img/Quagmire.jpeg"));
		
		JLabel QuagmireImg = new JLabel(new ImageIcon(imgQuagmirejpeg.getScaledInstance(110, 170, DO_NOTHING_ON_CLOSE)));
		QuagmireImg.setBounds(342, 38, 105, 163);
		Abajo.add(QuagmireImg);

		BufferedImage imgKoolAidjpeg = ImageIO.read(new File("./img/KoolAid.jpeg"));
		
		JLabel KoolAidImg = new JLabel(new ImageIcon(imgKoolAidjpeg.getScaledInstance(110, 170, DO_NOTHING_ON_CLOSE)));
		KoolAidImg.setBounds(12, 38, 105, 163);
		Abajo.add(KoolAidImg);

		BufferedImage imgClevelandjpeg = ImageIO.read(new File("./img/Cleveland.jpeg"));
		
		JLabel ClevelandImg = new JLabel(new ImageIcon(imgClevelandjpeg.getScaledInstance(110, 170, DO_NOTHING_ON_CLOSE)));
		ClevelandImg.setBounds(561, 38, 105, 163);
		Abajo.add(ClevelandImg);

		BufferedImage imgLoisjpeg = ImageIO.read(new File("./img/Lois.jpeg"));
		
		
		JLabel LoisImg = new JLabel(new ImageIcon(imgLoisjpeg.getScaledInstance(110, 170, DO_NOTHING_ON_CLOSE)));
		LoisImg.setBounds(122, 38, 105, 163);
		Abajo.add(LoisImg);
		
		JButton btnKoolAid = new JButton("Hide");
		btnKoolAid.setBounds(12, 213, 105, 27);
		Abajo.add(btnKoolAid);
		
			JButton btnKoolAidResponse = new JButton("Guess");
		
			btnKoolAidResponse.setBounds(12, 213, 105, 27);
			Abajo.add(btnKoolAidResponse);
			btnKoolAidResponse.setVisible(false);
		
		JButton btnLois = new JButton("Hide");
		btnLois.setBounds(122, 213, 105, 27);
		Abajo.add(btnLois);
		
			JButton btnLoisResponse = new JButton("Guess");
		
			btnLoisResponse.setBounds(122, 213, 105, 27);
			Abajo.add(btnLoisResponse);
			btnLoisResponse.setVisible(false);
		
		JButton btnMeg = new JButton("Hide");
		btnMeg.setBounds(232, 213, 105, 27);
		Abajo.add(btnMeg);
		
			JButton btnMegResponse = new JButton("Guess");
		
			btnMegResponse.setBounds(232, 213, 105, 27);
			Abajo.add(btnMegResponse);
			btnMegResponse.setVisible(false);
		
		
		JButton btnQuagmire = new JButton("Hide");
		btnQuagmire.setBounds(342, 213, 105, 27);
		Abajo.add(btnQuagmire);
		
			JButton btnQuagmireResponse = new JButton("Guess");
		
			btnQuagmireResponse.setBounds(342, 213, 105, 27);
			Abajo.add(btnQuagmireResponse);
			btnQuagmireResponse.setVisible(false);
		
		JButton btnCleveland = new JButton("Hide");
		btnCleveland.setBounds(561, 213, 105, 27);
		Abajo.add(btnCleveland);
	
			JButton btnClevelandResponse = new JButton("Guess");
		
			btnClevelandResponse.setBounds(561, 213, 105, 27);
			Abajo.add(btnClevelandResponse);
			btnClevelandResponse.setVisible(false);
		
		JButton btnStewie = new JButton("Hide");
		btnStewie.setBounds(452, 213, 105, 27);
		Abajo.add(btnStewie);
		
		JButton btnStewieResponse = new JButton("Guess");
		
		btnStewieResponse.setBounds(452, 213, 105, 27);
		Abajo.add(btnStewieResponse);
		btnStewieResponse.setVisible(false);
		
		JPanel Chat2 = new JPanel();
		Chat2.setBounds(684, 5, 370, 533);
		contentPane.add(Chat2);
		Chat2.setLayout(null);
		
		JPanel Chat = new JPanel();
		Chat.setBounds(0, 0, 363, 531);
		Chat2.add(Chat);
		Chat.setBorder(new EmptyBorder(5, 5, 5, 5));
		Chat.setLayout(null);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(12, 84, 339, 322);
		Chat.add(scroll);
		
		JTextArea Chatlog = new JTextArea();
		scroll.setViewportView(Chatlog);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBounds(621, 493, 105, 26);
		Chat.add(btnSend);
		
		ChatWrite = new JTextField();
		ChatWrite.setBounds(108, 419, 243, 27);
		ChatWrite.setColumns(10);
		Chat.add(ChatWrite);
		
		JButton btnServerConnect = new JButton("make a room");
		
		btnServerConnect.setBounds(12, 12, 339, 27);
		Chat.add(btnServerConnect);
		
		JButton btnClient = new JButton("search a room");
		btnClient.setBounds(12, 44, 339, 27);
		Chat.add(btnClient);
		
		JButton btnAnswer = new JButton("Answer");
		btnAnswer.setBounds(172, 493, 105, 27);
		Chat.add(btnAnswer);
		
		
		
		//Creamos los personajes y los metemos en un arrayList
		
		
		
		Personajes.get(0).setOcultarBtn(btnPeter);
		Personajes.get(1).setOcultarBtn(btnBabs);
		Personajes.get(2).setOcultarBtn(btnBrian);
		Personajes.get(3).setOcultarBtn(btnChris);
		Personajes.get(4).setOcultarBtn(btnHerbert);
		Personajes.get(5).setOcultarBtn(btnJoe);
		Personajes.get(6).setOcultarBtn(btnStewie);
		Personajes.get(7).setOcultarBtn(btnMeg);
		Personajes.get(8).setOcultarBtn(btnQuagmire);
		Personajes.get(9).setOcultarBtn(btnKoolAid);
		Personajes.get(10).setOcultarBtn(btnCleveland);
		Personajes.get(11).setOcultarBtn(btnLois);	

		//poner los elementos invisibles para luego activarlos
		jLabelimg.add(PeterImg);
		jLabelimg.add(BabsImg);
		jLabelimg.add(BrianImg);
		jLabelimg.add(ChrisImg);
		jLabelimg.add(HerbertImg);
		jLabelimg.add(JoeImg);
		jLabelimg.add(StewieImg);
		jLabelimg.add(MegImg);
		jLabelimg.add(QuagmireImg);
		jLabelimg.add(KoolAidImg);
		jLabelimg.add(ClevelandImg);
		jLabelimg.add(LoisImg);
		
				for (int i = 0; i < jLabelimg.size() &&  i < Personajes.size(); i++) {
					jLabelimg.get(i).setVisible(false);
					Personajes.get(i).getOcultarBtn().setVisible(false);	
				}
				
		
		for (int i = 0; i < Personajes.size(); i++) {
			if(Personajes.get(i).getName().equals(character)) {
				BufferedImage imgChoose =Personajes.get(i).getImagepg() ;
				choose = new JLabel();
				choose=  new JLabel(new ImageIcon(imgChoose.getScaledInstance(170, 170, DO_NOTHING_ON_CLOSE)));
				choose.setBounds(12, 418, 83, 101);
				Chat.add(choose);
				
				
			}
		}

		

		//accion botones
		btnPeter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetImagesVisibility(PeterImg,btnPeter);
				}});

		btnBabs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetImagesVisibility(BabsImg,btnBabs);
				}});
		btnBrian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetImagesVisibility(BrianImg,btnBrian);
				}});
		btnChris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetImagesVisibility(ChrisImg,btnChris);
				}});
		btnHerbert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetImagesVisibility(HerbertImg,btnHerbert);
				}});
		btnJoe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetImagesVisibility(JoeImg,btnJoe);
				}});
		btnStewie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetImagesVisibility(StewieImg,btnStewie);
				}});
		btnMeg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetImagesVisibility(MegImg,btnMeg);
				}});
		btnQuagmire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetImagesVisibility(QuagmireImg,btnQuagmire);
				}});
		btnKoolAid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetImagesVisibility(KoolAidImg,btnKoolAid);
				}});
		btnCleveland.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetImagesVisibility(ClevelandImg,btnCleveland);
				}});
		btnLois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetImagesVisibility(LoisImg,btnLois);
				}});
		player = new Player(username,character,roomId);
		
		
		 whoiswho = new DataBase( player, Personajes);
		
		 try {
				roomId=whoiswho.setRoomId();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
		player.setRoomId(roomId);
		 
		btnServerConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					server = new ServerSocket(PORT);
					server2 = new ServerSocket(PORT2);
					client = server.accept();
					client2 = server2.accept();
					client.setSoLinger (true, 10);	
					client2.setSoLinger (true, 10);		
					input = new BufferedReader(new InputStreamReader(client.getInputStream()));
					output = new PrintStream(client.getOutputStream());	
					input2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
					output2 = new PrintStream(client2.getOutputStream());
					
				
					
					
				} catch (IOException e1) {

					e1.printStackTrace();
				}
				m= new messT(input, Chatlog);
				try {
					m2= new MessT2(input2, character,contentPane,player,pierde, whoiswho, output2,botonesRes);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				m2.start();
				m.start();
				
				StartMatch(botones,jLabelimg,lblUsuario,lblDerrotas,lblVictorias,lblPersonajeMasUsado);
				btnServerConnect.setVisible(false);
				btnClient.setVisible(false);
			}
		});
		
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					socket = new Socket(SERVER, PORT);
					socket2 = new Socket(SERVER, PORT2);
					 input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					 input2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
					 output = new PrintStream(socket.getOutputStream());
					 output2 = new PrintStream(socket2.getOutputStream());
				} catch (IOException e1) {
					e1.printStackTrace();
				}  
				 m= new messT(input, Chatlog);
				 
					try {
						m2= new MessT2(input2, character,contentPane, player, pierde, whoiswho, output2,botonesRes);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				 m2.start();
				 m.start();
				 
				 StartMatch(botones,jLabelimg,lblUsuario,lblDerrotas,lblVictorias,lblPersonajeMasUsado);
				btnServerConnect.setVisible(false);
				btnClient.setVisible(false);
			}
		});

		ChatWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 output.println(ChatWrite.getText());
				 Chatlog.setText(Chatlog.getText()+" Me: "+ ChatWrite.getText()+"\n");
				 ChatWrite.setText("");
			}
		});
		
		
		
		botones.add(btnPeter);
		botones.add(btnBabs);
		botones.add(btnBrian);
		botones.add(btnChris);
		botones.add(btnHerbert);
		botones.add(btnJoe);
		botones.add(btnKoolAid);
		botones.add(btnLois);
		botones.add(btnMeg);
		botones.add(btnQuagmire);
		botones.add(btnStewie);
		botones.add(btnCleveland);
		
		botonesRes.add(btnPeterResponse);
		botonesRes.add(btnBabsResponse);
		botonesRes.add(btnBrianResponse);
		botonesRes.add(btnChrisResponse);
		botonesRes.add(btnHerbertResponse);
		botonesRes.add(btnJoeResponse);
		
		 lblVictorias = new JLabel("Wins:");
		lblVictorias.setBounds(177, 161, 275, 54);
		Arriba.add(lblVictorias);
		lblVictorias.setText(lblVictorias.getText()+whoiswho.getPartidasGanadas());
		
		botonesRes.add(btnKoolAidResponse);
		botonesRes.add(btnLoisResponse);
		botonesRes.add(btnMegResponse);
		botonesRes.add(btnQuagmireResponse);
		botonesRes.add(btnStewieResponse);
		botonesRes.add(btnClevelandResponse);
		
		 lblDerrotas = new JLabel("Loses: ");
		lblDerrotas.setBounds(177, 12, 248, 54);
		Abajo.add(lblDerrotas);
		lblDerrotas.setText(lblDerrotas.getText()+whoiswho.getPartidasPerdidas());
		
		 lblPersonajeMasUsado = new JLabel("Most used: ");
		lblPersonajeMasUsado.setBounds(177, 118, 263, 59);
		Abajo.add(lblPersonajeMasUsado);
		lblPersonajeMasUsado.setText(lblPersonajeMasUsado.getText()+ whoiswho.getPersonajeMasUsado());
		
		lblUsuario = new JLabel("Username: ");
		lblUsuario.setBounds(177, 36, 269, 58);
		Arriba.add(lblUsuario);
		lblUsuario.setText(lblUsuario.getText()+ player.getUsername());
		
		btnAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetAnswerMode(btnServerConnect,btnClient,Chatlog,scroll,ChatWrite,choose,botones,botonesRes);
				
			
		}});
		
		
		btnPeterResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output2.println("Peter");
				for (JButton jButton : botonesRes) {
					jButton.setEnabled(false);
				}
				
				}});
		btnBabsResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output2.println("Babs");
				for (JButton jButton : botonesRes) {
					jButton.setEnabled(false);
				}
				}});
		btnBrianResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output2.println("Brian");
				for (JButton jButton : botonesRes) {
					jButton.setEnabled(false);
				}
				}});
		btnChrisResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output2.println("Chris");
				for (JButton jButton : botonesRes) {
					jButton.setEnabled(false);
				}
				}});
		btnHerbertResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output2.println("Herbert");
				for (JButton jButton : botonesRes) {
					jButton.setEnabled(false);
				}
				}});
		btnJoeResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output2.println("Joe");
				for (JButton jButton : botonesRes) {
					jButton.setEnabled(false);
				}
				}});
		btnKoolAidResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output2.println("KoolAid");
				for (JButton jButton : botonesRes) {
					jButton.setEnabled(false);
				}
				}});
		btnLoisResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output2.println("Lois");
				for (JButton jButton : botonesRes) {
					jButton.setEnabled(false);
				}
				}});
		btnMegResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output2.println("Meg");
				for (JButton jButton : botonesRes) {
					jButton.setEnabled(false);
				}
				}});
		btnQuagmireResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output2.println("Quagmire");
				for (JButton jButton : botonesRes) {
					jButton.setEnabled(false);
				}
				}});
		btnStewieResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output2.println("Stewie");
				for (JButton jButton : botonesRes) {
					jButton.setEnabled(false);
				}
				}});
		btnClevelandResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output2.println("Cleveland");
				for (JButton jButton : botonesRes) {
					jButton.setEnabled(false);
				}
				}});

		
		
		
	}
	
		
	public void SetAnswerMode(JButton btnServerConnect,JButton btnclientConnect, JTextArea chatlog, JScrollPane scroll, JTextField chatwrite, JLabel choose,
			ArrayList<JButton> botones, ArrayList<JButton> botonesRes
			
			) {
		if (choose.isVisible()) {
			
			chatlog.setVisible(false);
			scroll.setVisible(false);
			chatwrite.setVisible(false);
			choose.setVisible(false);
			
		for (JButton jButton : botones) {
			jButton.setVisible(false);
		}
		
		for (JButton jButton : botonesRes) {
			jButton.setVisible(true);
		}
		}
		else {
			chatlog.setVisible(true);
			scroll.setVisible(true);
			chatwrite.setVisible(true);
			choose.setVisible(true);
			
			for (JButton jButton : botones) {
				jButton.setVisible(true);
		}
			
			for (JButton jButton : botonesRes) {
				jButton.setVisible(false);
			}
	}
}

	public void SetImagesVisibility(JLabel b, JButton a) {
		if(b.isVisible()) {
			b.setVisible(false);
			a.setText("Show");
		}
		else {
			b.setVisible(true);
			a.setText("Hide");
	}
}
		public void StartMatch(ArrayList<JButton> botones,ArrayList<JLabel> jLabelimg, JLabel lblUsuario,JLabel lblVictorias, JLabel lblDerrotas,JLabel lblPersonajeMasUsado) {
			for (JButton jButton : botones) {
				jButton.setVisible(true);
		}
			for (JLabel JLabel : jLabelimg) {
				JLabel.setVisible(true);
		}
			lblUsuario.setVisible(false);
			lblVictorias.setVisible(false);
			lblDerrotas.setVisible(false);
			lblPersonajeMasUsado.setVisible(false);

			}
	

			
		


	public static ArrayList<Character> getPersonajes() {
		return Personajes;
	}

	public Player getPlayer() {
		return player;
	}

	public static void setPersonajes(ArrayList<Character> personajes) {
		Personajes = personajes;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
	
