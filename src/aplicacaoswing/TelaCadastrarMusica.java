package aplicacaoswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import fachada.Fachada;
import modelo.Album;
import modelo.Artista;
import modelo.Musica;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastrarMusica extends JFrame {

	private JFrame frame;
	private JTextField textField_url;
	private JTextField textField_preco;
	private JLabel lblArtista;
	private JTextField textField_artista;
	private JLabel lblAno;
	private JTextField textField_ano;
	private JLabel lblNmeroDuracao;
	private JTextField textField_duracao;
	private JLabel lblNomeDolbum;
	private JLabel labelMusica;
	private JTextField textField_musica;
	private JLabel status;
	private JTextField textFieldAlbum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarMusica window = new TelaCadastrarMusica();
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
	public TelaCadastrarMusica() {
		setTitle("Cadastro de M\u00FAsica");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textField_url = new JTextField();
		textField_url.setBounds(126, 45, 171, 20);
		getContentPane().add(textField_url);
		textField_url.setColumns(10);
		
		JLabel lblURL = new JLabel("URL");
		lblURL.setBounds(10, 48, 106, 14);
		getContentPane().add(lblURL);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setBounds(10, 79, 85, 14);
		getContentPane().add(lblPreco);
		
		textField_preco = new JTextField();
		textField_preco.setBounds(126, 76, 49, 20);
		getContentPane().add(textField_preco);
		textField_preco.setColumns(10);
		
		lblArtista = new JLabel("Nome do Artista");
		lblArtista.setBounds(10, 110, 131, 14);
		getContentPane().add(lblArtista);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.inicializar();
				try {
					if(textField_url.getText().equalsIgnoreCase("") || textField_ano.getText().equalsIgnoreCase("") || 
							textField_artista.getText().equalsIgnoreCase("") || textField_duracao.getText().equalsIgnoreCase("")
							|| textField_musica.getText().equalsIgnoreCase("") || textField_preco.getText().equalsIgnoreCase("")
							|| textFieldAlbum.getText().equalsIgnoreCase(""))
						throw new Exception ("Existem campos em branco, tente novamente preenchendo-os");
					String nome = textField_musica.getText();
					double preco = Double.parseDouble(textField_preco.getText());
					int ano = Integer.parseInt(textField_ano.getText());
					Album al = Fachada.buscarAlbum(textFieldAlbum.getText());
					Artista a = Fachada.buscarArtista(textField_artista.getText());
					int duracao = Integer.parseInt(textField_duracao.getText());
					String url = textField_url.getText();
					Musica m = new Musica(nome, preco, ano, al, a, duracao, url);
					status.setText("Música "+ m.getNome() + " cadastrada com sucesso");
					textFieldAlbum.setText("");
					textField_ano.setText("");
					textField_artista.setText("");
					textField_duracao.setText("");
					textField_musica.setText("");
					textField_preco.setText("");
					textField_url.setText("");
					textField_musica.requestFocus();
						}catch(Exception err){
					status.setText(err.getMessage());
				}
			}
		});
		btnCadastrar.setBounds(171, 213, 106, 23);
		getContentPane().add(btnCadastrar);
		
		status = new JLabel("");
		status.setBounds(10, 247, 414, 14);
		getContentPane().add(status);
		
		textField_artista = new JTextField();
		textField_artista.setColumns(10);
		textField_artista.setBounds(126, 107, 171, 20);
		getContentPane().add(textField_artista);
		
		lblAno = new JLabel("Ano");
		lblAno.setBounds(205, 79, 49, 14);
		getContentPane().add(lblAno);
		
		textField_ano = new JTextField();
		textField_ano.setColumns(10);
		textField_ano.setBounds(248, 76, 49, 20);
		getContentPane().add(textField_ano);
		
		lblNmeroDuracao = new JLabel("Dura\u00E7\u00E3o");
		lblNmeroDuracao.setBounds(10, 164, 131, 14);
		getContentPane().add(lblNmeroDuracao);
		
		textField_duracao = new JTextField();
		textField_duracao.setColumns(10);
		textField_duracao.setBounds(191, 161, 49, 20);
		getContentPane().add(textField_duracao);
		
		lblNomeDolbum = new JLabel("Nome do \u00C1lbum");
		lblNomeDolbum.setBounds(10, 139, 131, 14);
		getContentPane().add(lblNomeDolbum);
		
		labelMusica = new JLabel("Nome da M\u00FAsica");
		labelMusica.setBounds(10, 17, 106, 14);
		getContentPane().add(labelMusica);
		
		textField_musica = new JTextField();
		textField_musica.setColumns(10);
		textField_musica.setBounds(126, 14, 171, 20);
		getContentPane().add(textField_musica);
		
		textFieldAlbum = new JTextField();
		textFieldAlbum.setColumns(10);
		textFieldAlbum.setBounds(126, 135, 171, 20);
		getContentPane().add(textFieldAlbum);
		initialize();
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
