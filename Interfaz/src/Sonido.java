import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;

////////////////////////////////////////////
//
//
//	@Author Robert Vasquez - 2019
//
//
///////////////////////////////////////////

public class Sonido {
	JFrame ventana;
	JPanel panelBotones;
	JButton play;
	Clip sonido;
	
	public void crearBotones(){
		panelBotones = new JPanel();
		panelBotones.setSize(120,120);
		panelBotones.setLayout(new BoxLayout(panelBotones,BoxLayout.X_AXIS));
		play = new JButton();
		play.setSize(100,100);
		play.setText("PLAY");
		panelBotones.add(play);
	}
	
	public void ejecutarAudio() throws IOException, UnsupportedAudioFileException, InterruptedException{
		
		try{
			sonido = AudioSystem.getClip();
			File archivo = new File("..\\Music\\The_Cello_Song_-_Bach_is_back_with_7_more_cellos_-_The_Piano_Guys");
			sonido.open(AudioSystem.getAudioInputStream(archivo));
			sonido.start();
			Thread.sleep(1000);
			sonido.close();
			System.out.println("Entre");
			
		}catch(LineUnavailableException e){
			e.printStackTrace();
		
		}
		
	}
	
	public void crearVentana(){
		ventana = new JFrame();
		ventana.setLayout(new BoxLayout(ventana.getContentPane(),BoxLayout.Y_AXIS));
		ventana.setTitle("Reproductor de Sonido");
		ventana.setSize(600,600);
		play.addActionListener((ActionListener) this);
		ventana.add(panelBotones);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}
	
	public Sonido(){
		crearBotones();
		crearVentana();
	}
	
	public static void main(String[] arg){
		Sonido ventana = new Sonido();
	}
	
	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == play){
			
			try{
				ejecutarAudio();
			}catch (IOException | UnsupportedAudioFileException e1){
				e1.printStackTrace();
			}catch(InterruptedException e1){
				e1.printStackTrace();
			}
			
		}
	}
	
		
	}
	
	
