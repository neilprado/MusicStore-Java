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
import modelo.Artista;
import modelo.Genero;
import modelo.Musica;

import java.awt.Color;
public class TelaListarArtistas extends JFrame {

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
					TelaListarArtistas window = new TelaListarArtistas();
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
	public TelaListarArtistas() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Listar Artistas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 694, 344);
		getContentPane().setLayout(null);
		
		Fachada.inicializar();
		List<Artista> artistas = Fachada.listarArtistasCadastrados(); 
		button = new JButton[artistas.size()];
		label = new JLabel[artistas.size()];
		int i = 0;
		for(Artista a: artistas) {
			button[i] = new JButton("");
			button[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			button[i].setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/artista.jpg")));
			getContentPane().add(button[i]);
			button[i].setBounds(4*(i*22), 11, 89, 68);
			label[i] = new JLabel(a.getNome());
			label[i].setBounds(4*(i*22), 79, 89, 14);
			getContentPane().add(label[i]);			
			initialize();
			button[i] = new JButton("");	
			i++;
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
