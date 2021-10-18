package Teste;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.awt.Toolkit;

public class Consulta extends JFrame {

	private JPanel contentPane;
	private JTable tablepesquisaavancada;
	private JFormattedTextField txtpesquisaid;
	private JCheckBoxMenuItem cboxtelefone;
	private JCheckBoxMenuItem cboxidade;
	private JCheckBoxMenuItem cboxsobrenome;
	private JCheckBoxMenuItem cboxnome;
	private JCheckBoxMenuItem cboxid;
	private List<Contato> contatos;
	private DefaultTableModel modelo;
	
	ContatoDao dao = new ContatoDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulta frame = new Consulta();
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
	public Consulta() {
		setTitle("Pesquisa Avan\u00E7ada");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\teste\\OneDrive\\\u00C1rea de Trabalho\\lupa.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 727, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblpesquisa = new JLabel("Pesquisar:");
		lblpesquisa.setHorizontalAlignment(SwingConstants.TRAILING);
		lblpesquisa.setBounds(10, 146, 102, 23);
		lblpesquisa.setFont(new Font("SansSerif", Font.BOLD, 16));
		
		JButton btnpesquisar = new JButton("PESQUISAR");
		
		btnpesquisar.setBounds(80, 189, 137, 29);
		btnpesquisar.setFont(new Font("SansSerif", Font.BOLD, 16));
		contentPane.setLayout(null);
		contentPane.add(lblpesquisa);
		contentPane.add(btnpesquisar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(245, 89, 456, 340);
		contentPane.add(scrollPane);
		
		tablepesquisaavancada = new JTable();
		tablepesquisaavancada.setFont(new Font("SansSerif", Font.BOLD, 16));
		tablepesquisaavancada.setForeground(Color.WHITE);
		tablepesquisaavancada.setBackground(Color.BLACK);
		mostraRegistros();
		scrollPane.setViewportView(tablepesquisaavancada);
		
		JButton btnreset = new JButton("RESET");
		
		btnreset.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnreset.setBounds(80, 229, 137, 29);
		contentPane.add(btnreset);
		
		cboxid = new JCheckBoxMenuItem("ID");
		
		cboxid.setBounds(10, 269, 124, 26);
		contentPane.add(cboxid);
		
		cboxnome = new JCheckBoxMenuItem("Nome");
		cboxnome.setBounds(10, 302, 124, 26);
		contentPane.add(cboxnome);
		
		cboxsobrenome = new JCheckBoxMenuItem("Sobrenome");
		cboxsobrenome.setBounds(10, 339, 124, 26);
		contentPane.add(cboxsobrenome);
		
		cboxidade = new JCheckBoxMenuItem("Idade");
		cboxidade.setBounds(10, 376, 124, 26);
		contentPane.add(cboxidade);
		
		cboxtelefone = new JCheckBoxMenuItem("Telefone");
		cboxtelefone.setBounds(10, 413, 124, 26);
		contentPane.add(cboxtelefone);
		
		txtpesquisaid = new JFormattedTextField();
		txtpesquisaid.setFont(new Font("SansSerif", Font.BOLD, 16));
		txtpesquisaid.setBounds(112, 144, 60, 27);
		contentPane.add(txtpesquisaid);
		
		
		
		
		
		
		
		
		
		
		
		
		//Ações dos botões:
		
		btnpesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {					
				if(cboxid.isSelected()) {
							buscarid();
				}
				
				else if(cboxnome.isSelected()) {
					
					contatos = dao.BuscarNomeDao(txtpesquisaid.getText().replaceAll("\\s+",""));
					
					criartabela();
					
					for(Contato contato: contatos) {
						
						modelo.addRow(new Object[] {contato.getId(),
								contato.getNome(),
								contato.getSobrenome(),
								contato.getIdade(),
								contato.getTelefone()});
					}
					
					
				}
				else if(cboxsobrenome.isSelected()) {
					contatos = dao.BuscarSobrenomeDao(txtpesquisaid.getText().replaceAll("\\s+",""));
					
					criartabela();
					
					for(Contato contato: contatos) {
						
						modelo.addRow(new Object[] {contato.getId(),
								contato.getNome(),
								contato.getSobrenome(),
								contato.getIdade(),
								contato.getTelefone()});
					}
					
				}
				else if(cboxidade.isSelected()) {
					
					contatos = dao.BuscarIdadeDao(Integer.parseInt(txtpesquisaid.getText().replaceAll("\\s+","")));
					
					criartabela();
					
					for(Contato contato: contatos) {
						
						modelo.addRow(new Object[] {contato.getId(),
								contato.getNome(),
								contato.getSobrenome(),
								contato.getIdade(),
								contato.getTelefone()});
					}
					
				}
				else if(cboxtelefone.isSelected()) {

					contatos = dao.BuscarTelefoneDao(txtpesquisaid.getText().replaceAll("\\s+",""));
					
					criartabela();
					
					for(Contato contato: contatos) {
						
						modelo.addRow(new Object[] {contato.getId(),
								contato.getNome(),
								contato.getSobrenome(),
								contato.getIdade(),
								contato.getTelefone()});
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Selecione o que quer pesquisar!");
				}
				
			}
		});
		
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpaTela();
				mostraRegistros();
			}
		});
		
		
		
		//Ações dos CheckBox:
		
		cboxid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboxnome.setSelected(false);
				cboxsobrenome.setSelected(false);
				cboxidade.setSelected(false);
				cboxtelefone.setSelected(false);
				
				lblpesquisa.setText("ID:");
				txtpesquisaid.setText("");
				txtpesquisaid.setBounds(112, 144, 60, 27);
				
			}
		});
		
		cboxnome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboxid.setSelected(false);
				cboxsobrenome.setSelected(false);
				cboxidade.setSelected(false);
				cboxtelefone.setSelected(false);
				
				lblpesquisa.setText("Nome:");
				
				txtpesquisaid.setBounds(112, 144, 132, 27);
				txtpesquisaid.setText("");
			}
		});
		
		cboxsobrenome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboxid.setSelected(false);
				cboxnome.setSelected(false);
				cboxidade.setSelected(false);
				cboxtelefone.setSelected(false);
				
				lblpesquisa.setText("Sobrenome:");
				
				txtpesquisaid.setBounds(112, 144, 132, 27);
				txtpesquisaid.setText("");
			}
		});
		
		cboxidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboxid.setSelected(false);
				cboxsobrenome.setSelected(false);
				cboxnome.setSelected(false);
				cboxtelefone.setSelected(false);
				
				lblpesquisa.setText("Idade:");
				
				
				txtpesquisaid.setBounds(112, 144, 60, 27);
				txtpesquisaid.setText("");
				
			}
		});
		
		cboxtelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboxid.setSelected(false);
				cboxsobrenome.setSelected(false);
				cboxidade.setSelected(false);
				cboxnome.setSelected(false);
				
				lblpesquisa.setText("Telefone:");
				
				txtpesquisaid.setBounds(112, 144, 132, 27);
				txtpesquisaid.setText("");
			}
		});
		
	}
	
	
	
	public void limpaTela() {
		txtpesquisaid.setText("");
		cboxid.setSelected(false);
		cboxnome.setSelected(false);
		cboxsobrenome.setSelected(false);
		cboxidade.setSelected(false);
		cboxtelefone.setSelected(false);
	} 
	
		public void mostraRegistros() {
				
				contatos = dao.consultarDao();
				
				criartabela();
				
				for(Contato contato: contatos) {
					
					modelo.addRow(new Object[] {contato.getId(),
							contato.getNome(),
							contato.getSobrenome(),
							contato.getIdade(),
							contato.getTelefone()});
				}
		}
		
		public void buscarid() {
			contatos = dao.BuscarIdDao(Long.parseLong(txtpesquisaid.getText()));
			
			criartabela();
		
		for(Contato contato: contatos) {
			
			modelo.addRow(new Object[] {contato.getId(),
					contato.getNome(),
					contato.getSobrenome(),
					contato.getIdade(),
					contato.getTelefone()});
		}
		
		limpaTela();
		}

		public void criartabela() {
			tablepesquisaavancada.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ID", "Nome", "Sobrenome", "Idade", "Telefone"
					}
				) {
					Class[] columnTypes = new Class[] {
						Long.class, String.class, String.class, Integer.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				tablepesquisaavancada.getColumnModel().getColumn(0).setPreferredWidth(42);
				tablepesquisaavancada.getColumnModel().getColumn(1).setPreferredWidth(167);
				tablepesquisaavancada.getColumnModel().getColumn(2).setPreferredWidth(150);
				tablepesquisaavancada.getColumnModel().getColumn(3).setPreferredWidth(51);
				tablepesquisaavancada.getColumnModel().getColumn(4).setPreferredWidth(176);
			
			modelo = (DefaultTableModel) tablepesquisaavancada.getModel();
		}

}
