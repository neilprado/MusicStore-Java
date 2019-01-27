package aplicacaoswing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada.Fachada;
import modelo.Album;
import modelo.Genero;
import modelo.Musica;

import java.awt.Color;
public class TelaListarAlbuns extends JFrame {

	private JFrame frame;
	private JButton button[];
	private JLabel label[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarAlbuns window = new TelaListarAlbuns();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarAlbuns() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Listar \u00C1lbuns");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 694, 344);
		getContentPane().setLayout(null);
		
		Fachada.inicializar();
		List<Album> albuns = Fachada.listarAlbuns(); 
		button = new JButton[albuns.size()];
		label = new JLabel[albuns.size()];
		for(int i = 0; i < albuns.size(); i++) {
			if(i <= 7) {
				button[i] = new JButton("");
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				button[i].setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/album.jpg")));
				getContentPane().add(button[i]);
				button[i].setBounds(4*(i*22), 11, 89, 68);
				label[i] = new JLabel("New Label");
				label[i].setBounds(4*(i*22), 79, 89, 14);
				getContentPane().add(label[i]);			
				initialize();
			}else {
				button[i] = new JButton("");
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				button[i].setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/album.jpg")));
				getContentPane().add(button[i]);
				button[i].setBounds(4*(i*22), 111, 89, 68);
				label[i] = new JLabel("New Label");
				label[i].setBounds(4*(i*22), 179, 89, 14);
				getContentPane().add(label[i]);			
				initialize();	
			}
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
