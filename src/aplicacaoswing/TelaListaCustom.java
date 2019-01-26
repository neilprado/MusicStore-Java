package aplicacaoswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

public class TelaListaCustom {

	private JFrame frmBusca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaCustom window = new TelaListaCustom();
					window.frmBusca.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListaCustom() {
		
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
