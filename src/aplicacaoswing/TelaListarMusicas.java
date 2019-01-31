package aplicacaoswing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import fachada.Fachada;
import modelo.Musica;
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
		int i = 0;
		int j = 0;
		for(Musica m: musicas) {
			if(i < 8) {
				button[i] = new JButton("");
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							TelaVideo tela = new TelaVideo(m);
							System.out.println(m.getAno());
							tela.setVisible(true);
						}catch(Exception err) {
							System.out.println(err.getMessage());
						}
					}
				});
				button[i].setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/musica.jpg")));
				getContentPane().add(button[i]);
				button[i].setBounds(4*(i*22), 11, 89, 68);
				label[i] = new JLabel(m.getNome());
				label[i].setBounds(4*(i*22), 79, 89, 14);
				getContentPane().add(label[i]);			
				initialize();
			}else {
				button[i] = new JButton("");
				button[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							TelaVideo tela = new TelaVideo(m);
							System.out.println(m.getNome());
							tela.setVisible(true);
						}catch(Exception err) {
							System.out.println(err.getMessage());
						}
					}
				});
				button[i].setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/musica.jpg")));
				getContentPane().add(button[i]);
				button[i].setBounds(4*(j*22), 111, 89, 68);
				label[i] = new JLabel(m.getNome());
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
