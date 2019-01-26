package aplicacaoswing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TelaPrincipal {

	private JFrame frmMusicstore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmMusicstore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMusicstore = new JFrame();
		frmMusicstore.setTitle("MusicStore");
		frmMusicstore.setBounds(100, 100, 545, 335);
		frmMusicstore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMusicstore.getContentPane().setLayout(null);
		try {
			frmMusicstore.setContentPane(new FundoTela("/imagem/bground.jpg"));
		}catch(IOException e1) {}
		
		JLabel lblCadastros = new JLabel("Cadastros");
		lblCadastros.setBounds(10, 31, 79, 14);
		frmMusicstore.getContentPane().add(lblCadastros);
		
		JButton btnListArtista = new JButton("");
		btnListArtista.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/artista.jpg")));
		btnListArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaListarArtistas t = new TelaListarArtistas();
					t.setVisible(true);
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnListArtista.setBounds(88, 77, 89, 55);
		frmMusicstore.getContentPane().add(btnListArtista);
		
		JButton btnAlbum = new JButton("");
		btnAlbum.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/album.jpg")));
		btnAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaCadastrarAlbum t = new TelaCadastrarAlbum();
					t.setVisible(true);
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnAlbum.setBounds(187, 11, 89, 55);
		frmMusicstore.getContentPane().add(btnAlbum);
		
		JButton btnMusica = new JButton("");
		btnMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaCadastrarMusica t = new TelaCadastrarMusica();
					t.setVisible(true);
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnMusica.setBounds(286, 11, 89, 55);
		frmMusicstore.getContentPane().add(btnMusica);
		
		JButton btnGenero = new JButton("");
		btnGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaCadastrarGenero t = new TelaCadastrarGenero();
					t.setVisible(true);
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnGenero.setBounds(385, 11, 89, 55);
		frmMusicstore.getContentPane().add(btnGenero);
		
		JLabel lblListagens = new JLabel("Listagens");
		lblListagens.setBounds(10, 97, 46, 14);
		frmMusicstore.getContentPane().add(lblListagens);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/artista.jpg")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaCadastrarArtista t = new TelaCadastrarArtista();
					t.setVisible(true);
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		});
		button.setBounds(88, 11, 89, 55);
		frmMusicstore.getContentPane().add(button);
		
		JButton btnListAlbum = new JButton("");
		btnListAlbum.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/album.jpg")));
		btnListAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaListarAlbuns t = new TelaListarAlbuns();
					t.setVisible(true);
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnListAlbum.setBounds(187, 77, 89, 55);
		frmMusicstore.getContentPane().add(btnListAlbum);
		
		JButton btnListMusica = new JButton("");
		btnListMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaListarMusicas t = new TelaListarMusicas();
					t.setVisible(true);
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnListMusica.setBounds(286, 77, 89, 55);
		frmMusicstore.getContentPane().add(btnListMusica);
		
		JButton btnListGenero = new JButton("");
		btnListGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaListarGeneros t = new TelaListarGeneros();
					t.setVisible(true);
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnListGenero.setBounds(385, 77, 89, 55);
		frmMusicstore.getContentPane().add(btnListGenero);
		
		JLabel lblAtualizao = new JLabel("Atualiza\u00E7\u00F5es");
		lblAtualizao.setBounds(10, 163, 63, 14);
		frmMusicstore.getContentPane().add(lblAtualizao);
		
		JButton btnUpdateArtista = new JButton("");
		btnUpdateArtista.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/artista.jpg")));
		btnUpdateArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaAtualizarArtista t = new TelaAtualizarArtista();
					t.setVisible(true);
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnUpdateArtista.setBounds(88, 143, 89, 55);
		frmMusicstore.getContentPane().add(btnUpdateArtista);
		
		JButton btnUpdateAlbum = new JButton("");
		btnUpdateAlbum.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/album.jpg")));
		btnUpdateAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaAtualizarAlbum t = new TelaAtualizarAlbum();
					t.setVisible(true);
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnUpdateAlbum.setBounds(187, 143, 89, 55);
		frmMusicstore.getContentPane().add(btnUpdateAlbum);
		
		JButton btnUpdateMusica = new JButton("");
		btnUpdateMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaAtualizarMusica t = new TelaAtualizarMusica();
					t.setVisible(true);
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnUpdateMusica.setBounds(286, 143, 89, 55);
		frmMusicstore.getContentPane().add(btnUpdateMusica);
		
		JButton btnUpdateGenero = new JButton("");
		btnUpdateGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaAtualizarGenero t = new TelaAtualizarGenero();
					t.setVisible(true);
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnUpdateGenero.setBounds(385, 143, 89, 55);
		frmMusicstore.getContentPane().add(btnUpdateGenero);
		
		JLabel lblNewLabel = new JLabel("Exclus\u00F5es");
		lblNewLabel.setBounds(10, 230, 63, 14);
		frmMusicstore.getContentPane().add(lblNewLabel);
		
		JButton btnDeleteArtista = new JButton("");
		btnDeleteArtista.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/artista.jpg")));
		btnDeleteArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaRemoverArtista t = new TelaRemoverArtista();
					t.setVisible(true);
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnDeleteArtista.setBounds(88, 210, 89, 55);
		frmMusicstore.getContentPane().add(btnDeleteArtista);
		
		JButton btnDeleteAlbum = new JButton("");
		btnDeleteAlbum.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/album.jpg")));
		btnDeleteAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaRemoverAlbum t = new TelaRemoverAlbum();
					t.setVisible(true);
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnDeleteAlbum.setBounds(187, 209, 89, 55);
		frmMusicstore.getContentPane().add(btnDeleteAlbum);
		
		JButton btnDeleteMusica = new JButton("");
		btnDeleteMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaRemoverMusica t = new TelaRemoverMusica();
					t.setVisible(true);
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnDeleteMusica.setBounds(286, 209, 89, 55);
		frmMusicstore.getContentPane().add(btnDeleteMusica);
		
		JButton btnDeleteGenero = new JButton("");
		btnDeleteGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaRemoverGenero t = new TelaRemoverGenero();
					t.setVisible(true);
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		});
		btnDeleteGenero.setBounds(385, 209, 89, 55);
		frmMusicstore.getContentPane().add(btnDeleteGenero);
		
		JMenuBar menuBar = new JMenuBar();
		frmMusicstore.setJMenuBar(menuBar);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmCadastrarArtista = new JMenuItem("Cadastrar Artista");
		mntmCadastrarArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarArtista t = new TelaCadastrarArtista();
				t.setVisible(true);
			}
		});
		mnCadastrar.add(mntmCadastrarArtista);
		
		JMenuItem mntmCadastrarlbum = new JMenuItem("Cadastrar \u00C1lbum");
		mntmCadastrarlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarAlbum t = new TelaCadastrarAlbum();
				t.setVisible(true);
			}
		});
		mnCadastrar.add(mntmCadastrarlbum);
		
		JMenuItem mntmCadastrarMsica = new JMenuItem("Cadastrar M\u00FAsica");
		mntmCadastrarMsica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarMusica t = new TelaCadastrarMusica();
				t.setVisible(true);
			}
		});
		mnCadastrar.add(mntmCadastrarMsica);
		
		JMenuItem mntmCadastrarGnero = new JMenuItem("Cadastrar G\u00EAnero");
		mntmCadastrarGnero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarGenero t = new TelaCadastrarGenero();
				t.setVisible(true);
			}
		});
		mnCadastrar.add(mntmCadastrarGnero);
		
		JMenu mnListar = new JMenu("Listar");
		menuBar.add(mnListar);
		
		JMenuItem mntmListarArtistas = new JMenuItem("Listar Artistas");
		mntmListarArtistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarArtistas t = new TelaListarArtistas();
				t.setVisible(true);
			}
		});
		mnListar.add(mntmListarArtistas);
		
		JMenuItem mntmListarAlbuns = new JMenuItem("Listar \u00C1lbuns");
		mntmListarAlbuns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarAlbuns t = new TelaListarAlbuns();
				t.setVisible(true);
			}
		});
		mnListar.add(mntmListarAlbuns);
		
		JMenuItem mntmListarMusicas = new JMenuItem("Listar M\u00FAsicas");
		mntmListarMusicas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarMusicas t = new TelaListarMusicas();
				t.setVisible(true);
			}
		});
		mnListar.add(mntmListarMusicas);
		
		JMenuItem mntmListarGeneros = new JMenuItem("Listar G\u00EAneros");
		mntmListarGeneros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarGeneros t = new TelaListarGeneros();
				t.setVisible(true);
			}
		});
		mnListar.add(mntmListarGeneros);
		
		JMenu mnAtualizar = new JMenu("Atualizar");
		menuBar.add(mnAtualizar);
		
		JMenuItem mntmAtualizarArtista = new JMenuItem("Atualizar Artista");
		mntmAtualizarArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAtualizarArtista t = new TelaAtualizarArtista();
				t.setVisible(true);
			}
		});
		mnAtualizar.add(mntmAtualizarArtista);
		
		JMenuItem mntmAtualizarlbum = new JMenuItem("Atualizar \u00C1lbum");
		mntmAtualizarlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAtualizarAlbum t = new TelaAtualizarAlbum();
				t.setVisible(true);
			}
		});
		mnAtualizar.add(mntmAtualizarlbum);
		
		JMenuItem mntmAtualizarMsica = new JMenuItem("Atualizar M\u00FAsica");
		mntmAtualizarMsica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAtualizarMusica t = new TelaAtualizarMusica();
				t.setVisible(true);
			}
		});
		mnAtualizar.add(mntmAtualizarMsica);
		
		JMenuItem mntmAtualizarGnero = new JMenuItem("Atualizar G\u00EAnero");
		mntmAtualizarGnero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAtualizarGenero t = new TelaAtualizarGenero();
				t.setVisible(true);
			}
		});
		mnAtualizar.add(mntmAtualizarGnero);
		
		JMenu mnExcluir = new JMenu("Excluir");
		menuBar.add(mnExcluir);
		
		JMenuItem mntmExcluirArtista = new JMenuItem("Excluir Artista");
		mntmExcluirArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverArtista t = new TelaRemoverArtista();
				t.setVisible(true);
			}
		});
		mnExcluir.add(mntmExcluirArtista);
		
		JMenuItem mntmExcluirlbum = new JMenuItem("Excluir \u00C1lbum");
		mntmExcluirlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverAlbum t = new TelaRemoverAlbum();
				t.setVisible(true);
			}
		});
		mnExcluir.add(mntmExcluirlbum);
		
		JMenuItem mntmExcluirMsica = new JMenuItem("Excluir M\u00FAsica");
		mntmExcluirMsica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverMusica t = new TelaRemoverMusica();
				t.setVisible(true);
			}
		});
		mnExcluir.add(mntmExcluirMsica);
		
		JMenuItem mntmExcluirGnero = new JMenuItem("Excluir G\u00EAnero");
		mntmExcluirGnero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverGenero t = new TelaRemoverGenero();
				t.setVisible(true);
			}
		});
		mnExcluir.add(mntmExcluirGnero);
	}
}
