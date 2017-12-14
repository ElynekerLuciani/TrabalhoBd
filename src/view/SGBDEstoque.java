package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import model.ModeloTabela;
import model.Fornecedor;
import model.Cliente;
import model.Validar;
import model.Categoria;
import java.awt.event.FocusAdapter;
import javax.swing.JComboBox;

public class SGBDEstoque {

	private JTextField ComplementoC = null;
	private JFrame frame;
	private JTextField NomeCF;
	private JTextField EnderecoCF;
	private JTextField Numero;
	private JTextField Complemento;
	private JTextField Telefone1CF;
	private JTextField Telefone2CF;
	private JTextField EmailCF;
	private ButtonGroup radios = new ButtonGroup();
	private JTextField CpfCF;
	private JTextField CnpjCF;
	private String[] VisualizarFornecedores = new String[] { "Id", "Nome", "CPF/CNPJ", "Telefone1", "Telefone2",
			"E-mail" };
	private String[] VisualizarCli = new String[] { "Id", "Nome", "CPF", "Telefone1", "Telefone2", "E-mail" };
	private JTable VFornecedores;
	private JTable VClientes;
	private JTextField txtId;
	private JTextField Idcliente;
	private JTextField EnderecoCC;
	private JTextField NumeroC;
	private JTextField Telefone1CC;
	private JTextField Telefone2CC;
	private JTextField EmailCC;
	private JTextField NomeCC;
	private JTextField Cpfcc;
	private JTextField IdProduto;
	private JTextField NomeCP;
	private JTextField DescricaoCP;
	private JTextField ValorCompra;
	private JTextField ValorVendaCP;
	private JTextField NomeCCA;
	private JTextField IdCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					SGBDEstoque window = new SGBDEstoque();
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
	public SGBDEstoque() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setLocationRelativeTo(null);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("D:\\java\\TrabalhoBD\\imagens\\logo.png"));
		logo.setBounds((int) ((d.getWidth() / 2) - (276 / 2)), 0, 276, 89);
		frame.getContentPane().add(logo);

		// Declarações

		JPanel BotaoHoverFornecedor = new JPanel();

		JPanel BotaoHoverCategoria = new JPanel();

		JPanel BotaoHoverCliente = new JPanel();

		JPanel BotaoHoverProduto = new JPanel();

		JPanel BotaoHoverEstoque = new JPanel();

		JLabel Categoria = DefaultComponentFactory.getInstance().createTitle("Categoria");

		JLabel Cliente = DefaultComponentFactory.getInstance().createTitle("Cliente");

		JLabel Produto = DefaultComponentFactory.getInstance().createTitle("Produto");

		JLabel Estoque = DefaultComponentFactory.getInstance().createTitle("Estoque");

		JLabel CadastrarFornecedores = DefaultComponentFactory.getInstance().createTitle("Cadastrar fornecedores");

		JLabel Visualizarfornecedores = DefaultComponentFactory.getInstance().createTitle("Visualizar fornecedores");

		JPanel ArticleCFornecedor = new JPanel();

		JRadioButton PessoaJuridica = new JRadioButton("Pessoa Juridica");

		JRadioButton PessoaFisica = new JRadioButton("Pessoa F\u00EDsica");

		radios.add(PessoaFisica);

		radios.add(PessoaJuridica);

		JLabel Cpf = DefaultComponentFactory.getInstance().createTitle("C.P.F.:");

		JLabel Cnpj = DefaultComponentFactory.getInstance().createTitle("C.N.P.J.:");

		JLabel Required6 = DefaultComponentFactory.getInstance().createTitle("*");

		JPanel CancelarCCa = new JPanel();
		
		JPanel CadastrarCCa = new JPanel();
		
		JPanel CancelarCF = new JPanel();

		JPanel CancelarCP = new JPanel();

		JPanel CancelarCC = new JPanel();

		JPanel CadastrarCP = new JPanel();

		JPanel CadastrarCF = new JPanel();

		JPanel CadastrarCC = new JPanel();

		JPanel AlterarVF = new JPanel();

		JPanel AlterarVC = new JPanel();

		JPanel ExcluirVF = new JPanel();

		JPanel ExcluirVC = new JPanel();

		JPanel ArticleVFornecedor = new JPanel();

		JPanel ArticleVCliente = new JPanel();

		JPanel ArticleCCliente = new JPanel();

		JLabel CadastrarClientes = DefaultComponentFactory.getInstance().createLabel("Cadastrar clientes");

		JLabel VisualizarClientes = DefaultComponentFactory.getInstance().createLabel("Visualizar clientes");

		JLabel CadastrarProdutos = DefaultComponentFactory.getInstance().createLabel("Cadastrar produtos");

		JLabel VisualizarProdutos = DefaultComponentFactory.getInstance().createLabel("Visualizar produtos");

		JLabel CadastrarCategoria = DefaultComponentFactory.getInstance().createLabel("Cadastrar Categoria");

		JLabel VisualizarCategoria = DefaultComponentFactory.getInstance().createLabel("Visualizar Categoria");

		JPanel ArticleCProdutos = new JPanel();

		JPanel ArticleCCategoria = new JPanel();

		// Declarações

		JLabel Fornecedor = DefaultComponentFactory.getInstance().createTitle("Fornecedor");
		Fornecedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Fornecedor.setForeground(Color.yellow);
				Cliente.setForeground(Color.white);
				Categoria.setForeground(Color.white);
				Produto.setForeground(Color.white);
				Estoque.setForeground(Color.white);
				BotaoHoverFornecedor.setVisible(true);
				BotaoHoverCliente.setVisible(false);
				BotaoHoverCategoria.setVisible(false);
				BotaoHoverProduto.setVisible(false);
				BotaoHoverEstoque.setVisible(false);
				Visualizarfornecedores.setVisible(true);
				CadastrarFornecedores.setVisible(true);
				VisualizarClientes.setVisible(false);
				CadastrarClientes.setVisible(false);
				VisualizarCategoria.setVisible(false);
				CadastrarCategoria.setVisible(false);
				VisualizarClientes.setForeground(Color.white);
				CadastrarClientes.setForeground(Color.white);
				Visualizarfornecedores.setForeground(Color.white);
				CadastrarFornecedores.setForeground(Color.white);
				VisualizarProdutos.setForeground(Color.white);
				CadastrarProdutos.setForeground(Color.white);
				VisualizarCategoria.setForeground(Color.white);
				CadastrarCategoria.setForeground(Color.white);
				ArticleCFornecedor.setVisible(false);
				ArticleVFornecedor.setVisible(false);
				ArticleVCliente.setVisible(false);
				ArticleCCliente.setVisible(false);
				ArticleCProdutos.setVisible(false);
				ArticleCCategoria.setVisible(false);
				// ArticleVProdutos.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (Fornecedor.getForeground() != Color.yellow)
					BotaoHoverFornecedor.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (Fornecedor.getForeground() != Color.yellow)
					BotaoHoverFornecedor.setVisible(false);
			}
		});
		Fornecedor.setForeground(Color.yellow);
		Fornecedor.setFont(new Font("Arial", Font.PLAIN, 16));
		Fornecedor.setBounds(10, 100, 88, 14);
		frame.getContentPane().add(Fornecedor);

		Cliente.setForeground(Color.WHITE);
		Cliente.setFont(new Font("Arial", Font.PLAIN, 16));
		Cliente.setBounds(110, 100, 49, 14);
		frame.getContentPane().add(Cliente);

		Categoria.setForeground(Color.WHITE);
		Categoria.setFont(new Font("Arial", Font.PLAIN, 16));
		Categoria.setBounds(175, 100, 72, 14);
		frame.getContentPane().add(Categoria);

		// Categoria
		Categoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Categoria.setForeground(Color.yellow);
				Cliente.setForeground(Color.white);
				Fornecedor.setForeground(Color.white);
				Produto.setForeground(Color.white);
				Estoque.setForeground(Color.white);
				BotaoHoverCliente.setVisible(false);
				BotaoHoverCategoria.setVisible(true);
				BotaoHoverFornecedor.setVisible(false);
				BotaoHoverProduto.setVisible(false);
				BotaoHoverEstoque.setVisible(false);
				VisualizarClientes.setVisible(false);
				CadastrarClientes.setVisible(false);
				VisualizarProdutos.setVisible(false);
				CadastrarProdutos.setVisible(false);
				VisualizarCategoria.setVisible(true);
				CadastrarCategoria.setVisible(true);
				VisualizarClientes.setForeground(Color.white);
				CadastrarClientes.setForeground(Color.white);
				Visualizarfornecedores.setForeground(Color.white);
				CadastrarFornecedores.setForeground(Color.white);
				VisualizarProdutos.setForeground(Color.white);
				CadastrarProdutos.setForeground(Color.white);
				VisualizarCategoria.setForeground(Color.white);
				CadastrarCategoria.setForeground(Color.white);
				Visualizarfornecedores.setVisible(false);
				CadastrarFornecedores.setVisible(false);
				ArticleCFornecedor.setVisible(false);
				ArticleVFornecedor.setVisible(false);
				ArticleVCliente.setVisible(false);
				ArticleCCliente.setVisible(false);
				// ArticleVProdutos.setVisible(false);
				ArticleCProdutos.setVisible(false);
				ArticleCCategoria.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (Categoria.getForeground() != Color.yellow)
					BotaoHoverCategoria.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (Categoria.getForeground() != Color.yellow)
					BotaoHoverCategoria.setVisible(false);
			}
		});

		// Cliente
		Cliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente.setForeground(Color.yellow);
				Categoria.setForeground(Color.white);
				Fornecedor.setForeground(Color.white);
				Produto.setForeground(Color.white);
				Estoque.setForeground(Color.white);
				BotaoHoverCliente.setVisible(true);
				BotaoHoverCategoria.setVisible(false);
				BotaoHoverFornecedor.setVisible(false);
				BotaoHoverProduto.setVisible(false);
				BotaoHoverEstoque.setVisible(false);
				VisualizarClientes.setVisible(true);
				CadastrarClientes.setVisible(true);
				VisualizarProdutos.setVisible(false);
				CadastrarProdutos.setVisible(false);
				VisualizarCategoria.setVisible(false);
				CadastrarCategoria.setVisible(false);
				VisualizarClientes.setForeground(Color.white);
				CadastrarClientes.setForeground(Color.white);
				Visualizarfornecedores.setForeground(Color.white);
				CadastrarFornecedores.setForeground(Color.white);
				VisualizarProdutos.setForeground(Color.white);
				CadastrarProdutos.setForeground(Color.white);
				VisualizarCategoria.setForeground(Color.white);
				CadastrarCategoria.setForeground(Color.white);
				Visualizarfornecedores.setVisible(false);
				CadastrarFornecedores.setVisible(false);
				ArticleCFornecedor.setVisible(false);
				ArticleVFornecedor.setVisible(false);
				ArticleVCliente.setVisible(false);
				ArticleCCliente.setVisible(false);
				// ArticleVProdutos.setVisible(false);
				ArticleCProdutos.setVisible(false);
				ArticleCCategoria.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (Cliente.getForeground() != Color.yellow)
					BotaoHoverCliente.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (Cliente.getForeground() != Color.yellow)
					BotaoHoverCliente.setVisible(false);
			}
		});

		// Produto
		Produto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Produto.setForeground(Color.yellow);
				Cliente.setForeground(Color.white);
				Categoria.setForeground(Color.white);
				Fornecedor.setForeground(Color.white);
				Estoque.setForeground(Color.white);
				BotaoHoverProduto.setVisible(true);
				BotaoHoverCliente.setVisible(false);
				BotaoHoverCategoria.setVisible(false);
				BotaoHoverFornecedor.setVisible(false);
				BotaoHoverEstoque.setVisible(false);
				Visualizarfornecedores.setVisible(false);
				CadastrarFornecedores.setVisible(false);
				ArticleCFornecedor.setVisible(false);
				ArticleVFornecedor.setVisible(false);
				ArticleCCliente.setVisible(false);
				ArticleVCliente.setVisible(false);
				// ArticleVProdutos.setVisible(false);
				ArticleCProdutos.setVisible(false);
				VisualizarProdutos.setVisible(true);
				CadastrarProdutos.setVisible(true);
				VisualizarClientes.setVisible(false);
				CadastrarClientes.setVisible(false);
				VisualizarCategoria.setVisible(false);
				CadastrarCategoria.setVisible(false);
				ArticleCCategoria.setVisible(false);
				VisualizarClientes.setForeground(Color.white);
				CadastrarClientes.setForeground(Color.white);
				Visualizarfornecedores.setForeground(Color.white);
				CadastrarFornecedores.setForeground(Color.white);
				VisualizarProdutos.setForeground(Color.white);
				CadastrarProdutos.setForeground(Color.white);
				VisualizarCategoria.setForeground(Color.white);
				CadastrarCategoria.setForeground(Color.white);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (Produto.getForeground() != Color.yellow)
					BotaoHoverProduto.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (Produto.getForeground() != Color.yellow)
					BotaoHoverProduto.setVisible(false);
			}
		});
		Produto.setForeground(Color.WHITE);
		Produto.setFont(new Font("Arial", Font.PLAIN, 16));
		Produto.setBounds(259, 100, 55, 14);
		frame.getContentPane().add(Produto);

		// Estoque
		Estoque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Estoque.setForeground(Color.yellow);
				Produto.setForeground(Color.white);
				Cliente.setForeground(Color.white);
				Categoria.setForeground(Color.white);
				Fornecedor.setForeground(Color.white);
				BotaoHoverEstoque.setVisible(true);
				BotaoHoverProduto.setVisible(false);
				BotaoHoverCliente.setVisible(false);
				BotaoHoverCategoria.setVisible(false);
				BotaoHoverFornecedor.setVisible(false);
				Visualizarfornecedores.setVisible(false);
				CadastrarFornecedores.setVisible(false);
				ArticleCFornecedor.setVisible(false);
				ArticleVFornecedor.setVisible(false);
				ArticleCCategoria.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (Estoque.getForeground() != Color.yellow)
					BotaoHoverEstoque.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (Estoque.getForeground() != Color.yellow)
					BotaoHoverEstoque.setVisible(false);
			}
		});
		Estoque.setForeground(Color.WHITE);
		Estoque.setFont(new Font("Arial", Font.PLAIN, 16));
		Estoque.setBounds(338, 100, 58, 14);
		frame.getContentPane().add(Estoque);

		// Visualizar fornecedores
		Visualizarfornecedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Visualizarfornecedores.setForeground(Color.yellow);
				CadastrarFornecedores.setForeground(Color.white);
				ArticleCFornecedor.setVisible(false);
				criarTabela(VisualizarFornecedores, VFornecedores, "");
				ArticleVFornecedor.setVisible(true);
				ArticleCFornecedor.setVisible(false);
				ArticleVCliente.setVisible(false);
				ArticleCCliente.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (Visualizarfornecedores.getForeground() != Color.yellow)
					Visualizarfornecedores.setForeground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (Visualizarfornecedores.getForeground() != Color.yellow)
					Visualizarfornecedores.setForeground(Color.white);
			}
		});

		// Cadastrar Categoria
		CadastrarCategoria.setForeground(Color.WHITE);
		CadastrarCategoria.setFont(new Font("Arial", Font.PLAIN, 16));
		CadastrarCategoria.setBounds(200, 135, 144, 14);
		CadastrarCategoria.setVisible(false);
		CadastrarCategoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CadastrarCategoria.setForeground(Color.yellow);
				VisualizarCategoria.setForeground(Color.white);
				ArticleCProdutos.setVisible(false);
				ArticleVFornecedor.setVisible(false);
				ArticleVCliente.setVisible(false);
				ArticleCCliente.setVisible(false);
				ArticleCCategoria.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (CadastrarCategoria.getForeground() != Color.yellow)
					CadastrarCategoria.setForeground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (CadastrarCategoria.getForeground() != Color.yellow)
					CadastrarCategoria.setForeground(Color.white);
			}
		});
		frame.getContentPane().add(CadastrarCategoria);

		// Visualizar Categoria
		VisualizarCategoria.setForeground(Color.WHITE);
		VisualizarCategoria.setFont(new Font("Arial", Font.PLAIN, 16));
		VisualizarCategoria.setBounds(40, 135, 142, 14);
		VisualizarCategoria.setVisible(false);
		VisualizarCategoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VisualizarCategoria.setForeground(Color.yellow);
				CadastrarCategoria.setForeground(Color.white);
				// ArticleCProduto.setVisible(true);
				ArticleVFornecedor.setVisible(false);
				ArticleVCliente.setVisible(false);
				ArticleCCliente.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (VisualizarCategoria.getForeground() != Color.yellow)
					VisualizarCategoria.setForeground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (VisualizarCategoria.getForeground() != Color.yellow)
					VisualizarCategoria.setForeground(Color.white);
			}
		});
		frame.getContentPane().add(VisualizarCategoria);
		frame.getContentPane().add(CadastrarProdutos);

		// Cadastrar Produtos
		CadastrarProdutos.setForeground(Color.WHITE);
		CadastrarProdutos.setFont(new Font("Arial", Font.PLAIN, 16));
		CadastrarProdutos.setBounds(200, 135, 139, 14);
		CadastrarProdutos.setVisible(false);
		CadastrarProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CadastrarProdutos.setForeground(Color.yellow);
				VisualizarProdutos.setForeground(Color.white);
				ArticleCProdutos.setVisible(true);
				ArticleVFornecedor.setVisible(false);
				ArticleVCliente.setVisible(false);
				ArticleCCliente.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (CadastrarProdutos.getForeground() != Color.yellow)
					CadastrarProdutos.setForeground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (CadastrarProdutos.getForeground() != Color.yellow)
					CadastrarProdutos.setForeground(Color.white);
			}
		});

		// Visualizar Produtos
		VisualizarProdutos.setForeground(Color.WHITE);
		VisualizarProdutos.setFont(new Font("Arial", Font.PLAIN, 16));
		VisualizarProdutos.setBounds(40, 135, 138, 14);
		VisualizarProdutos.setVisible(false);
		VisualizarProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VisualizarProdutos.setForeground(Color.yellow);
				CadastrarProdutos.setForeground(Color.white);
				// criarTabela(VisualizarFornecedores, VFornecedores, "");
				// ArticleVProduto.setVisible(true);
				ArticleCFornecedor.setVisible(false);
				ArticleVCliente.setVisible(false);
				ArticleCCliente.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (VisualizarProdutos.getForeground() != Color.yellow)
					VisualizarProdutos.setForeground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (VisualizarProdutos.getForeground() != Color.yellow)
					VisualizarProdutos.setForeground(Color.white);
			}
		});
		frame.getContentPane().add(VisualizarProdutos);

		// Visualizar fornecedores
		Visualizarfornecedores.setForeground(Color.WHITE);
		Visualizarfornecedores.setFont(new Font("Arial", Font.PLAIN, 16));
		Visualizarfornecedores.setBounds(40, 135, 166, 14);
		frame.getContentPane().add(Visualizarfornecedores);

		// Cadastrar Fornecedores
		CadastrarFornecedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CadastrarFornecedores.setForeground(Color.yellow);
				Visualizarfornecedores.setForeground(Color.white);
				ArticleCFornecedor.setVisible(true);
				ArticleVFornecedor.setVisible(false);
				ArticleVCliente.setVisible(false);
				ArticleCCliente.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (CadastrarFornecedores.getForeground() != Color.yellow)
					CadastrarFornecedores.setForeground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (CadastrarFornecedores.getForeground() != Color.yellow)
					CadastrarFornecedores.setForeground(Color.white);
			}
		});
		CadastrarFornecedores.setForeground(Color.WHITE);
		CadastrarFornecedores.setFont(new Font("Arial", Font.PLAIN, 16));
		CadastrarFornecedores.setBounds(228, 135, 166, 14);
		frame.getContentPane().add(CadastrarFornecedores);

		// Visualizar Clientes
		VisualizarClientes.setForeground(Color.WHITE);
		VisualizarClientes.setFont(new Font("Arial", Font.PLAIN, 16));
		VisualizarClientes.setBounds(40, 135, 131, 14);
		VisualizarClientes.setVisible(false);
		VisualizarClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (VisualizarClientes.getForeground() != Color.yellow)
					VisualizarClientes.setForeground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (VisualizarClientes.getForeground() != Color.yellow)
					VisualizarClientes.setForeground(Color.white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				VisualizarClientes.setForeground(Color.yellow);
				CadastrarClientes.setForeground(Color.white);
				criarTabelaC(VisualizarCli, VClientes, "");
				ArticleVCliente.setVisible(true);
				ArticleCCliente.setVisible(false);
				ArticleVFornecedor.setVisible(false);
				ArticleCFornecedor.setVisible(false);
			}
		});
		frame.getContentPane().add(VisualizarClientes);

		// Cadastrar Clientes
		CadastrarClientes.setForeground(Color.WHITE);
		CadastrarClientes.setFont(new Font("Arial", Font.PLAIN, 16));
		CadastrarClientes.setBounds(190, 135, 131, 14);
		CadastrarClientes.setVisible(false);
		CadastrarClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (CadastrarClientes.getForeground() != Color.yellow)
					CadastrarClientes.setForeground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (CadastrarClientes.getForeground() != Color.yellow)
					CadastrarClientes.setForeground(Color.white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				VisualizarClientes.setForeground(Color.white);
				CadastrarClientes.setForeground(Color.yellow);
				ArticleVCliente.setVisible(false);
				ArticleCCliente.setVisible(true);
				ArticleVFornecedor.setVisible(false);
				ArticleCFornecedor.setVisible(false);
			}
		});
		frame.getContentPane().add(CadastrarClientes);
		frame.getContentPane().add(BotaoHoverFornecedor);

		// Botao Hover Fornecedor
		BotaoHoverFornecedor.setBackground(SystemColor.controlDkShadow);
		BotaoHoverFornecedor.setBorder(new LineBorder((new Color(54, 54, 54)), 16, true));
		BotaoHoverFornecedor.setBounds(4, 95, 90, 24);
		BotaoHoverFornecedor.setVisible(true);

		// Botao Hover Categoria
		BotaoHoverCategoria.setBackground(SystemColor.controlDkShadow);
		BotaoHoverCategoria.setBorder(new LineBorder((new Color(54, 54, 54)), 16, true));
		BotaoHoverCategoria.setBounds(173, 95, 73, 24);
		BotaoHoverCategoria.setVisible(false);
		frame.getContentPane().add(BotaoHoverCategoria);

		// Botao Hover Cliente
		BotaoHoverCliente.setBackground(SystemColor.controlDkShadow);
		BotaoHoverCliente.setBorder(new LineBorder((new Color(54, 54, 54)), 16, true));
		BotaoHoverCliente.setBounds(104, 95, 61, 24);
		BotaoHoverCliente.setVisible(false);
		frame.getContentPane().add(BotaoHoverCliente);

		// Botao Hover Produto
		BotaoHoverProduto.setBackground(SystemColor.controlDkShadow);
		BotaoHoverProduto.setBorder(new LineBorder((new Color(54, 54, 54)), 16, true));
		BotaoHoverProduto.setBounds(254, 95, 66, 24);
		BotaoHoverProduto.setVisible(false);
		frame.getContentPane().add(BotaoHoverProduto);

		// Botao Hover Estoque
		BotaoHoverEstoque.setBackground(SystemColor.controlDkShadow);
		BotaoHoverEstoque.setBorder(new LineBorder((new Color(54, 54, 54)), 16, true));
		BotaoHoverEstoque.setBounds(332, 95, 68, 24);
		BotaoHoverEstoque.setVisible(false);
		frame.getContentPane().add(BotaoHoverEstoque);

		JPanel BotaoFornecedor = new JPanel();
		BotaoFornecedor.setBackground(new Color(105, 105, 105));
		BotaoFornecedor.setBounds(0, 91, 98, 29);
		frame.getContentPane().add(BotaoFornecedor);

		JPanel BotaoCategoria = new JPanel();
		BotaoCategoria.setBackground(SystemColor.controlDkShadow);
		BotaoCategoria.setBounds(171, 91, 77, 29);
		frame.getContentPane().add(BotaoCategoria);

		JPanel BotaoCliente = new JPanel();
		BotaoCliente.setBackground(SystemColor.controlDkShadow);
		BotaoCliente.setBounds(100, 91, 69, 29);
		frame.getContentPane().add(BotaoCliente);

		JPanel BotaoProduto = new JPanel();
		BotaoProduto.setBackground(SystemColor.controlDkShadow);
		BotaoProduto.setBounds(250, 91, 75, 29);
		frame.getContentPane().add(BotaoProduto);

		JPanel BotaoEstoque = new JPanel();
		BotaoEstoque.setBackground(SystemColor.controlDkShadow);
		BotaoEstoque.setBounds(327, 91, 1038, 29);
		frame.getContentPane().add(BotaoEstoque);

		JPanel BorderMenu = new JPanel();
		BorderMenu.setBackground(new Color(130, 130, 130));
		BorderMenu.setBounds(0, 86, (int) d.getWidth(), 1);
		frame.getContentPane().add(BorderMenu);

		JGradientPanel Menu = new JGradientPanel(new Color(105, 105, 105), 0.1, new Color(79, 79, 79), 0.9);
		Menu.setBounds(0, 85, (int) d.getWidth(), 35);
		frame.getContentPane().add(Menu);

		JPanel BorderSubMenu = new JPanel();
		BorderSubMenu.setBackground(new Color(156, 156, 156));
		BorderSubMenu.setBounds(0, 121, (int) d.getWidth(), 1);
		frame.getContentPane().add(BorderSubMenu);

		JGradientPanel SubMenu = new JGradientPanel(new Color(105, 105, 105), 0.1, new Color(54, 54, 54), 0.9);
		SubMenu.setBounds(0, 120, 1366, 45);
		frame.getContentPane().add(SubMenu);

		JPanel Header = new JPanel();
		Header.setBackground(new Color(54, 54, 54));
		Header.setBounds(0, 0, 1366, 165);
		frame.getContentPane().add(Header);

		// Article Visualizar fornecedor
		ArticleVFornecedor.setBackground(Color.WHITE);
		ArticleVFornecedor.setBounds(139, 169, 1088, 506);
		ArticleVFornecedor.setLayout(null);
		ArticleVFornecedor.setVisible(false);

		// Article Visualizar cliente
		ArticleVCliente.setBackground(Color.WHITE);
		ArticleVCliente.setBounds(139, 169, 1088, 506);
		ArticleVCliente.setVisible(false);

		// Article Cadastrar Categoria
		ArticleCCategoria.setBackground(Color.WHITE);
		ArticleCCategoria.setBounds(139, 169, 1088, 506);
		ArticleCCategoria.setVisible(false);
		frame.getContentPane().add(ArticleCCategoria);
		ArticleCCategoria.setLayout(null);
		
		IdCategoria = new JTextField();
		IdCategoria.setBounds(0, 0, 122, 28);
		ArticleCCategoria.add(IdCategoria);
		IdCategoria.setText("-1");
		IdCategoria.setColumns(10);
		IdCategoria.setVisible(false);

		JLabel NomeDaCategoriaC = DefaultComponentFactory.getInstance().createLabel("Nome da Categoria:");
		NomeDaCategoriaC.setFont(new Font("Arial", Font.PLAIN, 16));
		NomeDaCategoriaC.setBounds(57, 170, 142, 14);
		ArticleCCategoria.add(NomeDaCategoriaC);

		NomeCCA = new JTextField();
		NomeCCA.setText("Nome da categoria");
		NomeCCA.setForeground(Color.LIGHT_GRAY);
		NomeCCA.setBounds(57, 189, 604, 25);
		ArticleCCategoria.add(NomeCCA);
		NomeCCA.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (NomeCCA.getText().length() <= 0 && NomeCCA.getForeground() == Color.black) {
					NomeCCA.setText("Nome da categoria");
					NomeCCA.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (NomeCCA.getText().length() > 0 && NomeCCA.getForeground() == Color.LIGHT_GRAY) {
					NomeCCA.setText("");
					NomeCCA.setForeground(Color.black);
				}
			}
		});
		NomeCCA.setColumns(10);

		////////////////////////////////////////////////////////

		JLabel CadastrarCa = DefaultComponentFactory.getInstance().createTitle("Cadastrar");
		CadastrarCa.setBounds(42, 18, 70, 16);
		CadastrarCCa.add(CadastrarCa);
		CadastrarCa.setForeground(Color.BLACK);
		CadastrarCa.setFont(new Font("Arial", Font.PLAIN, 16));

		// CadastrarCCa
		CadastrarCCa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				CadastrarCCa.setBackground(new Color(0, 100, 0));
				CadastrarCa.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				CadastrarCCa.setBackground(new Color(50, 205, 50));
				CadastrarCa.setForeground(Color.black);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Categoria categoria = new Categoria();
				if (IdCategoria.getText().trim().equals("-1")) {
					try {
						categoria.adicionarCategoria(NomeCCA.getText());
						JOptionPane.showMessageDialog(ArticleCCategoria, "Categoria cadastrado com sucesso.", null,JOptionPane.INFORMATION_MESSAGE);
						IdCategoria.setText("-1");
						NomeCCA.setText("Nome da categoria");
						NomeCCA.setForeground(Color.LIGHT_GRAY);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(ArticleCFornecedor, e1.getMessage(), null,JOptionPane.ERROR_MESSAGE);
					}
				} else {
//					try {
//						cliente.alterarCliente(Idcliente.getText(), NomeCC.getText(), EnderecoCC.getText(),
//								NumeroC.getText(), ComplementoC.getText(), Telefone1CC.getText(), Telefone2CC.getText(),
//								EmailCC.getText(), Cpfcc.getText());
//						JOptionPane.showMessageDialog(ArticleCCliente, "Cliente alterado com sucesso.", null,
//								JOptionPane.INFORMATION_MESSAGE);
//						txtId.setText("-1");
//						NomeCC.setText("Nome completo");
//						EnderecoCC.setText("prefixo (rua,AV.,e.t.c...) seu endereço");
//						NumeroC.setText("123456");
//						ComplementoC.setText("Complemento do seu endereço");
//						Telefone1CC.setText("(99) 99999-9999");
//						Telefone2CC.setText("(99) 99999-9999");
//						EmailCC.setText("seuemail@gmail.com");
//						Cpfcc.setText("000.000.000-00");
//						NomeCC.setForeground(Color.LIGHT_GRAY);
//						EnderecoCC.setForeground(Color.LIGHT_GRAY);
//						NumeroC.setForeground(Color.LIGHT_GRAY);
//						ComplementoC.setForeground(Color.LIGHT_GRAY);
//						Telefone1CC.setForeground(Color.LIGHT_GRAY);
//						Telefone2CC.setForeground(Color.LIGHT_GRAY);
//						EmailCC.setForeground(Color.LIGHT_GRAY);
//						Cpfcc.setForeground(Color.LIGHT_GRAY);
//					} catch (Exception e1) {
//						JOptionPane.showMessageDialog(ArticleCCliente, e1.getMessage(), null,
//								JOptionPane.ERROR_MESSAGE);
//					}
				}
			}
		});
		CadastrarCCa.setBackground(new Color(50, 205, 50));
		CadastrarCCa.setBounds(786, 450, 147, 50);
		ArticleCCategoria.add(CadastrarCCa);
		CadastrarCCa.setLayout(null);

		JLabel CancelarCa = DefaultComponentFactory.getInstance().createTitle("Cancelar");
		CancelarCa.setBounds(43, 18, 65, 16);
		CancelarCCa.add(CancelarCa);
		CancelarCa.setForeground(Color.BLACK);
		CancelarCa.setFont(new Font("Arial", Font.PLAIN, 16));

		// CancelarCCa
		CancelarCCa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				CancelarCCa.setBackground(new Color(0, 100, 0));
				CancelarCa.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				CancelarCCa.setBackground(new Color(50, 205, 50));
				CancelarCa.setForeground(Color.black);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Idcliente.setText("-1");
				NomeCC.setText("Nome completo");
				NomeCC.setForeground(Color.LIGHT_GRAY);
				EnderecoCC.setText("prefixo (rua,AV.,e.t.c...) seu endereço");
				EnderecoCC.setForeground(Color.LIGHT_GRAY);
				NumeroC.setText("123456");
				NumeroC.setForeground(Color.LIGHT_GRAY);
				ComplementoC.setText("Complemento do seu endereço");
				ComplementoC.setForeground(Color.LIGHT_GRAY);
				Telefone1CC.setText("(99) 99999-9999");
				Telefone1CC.setForeground(Color.LIGHT_GRAY);
				Telefone2CC.setText("(99) 99999-9999");
				Telefone2CC.setForeground(Color.LIGHT_GRAY);
				EmailCC.setText("seuemail@gmail.com");
				EmailCF.setForeground(Color.LIGHT_GRAY);
				Cpfcc.setText("000.000.000-00");
				Cpfcc.setForeground(Color.LIGHT_GRAY);
			}
		});
		CancelarCCa.setBackground(new Color(50, 205, 50));
		CancelarCCa.setBounds(935, 450, 147, 50);
		ArticleCCategoria.add(CancelarCCa);
		CancelarCCa.setLayout(null);

		// Article Cadastrar Produto
		ArticleCProdutos.setBackground(Color.WHITE);
		ArticleCProdutos.setBounds(139, 169, 1088, 506);
		frame.getContentPane().add(ArticleCProdutos);
		ArticleCProdutos.setLayout(null);
		ArticleCProdutos.setVisible(false);

		IdProduto = new JTextField();
		IdProduto.setText("-1");
		IdProduto.setBounds(425, 5, 122, 28);
		ArticleCProdutos.add(IdProduto);
		IdProduto.setVisible(false);
		IdProduto.setColumns(10);

		JLabel NomeP = DefaultComponentFactory.getInstance().createLabel("Nome:");
		NomeP.setFont(new Font("Arial", Font.PLAIN, 16));
		NomeP.setBounds(51, 50, 46, 14);
		ArticleCProdutos.add(NomeP);

		NomeCP = new JTextField();
		NomeCP.setBounds(51, 67, 539, 25);
		ArticleCProdutos.add(NomeCP);
		NomeCP.setColumns(10);

		JLabel DescricaoP = DefaultComponentFactory.getInstance().createLabel("Descri\u00E7\u00E3o:");
		DescricaoP.setFont(new Font("Arial", Font.PLAIN, 16));
		DescricaoP.setBounds(51, 97, 76, 14);
		ArticleCProdutos.add(DescricaoP);

		DescricaoCP = new JTextField();
		DescricaoCP.setBounds(51, 116, 539, 25);
		ArticleCProdutos.add(DescricaoCP);
		DescricaoCP.setColumns(10);

		JLabel ValorDaCompraP = DefaultComponentFactory.getInstance().createLabel("Valor da compra do produto:");
		ValorDaCompraP.setFont(new Font("Arial", Font.PLAIN, 16));
		ValorDaCompraP.setBounds(51, 145, 199, 14);
		ArticleCProdutos.add(ValorDaCompraP);

		ValorCompra = new JTextField();
		ValorCompra.setBounds(51, 167, 199, 25);
		ArticleCProdutos.add(ValorCompra);
		ValorCompra.setColumns(10);

		JLabel ValorParaVendaP = DefaultComponentFactory.getInstance().createLabel("Valor para a venda do produto:");
		ValorParaVendaP.setFont(new Font("Arial", Font.PLAIN, 16));
		ValorParaVendaP.setBounds(375, 145, 215, 14);
		ArticleCProdutos.add(ValorParaVendaP);

		ValorVendaCP = new JTextField();
		ValorVendaCP.setBounds(374, 166, 216, 25);
		ArticleCProdutos.add(ValorVendaCP);
		ValorVendaCP.setColumns(10);

		JLabel CategoriaP = DefaultComponentFactory.getInstance().createLabel("Categoria:");
		CategoriaP.setFont(new Font("Arial", Font.PLAIN, 16));
		CategoriaP.setBounds(51, 199, 76, 14);
		ArticleCProdutos.add(CategoriaP);

		JComboBox CategoriaCP = new JComboBox();
		CategoriaCP.setBounds(51, 218, 199, 25);
		ArticleCProdutos.add(CategoriaCP);

		JLabel FornecedorC = DefaultComponentFactory.getInstance().createLabel("Fornecedor:");
		FornecedorC.setFont(new Font("Arial", Font.PLAIN, 16));
		FornecedorC.setBounds(51, 250, 85, 16);
		ArticleCProdutos.add(FornecedorC);

		JComboBox FornecedorCP = new JComboBox();
		FornecedorCP.setBounds(51, 270, 551, 25);
		ArticleCProdutos.add(FornecedorCP);
		frame.getContentPane().add(ArticleVCliente);
		ArticleVCliente.setLayout(null);

		////////////////////////////////////////////////////////

		JLabel CadastrarP = DefaultComponentFactory.getInstance().createTitle("Cadastrar");
		CadastrarP.setBounds(42, 18, 70, 16);
		CadastrarCP.add(CadastrarP);
		CadastrarP.setForeground(Color.BLACK);
		CadastrarP.setFont(new Font("Arial", Font.PLAIN, 16));

		// CadastrarCP
		CadastrarCP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				CadastrarCP.setBackground(new Color(0, 100, 0));
				CadastrarP.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				CadastrarCP.setBackground(new Color(50, 205, 50));
				CadastrarP.setForeground(Color.black);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente cliente = new Cliente();
				if (txtId.getText().trim().equals("-1")) {
					try {
						cliente.cadastrarCliente(NomeCC.getText(), Cpfcc.getText(), EnderecoCC.getText(),
								NumeroC.getText(), ComplementoC.getText(), Telefone1CC.getText(), Telefone2CC.getText(),
								EmailCC.getText());
						JOptionPane.showMessageDialog(ArticleCFornecedor, "Cliente cadastrado com sucesso.", null,
								JOptionPane.INFORMATION_MESSAGE);
						Idcliente.setText("-1");
						NomeCC.setText("Nome completo");
						EnderecoCC.setText("prefixo (rua,AV.,e.t.c...) seu endereço");
						NumeroC.setText("123456");
						ComplementoC.setText("Complemento do seu endereço");
						Telefone1CC.setText("(99) 99999-9999");
						Telefone2CC.setText("(99) 99999-9999");
						EmailCC.setText("seuemail@gmail.com");
						Cpfcc.setText("000.000.000-00");
						NomeCC.setForeground(Color.LIGHT_GRAY);
						EnderecoCC.setForeground(Color.LIGHT_GRAY);
						NumeroC.setForeground(Color.LIGHT_GRAY);
						ComplementoC.setForeground(Color.LIGHT_GRAY);
						Telefone1CC.setForeground(Color.LIGHT_GRAY);
						Telefone2CC.setForeground(Color.LIGHT_GRAY);
						EmailCC.setForeground(Color.LIGHT_GRAY);
						Cpfcc.setForeground(Color.LIGHT_GRAY);
						PessoaFisica.setSelected(true);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(ArticleCFornecedor, e1.getMessage(), null,
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					try {
						cliente.alterarCliente(Idcliente.getText(), NomeCC.getText(), EnderecoCC.getText(),
								NumeroC.getText(), ComplementoC.getText(), Telefone1CC.getText(), Telefone2CC.getText(),
								EmailCC.getText(), Cpfcc.getText());
						JOptionPane.showMessageDialog(ArticleCCliente, "Cliente alterado com sucesso.", null,
								JOptionPane.INFORMATION_MESSAGE);
						txtId.setText("-1");
						NomeCC.setText("Nome completo");
						EnderecoCC.setText("prefixo (rua,AV.,e.t.c...) seu endereço");
						NumeroC.setText("123456");
						ComplementoC.setText("Complemento do seu endereço");
						Telefone1CC.setText("(99) 99999-9999");
						Telefone2CC.setText("(99) 99999-9999");
						EmailCC.setText("seuemail@gmail.com");
						Cpfcc.setText("000.000.000-00");
						NomeCC.setForeground(Color.LIGHT_GRAY);
						EnderecoCC.setForeground(Color.LIGHT_GRAY);
						NumeroC.setForeground(Color.LIGHT_GRAY);
						ComplementoC.setForeground(Color.LIGHT_GRAY);
						Telefone1CC.setForeground(Color.LIGHT_GRAY);
						Telefone2CC.setForeground(Color.LIGHT_GRAY);
						EmailCC.setForeground(Color.LIGHT_GRAY);
						Cpfcc.setForeground(Color.LIGHT_GRAY);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(ArticleCCliente, e1.getMessage(), null,
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		CadastrarCP.setBackground(new Color(50, 205, 50));
		CadastrarCP.setBounds(786, 450, 147, 50);
		ArticleCProdutos.add(CadastrarCP);
		CadastrarCP.setLayout(null);

		JLabel CancelarP = DefaultComponentFactory.getInstance().createTitle("Cancelar");
		CancelarP.setBounds(43, 18, 65, 16);
		CancelarCP.add(CancelarP);
		CancelarP.setForeground(Color.BLACK);
		CancelarP.setFont(new Font("Arial", Font.PLAIN, 16));

		// CancelarCP
		CancelarCP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				CancelarCP.setBackground(new Color(0, 100, 0));
				CancelarP.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				CancelarCP.setBackground(new Color(50, 205, 50));
				CancelarP.setForeground(Color.black);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Idcliente.setText("-1");
				NomeCC.setText("Nome completo");
				NomeCC.setForeground(Color.LIGHT_GRAY);
				EnderecoCC.setText("prefixo (rua,AV.,e.t.c...) seu endereço");
				EnderecoCC.setForeground(Color.LIGHT_GRAY);
				NumeroC.setText("123456");
				NumeroC.setForeground(Color.LIGHT_GRAY);
				ComplementoC.setText("Complemento do seu endereço");
				ComplementoC.setForeground(Color.LIGHT_GRAY);
				Telefone1CC.setText("(99) 99999-9999");
				Telefone1CC.setForeground(Color.LIGHT_GRAY);
				Telefone2CC.setText("(99) 99999-9999");
				Telefone2CC.setForeground(Color.LIGHT_GRAY);
				EmailCC.setText("seuemail@gmail.com");
				EmailCF.setForeground(Color.LIGHT_GRAY);
				Cpfcc.setText("000.000.000-00");
				Cpfcc.setForeground(Color.LIGHT_GRAY);
			}
		});
		CancelarCP.setBackground(new Color(50, 205, 50));
		CancelarCP.setBounds(935, 450, 147, 50);
		ArticleCProdutos.add(CancelarCP);
		CancelarCP.setLayout(null);

		///////////////////////////////////////////////////////

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(59, 44, 973, 401);
		ArticleVCliente.add(scrollPane_1);

		// tabela de Vclientes
		VClientes = new JTable();
		VClientes.setFont(new Font("SansSerif", VClientes.getFont().getStyle(), 12));
		VClientes.setShowVerticalLines(true);
		VClientes.setShowHorizontalLines(true);
		scrollPane_1.setViewportView(VClientes);
		VClientes.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Nome", "CPF", "Telefone1", "Telefone2", "E-mail" }));
		VClientes.getColumnModel().getColumn(0).setPreferredWidth(0);
		VClientes.getColumnModel().getColumn(0).setMinWidth(0);
		VClientes.getColumnModel().getColumn(0).setMaxWidth(0);
		VClientes.getColumnModel().getColumn(1).setPreferredWidth(93);

		JLabel AlterarC = DefaultComponentFactory.getInstance().createTitle("Alterar");
		AlterarC.setBounds(56, 18, 46, 16);
		AlterarVC.add(AlterarC);
		AlterarC.setForeground(Color.BLACK);
		AlterarC.setFont(new Font("Arial", Font.PLAIN, 16));

		// AlterarVC
		AlterarVC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				AlterarVC.setBackground(new Color(0, 100, 0));
				AlterarC.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				AlterarVC.setBackground(new Color(50, 205, 50));
				AlterarC.setForeground(Color.black);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (VClientes.getSelectedRow() != -1) {
					Cliente Cliente = new Cliente();
					try {
						Cliente = Cliente.buscarCliente((String) VClientes.getValueAt(VClientes.getSelectedRow(), 0));
						NomeCC.setText(Cliente.getNome());
						EnderecoCC.setText(Cliente.getEndereco().getEndereco());
						NumeroC.setText(Cliente.getEndereco().getNumero());
						ComplementoC.setText(Cliente.getEndereco().getComplemento());
						Telefone1CC.setText(Cliente.getContato().getNumero1());
						Telefone2CC.setText(Cliente.getContato().getNumero2());
						EmailCC.setText(Cliente.getContato().getEmail());
						Idcliente.setText(Cliente.getId());
						Cpfcc.setText(Cliente.getCpf());
						NomeCC.setForeground(Color.black);
						EnderecoCC.setForeground(Color.black);
						NumeroC.setForeground(Color.black);
						ComplementoC.setForeground(Color.black);
						Telefone1CC.setForeground(Color.black);
						Telefone2CC.setForeground(Color.black);
						EmailCC.setForeground(Color.black);
						Cpfcc.setForeground(Color.black);
						CadastrarClientes.setForeground(Color.yellow);
						VisualizarClientes.setForeground(Color.white);
						ArticleCCliente.setVisible(true);
						ArticleVCliente.setVisible(false);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(ArticleVCliente, e1.getMessage(), null,
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(ArticleVCliente, "Selecione um cliente para alterar", null,
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		AlterarVC.setBackground(new Color(50, 205, 50));
		AlterarVC.setBounds(786, 450, 147, 50);
		ArticleVCliente.add(AlterarVC);
		AlterarVC.setLayout(null);

		JLabel ExcluirC = DefaultComponentFactory.getInstance().createTitle("Excluir");
		ExcluirC.setBounds(53, 18, 46, 16);
		ExcluirVC.add(ExcluirC);
		ExcluirC.setForeground(Color.BLACK);
		ExcluirC.setFont(new Font("Arial", Font.PLAIN, 16));

		// ExcluirVC
		ExcluirVC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ExcluirVC.setBackground(new Color(0, 100, 0));
				ExcluirC.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ExcluirVC.setBackground(new Color(50, 205, 50));
				ExcluirC.setForeground(Color.black);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (VClientes.getSelectedRow() != -1) {
					int i = JOptionPane.showConfirmDialog(ArticleVCliente, "Deseja excluir o cliente?", null,
							JOptionPane.YES_NO_OPTION);
					if (i == JOptionPane.YES_OPTION) {
						Cliente cliente = new Cliente();
						try {
							cliente.excluirCliente((String) VClientes.getValueAt(VClientes.getSelectedRow(), 0));
							if (!criarTabelaC(VisualizarCli, VClientes, "select * from clientes order by Nome;"))
								;
							JOptionPane.showMessageDialog(ArticleVCliente, "Cliente excluido com sucesso", null,
									JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(ArticleVCliente, e1.getMessage(), null,
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(ArticleVCliente, "Seelecione um cliente", null,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		ExcluirVC.setBackground(new Color(50, 205, 50));
		ExcluirVC.setBounds(935, 450, 147, 50);
		ArticleVCliente.add(ExcluirVC);
		ExcluirVC.setLayout(null);

		////////////////////////////////////////////////////////////////

		// Article Cadastrar Cliente
		ArticleCCliente.setBackground(Color.WHITE);
		ArticleCCliente.setBounds(139, 169, 1088, 506);
		ArticleCCliente.setVisible(false);
		frame.getContentPane().add(ArticleCCliente);
		ArticleCCliente.setLayout(null);

		Idcliente = new JTextField();
		Idcliente.setText("-1");
		Idcliente.setBounds(471, 17, 122, 28);
		ArticleCCliente.add(Idcliente);
		Idcliente.setColumns(10);

		JLabel NomeC = DefaultComponentFactory.getInstance().createLabel("Nome:");
		NomeC.setFont(new Font("Arial", Font.PLAIN, 16));
		NomeC.setBounds(51, 50, 46, 14);
		ArticleCCliente.add(NomeC);

		NomeCC = new JTextField();
		NomeCC.setText("Nome do cliente");
		NomeCC.setForeground(Color.LIGHT_GRAY);
		NomeCC.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (NomeCC.getText().length() <= 0 && NomeCC.getForeground() == Color.black) {
					NomeCC.setText("Nome do cliente");
					NomeCC.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (NomeCC.getText().length() > 0 && NomeCC.getForeground() == Color.LIGHT_GRAY) {
					NomeCC.setText("");
					NomeCC.setForeground(Color.black);
				}
			}
		});
		NomeCC.setBounds(51, 67, 539, 25);
		ArticleCCliente.add(NomeCC);
		NomeCC.setColumns(10);

		Idcliente.setVisible(false);

		JLabel EnderecoC = DefaultComponentFactory.getInstance().createTitle("Endere\u00E7o:");
		EnderecoC.setFont(new Font("Arial", Font.PLAIN, 16));
		EnderecoC.setBounds(51, 95, 72, 16);
		ArticleCCliente.add(EnderecoC);

		JLabel Required2C = DefaultComponentFactory.getInstance().createTitle("*");
		Required2C.setFont(new Font("Arial", Font.PLAIN, 16));
		Required2C.setForeground(Color.RED);
		Required2C.setBounds(123, 96, 6, 16);
		ArticleCCliente.add(Required2C);

		EnderecoCC = new JTextField();
		EnderecoCC.setColumns(10);
		EnderecoCC.setDocument(new Documento(100, ""));
		EnderecoCC.setText("prefixo (rua,AV.,e.t.c...) seu endereço");
		EnderecoCC.setForeground(Color.LIGHT_GRAY);
		EnderecoCC.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (EnderecoCC.getText().length() <= 0 && EnderecoCC.getForeground() == Color.black) {
					EnderecoCC.setText("prefixo (rua,AV.,e.t.c ....) seu endereço");
					EnderecoCC.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (EnderecoCC.getText().length() > 0 && EnderecoCC.getForeground() == Color.LIGHT_GRAY) {
					EnderecoCC.setText("");
					EnderecoCC.setForeground(Color.black);
				}
			}
		});
		EnderecoCC.setBounds(51, 112, 390, 25);
		ArticleCCliente.add(EnderecoCC);

		JLabel NumeroCC = DefaultComponentFactory.getInstance().createTitle("Numero:");
		NumeroCC.setFont(new Font("Arial", Font.PLAIN, 16));
		NumeroCC.setBounds(525, 96, 59, 16);
		ArticleCCliente.add(NumeroCC);

		JLabel Required3C = DefaultComponentFactory.getInstance().createTitle("*");
		Required3C.setFont(new Font("Arial", Font.BOLD, 16));
		Required3C.setForeground(Color.RED);
		Required3C.setBounds(584, 96, 6, 16);
		ArticleCCliente.add(Required3C);

		NumeroC = new JTextField();
		NumeroC.setColumns(10);
		NumeroC.setBounds(525, 111, 65, 25);
		NumeroC.setDocument(new Documento(6, "[\\D]"));
		NumeroC.setText("123456");
		NumeroC.setForeground(Color.LIGHT_GRAY);
		NumeroC.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (NumeroC.getText().length() <= 0 && NumeroC.getForeground() == Color.black) {
					NumeroC.setText("123456");
					NumeroC.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (NumeroC.getText().length() > 0 && NumeroC.getForeground() == Color.LIGHT_GRAY) {
					NumeroC.setText("");
					NumeroC.setForeground(Color.black);
				}
			}
		});
		ArticleCCliente.add(NumeroC);

		JLabel ComplementoCC = DefaultComponentFactory.getInstance().createTitle("Complemento:");
		ComplementoCC.setFont(new Font("Arial", Font.PLAIN, 16));
		ComplementoCC.setBounds(51, 139, 102, 16);
		ArticleCCliente.add(ComplementoCC);

		ComplementoC = new JTextField();
		ComplementoC.setColumns(10);
		ComplementoC.setBounds(51, 156, 539, 25);
		ComplementoC.setDocument(new Documento(100, ""));
		ComplementoC.setText("Complemento do seu endereço");
		ComplementoC.setForeground(Color.LIGHT_GRAY);
		ComplementoC.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (ComplementoC.getText().length() <= 0 && ComplementoC.getForeground() == Color.black) {
					ComplementoC.setText("Complemento do seu endereço");
					ComplementoC.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (ComplementoC.getText().length() > 0 && ComplementoC.getForeground() == Color.LIGHT_GRAY) {
					ComplementoC.setText("");
					ComplementoC.setForeground(Color.black);
				}
			}
		});
		ArticleCCliente.add(ComplementoC);

		JLabel CpfC = DefaultComponentFactory.getInstance().createLabel("CPF:");
		CpfC.setFont(new Font("SansSerif", Font.PLAIN, 16));
		CpfC.setBounds(51, 276, 37, 14);
		ArticleCCliente.add(CpfC);

		JLabel Required6C = DefaultComponentFactory.getInstance().createTitle("*");
		Required6C.setFont(new Font("Arial", Font.PLAIN, 16));
		Required6C.setForeground(Color.RED);
		Required6C.setBounds(91, 276, 6, 16);
		ArticleCCliente.add(Required6C);

		Cpfcc = new JTextField();
		Cpfcc.setBounds(51, 297, 271, 25);
		ArticleCCliente.add(Cpfcc);
		Cpfcc.setColumns(10);
		Cpfcc.setDocument(new Documento(14, "[\\D&&[^.-]]"));
		Cpfcc.setText("000.000.000-00");
		Cpfcc.setForeground(Color.LIGHT_GRAY);
		Cpfcc.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (Cpfcc.getText().length() <= 0 && Cpfcc.getForeground() == Color.black) {
					Cpfcc.setText("000.000.000-00");
					Cpfcc.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (Cpfcc.getText().length() > 0 && Cpfcc.getForeground() == Color.LIGHT_GRAY) {
					Cpfcc.setText("");
					Cpfcc.setForeground(Color.black);
				}
			}
		});
		frame.getContentPane().add(ArticleVFornecedor);
		ArticleCCliente.setVisible(false);

		JLabel Telefone1C = DefaultComponentFactory.getInstance().createTitle("Telefone1:");
		Telefone1C.setFont(new Font("Arial", Font.PLAIN, 16));
		Telefone1C.setBounds(53, 182, 76, 16);
		ArticleCCliente.add(Telefone1C);

		JLabel Required4C = DefaultComponentFactory.getInstance().createTitle("*");
		Required4C.setFont(new Font("Arial", Font.PLAIN, 16));
		Required4C.setForeground(Color.RED);
		Required4C.setBounds(128, 182, 6, 16);
		ArticleCCliente.add(Required4C);

		Telefone1CC = new JTextField();
		Telefone1CC.setColumns(10);
		Telefone1CC.setBounds(51, 201, 135, 25);
		Telefone1CC.setDocument(new Documento(15, "[\\D&&[^\\s()-]]"));
		Telefone1CC.setText("(99) 99999-9999");
		Telefone1CC.setForeground(Color.LIGHT_GRAY);
		Telefone1CC.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (Telefone1CC.getText().length() <= 0 && Telefone1CC.getForeground() == Color.black) {
					Telefone1CC.setText("(99) 99999-9999");
					Telefone1CC.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (Telefone1CC.getText().length() > 0 && Telefone1CC.getForeground() == Color.LIGHT_GRAY) {
					Telefone1CC.setText("");
					Telefone1CC.setForeground(Color.black);
				}
			}
		});
		ArticleCCliente.add(Telefone1CC);

		JLabel Telefone2C = DefaultComponentFactory.getInstance().createTitle("Telefone2:");
		Telefone2C.setFont(new Font("Arial", Font.PLAIN, 16));
		Telefone2C.setBounds(455, 182, 74, 16);
		ArticleCCliente.add(Telefone2C);

		Telefone2CC = new JTextField();
		Telefone2CC.setColumns(10);
		Telefone2CC.setBounds(455, 201, 135, 25);
		Telefone2CC.setDocument(new Documento(15, "[\\D&&[^\\s()-]]"));
		Telefone2CC.setText("(99) 99999-9999");
		Telefone2CC.setForeground(Color.LIGHT_GRAY);
		Telefone2CC.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (Telefone2CC.getText().length() <= 0 && Telefone2CC.getForeground() == Color.black) {
					Telefone2CC.setText("(99) 99999-9999");
					Telefone2CC.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (Telefone2CC.getText().length() > 0 && Telefone2CC.getForeground() == Color.LIGHT_GRAY) {
					Telefone2CC.setText("");
					Telefone2CC.setForeground(Color.black);
				}
			}
		});
		ArticleCCliente.add(Telefone2CC);

		JLabel EmailC = DefaultComponentFactory.getInstance().createTitle("E-mail:");
		EmailC.setFont(new Font("Arial", Font.PLAIN, 16));
		EmailC.setBounds(51, 229, 49, 16);
		ArticleCCliente.add(EmailC);

		EmailCC = new JTextField();
		EmailCC.setColumns(10);
		EmailCC.setBounds(51, 246, 539, 25);
		EmailCC.setDocument(new Documento(100, ""));
		EmailCC.setText("seuemail@gmail.com");
		EmailCC.setForeground(Color.LIGHT_GRAY);
		Border defaul = EmailCC.getBorder();
		EmailCC.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (EmailCC.getText().length() <= 0 && EmailCC.getForeground() == Color.black) {
					EmailCC.setText("seuemail@gmail.com");
					EmailCC.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (EmailCC.getText().length() > 0 && EmailCC.getForeground() == Color.LIGHT_GRAY) {
					EmailCC.setText("");
					EmailCC.setForeground(Color.black);
				}
			}
		});
		EmailCC.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (!Validar.validarEmail(EmailCC.getText())) {
					EmailCC.setBorder(new CompoundBorder(
							new CompoundBorder(new LineBorder(new Color(238, 221, 202), 1, true),
									new LineBorder(new Color(255, 64, 64))),
							new CompoundBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(141, 142, 143)),
									new CompoundBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(184, 184, 185)),
											new CompoundBorder(
													new MatteBorder(1, 0, 0, 0, (Color) new Color(203, 203, 204)),
													new MatteBorder(1, 0, 0, 0, (Color) new Color(229, 229, 230)))))));
				} else {
					EmailCC.setBorder(defaul);
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				if (!Validar.validarEmail(EmailCC.getText())) {
					EmailCC.setBorder(new CompoundBorder(
							new CompoundBorder(new LineBorder(new Color(238, 221, 202), 1, true),
									new LineBorder(new Color(255, 64, 64))),
							new CompoundBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(141, 142, 143)),
									new CompoundBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(184, 184, 185)),
											new CompoundBorder(
													new MatteBorder(1, 0, 0, 0, (Color) new Color(203, 203, 204)),
													new MatteBorder(1, 0, 0, 0, (Color) new Color(229, 229, 230)))))));
				} else {
					// EmailCC.setBorder(new CompoundBorder(new
					// CompoundBorder(new LineBorder(new Color(202, 221, 238),
					// 1, true), new LineBorder(new Color(115, 164, 209))), new
					// CompoundBorder(new MatteBorder(1, 0, 0, 0, (Color) new
					// Color(141, 142, 143)), new CompoundBorder(new
					// MatteBorder(0, 1, 1, 1, (Color) new Color(184, 184,
					// 185)), new CompoundBorder(new MatteBorder(1, 0, 0, 0,
					// (Color) new Color(203, 203, 204)), new MatteBorder(1, 0,
					// 0, 0, (Color) new Color(229, 229, 230)))))));
					EmailCC.setBorder(defaul);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		ArticleCCliente.add(EmailCC);

		JLabel Required5C = DefaultComponentFactory.getInstance().createTitle("*");
		Required5C.setFont(new Font("Arial", Font.PLAIN, 16));
		Required5C.setForeground(Color.RED);
		Required5C.setBounds(97, 49, 6, 16);
		Required5C.setVisible(true);
		ArticleCCliente.add(Required5C);
		////////////////////////////////////////////////////////

		JLabel CadastrarC = DefaultComponentFactory.getInstance().createTitle("Cadastrar");
		CadastrarC.setBounds(42, 18, 70, 16);
		CadastrarCC.add(CadastrarC);
		CadastrarC.setForeground(Color.BLACK);
		CadastrarC.setFont(new Font("Arial", Font.PLAIN, 16));

		// CadastrarCC
		CadastrarCC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				CadastrarCC.setBackground(new Color(0, 100, 0));
				CadastrarC.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				CadastrarCC.setBackground(new Color(50, 205, 50));
				CadastrarC.setForeground(Color.black);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Cliente cliente = new Cliente();
				if (txtId.getText().trim().equals("-1")) {
					try {
						cliente.cadastrarCliente(NomeCC.getText(), Cpfcc.getText(), EnderecoCC.getText(),
								NumeroC.getText(), ComplementoC.getText(), Telefone1CC.getText(), Telefone2CC.getText(),
								EmailCC.getText());
						JOptionPane.showMessageDialog(ArticleCFornecedor, "Cliente cadastrado com sucesso.", null,
								JOptionPane.INFORMATION_MESSAGE);
						Idcliente.setText("-1");
						NomeCC.setText("Nome completo");
						EnderecoCC.setText("prefixo (rua,AV.,e.t.c...) seu endereço");
						NumeroC.setText("123456");
						ComplementoC.setText("Complemento do seu endereço");
						Telefone1CC.setText("(99) 99999-9999");
						Telefone2CC.setText("(99) 99999-9999");
						EmailCC.setText("seuemail@gmail.com");
						Cpfcc.setText("000.000.000-00");
						NomeCC.setForeground(Color.LIGHT_GRAY);
						EnderecoCC.setForeground(Color.LIGHT_GRAY);
						NumeroC.setForeground(Color.LIGHT_GRAY);
						ComplementoC.setForeground(Color.LIGHT_GRAY);
						Telefone1CC.setForeground(Color.LIGHT_GRAY);
						Telefone2CC.setForeground(Color.LIGHT_GRAY);
						EmailCC.setForeground(Color.LIGHT_GRAY);
						Cpfcc.setForeground(Color.LIGHT_GRAY);
						PessoaFisica.setSelected(true);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(ArticleCFornecedor, e1.getMessage(), null,
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					try {
						cliente.alterarCliente(Idcliente.getText(), NomeCC.getText(), EnderecoCC.getText(),
								NumeroC.getText(), ComplementoC.getText(), Telefone1CC.getText(), Telefone2CC.getText(),
								EmailCC.getText(), Cpfcc.getText());
						JOptionPane.showMessageDialog(ArticleCCliente, "Cliente alterado com sucesso.", null,
								JOptionPane.INFORMATION_MESSAGE);
						txtId.setText("-1");
						NomeCC.setText("Nome completo");
						EnderecoCC.setText("prefixo (rua,AV.,e.t.c...) seu endereço");
						NumeroC.setText("123456");
						ComplementoC.setText("Complemento do seu endereço");
						Telefone1CC.setText("(99) 99999-9999");
						Telefone2CC.setText("(99) 99999-9999");
						EmailCC.setText("seuemail@gmail.com");
						Cpfcc.setText("000.000.000-00");
						NomeCC.setForeground(Color.LIGHT_GRAY);
						EnderecoCC.setForeground(Color.LIGHT_GRAY);
						NumeroC.setForeground(Color.LIGHT_GRAY);
						ComplementoC.setForeground(Color.LIGHT_GRAY);
						Telefone1CC.setForeground(Color.LIGHT_GRAY);
						Telefone2CC.setForeground(Color.LIGHT_GRAY);
						EmailCC.setForeground(Color.LIGHT_GRAY);
						Cpfcc.setForeground(Color.LIGHT_GRAY);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(ArticleCCliente, e1.getMessage(), null,
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		CadastrarCC.setBackground(new Color(50, 205, 50));
		CadastrarCC.setBounds(786, 450, 147, 50);
		ArticleCCliente.add(CadastrarCC);
		CadastrarCC.setLayout(null);

		JLabel CancelarC = DefaultComponentFactory.getInstance().createTitle("Cancelar");
		CancelarC.setBounds(43, 18, 65, 16);
		CancelarCC.add(CancelarC);
		CancelarC.setForeground(Color.BLACK);
		CancelarC.setFont(new Font("Arial", Font.PLAIN, 16));

		// CancelarCC
		CancelarCC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				CancelarCC.setBackground(new Color(0, 100, 0));
				CancelarC.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				CancelarCC.setBackground(new Color(50, 205, 50));
				CancelarC.setForeground(Color.black);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Idcliente.setText("-1");
				NomeCC.setText("Nome completo");
				NomeCC.setForeground(Color.LIGHT_GRAY);
				EnderecoCC.setText("prefixo (rua,AV.,e.t.c...) seu endereço");
				EnderecoCC.setForeground(Color.LIGHT_GRAY);
				NumeroC.setText("123456");
				NumeroC.setForeground(Color.LIGHT_GRAY);
				ComplementoC.setText("Complemento do seu endereço");
				ComplementoC.setForeground(Color.LIGHT_GRAY);
				Telefone1CC.setText("(99) 99999-9999");
				Telefone1CC.setForeground(Color.LIGHT_GRAY);
				Telefone2CC.setText("(99) 99999-9999");
				Telefone2CC.setForeground(Color.LIGHT_GRAY);
				EmailCC.setText("seuemail@gmail.com");
				EmailCF.setForeground(Color.LIGHT_GRAY);
				Cpfcc.setText("000.000.000-00");
				Cpfcc.setForeground(Color.LIGHT_GRAY);
			}
		});
		CancelarCC.setBackground(new Color(50, 205, 50));
		CancelarCC.setBounds(935, 450, 147, 50);
		ArticleCCliente.add(CancelarCC);
		CancelarCC.setLayout(null);

		///////////////////////////////////////////////////////
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 44, 973, 401);
		ArticleVFornecedor.add(scrollPane);

		VFornecedores = new JTable();
		VFornecedores.setFont(new Font("SansSerif", VFornecedores.getFont().getStyle(), 12));
		VFornecedores.setShowVerticalLines(true);
		VFornecedores.setShowHorizontalLines(true);
		scrollPane.setViewportView(VFornecedores);
		VFornecedores.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Nome", "CPF/CNPJ", "Telefone1", "Telefone2", "E-mail" }));
		VFornecedores.getColumnModel().getColumn(0).setPreferredWidth(0);
		VFornecedores.getColumnModel().getColumn(0).setMinWidth(0);
		VFornecedores.getColumnModel().getColumn(0).setMaxWidth(0);
		VFornecedores.getColumnModel().getColumn(1).setPreferredWidth(93);

		JLabel Alterar = DefaultComponentFactory.getInstance().createTitle("Alterar");
		Alterar.setBounds(56, 18, 46, 16);
		AlterarVF.add(Alterar);
		Alterar.setForeground(Color.BLACK);
		Alterar.setFont(new Font("Arial", Font.PLAIN, 16));

		// AlterarVF
		AlterarVF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				AlterarVF.setBackground(new Color(0, 100, 0));
				Alterar.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				AlterarVF.setBackground(new Color(50, 205, 50));
				Alterar.setForeground(Color.black);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (VFornecedores.getSelectedRow() != -1) {
					Fornecedor fornecedor = new Fornecedor();
					try {
						fornecedor = fornecedor
								.buscarFornecedor((String) VFornecedores.getValueAt(VFornecedores.getSelectedRow(), 0));
						NomeCF.setText(fornecedor.getNome());
						EnderecoCF.setText(fornecedor.getEndereco().getEndereco());
						Numero.setText(fornecedor.getEndereco().getNumero());
						Complemento.setText(fornecedor.getEndereco().getComplemento());
						Telefone1CF.setText(fornecedor.getContato().getNumero1());
						Telefone2CF.setText(fornecedor.getContato().getNumero2());
						EmailCF.setText(fornecedor.getContato().getEmail());
						if (!fornecedor.getCpf().trim().equals("")) {
							PessoaFisica.setSelected(true);
						} else {
							PessoaJuridica.setSelected(true);
						}
						txtId.setText(fornecedor.getId());
						CpfCF.setText(fornecedor.getCpf());
						CnpjCF.setText(fornecedor.getCnpj());
						NomeCF.setForeground(Color.black);
						EnderecoCF.setForeground(Color.black);
						Numero.setForeground(Color.black);
						Complemento.setForeground(Color.black);
						Telefone1CF.setForeground(Color.black);
						Telefone2CF.setForeground(Color.black);
						EmailCF.setForeground(Color.black);
						CpfCF.setForeground(Color.black);
						CnpjCF.setForeground(Color.black);
						CadastrarFornecedores.setForeground(Color.yellow);
						Visualizarfornecedores.setForeground(Color.white);
						ArticleCFornecedor.setVisible(true);
						ArticleVFornecedor.setVisible(false);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(ArticleVFornecedor, e1.getMessage(), null,
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(ArticleVFornecedor, "Selecione um fornecedor para alterar", null,
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		AlterarVF.setBackground(new Color(50, 205, 50));
		AlterarVF.setBounds(786, 450, 147, 50);
		ArticleVFornecedor.add(AlterarVF);
		AlterarVF.setLayout(null);

		JLabel Excluir = DefaultComponentFactory.getInstance().createTitle("Excluir");
		Excluir.setBounds(53, 18, 46, 16);
		ExcluirVF.add(Excluir);
		Excluir.setForeground(Color.BLACK);
		Excluir.setFont(new Font("Arial", Font.PLAIN, 16));

		// ExcluirVF
		ExcluirVF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ExcluirVF.setBackground(new Color(0, 100, 0));
				Excluir.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ExcluirVF.setBackground(new Color(50, 205, 50));
				Excluir.setForeground(Color.black);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (VFornecedores.getSelectedRow() != -1) {
					int i = JOptionPane.showConfirmDialog(ArticleVFornecedor, "Deseja excluir o fornecedor?", null,
							JOptionPane.YES_NO_OPTION);
					if (i == JOptionPane.YES_OPTION) {
						Fornecedor fornecedor = new Fornecedor();
						try {
							fornecedor.excluirFornecedor(
									(String) VFornecedores.getValueAt(VFornecedores.getSelectedRow(), 0));
							if (!criarTabela(VisualizarFornecedores, VFornecedores,
									"select * from fornecedor order by Nome;"))
								;
							JOptionPane.showMessageDialog(ArticleVFornecedor, "Fornecedor excluido com sucesso", null,
									JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(ArticleVFornecedor, e1.getMessage(), null,
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(ArticleVFornecedor, "Seelecione um fornecedor", null,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		ExcluirVF.setBackground(new Color(50, 205, 50));
		ExcluirVF.setBounds(935, 450, 147, 50);
		ArticleVFornecedor.add(ExcluirVF);
		ExcluirVF.setLayout(null);

		// Article Cadastrar fornecedor
		ArticleCFornecedor.setBackground(Color.WHITE);
		ArticleCFornecedor.setBounds(139, 169, 1088, 506);
		frame.getContentPane().add(ArticleCFornecedor);
		ArticleCFornecedor.setVisible(false);
		ArticleCFornecedor.setLayout(null);

		txtId = new JTextField();
		txtId.setText("-1");
		txtId.setBounds(20, 20, 122, 28);
		ArticleCFornecedor.add(txtId);
		txtId.setColumns(10);
		txtId.setVisible(false);

		JLabel lblNome = DefaultComponentFactory.getInstance().createTitle("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNome.setBounds(51, 50, 46, 14);
		ArticleCFornecedor.add(lblNome);

		JLabel Required1 = DefaultComponentFactory.getInstance().createTitle("*");
		Required1.setForeground(Color.RED);
		Required1.setFont(new Font("Arial", Font.BOLD, 16));
		Required1.setBounds(99, 50, 6, 16);
		ArticleCFornecedor.add(Required1);

		NomeCF = new JTextField();
		NomeCF.setBounds(51, 67, 539, 25);
		NomeCF.setDocument(new Documento(80, ""));
		NomeCF.setText("Nome completo");
		NomeCF.setForeground(Color.LIGHT_GRAY);
		NomeCF.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (NomeCF.getText().length() <= 0 && NomeCF.getForeground() == Color.black) {
					NomeCF.setText("Nome Completo");
					NomeCF.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (NomeCF.getText().length() > 0 && NomeCF.getForeground() == Color.LIGHT_GRAY) {
					NomeCF.setText("");
					NomeCF.setForeground(Color.black);
				}
			}
		});
		ArticleCFornecedor.add(NomeCF);
		NomeCF.setColumns(10);

		JLabel Endereco = DefaultComponentFactory.getInstance().createTitle("Endere\u00E7o:");
		Endereco.setFont(new Font("Arial", Font.PLAIN, 16));
		Endereco.setBounds(51, 95, 72, 16);
		ArticleCFornecedor.add(Endereco);

		JLabel Required2 = DefaultComponentFactory.getInstance().createTitle("*");
		Required2.setFont(new Font("Arial", Font.PLAIN, 16));
		Required2.setForeground(Color.RED);
		Required2.setBounds(123, 96, 6, 16);
		ArticleCFornecedor.add(Required2);

		EnderecoCF = new JTextField();
		EnderecoCF.setColumns(10);
		EnderecoCF.setDocument(new Documento(100, ""));
		EnderecoCF.setText("prefixo (rua,AV.,e.t.c...) seu endereço");
		EnderecoCF.setForeground(Color.LIGHT_GRAY);
		EnderecoCF.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (EnderecoCF.getText().length() <= 0 && EnderecoCF.getForeground() == Color.black) {
					EnderecoCF.setText("prefixo (rua,AV.,e.t.c ....) seu endereço");
					EnderecoCF.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (EnderecoCF.getText().length() > 0 && EnderecoCF.getForeground() == Color.LIGHT_GRAY) {
					EnderecoCF.setText("");
					EnderecoCF.setForeground(Color.black);
				}
			}
		});
		EnderecoCF.setBounds(51, 112, 390, 25);
		ArticleCFornecedor.add(EnderecoCF);

		JLabel NumeroCF = DefaultComponentFactory.getInstance().createTitle("Numero:");
		NumeroCF.setFont(new Font("Arial", Font.PLAIN, 16));
		NumeroCF.setBounds(525, 96, 59, 16);
		ArticleCFornecedor.add(NumeroCF);

		JLabel Required3 = DefaultComponentFactory.getInstance().createTitle("*");
		Required3.setFont(new Font("Arial", Font.BOLD, 16));
		Required3.setForeground(Color.RED);
		Required3.setBounds(584, 96, 6, 16);
		ArticleCFornecedor.add(Required3);

		Numero = new JTextField();
		Numero.setColumns(10);
		Numero.setBounds(525, 111, 65, 25);
		Numero.setDocument(new Documento(6, "[\\D]"));
		Numero.setText("123456");
		Numero.setForeground(Color.LIGHT_GRAY);
		Numero.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (Numero.getText().length() <= 0 && Numero.getForeground() == Color.black) {
					Numero.setText("123456");
					Numero.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (Numero.getText().length() > 0 && Numero.getForeground() == Color.LIGHT_GRAY) {
					Numero.setText("");
					Numero.setForeground(Color.black);
				}
			}
		});
		ArticleCFornecedor.add(Numero);

		JLabel ComplementoCF = DefaultComponentFactory.getInstance().createTitle("Complemento:");
		ComplementoCF.setFont(new Font("Arial", Font.PLAIN, 16));
		ComplementoCF.setBounds(51, 139, 102, 16);
		ArticleCFornecedor.add(ComplementoCF);

		Complemento = new JTextField();
		Complemento.setColumns(10);
		Complemento.setBounds(51, 156, 539, 25);
		Complemento.setDocument(new Documento(100, ""));
		Complemento.setText("Complemento do seu endereço");
		Complemento.setForeground(Color.LIGHT_GRAY);
		Complemento.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (Complemento.getText().length() <= 0 && Complemento.getForeground() == Color.black) {
					Complemento.setText("Complemento do seu endereço");
					Complemento.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (Complemento.getText().length() > 0 && Complemento.getForeground() == Color.LIGHT_GRAY) {
					Complemento.setText("");
					Complemento.setForeground(Color.black);
				}
			}
		});
		ArticleCFornecedor.add(Complemento);

		JLabel Telefone1 = DefaultComponentFactory.getInstance().createTitle("Telefone1:");
		Telefone1.setFont(new Font("Arial", Font.PLAIN, 16));
		Telefone1.setBounds(53, 182, 76, 16);
		ArticleCFornecedor.add(Telefone1);

		JLabel Required4 = DefaultComponentFactory.getInstance().createTitle("*");
		Required4.setFont(new Font("Arial", Font.PLAIN, 16));
		Required4.setForeground(Color.RED);
		Required4.setBounds(128, 182, 6, 16);
		ArticleCFornecedor.add(Required4);

		Telefone1CF = new JTextField();
		Telefone1CF.setColumns(10);
		Telefone1CF.setBounds(51, 201, 135, 25);
		Telefone1CF.setDocument(new Documento(15, "[\\D&&[^\\s()-]]"));
		Telefone1CF.setText("(99) 99999-9999");
		Telefone1CF.setForeground(Color.LIGHT_GRAY);
		Telefone1CF.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (Telefone1CF.getText().length() <= 0 && Telefone1CF.getForeground() == Color.black) {
					Telefone1CF.setText("(99) 99999-9999");
					Telefone1CF.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (Telefone1CF.getText().length() > 0 && Telefone1CF.getForeground() == Color.LIGHT_GRAY) {
					Telefone1CF.setText("");
					Telefone1CF.setForeground(Color.black);
				}
			}
		});
		ArticleCFornecedor.add(Telefone1CF);

		JLabel Telefone2 = DefaultComponentFactory.getInstance().createTitle("Telefone2:");
		Telefone2.setFont(new Font("Arial", Font.PLAIN, 16));
		Telefone2.setBounds(455, 182, 74, 16);
		ArticleCFornecedor.add(Telefone2);

		Telefone2CF = new JTextField();
		Telefone2CF.setColumns(10);
		Telefone2CF.setBounds(455, 201, 135, 25);
		Telefone2CF.setDocument(new Documento(15, "[\\D&&[^\\s()-]]"));
		Telefone2CF.setText("(99) 99999-9999");
		Telefone2CF.setForeground(Color.LIGHT_GRAY);
		Telefone2CF.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (Telefone2CF.getText().length() <= 0 && Telefone2CF.getForeground() == Color.black) {
					Telefone2CF.setText("(99) 99999-9999");
					Telefone2CF.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (Telefone2CF.getText().length() > 0 && Telefone2CF.getForeground() == Color.LIGHT_GRAY) {
					Telefone2CF.setText("");
					Telefone2CF.setForeground(Color.black);
				}
			}
		});
		ArticleCFornecedor.add(Telefone2CF);

		JLabel Email = DefaultComponentFactory.getInstance().createTitle("E-mail:");
		Email.setFont(new Font("Arial", Font.PLAIN, 16));
		Email.setBounds(51, 229, 49, 16);
		ArticleCFornecedor.add(Email);

		EmailCF = new JTextField();
		EmailCF.setColumns(10);
		EmailCF.setBounds(51, 246, 539, 25);
		EmailCF.setDocument(new Documento(100, ""));
		EmailCF.setText("seuemail@gmail.com");
		EmailCF.setForeground(Color.LIGHT_GRAY);
		EmailCF.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (EmailCF.getText().length() <= 0 && EmailCF.getForeground() == Color.black) {
					EmailCF.setText("seuemail@gmail.com");
					EmailCF.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (EmailCF.getText().length() > 0 && EmailCF.getForeground() == Color.LIGHT_GRAY) {
					EmailCF.setText("");
					EmailCF.setForeground(Color.black);
				}
			}
		});
		EmailCF.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (!Validar.validarEmail(EmailCF.getText())) {
					EmailCF.setBorder(new CompoundBorder(
							new CompoundBorder(new LineBorder(new Color(238, 221, 202), 1, true),
									new LineBorder(new Color(255, 64, 64))),
							new CompoundBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(141, 142, 143)),
									new CompoundBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(184, 184, 185)),
											new CompoundBorder(
													new MatteBorder(1, 0, 0, 0, (Color) new Color(203, 203, 204)),
													new MatteBorder(1, 0, 0, 0, (Color) new Color(229, 229, 230)))))));
				} else {
					EmailCF.setBorder(defaul);
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				if (!Validar.validarEmail(EmailCF.getText())) {
					EmailCF.setBorder(new CompoundBorder(
							new CompoundBorder(new LineBorder(new Color(238, 221, 202), 1, true),
									new LineBorder(new Color(255, 64, 64))),
							new CompoundBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(141, 142, 143)),
									new CompoundBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(184, 184, 185)),
											new CompoundBorder(
													new MatteBorder(1, 0, 0, 0, (Color) new Color(203, 203, 204)),
													new MatteBorder(1, 0, 0, 0, (Color) new Color(229, 229, 230)))))));
				} else {
					// EmailCF.setBorder(new CompoundBorder(new
					// CompoundBorder(new LineBorder(new Color(202, 221, 238),
					// 1, true), new LineBorder(new Color(115, 164, 209))), new
					// CompoundBorder(new MatteBorder(1, 0, 0, 0, (Color) new
					// Color(141, 142, 143)), new CompoundBorder(new
					// MatteBorder(0, 1, 1, 1, (Color) new Color(184, 184,
					// 185)), new CompoundBorder(new MatteBorder(1, 0, 0, 0,
					// (Color) new Color(203, 203, 204)), new MatteBorder(1, 0,
					// 0, 0, (Color) new Color(229, 229, 230)))))));
					EmailCF.setBorder(defaul);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		ArticleCFornecedor.add(EmailCF);

		JLabel Required5 = DefaultComponentFactory.getInstance().createTitle("*");
		Required5.setFont(new Font("Arial", Font.PLAIN, 16));
		Required5.setForeground(Color.RED);
		Required5.setBounds(101, 301, 6, 16);
		Required5.setVisible(true);
		ArticleCFornecedor.add(Required5);

		// Pessoa Fisica
		PessoaFisica.setBounds(51, 275, 102, 18);
		PessoaFisica.setSelected(true);
		PessoaFisica.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (PessoaFisica.isSelected()) {
					Cpf.setVisible(true);
					CpfCF.setVisible(true);
					Required5.setVisible(true);
					Cnpj.setVisible(false);
					CnpjCF.setVisible(false);
					Required6.setVisible(false);
				}
			}
		});
		ArticleCFornecedor.add(PessoaFisica);

		// Pessoa Juridica
		PessoaJuridica.setBounds(475, 275, 115, 18);
		PessoaJuridica.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (PessoaJuridica.isSelected()) {
					Cpf.setVisible(false);
					CpfCF.setVisible(false);
					Required5.setVisible(false);
					Cnpj.setVisible(true);
					CnpjCF.setVisible(true);
					Required6.setVisible(true);
				}
			}
		});
		ArticleCFornecedor.add(PessoaJuridica);

		// C.P.F.
		Cpf.setFont(new Font("Arial", Font.PLAIN, 16));
		Cpf.setBounds(51, 301, 50, 16);
		Cpf.setVisible(true);
		ArticleCFornecedor.add(Cpf);

		CpfCF = new JTextField();
		CpfCF.setDocument(new Documento(14, "[\\D&&[^.-]]"));
		CpfCF.setForeground(Color.LIGHT_GRAY);
		CpfCF.setColumns(10);
		CpfCF.setText("000.000.000-00");
		CpfCF.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (CpfCF.getText().length() <= 0 && CpfCF.getForeground() == Color.black) {
					CpfCF.setText("000.000.000-00");
					CpfCF.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (CpfCF.getText().length() > 0 && CpfCF.getForeground() == Color.LIGHT_GRAY) {
					CpfCF.setText("");
					CpfCF.setForeground(Color.black);
				}
			}
		});
		CpfCF.setVisible(true);
		CpfCF.setBounds(51, 318, 539, 25);
		ArticleCFornecedor.add(CpfCF);

		// Required6
		Required6.setFont(new Font("Arial", Font.PLAIN, 16));
		Required6.setForeground(Color.RED);
		Required6.setBounds(114, 301, 6, 16);
		Required6.setVisible(false);
		ArticleCFornecedor.add(Required6);

		// C.P.F.
		Cnpj.setFont(new Font("Arial", Font.PLAIN, 16));
		Cnpj.setBounds(51, 301, 63, 16);
		Cnpj.setVisible(false);
		ArticleCFornecedor.add(Cnpj);

		CnpjCF = new JTextField();
		CnpjCF.setDocument(new Documento(18, "[\\D&&[^./-]]"));
		CnpjCF.setForeground(Color.LIGHT_GRAY);
		CnpjCF.setColumns(10);
		CnpjCF.setText("00.000.000/0000-00");
		CnpjCF.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (CnpjCF.getText().length() <= 0 && CnpjCF.getForeground() == Color.black) {
					CnpjCF.setText("00.000.000/0000-00");
					CnpjCF.setForeground(Color.LIGHT_GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (CnpjCF.getText().length() > 0 && CnpjCF.getForeground() == Color.LIGHT_GRAY) {
					CnpjCF.setText("");
					CnpjCF.setForeground(Color.black);
				}
			}
		});
		CnpjCF.setVisible(true);
		CnpjCF.setBounds(51, 318, 539, 25);
		CnpjCF.setVisible(false);
		ArticleCFornecedor.add(CnpjCF);

		JLabel Cadastrar = DefaultComponentFactory.getInstance().createTitle("Cadastrar");
		Cadastrar.setBounds(42, 18, 70, 16);
		CadastrarCF.add(Cadastrar);
		Cadastrar.setForeground(Color.BLACK);
		Cadastrar.setFont(new Font("Arial", Font.PLAIN, 16));

		// CadastrarCF
		CadastrarCF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				CadastrarCF.setBackground(new Color(0, 100, 0));
				Cadastrar.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				CadastrarCF.setBackground(new Color(50, 205, 50));
				Cadastrar.setForeground(Color.black);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Fornecedor fornecedor = new Fornecedor();
				if (txtId.getText().trim().equals("-1")) {
					try {
						fornecedor.cadastrarFornecedor(NomeCF.getText(), CpfCF.getText(), CnpjCF.getText(),
								PessoaFisica.isSelected(), EnderecoCF.getText(), Numero.getText(),
								ComplementoCF.getText(), Telefone1CF.getText(), Telefone2CF.getText(),
								EmailCF.getText());
						JOptionPane.showMessageDialog(ArticleCFornecedor, "Fornecedor cadastrado com sucesso.", null,
								JOptionPane.INFORMATION_MESSAGE);
						txtId.setText("-1");
						NomeCF.setText("Nome completo");
						EnderecoCF.setText("prefixo (rua,AV.,e.t.c...) seu endereço");
						Numero.setText("123456");
						Complemento.setText("Complemento do seu endereço");
						Telefone1CF.setText("(99) 99999-9999");
						Telefone2CF.setText("(99) 99999-9999");
						EmailCF.setText("seuemail@gmail.com");
						CpfCF.setText("000.000.000-00");
						CnpjCF.setText("00.000.000/0000-00");
						NomeCF.setForeground(Color.LIGHT_GRAY);
						EnderecoCF.setForeground(Color.LIGHT_GRAY);
						Numero.setForeground(Color.LIGHT_GRAY);
						Complemento.setForeground(Color.LIGHT_GRAY);
						Telefone1CF.setForeground(Color.LIGHT_GRAY);
						Telefone2CF.setForeground(Color.LIGHT_GRAY);
						EmailCF.setForeground(Color.LIGHT_GRAY);
						CpfCF.setForeground(Color.LIGHT_GRAY);
						CnpjCF.setForeground(Color.LIGHT_GRAY);
						PessoaFisica.setSelected(true);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(ArticleCFornecedor, e1.getMessage(), null,
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					try {
						fornecedor.alterarFornecedor(txtId.getText(), NomeCF.getText(), EnderecoCF.getText(),
								Numero.getText(), Complemento.getText(), Telefone1CF.getText(), Telefone2CF.getText(),
								EmailCF.getText(), CpfCF.getText(), CnpjCF.getText(), PessoaFisica.isSelected());
						JOptionPane.showMessageDialog(ArticleCFornecedor, "Fornecedor alterado com sucesso.", null,
								JOptionPane.INFORMATION_MESSAGE);
						txtId.setText("-1");
						NomeCF.setText("Nome completo");
						EnderecoCF.setText("prefixo (rua,AV.,e.t.c...) seu endereço");
						Numero.setText("123456");
						Complemento.setText("Complemento do seu endereço");
						Telefone1CF.setText("(99) 99999-9999");
						Telefone2CF.setText("(99) 99999-9999");
						EmailCF.setText("seuemail@gmail.com");
						CpfCF.setText("000.000.000-00");
						CnpjCF.setText("00.000.000/0000-00");
						NomeCF.setForeground(Color.LIGHT_GRAY);
						EnderecoCF.setForeground(Color.LIGHT_GRAY);
						Numero.setForeground(Color.LIGHT_GRAY);
						Complemento.setForeground(Color.LIGHT_GRAY);
						Telefone1CF.setForeground(Color.LIGHT_GRAY);
						Telefone2CF.setForeground(Color.LIGHT_GRAY);
						EmailCF.setForeground(Color.LIGHT_GRAY);
						CpfCF.setForeground(Color.LIGHT_GRAY);
						CnpjCF.setForeground(Color.LIGHT_GRAY);
						PessoaFisica.setSelected(true);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(ArticleCFornecedor, e1.getMessage(), null,
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		CadastrarCF.setBackground(new Color(50, 205, 50));
		CadastrarCF.setBounds(786, 450, 147, 50);
		ArticleCFornecedor.add(CadastrarCF);
		CadastrarCF.setLayout(null);

		JLabel Cancelar = DefaultComponentFactory.getInstance().createTitle("Cancelar");
		Cancelar.setBounds(43, 18, 65, 16);
		CancelarCF.add(Cancelar);
		Cancelar.setForeground(Color.BLACK);
		Cancelar.setFont(new Font("Arial", Font.PLAIN, 16));

		// CancelarCF
		CancelarCF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				CancelarCF.setBackground(new Color(0, 100, 0));
				Cancelar.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				CancelarCF.setBackground(new Color(50, 205, 50));
				Cancelar.setForeground(Color.black);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtId.setText("-1");
				NomeCF.setText("Nome completo");
				NomeCF.setForeground(Color.LIGHT_GRAY);
				EnderecoCF.setText("prefixo (rua,AV.,e.t.c...) seu endereço");
				EnderecoCF.setForeground(Color.LIGHT_GRAY);
				Numero.setText("123456");
				Numero.setForeground(Color.LIGHT_GRAY);
				Complemento.setText("Complemento do seu endereço");
				Complemento.setForeground(Color.LIGHT_GRAY);
				Telefone1CF.setText("(99) 99999-9999");
				Telefone1CF.setForeground(Color.LIGHT_GRAY);
				Telefone2CF.setText("(99) 99999-9999");
				Telefone2CF.setForeground(Color.LIGHT_GRAY);
				EmailCF.setText("seuemail@gmail.com");
				EmailCF.setForeground(Color.LIGHT_GRAY);
				CpfCF.setText("000.000.000-00");
				CpfCF.setForeground(Color.LIGHT_GRAY);
				CnpjCF.setText("00.000.000/0000-00");
				CnpjCF.setForeground(Color.LIGHT_GRAY);
				PessoaFisica.setSelected(true);
			}
		});
		CancelarCF.setBackground(new Color(50, 205, 50));
		CancelarCF.setBounds(935, 450, 147, 50);
		ArticleCFornecedor.add(CancelarCF);
		CancelarCF.setLayout(null);

		JPanel Section = new JPanel();
		Section.setBackground(Color.WHITE);
		Section.setBounds(139, 169, 1088, 506);
		frame.getContentPane().add(Section);

		JLabel FooterText = DefaultComponentFactory.getInstance().createTitle("\u00A9 Trabalho de banco de dados");
		FooterText.setForeground(Color.WHITE);
		FooterText.setFont(new Font("Arial", Font.PLAIN, 16));
		FooterText.setBounds(10, 686, 216, 14);
		frame.getContentPane().add(FooterText);

		JPanel Footer = new JPanel();
		Footer.setBackground(Color.BLACK);
		Footer.setBounds(0, (int) (d.getHeight() - 87), (int) (d.getWidth()), 24);
		frame.getContentPane().add(Footer);
	}

	public boolean criarTabela(String[] Colunas, JTable table, String sql) {
		ArrayList<Object> dados = new ArrayList<Object>();
		ArrayList<Fornecedor> dados2 = new ArrayList<Fornecedor>();
		try {
			Fornecedor fornecedor = new Fornecedor();
			dados2 = fornecedor.buscarFornecedor();
			for (int i = 0; i < dados2.size(); i++) {
				dados.add(new Object[] { dados2.get(i).getId(), dados2.get(i).getNome(), dados2.get(i).getCpf(),
						dados2.get(i).getContato().getNumero1(), dados2.get(i).getContato().getNumero2(),
						dados2.get(i).getContato().getEmail() });
			}
		} catch (Exception e) {
			ModeloTabela modelo = new ModeloTabela(dados, Colunas);
			table.setModel(modelo);
			table.getColumnModel().getColumn(0).setMaxWidth(0);
			table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
			table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(0).setResizable(true);
			table.getColumnModel().getColumn(1).setPreferredWidth(334);
			table.getColumnModel().getColumn(1).setResizable(true);
			table.getColumnModel().getColumn(2).setPreferredWidth(134);
			table.getColumnModel().getColumn(2).setResizable(true);
			table.getColumnModel().getColumn(3).setPreferredWidth(134);
			table.getColumnModel().getColumn(3).setResizable(true);
			table.getColumnModel().getColumn(4).setPreferredWidth(134);
			table.getColumnModel().getColumn(4).setResizable(true);
			table.getColumnModel().getColumn(5).setPreferredWidth(231);
			table.getColumnModel().getColumn(5).setResizable(true);
			table.getTableHeader().setReorderingAllowed(true);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			return false;
		}
		ModeloTabela modelo = new ModeloTabela(dados, Colunas);
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setResizable(true);
		table.getColumnModel().getColumn(1).setPreferredWidth(334);
		table.getColumnModel().getColumn(1).setResizable(true);
		table.getColumnModel().getColumn(2).setPreferredWidth(134);
		table.getColumnModel().getColumn(2).setResizable(true);
		table.getColumnModel().getColumn(3).setPreferredWidth(134);
		table.getColumnModel().getColumn(3).setResizable(true);
		table.getColumnModel().getColumn(4).setPreferredWidth(134);
		table.getColumnModel().getColumn(4).setResizable(true);
		table.getColumnModel().getColumn(5).setPreferredWidth(231);
		table.getColumnModel().getColumn(5).setResizable(true);
		table.getTableHeader().setReorderingAllowed(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		return true;
	}

	public boolean criarTabelaC(String[] Colunas, JTable table, String sql) {
		ArrayList<Object> dados = new ArrayList<Object>();
		ArrayList<Cliente> dados2 = new ArrayList<Cliente>();
		try {
			Cliente cliente = new Cliente();
			dados2 = cliente.buscarClientes();
			for (int i = 0; i < dados2.size(); i++) {
				dados.add(new Object[] { dados2.get(i).getId(), dados2.get(i).getNome(), dados2.get(i).getCpf(),
						dados2.get(i).getContato().getNumero1(), dados2.get(i).getContato().getNumero2(),
						dados2.get(i).getContato().getEmail() });
			}
		} catch (Exception e) {
			ModeloTabela modelo = new ModeloTabela(dados, Colunas);
			table.setModel(modelo);
			table.getColumnModel().getColumn(0).setMaxWidth(0);
			table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
			table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(0).setResizable(true);
			table.getColumnModel().getColumn(1).setPreferredWidth(334);
			table.getColumnModel().getColumn(1).setResizable(true);
			table.getColumnModel().getColumn(2).setPreferredWidth(134);
			table.getColumnModel().getColumn(2).setResizable(true);
			table.getColumnModel().getColumn(3).setPreferredWidth(134);
			table.getColumnModel().getColumn(3).setResizable(true);
			table.getColumnModel().getColumn(4).setPreferredWidth(134);
			table.getColumnModel().getColumn(4).setResizable(true);
			table.getColumnModel().getColumn(5).setPreferredWidth(231);
			table.getColumnModel().getColumn(5).setResizable(true);
			table.getTableHeader().setReorderingAllowed(true);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			return false;
		}
		ModeloTabela modelo = new ModeloTabela(dados, Colunas);
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setResizable(true);
		table.getColumnModel().getColumn(1).setPreferredWidth(334);
		table.getColumnModel().getColumn(1).setResizable(true);
		table.getColumnModel().getColumn(2).setPreferredWidth(134);
		table.getColumnModel().getColumn(2).setResizable(true);
		table.getColumnModel().getColumn(3).setPreferredWidth(134);
		table.getColumnModel().getColumn(3).setResizable(true);
		table.getColumnModel().getColumn(4).setPreferredWidth(134);
		table.getColumnModel().getColumn(4).setResizable(true);
		table.getColumnModel().getColumn(5).setPreferredWidth(231);
		table.getColumnModel().getColumn(5).setResizable(true);
		table.getTableHeader().setReorderingAllowed(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		return true;
	}
}
