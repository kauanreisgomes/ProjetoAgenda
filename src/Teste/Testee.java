package Teste;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class Testee extends JFrame {

	private JPanel contentPane;
	private JTextField txtnome;
	private JTextField txtsobrenome;
	private JTable tableagenda;
	private JTextField txtid;
	private JTextField txtidade;
	private JFormattedTextField txttelefone;
	ContatoDao dao = new ContatoDao();
	Contato contato = new Contato();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Testee frame = new Testee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public Testee() throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\teste\\OneDrive\\\u00C1rea de Trabalho\\download.jfif"));
		setTitle("Programa\u00E7\u00E3o Java");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 531);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnome = new JLabel("Nome:");
		lblnome.setBounds(47, 146, 62, 14);
		contentPane.add(lblnome);
		
		JLabel lblsobrenome = new JLabel("Sobrenome:");
		lblsobrenome.setBounds(47, 174, 73, 14);
		contentPane.add(lblsobrenome);
		
		JLabel lbltel = new JLabel("Telefone:");
		lbltel.setBounds(47, 229, 62, 14);
		contentPane.add(lbltel);
		
		txtnome = new JTextField();
		txtnome.setBounds(119, 143, 123, 20);
		contentPane.add(txtnome);
		txtnome.setColumns(10);
		
		txtsobrenome = new JTextField();
		txtsobrenome.setBounds(119, 171, 123, 20);
		contentPane.add(txtsobrenome);
		txtsobrenome.setColumns(10);
		
		JButton btnadd = new JButton("Adicionar");
		
		btnadd.setBounds(47, 305, 89, 23);
		contentPane.add(btnadd);
		
		JButton btneditar = new JButton("Editar");
		btneditar.setBounds(45, 339, 89, 23);
		contentPane.add(btneditar);
		
		JLabel lblNewLabel = new JLabel("Agenda");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 28));
		lblNewLabel.setBounds(274, 11, 241, 35);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 44, 489, 437);
		contentPane.add(scrollPane);
		
		tableagenda = new JTable();
		tableagenda.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(tableagenda);
		tableagenda.setForeground(Color.WHITE);
		tableagenda.setBackground(Color.BLACK);
		tableagenda.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_1 = new JLabel("id:");
		lblNewLabel_1.setBounds(47, 118, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		txtid = new JTextField();
		txtid.setBounds(119, 112, 62, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JButton btnlistar = new JButton("Listar");
		btnlistar.setBounds(153, 305, 89, 23);
		contentPane.add(btnlistar);
		
		JButton btnapagar = new JButton("Excluir");
		btnapagar.setBounds(153, 339, 89, 23);
		contentPane.add(btnapagar);
		
		JLabel lblNewLabel_2 = new JLabel("Idade:");
		lblNewLabel_2.setBounds(47, 204, 62, 14);
		contentPane.add(lblNewLabel_2);
		
		txtidade = new JTextField();
		txtidade.setBounds(119, 199, 53, 20);
		contentPane.add(txtidade);
		txtidade.setColumns(10);
		
		
		
		
		
		//TABELA:
		tableagenda.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "Sobrenome", "Idade", "Telefone"
			}
		));
		tableagenda.getColumnModel().getColumn(0).setPreferredWidth(42);
		tableagenda.getColumnModel().getColumn(1).setPreferredWidth(146);
		tableagenda.getColumnModel().getColumn(2).setPreferredWidth(121);
		tableagenda.getColumnModel().getColumn(3).setPreferredWidth(54);
		tableagenda.getColumnModel().getColumn(4).setPreferredWidth(178);
		
		txttelefone = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		txttelefone.setBounds(119, 226, 123, 17);
		contentPane.add(txttelefone);
		
		mostraRegistros();
	
		
	
		
		
		
		//Ações dos butões:
		
				//Botão adicionar:
				btnadd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtid.getText().isEmpty()) {
							
							
							contato.setNome(txtnome.getText());
							contato.setSobrenome(txtsobrenome.getText());
							contato.setIdade(Integer.parseInt(txtidade.getText()));
							contato.setTelefone(txttelefone.getText());
							
							try {
								dao.salvarDao(contato);
								//mensagem("Contato Salvo com SUCESSO!");
							}catch(Exception e1){
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(btnadd,"Contato Salvo com Sucesso!");
							
						}else {
							JOptionPane.showMessageDialog(btnadd,"Não é possível cadastrar um contato já existente!");
							//mensagem("Não é possível cadastrar um contato já existente! ");
						}
					}
				});
				
				btneditar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!txtidade.getText().isEmpty()) {
								
								contato.setId(Long.parseLong(txtid.getText()));
								contato.setNome(txtnome.getText());
								contato.setSobrenome(txtsobrenome.getText());
								contato.setIdade(Integer.parseInt(txtidade.getText()));
								contato.setTelefone(txttelefone.getText());
								try {
									dao.editarDao(contato);
								}catch(Exception e1) {
									e1.printStackTrace();
								}
								
								limpaRegistros();
								JOptionPane.showMessageDialog(btneditar,"Contato Editado com Sucesso!");
						}else {
							JOptionPane.showMessageDialog(btneditar,"Não é possível editar um contato não existente!");
						}
					}
				});
				
				btnapagar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int num = tableagenda.getSelectedRow();
						
						System.out.println(tableagenda.getValueAt(num, 0));
						
						long id = (long) tableagenda.getValueAt(num, 0);
						
						dao.deletarDao(id);
						limpaRegistros();
						JOptionPane.showMessageDialog(btnapagar, "Usuário deletado com sucesso.");	
					}
				});
				
				
				btnlistar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						int num = tableagenda.getSelectedRow();
					
						txtid.setText(tableagenda.getValueAt(num, 0).toString());
						txtnome.setText(tableagenda.getValueAt(num, 1).toString());
						txtsobrenome.setText(tableagenda.getValueAt(num, 2).toString());
						txtidade.setText(tableagenda.getValueAt(num, 3).toString());
						txttelefone.setText(tableagenda.getValueAt(num, 4).toString());
						
					}
				});
				
				
					
	}
	//Métodos úteis:
	public void limpaTela() {
		txtid.setText("");
		txtnome.setText("");
		txtsobrenome.setText("");
		txtidade.setText("");
		txttelefone.setText("");
		
		
	} 
	
	public void mostraRegistros() {
		
		List<Contato> contatos = dao.consultarDao();
		
		DefaultTableModel modelo = (DefaultTableModel) tableagenda.getModel();
		
		for(Contato contato: contatos) {
			
			modelo.addRow(new Object[] {contato.getId(),
					contato.getNome(),
					contato.getSobrenome(),
					contato.getIdade(),
					contato.getTelefone()});
		}
		
	}

	public void limpaRegistros(){
		
		DefaultTableModel modelo = (DefaultTableModel) tableagenda.getModel();
			modelo.setNumRows(0);
		
		limpaTela();
		mostraRegistros();	
	}
}
