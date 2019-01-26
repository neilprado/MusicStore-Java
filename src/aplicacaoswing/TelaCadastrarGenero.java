package aplicacaoswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import fachada.Fachada;
import modelo.Genero;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastrarGenero extends JFrame {

	private JFrame frame;
	private JTextField textField_genero;
	private JLabel status;
	private JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrarGenero window = new TelaCadastrarGenero();
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
	public TelaCadastrarGenero() {
		setTitle("Cadastro de G\u00EAnero");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(null);
		
		textField_genero = new JTextField();
		textField_genero.setBounds(126, 45, 171, 20);
		getContentPane().add(textField_genero);
		textField_genero.setColumns(10);
		
		JLabel lblNomeDoGenero = new JLabel("Nome do Genero");
		lblNomeDoGenero.setBounds(10, 48, 106, 14);
		getContentPane().add(lblNomeDoGenero);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada.inicializar();
				try {
					if(textField_genero.getText().equalsIgnoreCase(""))
						throw new Exception("Campo nome do gênero se encontra em branco");
					String nome = textField_genero.getText();
					Genero g = Fachada.cadastrarGenero(nome);
					status.setText("Gênero " + g.getNome() + " cadastrado com sucesso");
					textField_genero.setText("");
					textField_genero.requestFocus();
				}catch(Exception err) {
					status.setText(err.getMessage());
				}
			}
		});
		btnCadastrar.setBounds(168, 86, 106, 23);
		getContentPane().add(btnCadastrar);
		
		status = new JLabel("");
		status.setBounds(10, 132, 414, 14);
		getContentPane().add(status);
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
