package telas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class IncluirCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblTelefone;
	private JLabel lblEndereo;
	private JLabel lblSexo;
	private JLabel lblEmail;
	private JTextField textField_6;
	private JLabel lblCelular;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel lblCep;
	private JTextField textField_9;
	private JLabel lblRendaR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IncluirCliente frame = new IncluirCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IncluirCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(66, 131, 189, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(334, 131, 132, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(66, 192, 354, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(525, 131, 142, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(139, 301, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(83, 301, 46, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "", "Masculino", "Feminino" }));
		comboBox.setBounds(66, 252, 132, 20);
		contentPane.add(comboBox);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 134, 46, 14);
		contentPane.add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(280, 134, 46, 14);
		contentPane.add(lblCpf);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(494, 134, 46, 14);
		contentPane.add(lblRg);

		JLabel lblInclusoDeUsurios = new JLabel("Inclus\u00E3o de Usu\u00E1rios para compra de autom\u00F3vel Audi");
		lblInclusoDeUsurios.setFont(new Font("Arial", Font.BOLD, 25));
		lblInclusoDeUsurios.setBounds(10, 29, 657, 45);
		contentPane.add(lblInclusoDeUsurios);

		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 304, 46, 14);
		contentPane.add(lblTelefone);

		lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 195, 79, 14);
		contentPane.add(lblEndereo);

		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 255, 46, 14);
		contentPane.add(lblSexo);

		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(280, 255, 46, 14);
		contentPane.add(lblEmail);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(334, 252, 132, 20);
		contentPane.add(textField_6);

		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(280, 304, 46, 14);
		contentPane.add(lblCelular);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(334, 301, 46, 20);
		contentPane.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(390, 301, 86, 20);
		contentPane.add(textField_8);

		lblCep = new JLabel("Cep:");
		lblCep.setBounds(481, 195, 46, 14);
		contentPane.add(lblCep);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(535, 192, 132, 20);
		contentPane.add(textField_9);

		lblRendaR = new JLabel("Renda R$:");
		lblRendaR.setBounds(10, 364, 60, 14);
		contentPane.add(lblRendaR);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(83, 359, 223, 94);
		contentPane.add(textArea);

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(null, "Usuário clicou no botão");
			}
		});
		btnIncluir.setBounds(353, 430, 142, 23);
		contentPane.add(btnIncluir);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(525, 430, 142, 23);
		contentPane.add(btnCancelar);
	}
}
