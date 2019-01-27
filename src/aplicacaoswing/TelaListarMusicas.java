package aplicacaoswing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada.Fachada;
import modelo.Genero;
import modelo.Musica;

import java.awt.Color;
import javax.swing.SwingConstants;
public class TelaListarMusicas extends JFrame {

	private JFrame frame;
	private JLabel status;
	private JButton button[];
	private JLabel label[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarMusicas window = new TelaListarMusicas();
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
	public TelaListarMusicas() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Listar M\u00FAsicas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 694, 344);
		getContentPane().setLayout(null);
		
		
	
		
		Fachada.inicializar();
		List<Musica> musicas = Fachada.listarMusicas(); 
		button = new JButton[musicas.size()];
		label = new JLabel[musicas.size()];
		for(int i = 0; i < musicas.size(); i++) {
			button[i] = new JButton("");
			button[i].setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/musica.jpg")));
			getContentPane().add(button[i]);
			button[i].setBounds(4*(i*22), 11, 89, 68);
			label[i] = new JLabel("New Label");
			label[i].setBounds(4*(i*22), 79, 89, 14);
			getContentPane().add(label[i]);			
			initialize();
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
