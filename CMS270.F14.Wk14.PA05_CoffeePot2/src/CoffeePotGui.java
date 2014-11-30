import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CoffeePotGui extends JFrame {

	private JPanel contentPane;
	private int creamWanted = 0;
	private int lemonWanted = 0;
	private int sugarWanted = 0;
	private ArrayList<BeverageComponent> order = new ArrayList<BeverageComponent>();
	private BeverageComponent beverage;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// }

	/**
	 * Create the frame.
	 */
	public CoffeePotGui() {
		super();
		BeverageComponent coffee = new Coffee();
		BeverageComponent decaf = new Decaf();
		BeverageComponent soup = new Soup();
		BeverageComponent tea = new Tea();
		BeverageComponent cream = new Cream();
		BeverageComponent lemon = new Lemon();
		BeverageComponent sugar = new Sugar();

		ProductList pl = new ProductList();
		ChangeMachine cm = new ChangeMachine();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// top panel
		JPanel topPanel = new JPanel();
		topPanel.setBounds(10, 11, 364, 85);
		contentPane.add(topPanel);

		// JTextPane textPane = new JTextPane();
		// topPanel.add(textPane);

		// beverage menu panel
		JPanel bevPanel = new JPanel();
		bevPanel.setBounds(10, 107, 364, 100);
		contentPane.add(bevPanel);
		JButton[] bevButtons = new JButton[pl.getAllBeverages().size()];
		for (int i = 0; i < pl.getAllBeverages().size(); i++) {
			beverage = (BeverageComponent) pl.getAllBeverages().get(i);
			System.out.println(beverage);
			bevButtons[i] = new JButton(
					((Beverage) pl.getAllBeverages().get(i)).getName());
			bevPanel.add(bevButtons[i]);
			// bevButtons[i].addActionListener(new ActionListener() {
			//
			// @Override
			// public void actionPerformed(ActionEvent e) {
			// @SuppressWarnings("unused")
			// JButton button = (JButton) e.getSource();
			// order.add();
			// }
			// });
		}
		// for (int i = 0; i < order.size(); i++) {
		// System.out.println(order.get(i).getName());
		// }

		// condiment menu panel
		JPanel condimentPanel = new JPanel();
		condimentPanel.setBounds(10, 218, 364, 100);
		contentPane.add(condimentPanel);

		JLabel condimentCreamButton = new JLabel("Cream");
		condimentCreamButton.setBounds(51, 5, 40, 14);
		JLabel condimentSugarButton = new JLabel("Sugar");
		condimentSugarButton.setBounds(168, 5, 40, 14);
		JLabel condimentLemonButton = new JLabel("Lemon");
		condimentLemonButton.setBounds(292, 5, 40, 14);
		condimentPanel.setLayout(null);
		condimentPanel.add(condimentCreamButton);
		condimentPanel.add(condimentSugarButton);
		condimentPanel.add(condimentLemonButton);

		JButton btnPlusCream = new JButton("+");
		btnPlusCream.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creamWanted++;
				// add cream to order
				order.add(cream);
				if (cream.getInventory() <= creamWanted) {
					btnPlusCream.setEnabled(false);
				}
			}
		});
		btnPlusCream.setBounds(20, 30, 89, 23);
		btnPlusCream.setEnabled(false);
		condimentPanel.add(btnPlusCream);

		JButton btnMinCream = new JButton("-");
		btnMinCream.setBounds(20, 66, 89, 23);
		btnMinCream.setEnabled(false);
		condimentPanel.add(btnMinCream);

		JButton btnPlusSugar = new JButton("+");
		btnPlusSugar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sugarWanted++;
				if (sugar.getInventory() <= sugarWanted) {
					btnPlusSugar.setEnabled(false);
				}
			}
		});
		btnPlusSugar.setBounds(137, 30, 89, 23);
		btnPlusSugar.setEnabled(false);
		condimentPanel.add(btnPlusSugar);

		JButton btnMinSugar = new JButton("-");
		btnMinSugar.setBounds(137, 66, 89, 23);
		btnMinSugar.setEnabled(false);
		condimentPanel.add(btnMinSugar);

		JButton btnPlusLemon = new JButton("+");
		btnPlusLemon.setBounds(265, 30, 89, 23);
		btnPlusLemon.setEnabled(false);
		condimentPanel.add(btnPlusLemon);

		JButton btnMinLemon = new JButton("-");
		btnMinLemon.setBounds(265, 66, 89, 23);
		btnMinLemon.setEnabled(false);
		condimentPanel.add(btnMinLemon);

		bevButtons[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnPlusCream.setEnabled(true);
				btnMinCream.setEnabled(true);
				btnPlusSugar.setEnabled(true);
				btnMinSugar.setEnabled(true);
				btnPlusLemon.setEnabled(false);
				btnMinLemon.setEnabled(false);
			}
		});

		bevButtons[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnPlusCream.setEnabled(true);
				btnMinCream.setEnabled(true);
				btnPlusSugar.setEnabled(true);
				btnMinSugar.setEnabled(true);
				btnPlusLemon.setEnabled(false);
				btnMinLemon.setEnabled(false);
			}
		});

		bevButtons[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnPlusCream.setEnabled(true);
				btnMinCream.setEnabled(true);
				btnPlusSugar.setEnabled(true);
				btnMinSugar.setEnabled(true);
				btnPlusLemon.setEnabled(true);
				btnMinLemon.setEnabled(true);

			}
		});

		bevButtons[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnPlusCream.setEnabled(false);
				btnMinCream.setEnabled(false);
				btnPlusSugar.setEnabled(false);
				btnMinSugar.setEnabled(false);
				btnPlusLemon.setEnabled(false);
				btnMinLemon.setEnabled(false);

			}
		});

		// cash control panel
		JPanel cashPanel = new JPanel();
		cashPanel.setLayout(null);
		cashPanel.setBounds(10, 329, 364, 100);
		contentPane.add(cashPanel);

		JButton btnRcard = new JButton("rCard");
		btnRcard.setBounds(70, 11, 89, 23);
		cashPanel.add(btnRcard);

		JButton btnCash = new JButton("Cash");
		btnCash.setBounds(197, 11, 89, 23);
		cashPanel.add(btnCash);

		JButton nickelButton = new JButton(".05");
		nickelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cm.insertNickel();
			}
		});
		nickelButton.setBounds(25, 65, 70, 25);
		cashPanel.add(nickelButton);

		JButton dimeButton = new JButton(".10");
		dimeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cm.insertDime();
			}
		});
		dimeButton.setBounds(109, 65, 70, 25);
		cashPanel.add(dimeButton);

		JButton quarterButton = new JButton(".25");
		quarterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cm.insertQuarter();
			}
		});
		quarterButton.setBounds(197, 65, 70, 25);
		cashPanel.add(quarterButton);

		JButton dollarButton = new JButton("1.00");
		dollarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cm.insertDollar();
			}
		});
		dollarButton.setBounds(286, 65, 70, 25);
		cashPanel.add(dollarButton);

		// order & cancel order panel
		JPanel orderPanel = new JPanel();
		orderPanel.setBounds(10, 442, 364, 69);
		contentPane.add(orderPanel);

		JButton btnOrderButton = new JButton("Order");
		btnOrderButton.setBounds(39, 11, 100, 45);
		btnOrderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		orderPanel.setLayout(null);
		orderPanel.add(btnOrderButton);

		JButton btnCoinReturn = new JButton("Coin Return");
		btnCoinReturn.setBounds(220, 11, 100, 45);
		orderPanel.add(btnCoinReturn);
	}
}
