package tfg;

import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Character{

	private String name;
	private JLabel Image;
	private BufferedImage Imagepg;
	private JButton OcultarBtn;
	private Boolean Oculto=false;
	private int vecesUtilizado;
	


	public Character(String name, JLabel image, BufferedImage imagepg) {
		super();
		this.name = name;
		Image = image;
		Imagepg = imagepg;
		vecesUtilizado++;
	}



	public JButton getOcultarBtn() {
		return OcultarBtn;
	}



	public Boolean getOculto() {
		return Oculto;
	}



	public void setOcultarBtn(JButton ocultar) {
		OcultarBtn = ocultar;
	}



	public void setOculto(Boolean oculto) {
		Oculto = oculto;
	}



	public String getName() {
		return name;
	}

	public JLabel getImage() {
		return Image;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setImage(JLabel image) {
		Image = image;
	}


	public BufferedImage getImagepg() {
		return Imagepg;
	}


	public void setImagepg(BufferedImage imagepg) {
		Imagepg = imagepg;
	}


	public int getVecesUtilizado() {
		return vecesUtilizado;
	}

	
	
	
}
