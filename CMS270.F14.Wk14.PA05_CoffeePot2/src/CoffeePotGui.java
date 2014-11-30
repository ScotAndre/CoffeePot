import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CoffeePotGui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// }

	/**
	 * Create the frame.
	 */
	public CoffeePotGui() {
		// super();
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

		// beverage menu panel
		JPanel bevPanel = new JPanel();
		bevPanel.setBounds(10, 107, 364, 100);
		contentPane.add(bevPanel);
		JButton[] bevButtons = new JButton[pl.getAllBeverages().size()];
		for (int i = 0; i < pl.getAllBeverages().size(); i++) {
			bevButtons[i] = new JButton(
					((Beverage) pl.getAllBeverages().get(i)).getName());
			bevPanel.add(bevButtons[i]);
		}

		// condiment menu panel
		JPanel condimentPanel = new JPanel();
		condimentPanel.setBounds(10, 218, 364, 100);
		contentPane.add(condimentPanel);

		bevButtons[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

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

		JButton nickelButton = new JButton("5");
		nickelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cm.insertNickel();
			}
		});
		nickelButton.setBounds(25, 65, 50, 25);
		cashPanel.add(nickelButton);

		JButton dimeButton = new JButton("10");
		dimeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cm.insertDime();
			}
		});
		dimeButton.setBounds(109, 65, 50, 25);
		cashPanel.add(dimeButton);

		JButton quarterButton = new JButton("25");
		quarterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cm.insertQuarter();
			}
		});
		quarterButton.setBounds(197, 65, 50, 25);
		cashPanel.add(quarterButton);

		JButton dollarButton = new JButton("1");
		dollarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cm.insertDollar();
			}
		});
		dollarButton.setBounds(286, 65, 50, 25);
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
