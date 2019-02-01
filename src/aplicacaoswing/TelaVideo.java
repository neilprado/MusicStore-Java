package aplicacaoswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import fachada.Fachada;
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
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVideo window = new TelaVideo(mu);
					window.frmBusca.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
NativeInterface.runEventPump();
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				NativeInterface.close();
			}
		}));
	}
	
	public static JPanel getBrowser(Musica m) {
		JPanel wbPanel = new JPanel(new BorderLayout());
		JWebBrowser wb = new JWebBrowser();
		wbPanel.add(wb, BorderLayout.CENTER);
		wb.setBarsVisible(false);
		wb.navigate(m.getUrl());
		return wbPanel;
	}


	/**
	 * Create the application.
	 * @param a 
	 */
	public TelaVideo(Musica m) {
		NativeInterface.open();
		
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Youtube Video");
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 655, 333);
		getContentPane().add(getBrowser(m), BorderLayout.CENTER);
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBusca = new JFrame();
		frmBusca.setBounds(100, 100, 450, 300);
		frmBusca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}