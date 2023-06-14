package tfg;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Choosing extends JFrame {

	private JPanel contentPane;
	private static Choosing frame;
	private static String character;
	private String username;
	private static ArrayList<Character> Personajes;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Choosing();
					frame.setVisible(true);
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
	public Choosing() throws IOException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {

				 username = JOptionPane.showInputDialog(frame, 	"What's your username?");
				
				JOptionPane.showMessageDialog(
						frame, "Choose Your Character", "",
					   	JOptionPane.INFORMATION_MESSAGE);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1210, 706);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);

		BufferedImage imgPeterjpeg = ImageIO.read(new File("./img/Peter.jpeg"));

		BufferedImage imgBabsjpeg = ImageIO.read(new File("./img/Babs.jpeg"));

		BufferedImage imgBrianjpeg = ImageIO.read(new File("./img/Brian.jpeg"));

		BufferedImage imgChrisjpeg = ImageIO.read(new File("./img/Chris.jpeg"));

		BufferedImage imgHerbertjpeg = ImageIO.read(new File("./img/Herbert.jpeg"));

		BufferedImage imgJoejpeg = ImageIO.read(new File("./img/Joe.jpeg"));

		BufferedImage imgStewiejpeg = ImageIO.read(new File("./img/Stewie.jpeg"));

		BufferedImage imgMegjpeg = ImageIO.read(new File("./img/Meg.jpeg"));

		BufferedImage imgQuagmirejpeg = ImageIO.read(new File("./img/Quagmire.jpeg"));

		BufferedImage imgKoolAidjpeg = ImageIO.read(new File("./img/KoolAid.jpeg"));

		BufferedImage imgClevelandjpeg = ImageIO.read(new File("./img/Cleveland.jpeg"));

		BufferedImage imgLoisjpeg = ImageIO.read(new File("./img/Lois.jpeg"));

		JLabel PeterImg =  new JLabel(new ImageIcon(imgPeterjpeg.getScaledInstance(170, 170, DO_NOTHING_ON_CLOSE)));
		PeterImg.setBounds(181, 42, 170, 170);
		contentPane.add(PeterImg);
		PeterImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					character = "Peter";
					Main m= new Main(character,username, Personajes);
					m.setVisible(true);
					frame.dispose();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});

		JLabel BabsImg = new JLabel(new ImageIcon(imgBabsjpeg.getScaledInstance(170, 170, DO_NOTHING_ON_CLOSE)));
		BabsImg.setBounds(401, 42, 170, 170);
		contentPane.add(BabsImg);
		
		BabsImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					character = "Babs";
					Main m= new Main(character,username, Personajes);
					m.setVisible(true);
					frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});

		JLabel BrianImg = new JLabel(new ImageIcon(imgBrianjpeg.getScaledInstance(170, 170, DO_NOTHING_ON_CLOSE)));
		BrianImg.setBounds(621, 42, 170, 170);
		contentPane.add(BrianImg);

		BrianImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					character = "Brian";
					Main m= new Main(character,username, Personajes);
					m.setVisible(true);
					frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});
		
		JLabel ChrisImg = new JLabel(new ImageIcon(imgChrisjpeg.getScaledInstance(170, 170, DO_NOTHING_ON_CLOSE)));
		ChrisImg.setBounds(841, 42, 170, 170);
		contentPane.add(ChrisImg);
		
		ChrisImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					character = "Chris";
					Main m= new Main(character,username, Personajes);
					m.setVisible(true);
					frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});
		

		JLabel HerbertImg = new JLabel(new ImageIcon(imgHerbertjpeg.getScaledInstance(170, 170, DO_NOTHING_ON_CLOSE)));
		HerbertImg.setBounds(181, 241, 170, 170);
		contentPane.add(HerbertImg);

		HerbertImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					character = "Herbert";
					Main m= new Main(character,username, Personajes);
					m.setVisible(true);
					frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});
		
		
		JLabel JoeImg = new JLabel(new ImageIcon(imgJoejpeg.getScaledInstance(170, 170, DO_NOTHING_ON_CLOSE)));
		JoeImg.setBounds(401, 241, 170, 170);
		contentPane.add(JoeImg);
		
		JoeImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					character = "Joe";
					Main m= new Main(character,username, Personajes);
					m.setVisible(true);
					frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});


		JLabel StewieImg = new JLabel(new ImageIcon(imgStewiejpeg.getScaledInstance(170, 170, DO_NOTHING_ON_CLOSE)));
		StewieImg.setBounds(621, 241, 170, 170);
		contentPane.add(StewieImg);
		
		StewieImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					character = "Stewie";
					Main m= new Main(character,username, Personajes);
					m.setVisible(true);
					frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});


		JLabel MegImg = new JLabel(new ImageIcon(imgMegjpeg.getScaledInstance(170, 170, DO_NOTHING_ON_CLOSE)));
		MegImg.setBounds(841, 241, 170, 170);
		contentPane.add(MegImg);
		
		MegImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					character = "Meg";
					Main m= new Main(character,username, Personajes);
					m.setVisible(true);
					frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});

		JLabel QuagmireImg = new JLabel(new ImageIcon(imgQuagmirejpeg.getScaledInstance(170, 170, DO_NOTHING_ON_CLOSE)));
		QuagmireImg.setBounds(181, 442, 170, 170);
		contentPane.add(QuagmireImg);
		
		QuagmireImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					character = "Quagmire";
					Main m= new Main(character,username, Personajes);
					m.setVisible(true);
					frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});

		JLabel KoolAidImg = new JLabel(new ImageIcon(imgKoolAidjpeg.getScaledInstance(170, 170, DO_NOTHING_ON_CLOSE)));
		KoolAidImg.setBounds(401, 442, 170, 170);
		contentPane.add(KoolAidImg);
		
		KoolAidImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					character = "KoolAid";
					Main m= new Main(character,username, Personajes);
					m.setVisible(true);
					frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});

		JLabel ClevelandImg = new JLabel(new ImageIcon(imgClevelandjpeg.getScaledInstance(170, 170, DO_NOTHING_ON_CLOSE)));
		ClevelandImg.setBounds(621, 442, 170, 170);
		contentPane.add(ClevelandImg);

		ClevelandImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					character = "Cleveland";
					Main m= new Main(character,username, Personajes);
					m.setVisible(true);
					frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});

		JLabel LoisImg = new JLabel(new ImageIcon(imgLoisjpeg.getScaledInstance(170, 170, DO_NOTHING_ON_CLOSE)));
		LoisImg.setBounds(841, 442, 170, 170);
		contentPane.add(LoisImg);

		LoisImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					character = "Lois";
					Main m= new Main(character,username, Personajes);
					m.setVisible(true);
					frame.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
			}
		});
		
		Personajes = new ArrayList<Character>();
		
		Character Peter = new Character ("Peter", PeterImg,imgPeterjpeg );
		Character Babs = new Character ("Babs", BabsImg,imgBabsjpeg );
		Character Brian = new Character ("Brian", BrianImg,imgBrianjpeg );
		Character Chris = new Character ("Chris", ChrisImg,imgChrisjpeg );
		Character Herbert = new Character ("Herbert", HerbertImg,imgHerbertjpeg );
		Character Joe = new Character ("Joe", JoeImg,imgJoejpeg );
		Character Stewie = new Character ("Stewie", StewieImg,imgStewiejpeg );
		Character Meg = new Character ("Meg", MegImg,imgMegjpeg );
		Character Quagmire = new Character ("Quagmire", QuagmireImg,imgQuagmirejpeg );
		Character KoolAid = new Character ("KoolAid", KoolAidImg,imgKoolAidjpeg );
		Character Cleveland = new Character ("Cleveland", ClevelandImg,imgClevelandjpeg );
		Character Lois = new Character ("Lois", LoisImg,imgLoisjpeg );
		
		Personajes.add(Peter);
		Personajes.add(Babs);
		Personajes.add(Brian);
		Personajes.add(Chris);
		Personajes.add(Herbert);
		Personajes.add(Joe);
		Personajes.add(Stewie);
		Personajes.add(Meg);
		Personajes.add(Quagmire);
		Personajes.add(KoolAid);
		Personajes.add(Cleveland);
		Personajes.add(Lois);
		
		}
	}


