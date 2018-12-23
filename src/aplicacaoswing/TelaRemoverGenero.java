package aplicacaoswing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada.Fachada;
import modelo.Genero;
public class TelaRemoverGenero extends JFrame {

	private JFrame frame;
	private JTextField textField_genero;
	private JLabel status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverGenero window = new TelaRemoverGenero();
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
	public TelaRemoverGenero() {
		setTitle("Remover G\u00EAnero");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 206);
		getContentPane().setLayout(null);
		
		textField_genero = new JTextField();
		textField_genero.setBounds(126, 45, 171, 20);
		getContentPane().add(textField_genero);
		textField_genero.setColumns(10);
		
		JLabel lblNomeGenero = new JLabel("Nome do G\u00EAnero");
		lblNomeGenero.setBounds(10, 48, 106, 14);
		getContentPane().add(lblNomeGenero);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField_genero.getText().equalsIgnoreCase(""))
						throw new Exception("Não é possível remover, campo em branco");
					Genero g = Fachada.removerGenero(textField_genero.getText());
					status.setText("Gênero " + g.getNome() + " removido com sucesso");
				}catch(Exception err) {
					status.setText(err.getMessage());
				}
			}
		});
		btnCadastrar.setBounds(165, 99, 106, 23);
		getContentPane().add(btnCadastrar);
		
		status = new JLabel("");
		status.setBounds(10, 153, 414, 14);
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
