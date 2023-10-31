package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;

public class Servicos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtOS;
	private JTextField txtData;
	private JTextField txtEquipamento;
	private JTextField txtValor;
	private JTextField txtID;

	private PreparedStatement pst;
	private ResultSet rs;
	private Connection con;
	DAO dao = new DAO();
	private JTextField txtDefeito;
	private JTextField txtCliente;
	private JScrollPane scrollPaneCli;
	@SuppressWarnings("rawtypes")
	private JList ListCli;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtSerie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servicos dialog = new Servicos();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("rawtypes")
	public Servicos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Servicos.class.getResource("/img/logo (1).png")));
		setTitle("Servicos");
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPaneCli.setVisible(false);
			}
		});
		getContentPane().setBackground(new Color(249, 249, 249));
		setModal(true);
		setBounds(100, 100, 541, 378);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblOS = new JLabel("OS:");
		lblOS.setFont(new Font("Arial", Font.PLAIN, 14));
		lblOS.setBounds(20, 21, 46, 14);
		getContentPane().add(lblOS);

		txtOS = new JTextField();
		txtOS.setBackground(SystemColor.controlShadow);
		txtOS.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtOS.setEditable(false);
		txtOS.setBounds(20, 42, 86, 27);
		getContentPane().add(txtOS);
		txtOS.setColumns(10);

		txtData = new JTextField();
		txtData.setFont(new Font("Dialog", Font.PLAIN, 10));
		txtData.setBackground(SystemColor.activeCaptionBorder);
		txtData.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtData.setEditable(false);
		txtData.setColumns(10);
		txtData.setBounds(203, 42, 130, 27);
		getContentPane().add(txtData);

		JLabel lblData = new JLabel("Data e hora:");
		lblData.setFont(new Font("Arial", Font.PLAIN, 14));
		lblData.setBounds(203, 21, 93, 14);
		getContentPane().add(lblData);

		txtEquipamento = new JTextField();
		txtEquipamento.setBackground(SystemColor.control);
		txtEquipamento.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEquipamento.setColumns(10);
		txtEquipamento.setBounds(20, 102, 202, 27);
		getContentPane().add(txtEquipamento);

		JLabel lblEquipamento = new JLabel("Aparelho:");
		lblEquipamento.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEquipamento.setBounds(20, 86, 105, 14);
		getContentPane().add(lblEquipamento);

		JLabel lblDefeito = new JLabel("Defeito:");
		lblDefeito.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDefeito.setBounds(20, 186, 105, 14);
		getContentPane().add(lblDefeito);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Arial", Font.PLAIN, 14));
		lblValor.setBounds(20, 235, 105, 14);
		getContentPane().add(lblValor);

		txtValor = new JTextField();
		txtValor.setBackground(SystemColor.control);
		txtValor.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtValor.setColumns(10);
		txtValor.setBounds(20, 252, 190, 27);
		getContentPane().add(txtValor);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 10));
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarOS();
			}
		});
		btnBuscar.setToolTipText("Buscar");
		btnBuscar.setBounds(116, 41, 77, 23);
		getContentPane().add(btnBuscar);

		JButton btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(Servicos.class.getResource("/img/adicionarrr.png")));
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnAdd.setToolTipText("Adicionar");
		btnAdd.setBounds(225, 277, 48, 48);
		getContentPane().add(btnAdd);

		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(Servicos.class.getResource("/img/editarrr.png")));
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarOS();

			}
		});
		btnEditar.setToolTipText("Editar");
		btnEditar.setBounds(283, 277, 48, 48);
		getContentPane().add(btnEditar);

		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(Servicos.class.getResource("/img/trashhh.png")));
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirOS();
			}
		});
		btnExcluir.setBounds(344, 277, 48, 48);
		getContentPane().add(btnExcluir);

		txtDefeito = new JTextField();
		txtDefeito.setBackground(SystemColor.control);
		txtDefeito.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtDefeito.setColumns(10);
		txtDefeito.setBounds(20, 203, 490, 27);
		getContentPane().add(txtDefeito);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(343, 11, 167, 80);
		getContentPane().add(panel);
		panel.setLayout(null);

		txtCliente = new JTextField();
		txtCliente.setBackground(SystemColor.control);
		txtCliente.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listarClientes();
			}

		});
		
				scrollPaneCli = new JScrollPane();
				scrollPaneCli.setBounds(10, 39, 139, 31);
				panel.add(scrollPaneCli);
				scrollPaneCli.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				scrollPaneCli.setVisible(false);
				
						ListCli = new JList();
						ListCli.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								buscarClienteLista();
							}
						});
						scrollPaneCli.setViewportView(ListCli);
		txtCliente.setBounds(10, 22, 139, 27);
		panel.add(txtCliente);
		txtCliente.setColumns(10);

		txtID = new JTextField();
		txtID.setBackground(SystemColor.activeCaptionBorder);
		txtID.setEditable(false);
		txtID.setBounds(30, 52, 60, 20);
		panel.add(txtID);
		txtID.setColumns(10);

		JLabel lblIdDoCliente = new JLabel("ID:");
		lblIdDoCliente.setBounds(9, 54, 25, 14);
		panel.add(lblIdDoCliente);
		lblIdDoCliente.setFont(new Font("Arial", Font.PLAIN, 14));

		JButton btnLimpar = new JButton("");
		btnLimpar.setIcon(new ImageIcon(Servicos.class.getResource("/img/borracha.png")));
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setToolTipText("Limpar todos o campos");
		btnLimpar.setBounds(402, 277, 48, 48);
		getContentPane().add(btnLimpar);

		JButton btnImprimir = new JButton("");
		btnImprimir.setToolTipText("Imprimir esta OS");
		btnImprimir.setIcon(new ImageIcon(Servicos.class.getResource("/img/printer.png")));
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImprimirOS();
			}
		});
		btnImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnImprimir.setBounds(460, 277, 48, 48);
		getContentPane().add(btnImprimir);

		txtMarca = new JTextField();
		txtMarca.setBackground(SystemColor.control);
		txtMarca.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtMarca.setColumns(10);
		txtMarca.setBounds(232, 102, 278, 27);
		getContentPane().add(txtMarca);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMarca.setBounds(232, 86, 278, 14);
		getContentPane().add(lblMarca);

		txtModelo = new JTextField();
		txtModelo.setBackground(SystemColor.control);
		txtModelo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtModelo.setColumns(10);
		txtModelo.setBounds(20, 155, 202, 27);
		getContentPane().add(txtModelo);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblModelo.setBounds(20, 138, 105, 14);
		getContentPane().add(lblModelo);

		txtSerie = new JTextField();
		txtSerie.setBackground(SystemColor.control);
		txtSerie.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtSerie.setColumns(10);
		txtSerie.setBounds(232, 155, 278, 27);
		getContentPane().add(txtSerie);

		JLabel lblSerie = new JLabel("Número de série:");
		lblSerie.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSerie.setBounds(232, 138, 178, 14);
		getContentPane().add(lblSerie);

	}
	/**
	 * Metodo responsavel por: buscar OS pelo numera OS.
	 */
	private void buscarOS() {
		
		String numOS = JOptionPane.showInputDialog("Número da OS ");

		if (numOS != null) {
			String read = "select * from servicos inner join clientes on servicos.idcli = clientes.idcli where os = ?";
			try {
				
				con = dao.conectar();
			
				pst = con.prepareStatement(read);

			
				pst.setString(1, numOS);
			
				rs = pst.executeQuery();
				
				if (rs.next()) {
					

					txtOS.setText(rs.getString(1));
					txtData.setText(rs.getString(2)); 
					txtEquipamento.setText(rs.getString(3)); 
					txtMarca.setText(rs.getString(4)); 
					txtModelo.setText(rs.getString(5)); 
					txtSerie.setText(rs.getString(6));
					txtDefeito.setText(rs.getString(7));
					txtValor.setText(rs.getString(8));
					txtID.setText(rs.getString(9)); 
					txtCliente.setText(rs.getString(11)); 
				} else {
					
					JOptionPane.showMessageDialog(null, "OS inexistente");
					
				}
				con.close();

			} catch (Exception e) {
				System.out.println(e);

			}
		}

	}
	/**
	 * Metodo responsavel por: adicionar OS.
	 */
	private void adicionar() {

	

		if (txtEquipamento.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o aparelho");
			txtEquipamento.requestFocus();
		} else if (txtDefeito.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o defeito");
			txtDefeito.requestFocus();
		} else if (txtValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o valor");
			txtValor.requestFocus();
		} else {
		
			String create = "insert into servicos(equipamento,marca, modelo, serie, defeito,valor, idcli) values (?,?,?,?, ?, ?,?)";
			
			try {
			
				con = dao.conectar();
			
				pst = con.prepareStatement(create);
				pst.setString(1, txtEquipamento.getText());
				pst.setString(2, txtMarca.getText());
				pst.setString(3, txtModelo.getText());
				pst.setString(4, txtSerie.getText());
				pst.setString(5, txtDefeito.getText());
				pst.setString(6, txtValor.getText());
				pst.setString(7, txtID.getText());
			
				pst.executeUpdate();
			
				JOptionPane.showMessageDialog(null, "OS adicionada");
				
				limparCampos();

			
				con.close();
			}catch(com.mysql.cj.jdbc.exceptions.MysqlDataTruncation se) {
				JOptionPane.showMessageDialog(null, "Cliente não encontrado");
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "OS não adicionada.\nEsta OS já está sendo utilizada.");
				txtOS.setText(null);
				txtOS.requestFocus();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}

	}
	/**
	 * Metodo responsavel por: editar a OS .
	 */
	private void editarOS() {

		
		if (txtEquipamento.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo do aparelho");
			txtEquipamento.requestFocus();

		} else if (txtDefeito.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo defeito");
			txtDefeito.requestFocus();

		} else if (txtValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo valor");
			txtValor.requestFocus();

		} else {
		
			String update = "update servicos set equipamento=?, marca=?, modelo=?, serie=?, defeito=?, valor=?, idcli=? where os=?";
			
			try {
			
				con = dao.conectar();
				
				pst = con.prepareStatement(update);
				pst.setString(1, txtEquipamento.getText());
				pst.setString(2, txtDefeito.getText());
				pst.setString(3, txtValor.getText());
				pst.setString(4, txtID.getText());
				pst.setString(5, txtOS.getText());

			
				pst.executeUpdate();
			
				JOptionPane.showMessageDialog(null, "Dados do usuario editados com sucesso!");
				
				limparCampos();
				
				con.close();

			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Cliente não editado.\nEsta OS já está sendo utilizada.");
				txtOS.setText(null);
				txtOS.requestFocus();

			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}
	/**
	 * Metodo responsavel por: excluir a OS.
	 */
	private void excluirOS() {

		if (txtEquipamento.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo do aparelho");
			txtEquipamento.requestFocus();

		} else if (txtDefeito.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo defeito");
			txtDefeito.requestFocus();

		} else if (txtValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo valor");
			txtValor.requestFocus();

		} else {

			int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão desta OS?", "Atenção",
					JOptionPane.YES_NO_OPTION);

			if (confirma == JOptionPane.YES_OPTION) {

				String delete = "delete from servicos where os=?";

				try {

					con = dao.conectar();

					pst = con.prepareStatement(delete);
					pst.setString(1, txtOS.getText());

					pst.executeUpdate();

					JOptionPane.showMessageDialog(null, "OS excluida");

					limparCampos();

					con.close();

				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}
	/**
	 * Metodo responsavel por: limpar os campos.
	 */
	private void limparCampos() {
	
		txtOS.setText(null);
		txtData.setText(null);
		txtEquipamento.setText(null);
		txtDefeito.setText(null);
		txtValor.setText(null);
		txtID.setText(null);
		txtCliente.setText(null);
		txtSerie.setText(null);
		txtMarca.setText(null);
		txtModelo.setText(null);

	}
	/**
	 * Metodo responsavel por: listar clientes pelo nome.
	 */
	@SuppressWarnings("unchecked")
	private void listarClientes() {
		DefaultListModel<String> modelo = new DefaultListModel<>();

		ListCli.setModel(modelo);

		String readLista = "select * from clientes where nome like '" + txtCliente.getText() + "%'" + "order by nome";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(readLista);
			rs = pst.executeQuery();

			while (rs.next()) {
				modelo.addElement(rs.getString(2));
				scrollPaneCli.setVisible(true);

				if (txtCliente.getText().isEmpty()) {
					scrollPaneCli.setVisible(false);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	/**
	 * Metodo responsavel por: buscar cliente pelo nome.
	 */
	private void buscarClienteLista() {

		int linha = ListCli.getSelectedIndex();

		if (linha >= 0) {

			String readBuscaLista = "select *from clientes where nome like '" + txtCliente.getText() + "%'"

					+ "order by nome limit " + (linha) + " ,1";

			try {

				con = dao.conectar();

				pst = con.prepareStatement(readBuscaLista);

				rs = pst.executeQuery();

				if (rs.next()) {

					scrollPaneCli.setVisible(false);

					txtID.setText(rs.getString(1));
					txtCliente.setText(rs.getString(2));

				} else {

					JOptionPane.showMessageDialog(null, "Cliente inexistente");

				}

				con.close();

			} catch (Exception e) {

			}

		} else {

			scrollPaneCli.setVisible(false);

		}
	}
	/**
	 * Metodo responsavel por: abrir uma das escolhas de qual OS imprimir.
	 */
	private void ImprimirOS() {
		int choice = showPrintOptionsDialog();

		if (choice == JOptionPane.YES_OPTION) {

			imprimirOSCliente();
		} else if (choice == JOptionPane.NO_OPTION) {

			imprimirOSEmpresa();
		} else {

		}

	}
	/**
	 * Metodo responsavel por: escrever as opcoes de qual impressao escolher.
	 */
	private static int showPrintOptionsDialog() {
		Object[] options = { "Imprimir Via Cliente", "Imprimir Via Empresa" };
		return JOptionPane.showOptionDialog(null, "Escolha qual via imprimir:", "Opções de Impressão",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

	}
	/**
	 * Metodo responsavel por: imprimir a OS do cliente.
	 */
	private void imprimirOSCliente() {

		Document document = new Document();

		if (txtEquipamento.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo do aparelho");
			txtEquipamento.requestFocus();

		} else if (txtDefeito.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo defeito");
			txtDefeito.requestFocus();

		} else if (txtValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo valor");
			txtValor.requestFocus();

		} else {

			try {

				PdfWriter.getInstance(document, new FileOutputStream("oscliente.pdf"));

				document.open();

				String readOS = "select * from servicos inner join clientes on servicos.idcli = clientes.idcli where os=?";

				try {

					con = dao.conectar();

					pst = con.prepareStatement(readOS);
					pst.setString(1, txtOS.getText());

					rs = pst.executeQuery();

					if (rs.next()) {

						Image imagem = Image.getInstance(Servicos.class.getResource("/img/Logo.png"));
					
						imagem.scaleToFit(128, 128);

						imagem.setAlignment(Element.ALIGN_LEFT);
						document.add(imagem);

						Paragraph OS = new Paragraph("SP ASSISTÊNCIA TV");
						OS.setAlignment(Element.ALIGN_CENTER);
						document.add(OS);

						Paragraph via = new Paragraph(" (Via cliente) ");
						via.setAlignment(Element.ALIGN_CENTER);
						document.add(via);

						Paragraph cp = new Paragraph("COMPROVANTE DE RETIRADA",
								FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD));
						cp.setAlignment(Element.ALIGN_RIGHT);
						document.add(cp);

						Paragraph space = new Paragraph(" ");
						space.setAlignment(Element.ALIGN_MIDDLE);
						document.add(space);

						Paragraph desc = new Paragraph(
								" Pessoa Jurídica \n CNPJ: 20992924000129  INSC. ESTADUAL   INS. MUNICIPAL \n Endereço: Rua Tabapuã, 648 Loja 1 - Loja 1 \n Laboratório Técnico: Rua Carlos Censi, 56 \n (11) 947485487        Email: spassistenciavi@gmail.com");
						desc.setAlignment(Element.ALIGN_LEFT);
						document.add(desc);

						Paragraph desc2 = new Paragraph("\n SERVIÇO ESPECIALIZADO",
								FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD));
						desc2.setAlignment(Element.ALIGN_LEFT);
						document.add(desc2);

						Paragraph TVS = new Paragraph(
								" TV LED - TV LCD - TV PLASMA - 4K - SAMSUNG \n LG - AOC - PHILIPS - TOSHIBA");
						TVS.setAlignment(Element.ALIGN_RIGHT);
						document.add(TVS);

						Paragraph os = new Paragraph("OS: " + rs.getString(1) + "\n",
								FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD));
						os.setAlignment(Element.ALIGN_RIGHT);

						document.add(os);

						Paragraph nome = new Paragraph("Cliente: " + rs.getString(11));
						nome.setAlignment(Element.ALIGN_LEFT);
						document.add(nome);

						Paragraph endereco = new Paragraph("Endereço: " + rs.getString(15));
						endereco.setAlignment(Element.ALIGN_LEFT);
						document.add(endereco);

						Paragraph bairro = new Paragraph("Bairro: " + rs.getString(18));
						bairro.setAlignment(Element.ALIGN_LEFT);
						document.add(bairro);

						Paragraph aparelho = new Paragraph("\n Dados do aparelho: \n   ",
								FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD));
						aparelho.setAlignment(Element.ALIGN_MIDDLE);
						document.add(aparelho);

						PdfPTable tabela = new PdfPTable(4);
						PdfPCell col1 = new PdfPCell(new Paragraph("Equipamento: "));

						PdfPCell col2 = new PdfPCell(new Paragraph("Marca: "));

						PdfPCell col3 = new PdfPCell(new Paragraph("Modelo: "));

						PdfPCell col4 = new PdfPCell(new Paragraph("Número de série: "));

						tabela.addCell(col1);
						tabela.addCell(col2);
						tabela.addCell(col3);
						tabela.addCell(col4);

						tabela.addCell(rs.getString(3));
						tabela.addCell(rs.getString(4));
						tabela.addCell(rs.getString(5));
						tabela.addCell(rs.getString(6));

						document.add(tabela);

						Paragraph def = new Paragraph("Defeito: (estado do aparelho ou acessório) \n" + rs.getString(7)
								+ "\n________________________________________________________________");
						def.setAlignment(Element.ALIGN_LEFT);
						document.add(def);

						Paragraph assin = new Paragraph(
								"\n \n __________________  \n \n SP Assistência TV                                                                      São Paulo ____/____/____  ");
						assin.setAlignment(Element.ALIGN_LEFT);
						document.add(assin);

						Paragraph under = new Paragraph(
								"\n \n________________________________________________________________________ \n");
						under.setAlignment(Element.ALIGN_LEFT);
						document.add(under);

						Paragraph ap = new Paragraph(
								"Eu estou ciente que o aparelho acima está sendo retirado pela SP ASSISTÊNCIA TV para reparo. \n");
						ap.setAlignment(Element.ALIGN_LEFT);
						document.add(ap);

						Paragraph data = new Paragraph("Data OS: " + rs.getString(2));
						data.setAlignment(Element.ALIGN_CENTER);
						document.add(data);
					}

					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				document.close();

				try {

					Desktop.getDesktop().open(new File("oscliente.pdf"));
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}
	/**
	 * Metodo responsavel por: imprimir a OS da empresa.
	 */
	private void imprimirOSEmpresa() {

		Document document = new Document();

		if (txtEquipamento.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo do aparelho");
			txtEquipamento.requestFocus();

		} else if (txtDefeito.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo defeito");
			txtDefeito.requestFocus();

		} else if (txtValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo valor");
			txtValor.requestFocus();

		} else if (txtModelo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o campo modelo");
			txtModelo.requestFocus();

		} else {

			try {

				PdfWriter.getInstance(document, new FileOutputStream("osempresa.pdf"));

				document.open();

				String readOS = "select * from servicos inner join clientes on servicos.idcli = clientes.idcli where os=?";

				try {

					con = dao.conectar();

					pst = con.prepareStatement(readOS);
					pst.setString(1, txtOS.getText());

					rs = pst.executeQuery();

					if (rs.next()) {

						Image imagem = Image.getInstance(Servicos.class.getResource("/img/Logo.png"));
						
						imagem.scaleToFit(128, 128);

						imagem.setAlignment(Element.ALIGN_LEFT);
						document.add(imagem);

						Paragraph OS = new Paragraph("SP ASSISTÊNCIA TV");
						OS.setAlignment(Element.ALIGN_CENTER);
						document.add(OS);

						Paragraph via = new Paragraph(" (Via empresa) ");
						via.setAlignment(Element.ALIGN_CENTER);
						document.add(via);

						Paragraph cp = new Paragraph("COMPROVANTE DE RETIRADA",
								FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD));
						cp.setAlignment(Element.ALIGN_RIGHT);
						document.add(cp);

						Paragraph space = new Paragraph(" ");
						space.setAlignment(Element.ALIGN_MIDDLE);
						document.add(space);

						Paragraph space2 = new Paragraph(" ");
						space2.setAlignment(Element.ALIGN_MIDDLE);
						document.add(space2);

						Paragraph desc2 = new Paragraph("SERVIÇO ESPECIALIZADO",
								FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD));
						desc2.setAlignment(Element.ALIGN_LEFT);
						document.add(desc2);

						Paragraph TVS = new Paragraph(
								" TV LED - TV LCD - TV PLASMA - 4K - SAMSUNG \n LG - AOC - PHILIPS - TOSHIBA");
						TVS.setAlignment(Element.ALIGN_RIGHT);
						document.add(TVS);

						Paragraph os = new Paragraph("OS: " + rs.getString(1) + "\n",
								FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD));
						os.setAlignment(Element.ALIGN_RIGHT);

						document.add(os);

						Paragraph nome = new Paragraph("Cliente: " + rs.getString(11));
						nome.setAlignment(Element.ALIGN_LEFT);
						document.add(nome);

						Paragraph endereco = new Paragraph("Endereço: " + rs.getString(15));
						endereco.setAlignment(Element.ALIGN_LEFT);
						document.add(endereco);

						Paragraph bairro = new Paragraph("Bairro: " + rs.getString(18));
						bairro.setAlignment(Element.ALIGN_LEFT);
						document.add(bairro);

						Paragraph aparelho = new Paragraph("\n Dados do aparelho: \n   ",
								FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD));
						aparelho.setAlignment(Element.ALIGN_MIDDLE);
						document.add(aparelho);

						PdfPTable tabela = new PdfPTable(4);
						PdfPCell col1 = new PdfPCell(new Paragraph("Equipamento: "));

						PdfPCell col2 = new PdfPCell(new Paragraph("Marca: "));

						PdfPCell col3 = new PdfPCell(new Paragraph("Modelo: "));

						PdfPCell col4 = new PdfPCell(new Paragraph("Número de série: "));

						tabela.addCell(col1);
						tabela.addCell(col2);
						tabela.addCell(col3);
						tabela.addCell(col4);

						tabela.addCell(rs.getString(3));
						tabela.addCell(rs.getString(4));
						tabela.addCell(rs.getString(5));
						tabela.addCell(rs.getString(6));

						document.add(tabela);

						Paragraph def = new Paragraph("Defeito: (estado do aparelho ou acessório) \n" + rs.getString(7)
								+ "\n\n________________________________________________________________");
						def.setAlignment(Element.ALIGN_LEFT);
						document.add(def);

						Paragraph assin = new Paragraph(
								"\n \n \n \n \n__________________ \n \n Ass. Responsável                                                                     São Paulo ____/____/____ \n ");
						assin.setAlignment(Element.ALIGN_LEFT);
						document.add(assin);

						Paragraph under = new Paragraph(
								"\n \n________________________________________________________________________ \n");
						under.setAlignment(Element.ALIGN_LEFT);
						document.add(under);

						Paragraph ap = new Paragraph(
								"Eu estou ciente que o aparelho acima está sendo retirado pela SP ASSISTÊNCIA TV para reparo. \n");
						ap.setAlignment(Element.ALIGN_LEFT);
						document.add(ap);

						Paragraph data = new Paragraph("Data da emissão da OS: " + rs.getString(2));
						data.setAlignment(Element.ALIGN_CENTER);
						document.add(data);
					}

					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				document.close();

				try {

					Desktop.getDesktop().open(new File("osempresa.pdf"));
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}
}