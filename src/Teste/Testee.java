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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

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
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\teste\\OneDrive\\\u00C1rea de Trabalho\\download.jfif"));
		setTitle("Programa\u00E7\u00E3o Java");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 531);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("+");
		mnNewMenu.setForeground(new Color(0, 0, 0));
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnNewMenu.setBackground(new Color(0, 0, 0));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuconsultaavancada = new JMenuItem("Consulta Avan\u00E7ada");
		
		menuconsultaavancada.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		menuconsultaavancada.setBackground(SystemColor.info);
		mnNewMenu.add(menuconsultaavancada);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblnome = new JLabel("Nome:");
		lblnome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblsobrenome = new JLabel("Sobrenome:");
		lblsobrenome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lbltel = new JLabel("Telefone:");
		lbltel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtnome = new JTextField();
		txtnome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtnome.setColumns(10);
		
		txtsobrenome = new JTextField();
		txtsobrenome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtsobrenome.setColumns(10);
		
		JButton btnadd = new JButton("Adicionar");
		
		JButton btneditar = new JButton("Editar");
		
		JLabel lblNewLabel = new JLabel("Agenda");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 28));
		
		JScrollPane scrollPane = new JScrollPane();
		
		tableagenda = new JTable();
		tableagenda.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(tableagenda);
		tableagenda.setForeground(Color.WHITE);
		tableagenda.setBackground(Color.BLACK);
		tableagenda.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_1 = new JLabel("id:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtid = new JTextField();
		txtid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtid.setEditable(false);
		txtid.setColumns(10);
		
		JButton btnlistar = new JButton("Listar");
		
		JButton btnapagar = new JButton("Excluir");
		
		JLabel lblNewLabel_2 = new JLabel("Idade:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtidade = new JTextField();
		txtidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtidade.setColumns(10);
		
		
		
		
		
		//TABELA:
		mostraRegistros();
		
		txttelefone = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		txttelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnlimpar = new JButton("Limpar Campos");
		
		JLabel lblNewLabel_3 = new JLabel("Cadastro");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Impact", Font.PLAIN, 28));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btneditar, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
							.addGap(19)
							.addComponent(btnapagar, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(btnlimpar, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(lbltel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblnome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblsobrenome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
										.addComponent(btnadd, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
									.addGap(19)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtsobrenome, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtidade, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
										.addComponent(txttelefone, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtnome, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtid, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(btnlistar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(78)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
							.addGap(5))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addGap(166))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(107)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblnome)
							.addGap(16)
							.addComponent(lblsobrenome)
							.addGap(18)
							.addComponent(lblNewLabel_2)
							.addGap(11)
							.addComponent(lbltel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(txtnome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(txtsobrenome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(txtidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(txttelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnadd)
						.addComponent(btnlistar))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btneditar)
						.addComponent(btnapagar))
					.addGap(11)
					.addComponent(btnlimpar))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
					.addGap(6))
		);
		contentPane.setLayout(gl_contentPane);
	
		
	
		
		
		
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
							mostraRegistros();
							limpaTela();
							JOptionPane.showMessageDialog(null,"Contato Salvo com Sucesso!");
							
						}else {
							JOptionPane.showMessageDialog(null,"Não é possível cadastrar um contato já existente!");
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
								mostraRegistros();
								JOptionPane.showMessageDialog(null,"Contato Editado com Sucesso!");
						}else {
							JOptionPane.showMessageDialog(null,"Não é possível editar um contato não existente!");
						}
					}
				});
				
				btnapagar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int num = tableagenda.getSelectedRow();
						
						if(!tableagenda.isRowSelected(num) == false ) {
						
							//System.out.println(tableagenda.getValueAt(num, 0));
							long id = (long) tableagenda.getValueAt(num, 0);
							int resultado= JOptionPane.showConfirmDialog(null, "Tem certeza que quer deletar o contato ?");
							if(resultado==JOptionPane.YES_OPTION) {
								dao.deletarDao(id);
								limpaRegistros();
								mostraRegistros();
								JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso.");
							}else {
								JOptionPane.showMessageDialog(null, "Ótima escolha!");
							}
							
							
								
						}else {
							JOptionPane.showMessageDialog(null,"Selecione um usuário na tabela!");
						}
					}
				});
				
				
				btnlistar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						int num = tableagenda.getSelectedRow();
						if(!tableagenda.isRowSelected(num) == false ) {
							txtid.setText(tableagenda.getValueAt(num, 0).toString());
							txtnome.setText(tableagenda.getValueAt(num, 1).toString());
							txtsobrenome.setText(tableagenda.getValueAt(num, 2).toString());
							txtidade.setText(tableagenda.getValueAt(num, 3).toString());
							txttelefone.setText(tableagenda.getValueAt(num, 4).toString());
							
						}else {
							JOptionPane.showMessageDialog(btnapagar, "Selecione um usuário na tabela!");	
						}
						
					}
				});
				btnlimpar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						limpaTela();
					}
				});
				
				
				
				
				
				//Menu Eventos:
				
				menuconsultaavancada.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Consulta exibir = new Consulta();
						exibir.setVisible(true);
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
