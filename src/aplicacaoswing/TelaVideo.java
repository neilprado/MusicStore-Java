package aplicacaoswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.Album;
import modelo.Musica;

import java.awt.BorderLayout;
import java.awt.Color;

public class TelaVideo extends JFrame {

	private JFrame frmBusca;
	private static Musica mu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVideo window = new TelaVideo(mu);
					window.frmBusca.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param a 
	 */
	public TelaVideo(Musica m) {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Youtube Video");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 694, 344);
		getContentPane().setLayout(null);
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBusca = new JFrame();
		frmBusca.getContentPane().setBackground(new Color(255, 255, 255));
		frmBusca.setTitle("Busca");
		frmBusca.setBounds(100, 100, 450, 300);
		frmBusca.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBusca.getContentPane().setLayout(null);
	}

}
