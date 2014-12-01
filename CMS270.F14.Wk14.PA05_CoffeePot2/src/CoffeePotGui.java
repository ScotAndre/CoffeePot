import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class CoffeePotGui extends JFrame {
	private int creamWanted = 0;
	private int lemonWanted = 0;
	private int sugarWanted = 0;

	/**
	 * Create the frame.
	 */
	public CoffeePotGui() {
		super();
		DecimalFormat df = new DecimalFormat("##0.00");
		JPanel contentPane;
		Order order = new Order();
		BeverageComponent beverage;

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
		topPanel.setLayout(null);

		// Text areas at the top of the window
		JTextArea txtAreaRight = new JTextArea();
		txtAreaRight.setBounds(244, 0, 121, 85);
		txtAreaRight.setTabSize(4);
		txtAreaRight.setRows(4);
		txtAreaRight.setColumns(15);
		topPanel.add(txtAreaRight);
		JTextArea txtAreaCenter = new JTextArea();
		txtAreaCenter.setBounds(122, 0, 121, 85);
		txtAreaCenter.setTabSize(4);
		txtAreaCenter.setRows(4);
		txtAreaCenter.setColumns(15);
		topPanel.add(txtAreaCenter);
		JTextArea txtAreaLeft = new JTextArea();
		txtAreaLeft.setBounds(0, 0, 121, 85);
		txtAreaLeft.setTabSize(4);
		txtAreaLeft.setRows(4);
		txtAreaLeft.setColumns(15);
		topPanel.add(txtAreaLeft);

		// beverage menu panel
		JPanel bevPanel = new JPanel();
		bevPanel.setBounds(10, 107, 364, 100);
		contentPane.add(bevPanel);

		// build an array of buttons, one for each beverage
		JButton[] bevButtons = new JButton[pl.getAllBeverages().size()];
		for (int i = 0; i < pl.getAllBeverages().size(); i++) {
			beverage = (BeverageComponent) pl.getAllBeverages().get(i);
			bevButtons[i] = new JButton(
					((Beverage) pl.getAllBeverages().get(i)).getName());
			bevPanel.add(bevButtons[i]);
		}

		bevButtons[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				order.add(coffee);
				cm.addToPurchase(coffee.getPrice());
				double total = cm.getTotalPurchase() / 100.0;
				txtAreaRight.append("Total:\n $ " + df.format(total));
			}
		});

		bevButtons[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				order.add(decaf);
				cm.addToPurchase(decaf.getPrice());
				double total = cm.getTotalPurchase() / 100.0;
				txtAreaRight.append("Total:\n $ " + df.format(total));
			}
		});

		bevButtons[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				order.add(tea);
				cm.addToPurchase(tea.getPrice());
				double total = cm.getTotalPurchase() / 100.0;
				txtAreaRight.append("Total:\n $ " + df.format(total));
			}
		});

		bevButtons[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				order.add(soup);
				cm.addToPurchase(soup.getPrice());
				double total = cm.getTotalPurchase() / 100.0;
				txtAreaRight.append("Total:\n $ " + df.format(total));
			}
		});

		// Condiment Buttons
		JButton btnPlusCream = new JButton("+");
		JButton btnMinCream = new JButton("-");
		JButton btnPlusSugar = new JButton("+");
		JButton btnMinSugar = new JButton("-");
		JButton btnPlusLemon = new JButton("+");
		JButton btnMinLemon = new JButton("-");

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

		btnPlusCream.setBounds(20, 30, 89, 23);
		btnPlusCream.setEnabled(false);
		condimentPanel.add(btnPlusCream);

		// ActionListener for Cream Plus Button
		btnPlusCream.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creamWanted++;
				order.add(cream);
				if (cream.getInventory() <= creamWanted) {
					btnPlusCream.setEnabled(false);
				}
				btnMinCream.setEnabled(true);
			}
		});

		// ActionListener for Cream Minus Button
		btnMinCream.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				creamWanted--;
				order.remove(cream);
				if (creamWanted == 0) {
					btnMinCream.setEnabled(false);
				}
			}
		});
		btnMinCream.setBounds(20, 66, 89, 23);
		btnMinCream.setEnabled(false);
		condimentPanel.add(btnMinCream);

		// ActionListener for Sugar Plus Button
		btnPlusSugar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sugarWanted++;
				order.add(sugar);
				if (sugar.getInventory() <= sugarWanted) {
					btnPlusSugar.setEnabled(false);
				}
				btnMinSugar.setEnabled(true);

			}
		});
		btnPlusSugar.setBounds(137, 30, 89, 23);
		btnPlusSugar.setEnabled(false);
		condimentPanel.add(btnPlusSugar);

		// ActionListener for Sugar Minus Button
		btnMinSugar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sugarWanted--;
				order.remove(sugar);
				if (sugarWanted == 0) {
					btnMinSugar.setEnabled(false);
				}
			}
		});
		btnMinSugar.setBounds(137, 66, 89, 23);
		btnMinSugar.setEnabled(false);
		condimentPanel.add(btnMinSugar);

		// ActionListener for Lemon Plus Button
		btnPlusLemon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lemonWanted++;
				order.add(lemon);
				if (lemon.getInventory() <= lemonWanted) {
					btnPlusLemon.setEnabled(false);
				}
				btnMinLemon.setEnabled(true);
			}
		});

		// ActionListener for Lemon Minus Button
		btnMinLemon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lemonWanted--;
				order.remove(lemon);
				if (lemonWanted == 0) {
					btnMinLemon.setEnabled(false);
				}
			}
		});

		btnPlusLemon.setBounds(265, 30, 89, 23);
		btnPlusLemon.setEnabled(false);
		condimentPanel.add(btnPlusLemon);

		btnMinLemon.setBounds(265, 66, 89, 23);
		btnMinLemon.setEnabled(false);
		condimentPanel.add(btnMinLemon);

		// cash control panel
		JPanel cashPanel = new JPanel();
		cashPanel.setLayout(null);
		cashPanel.setBounds(10, 329, 364, 100);
		contentPane.add(cashPanel);

		// Cash Control Buttons
		JButton btnOrderButton = new JButton("Order");
		JButton btnCoinReturn = new JButton("Coin Return");
		JButton nickelButton = new JButton(".05");
		JButton dimeButton = new JButton(".10");
		JButton quarterButton = new JButton(".25");
		JButton dollarButton = new JButton("1.00");

		nickelButton.setEnabled(false);
		dimeButton.setEnabled(false);
		quarterButton.setEnabled(false);
		dollarButton.setEnabled(false);

		JButton btnRcard = new JButton("rCard");
		btnRcard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cm.setPaymentToRCard();
				nickelButton.setEnabled(false);
				dimeButton.setEnabled(false);
				quarterButton.setEnabled(false);
				dollarButton.setEnabled(false);
			}
		});
		btnRcard.setBounds(70, 11, 89, 23);
		cashPanel.add(btnRcard);

		JButton btnCash = new JButton("Cash");
		// ActionListener for the Cash Button
		btnCash.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nickelButton.setEnabled(true);
				dimeButton.setEnabled(true);
				quarterButton.setEnabled(true);
				dollarButton.setEnabled(true);
			}
		});
		btnCash.setBounds(197, 11, 89, 23);
		cashPanel.add(btnCash);

		// ActionListener for the Nickel Button
		nickelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cm.insertNickel();
				System.out.println("Your total inserted is: "
						+ cm.checkInsertedMoney());
				if (cm.hasPaidEnough(cm.getTotalPurchase())) {
					btnOrderButton.setEnabled(true);
				}
			}
		});
		nickelButton.setBounds(25, 65, 70, 25);
		cashPanel.add(nickelButton);

		dimeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cm.insertDime();
				System.out.println("Your total inserted is: "
						+ cm.checkInsertedMoney());
				if (cm.hasPaidEnough(cm.getTotalPurchase())) {
					btnOrderButton.setEnabled(true);
				}
			}
		});
		dimeButton.setBounds(109, 65, 70, 25);
		cashPanel.add(dimeButton);

		quarterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cm.insertQuarter();
				System.out.println("Your total inserted is: "
						+ cm.checkInsertedMoney());
				if (cm.hasPaidEnough(cm.getTotalPurchase())) {
					btnOrderButton.setEnabled(true);
				}
			}
		});
		quarterButton.setBounds(197, 65, 70, 25);
		cashPanel.add(quarterButton);

		dollarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cm.insertDollar();
				System.out.println("Your total inserted is: "
						+ cm.checkInsertedMoney());
				if (cm.hasPaidEnough(cm.getTotalPurchase())) {
					btnOrderButton.setEnabled(true);
				}
			}
		});
		dollarButton.setBounds(286, 65, 70, 25);
		cashPanel.add(dollarButton);

		// order & cancel order panel
		JPanel orderPanel = new JPanel();
		orderPanel.setBounds(10, 442, 364, 69);
		contentPane.add(orderPanel);

		btnOrderButton.setBounds(39, 11, 100, 45);
		// if payment is set to rCard - disable coin buttons
		// if payment is set to rCard - enable order button
		// if payment is set to cash - only enable order button if
		// enough money has been inserted
		if (!cm.getPaymentType()) {
			btnOrderButton.setEnabled(true);
		} else {
			btnOrderButton.setEnabled(false);
		}

		// ActionListener for Order Button
		btnOrderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < order.getOrder().size(); i++) {
					System.out.println(order.getOrder().get(i));
					btnPlusCream.setEnabled(false);
					btnMinCream.setEnabled(false);
					btnPlusSugar.setEnabled(false);
					btnMinSugar.setEnabled(false);
					btnPlusLemon.setEnabled(false);
					btnMinLemon.setEnabled(false);
					order.dispense();
					creamWanted = 0;
					lemonWanted = 0;
					sugarWanted = 0;
				}
			}
		});
		orderPanel.setLayout(null);
		orderPanel.add(btnOrderButton);

		// ActionListener for Coin Return
		btnCoinReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cm.makeChange(cm.checkInsertedMoney());
				btnOrderButton.setEnabled(false);
				order.cancelOrder();
				btnPlusCream.setEnabled(false);
				btnMinCream.setEnabled(false);
				btnPlusSugar.setEnabled(false);
				btnMinSugar.setEnabled(false);
				btnPlusLemon.setEnabled(false);
				btnMinLemon.setEnabled(false);
				creamWanted = 0;
				lemonWanted = 0;
				sugarWanted = 0;
			}
		});
		btnCoinReturn.setBounds(220, 11, 100, 45);
		orderPanel.add(btnCoinReturn);

		// *******************************************
		// ActionListeners for Beverages
		// *******************************************
		// ActionListener for Coffee
		bevButtons[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cream.getInventory() > creamWanted) {
					btnPlusCream.setEnabled(true);
				} else {
					btnPlusCream.setEnabled(false);
				}
				if (creamWanted > 0) {
					btnMinCream.setEnabled(true);
				} else {
					btnMinCream.setEnabled(false);
				}
				if (sugar.getInventory() > sugarWanted) {
					btnPlusSugar.setEnabled(true);
				} else {
					btnPlusSugar.setEnabled(false);
				}
				if (sugarWanted > 0) {
					btnMinSugar.setEnabled(true);
				} else {
					btnMinSugar.setEnabled(false);
				}
				btnPlusLemon.setEnabled(false);
				btnMinLemon.setEnabled(false);
			}
		});

		// ActionListener for Decaf
		bevButtons[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cream.getInventory() > creamWanted) {
					btnPlusCream.setEnabled(true);
				} else {
					btnPlusCream.setEnabled(false);
				}
				if (creamWanted > 0) {
					btnMinCream.setEnabled(true);
				} else {
					btnMinCream.setEnabled(false);
				}
				if (sugar.getInventory() > sugarWanted) {
					btnPlusSugar.setEnabled(true);
				} else {
					btnPlusSugar.setEnabled(false);
				}
				if (sugarWanted > 0) {
					btnMinSugar.setEnabled(true);
				} else {
					btnMinSugar.setEnabled(false);
				}
				btnPlusLemon.setEnabled(false);
				btnMinLemon.setEnabled(false);
			}
		});

		// ActionListener for Tea
		bevButtons[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cream.getInventory() > creamWanted) {
					btnPlusCream.setEnabled(true);
				} else {
					btnPlusCream.setEnabled(false);
				}
				if (creamWanted > 0) {
					btnMinCream.setEnabled(true);
				} else {
					btnMinCream.setEnabled(false);
				}
				if (sugar.getInventory() > sugarWanted) {
					btnPlusSugar.setEnabled(true);
				} else {
					btnPlusSugar.setEnabled(false);
				}
				if (sugarWanted > 0) {
					btnMinSugar.setEnabled(true);
				} else {
					btnMinSugar.setEnabled(false);
				}
				if (lemon.getInventory() > lemonWanted) {
					btnPlusLemon.setEnabled(true);
				} else {
					btnPlusLemon.setEnabled(false);
				}
				if (lemonWanted > 0) {
					btnMinLemon.setEnabled(true);
				} else {
					btnMinLemon.setEnabled(false);
				}

			}
		});

		// ActionListener for Soup
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

	}
}
