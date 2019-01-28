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
public class TelaListarGeneros extends JFrame {

	private JFrame frame;
	private JLabel label[];
	private JButton button[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarGeneros window = new TelaListarGeneros();
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
	public TelaListarGeneros() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Listar G\u00EAneros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 694, 344);
		getContentPane().setLayout(null);
		
		Fachada.inicializar();
		List<Genero> generos = Fachada.listarGenerosCadastrados(); 
		button = new JButton[generos.size()];
		label = new JLabel[generos.size()];
		int i = 0;
		int j = 0;
		for(Genero g: generos) {
			if(i < 8) {
				button[i] = new JButton("");
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				button[i].setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/genero.jpg")));
				getContentPane().add(button[i]);
				button[i].setBounds(4*(i*22), 11, 89, 68);
				label[i] = new JLabel(g.getNome());
				label[i].setBounds(4*(i*22), 79, 89, 14);
				getContentPane().add(label[i]);			
				initialize();
			}else {
				button[i] = new JButton("");
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				button[i].setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/genero.jpg")));
				getContentPane().add(button[i]);
				button[i].setBounds(4*(j*22), 111, 89, 68);
				label[i] = new JLabel(g.getNome());
				label[i].setBounds(4*(j*22), 179, 89, 14);
				getContentPane().add(label[i]);			
				initialize();
				j++;
			}
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
