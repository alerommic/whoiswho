package tfg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBase {

	private static Player player;
	private static ArrayList<Character> Personajes;
	private Connection connection;
	private String url="jdbc:mysql://base1.co0hpefhkk0o.us-east-1.rds.amazonaws.com:3306/WhoIsWho"; 
	private String user="admin";
	private String password="Administrador";
	private String query="";
	private boolean usuarioExistente = false;
	//boolean primeraVez;
	@SuppressWarnings("resource")
	public DataBase(Player player, ArrayList<Character> Personajes) throws IOException {
		
		DataBase.player=player;
		DataBase.Personajes=Personajes;
		
		
		
		//,,null,3,null
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(url,user,password); 
		//Statement sentence=connection.createStatement();
		
		
		query=("SELECT COUNT(*) FROM Usuarios WHERE nombre = ?");
		PreparedStatement sentence = connection.prepareStatement(query);		
		sentence.setString(1, player.getUsername());
		ResultSet resultSet = sentence.executeQuery();
		if (resultSet.next()) {
		    int count = resultSet.getInt(1);
		    usuarioExistente = count > 0;
		}
		
		
		//Falta poner la partida ganada y perdida en el MESST2
		
		if (!usuarioExistente) {
			query=("insert into Usuarios (nombre,partidasGanadas,partidasPerdidas) values (?,?,?)");
			sentence = connection.prepareStatement(query);			
			sentence.setString(1, player.getUsername());
			sentence.setInt(2, player.getPartidasGanadas());
			sentence.setInt(3, player.getPartidasPerdidas());

			 sentence.execute();
		}
	
		

		
		
		
		
	//System.out.println(rs.getString("nombre") + " " + rs.getString("codigo")+ " " + rs.getString("nif"));
		
		
	
		
	} catch (Exception e) { 
		e.printStackTrace();}
	}
		
	
	public int setRoomId() throws SQLException {
		int roomId=0;
	    query = "SELECT MAX(idPartida) FROM Partidas";
	    PreparedStatement sentence = connection.prepareStatement(query);
	    ResultSet resultSet = sentence.executeQuery();
	    if (resultSet.next()) {
	        roomId = resultSet.getInt(1);
	        roomId++; // Incrementar el valor de roomId en 1
	       
	    }
	    return roomId;
	}
	
	
	public void setFinalDePartida(Player ganador, Player perdedor) throws ClassNotFoundException {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password);
			query=("insert into Partidas values (?,?,?,?,?)");
			PreparedStatement sentence = connection.prepareStatement(query);

			
			
			sentence.setInt(1, player.getRoomId());
			sentence.setString(2, perdedor.getUsername());
			sentence.setString(3, ganador.getUsername());
			sentence.setString(4, perdedor.getCharacter());
			sentence.setString(5, ganador.getCharacter());
			sentence.execute();

			int PatidasG=0;
		    query = "SELECT partidasGanadas FROM Usuarios where nombre=?";
		    sentence = connection.prepareStatement(query);
		    sentence.setString(1, ganador.getUsername());
		    ResultSet resultSet = sentence.executeQuery();
		    if (resultSet.next()) {
		    	PatidasG = resultSet.getInt(1);
		    	PatidasG++; 
		       
		    }
		    
			query=("update Usuarios set partidasGanadas=? where nombre=?");
			sentence = connection.prepareStatement(query);
			sentence.setInt(1, PatidasG);
			sentence.setString(2, ganador.getUsername());

			 sentence.execute();
			 
			 int PatidasP=0;
			    query = "SELECT partidasPerdidas FROM Usuarios where nombre=?";
			    sentence = connection.prepareStatement(query);
			    sentence.setString(1, perdedor.getUsername());
			    resultSet = sentence.executeQuery();
			    if (resultSet.next()) {
			    	PatidasP = resultSet.getInt(1);
			    	PatidasP++; 
			       
			    }
			 
			 query=("update Usuarios set partidasPerdidas=? where nombre=?");
				sentence = connection.prepareStatement(query);
				sentence.setInt(1, PatidasP);
				sentence.setString(2, perdedor.getUsername());

				 sentence.execute();
				 
				 
				 
				 
				 for (int i = 0; i < Personajes.size(); i++) {
					 if((Personajes.get(i).getName().equals(ganador.getCharacter()))||(Personajes.get(i).getName().equals(perdedor.getCharacter()))) {
						 int VecesU=0;
						    query = "SELECT vecesUtilizado FROM Personajes where nombre=?";
						    sentence = connection.prepareStatement(query);
						    sentence.setString(1, Personajes.get(i).getName());
						    resultSet = sentence.executeQuery();
						    if (resultSet.next()) {
						    	VecesU = resultSet.getInt(1);
						    	VecesU++; 
						       
						    }
						query=("update Personajes set vecesUtilizado=? where nombre=?");
						sentence = connection.prepareStatement(query);
	
						sentence.setInt(1, VecesU);
						sentence.setString(2, Personajes.get(i).getName());
						sentence.execute();
					 }
					}	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		
	}
	
	public int getPartidasPerdidas() {
		 int PatidasP=0;
		    query = "SELECT partidasPerdidas FROM Usuarios where nombre=?";
			try {
				PreparedStatement sentence = connection.prepareStatement(query);
				 sentence.setString(1, player.getUsername());
				    ResultSet resultSet = sentence.executeQuery();
				    if (resultSet.next()) {
				    	PatidasP = resultSet.getInt(1);
				    }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   
		    return PatidasP;
	}
	
	public int getPartidasGanadas() {
		int PatidasG=0;
	    query = "SELECT partidasGanadas FROM Usuarios where nombre=?";
		try {
			PreparedStatement sentence = connection.prepareStatement(query);
			sentence.setString(1, player.getUsername());
		    ResultSet resultSet = sentence.executeQuery();
		    if (resultSet.next()) {
		    	PatidasG = resultSet.getInt(1);	       
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
		return PatidasG;
	}
	


	public String getPersonajeMasUsado() {
		String Personaje="";
	    query = "select nombre from Personajes where vecesUtilizado=(SELECT MAX(vecesUtilizado)FROM Personajes)";
		try {
			PreparedStatement sentence = connection.prepareStatement(query);
		    ResultSet resultSet = sentence.executeQuery();
		    if (resultSet.next()) {
		    	Personaje =Personaje + resultSet.getString(1) + "\n";	       
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
		return Personaje;
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	

}
