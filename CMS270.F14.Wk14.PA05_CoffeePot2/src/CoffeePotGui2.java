import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class CoffeePotGui2 extends JFrame {
	private int creamWanted = 0;
	private int lemonWanted = 0;
	private int sugarWanted = 0;

	public CoffeePotGui2() {
		super();
		DecimalFormat df = new DecimalFormat("##0.00");
		Order order = new Order();
		ProductList pl = new ProductList();
		ChangeMachine cm = new ChangeMachine();
		BeverageComponent beverage;
		BeverageComponent condiment;

		BeverageComponent coffee = new Coffee();
		BeverageComponent decaf = new Decaf();
		BeverageComponent soup = new Soup();
		BeverageComponent tea = new Tea();
		BeverageComponent cream = new Cream();
		BeverageComponent lemon = new Lemon();
		BeverageComponent sugar = new Sugar();

		// Buttons
		// condiment buttons
		JButton btnAddCream = new JButton("+");
		JButton btnSubtractCream = new JButton("-");
		JButton btnAddLemon = new JButton("+");
		JButton btnSubtractLemon = new JButton("-");
		JButton btnAddSugar = new JButton("+");
		JButton btnSubtractSugar = new JButton("-");

		JPanel contentPane;
		setBounds(100, 100, 400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(5, 1));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setBackground(Color.black);
		setContentPane(contentPane);

		// top or message panel
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel);
		topPanel.setLayout(new GridLayout(1, 3));
		JTextArea textLeft = new JTextArea();
		JTextArea textCenter = new JTextArea();
		JTextArea textRight = new JTextArea();
		topPanel.add(textLeft);
		topPanel.add(textCenter);
		topPanel.add(textRight);
		textLeft.setTabSize(4);
		textLeft.setRows(4);
		textLeft.setColumns(15);
		textLeft.setText("");
		textCenter.setTabSize(2);
		textCenter.setRows(6);
		textCenter.setColumns(15);
		textCenter.setText("\t\tMenu:\n");
		textRight.setTabSize(4);
		textRight.setRows(4);
		textRight.setColumns(15);
		textRight.setText("");

		// beverage selection panel
		JPanel bevPanel = new JPanel();
		contentPane.add(bevPanel);
		bevPanel.setLayout(new GridLayout(1, pl.getAllBeverages().size()));

		// build an array of buttons, one for each beverage
		JButton[] bevButtons = new JButton[pl.getAllBeverages().size()];
		for (int i = 0; i < pl.getAllBeverages().size(); i++) {
			beverage = (Beverage) pl.getAllBeverages().get(i);
			bevButtons[i] = new JButton(
					((Beverage) pl.getAllBeverages().get(i)).getName());
			bevPanel.add(bevButtons[i]);
			// Build the menu
			textCenter.append("\t" + beverage.toString() + "\n");
			// ActionListeners
			bevButtons[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String button = ((JButton) e.getSource()).getText();

					if (button.equalsIgnoreCase("Coffee")) {
						// turn off the beverage buttons
						for (int j = 0; j < bevButtons.length; j++) {
							bevButtons[j].setEnabled(false);
						}

						// active appropriate condiment buttons
						if (cream.getInventory() > creamWanted) {
							btnAddCream.setEnabled(true);
						}
						if (creamWanted > 0) {
							btnSubtractCream.setEnabled(true);
						}
						if (sugar.getInventory() > sugarWanted) {
							btnAddSugar.setEnabled(true);
						}
						if (sugarWanted > 0) {
							btnSubtractSugar.setEnabled(true);
						}
						order.add(coffee);
						cm.addToPurchase(coffee.getPrice());
						textRight.setText("");
						double total = cm.getTotalPurchase() / 100.0;
						textRight.append("\tTotal: \n$ " + df.format(total)
								+ "\n");
						textLeft.setText("");
					}// end coffee conditional

					if (button.equalsIgnoreCase("Decaf")) {
						// turn off the beverage buttons
						for (int j = 0; j < bevButtons.length; j++) {
							bevButtons[j].setEnabled(false);
						}

						// active appropriate condiment buttons
						if (cream.getInventory() > creamWanted) {
							btnAddCream.setEnabled(true);
						}
						if (sugar.getInventory() > sugarWanted) {
							btnAddSugar.setEnabled(true);
						}
						order.add(decaf);
						cm.addToPurchase(decaf.getPrice());
						textRight.setText("");
						double total = cm.getTotalPurchase() / 100.0;
						textRight.append("\tTotal: \n$ " + df.format(total)
								+ "\n");
						textLeft.setText("");
					}// end decaf conditional

					if (button.equalsIgnoreCase("Tea")) {
						// turn off the beverage buttons
						for (int j = 0; j < bevButtons.length; j++) {
							bevButtons[j].setEnabled(false);
						}

						if (cream.getInventory() > creamWanted) {
							btnAddCream.setEnabled(true);
						}
						if (lemon.getInventory() > lemonWanted) {
							btnAddLemon.setEnabled(true);
						}
						if (sugar.getInventory() > sugarWanted) {
							btnAddSugar.setEnabled(true);
						}
						order.add(tea);
						cm.addToPurchase(tea.getPrice());
						textRight.setText("");
						double total = cm.getTotalPurchase() / 100.0;
						textRight.append("\tTotal: \n$ " + df.format(total)
								+ "\n");
						textLeft.setText("");
					}// end tea conditional

					if (button.equalsIgnoreCase("Soup")) {
						// turn off the beverage buttons
						for (int j = 0; j < bevButtons.length; j++) {
							bevButtons[j].setEnabled(false);
						}
						order.add(soup);
						cm.addToPurchase(soup.getPrice());
						textRight.setText("");
						double total = cm.getTotalPurchase() / 100.0;
						textRight.append("\tTotal: \n$ " + df.format(total)
								+ "\n");
						textLeft.setText("");
					}// end soup conditional
				}
			});

		}// end button array for loop

		// condiment menu panel
		JPanel condimentPanel = new JPanel();
		JPanel topCondPanel = new JPanel();
		JPanel bottomCondPanel = new JPanel();
		contentPane.add(condimentPanel);
		condimentPanel.add(topCondPanel);
		condimentPanel.add(bottomCondPanel);
		condimentPanel.setBackground(Color.WHITE);
		condimentPanel.setLayout(new GridLayout(2, 1));
		topCondPanel.setLayout(new GridLayout(1, 3));
		bottomCondPanel.setLayout(new GridLayout(1, 6));

		// condiment labels
		JLabel[] condimentLabels = new JLabel[pl.getAllCondiments().size()];
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		for (int i = 0; i < pl.getAllCondiments().size(); i++) {
			condiment = (BeverageComponent) pl.getAllCondiments().get(i);
			condimentLabels[i] = new JLabel(((Condiment) pl.getAllCondiments()
					.get(i)).getName());
			topCondPanel.add(condimentLabels[i]);
			condimentLabels[i].setHorizontalAlignment(JLabel.CENTER);
			condimentLabels[i].setBorder(border);
		}
		// condiment add & subtract buttons
		bottomCondPanel.add(btnAddCream);
		bottomCondPanel.add(btnSubtractCream);
		bottomCondPanel.add(btnAddLemon);
		bottomCondPanel.add(btnSubtractLemon);
		bottomCondPanel.add(btnAddSugar);
		bottomCondPanel.add(btnSubtractSugar);
		btnAddCream.setEnabled(false);
		btnSubtractCream.setEnabled(false);
		btnAddLemon.setEnabled(false);
		btnSubtractLemon.setEnabled(false);
		btnAddSugar.setEnabled(false);
		btnSubtractSugar.setEnabled(false);

		// payment control panel
		JPanel paymentPanel = new JPanel();
		JPanel paymentTop = new JPanel();
		JPanel paymentBottom = new JPanel();
		contentPane.add(paymentPanel);
		paymentPanel.add(paymentTop);
		paymentPanel.add(paymentBottom);

		// payment buttons
		JButton btnRCard = new JButton("rCard");
		JButton btnCash = new JButton("Cash");
		paymentTop.add(btnRCard);
		paymentTop.add(btnCash);

		// coin buttons
		JButton btnNickel = new JButton(".05");
		JButton btnDime = new JButton(".10");
		JButton btnQuarter = new JButton(".25");
		JButton btnDollar = new JButton("1.00");
		paymentBottom.add(btnNickel);
		paymentBottom.add(btnDime);
		paymentBottom.add(btnQuarter);
		paymentBottom.add(btnDollar);
		btnNickel.setEnabled(false);
		btnDime.setEnabled(false);
		btnQuarter.setEnabled(false);
		btnDollar.setEnabled(false);

		// order control panel
		JPanel orderPanel = new JPanel();
		JPanel oPanelLeft = new JPanel();
		JPanel oPanelRight = new JPanel();
		contentPane.add(orderPanel);
		orderPanel.add(oPanelLeft);
		orderPanel.add(oPanelRight);

		// order & coin return Buttons
		JButton btnOrder = new JButton("Order");
		JButton btnCoinReturn = new JButton("Coin Return");
		oPanelLeft.add(btnOrder);
		oPanelRight.add(btnCoinReturn);

		// ***********************************************
		// ActionListeners
		// ***********************************************
		// Coin Return ActionListener
		btnCoinReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// re-enable all beverage buttons
				for (int i = 0; i < bevButtons.length; i++) {
					bevButtons[i].setEnabled(true);
				}
				// refund money
				textLeft.setText("");
				double refund = cm.getInsertedAmount() / 100.0;
				textLeft.append("Refunded: $ " + df.format(refund));
				cm.coinReturn();
				textRight.setText("\tTotal:");

				// reset condiments
				creamWanted = 0;
				lemonWanted = 0;
				sugarWanted = 0;
				btnAddCream.setEnabled(false);
				btnSubtractCream.setEnabled(false);
				btnAddLemon.setEnabled(false);
				btnSubtractLemon.setEnabled(false);
				btnAddSugar.setEnabled(false);
				btnSubtractSugar.setEnabled(false);

				// reset coin buttons
				cm.setPaymentToCash();
				btnNickel.setEnabled(false);
				btnDime.setEnabled(false);
				btnQuarter.setEnabled(false);
				btnDollar.setEnabled(false);
			}
		});// end coin return ActionListener

		// rCard Button ActionListener
		btnRCard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cm.setPaymentToRCard();
				btnNickel.setEnabled(false);
				btnDime.setEnabled(false);
				btnQuarter.setEnabled(false);
				btnDollar.setEnabled(false);
				textLeft.setText("");
				textLeft.append("rCard Selected\n");
			}
		});// end rCard ActionListener

		// Cash Button ActionListener
		btnCash.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cm.setPaymentToCash();
				btnNickel.setEnabled(true);
				btnDime.setEnabled(true);
				btnQuarter.setEnabled(true);
				btnDollar.setEnabled(true);
				textLeft.setText("");
				textLeft.append("Cash Selected\n");
			}
		});// end Cash Button ActionListener

		// ***********************************************
		// Coin Button ActionListeners
		// ***********************************************
		btnNickel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cm.insertNickel();
				textLeft.setText("");
				textLeft.append("Nickel Inserted\n");
				double inserted = cm.getInsertedAmount() / 100.0;
				textLeft.append("Total Inserted:\n $" + df.format(inserted));
			}
		});// end Nickel ActionListener

		btnDime.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cm.insertDime();
				textLeft.setText("");
				textLeft.append("Dime Inserted\n");
				double inserted = cm.getInsertedAmount() / 100.0;
				textLeft.append("Total Inserted:\n $" + df.format(inserted));

			}
		});// end Dime ActionListener

		btnQuarter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cm.insertQuarter();
				textLeft.setText("");
				textLeft.append("Quarter Inserted\n");
				double inserted = cm.getInsertedAmount() / 100.0;
				textLeft.append("Total Inserted:\n $" + df.format(inserted));

			}
		});// end Quarter ActionListener

		btnDollar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cm.insertDollar();
				textLeft.setText("");
				textLeft.append("Dollar Inserted\n");
				double inserted = cm.getInsertedAmount() / 100.0;
				textLeft.append("Total Inserted:\n $" + df.format(inserted));

			}
		});// end Dollar ActionListener

		// ***********************************************
		// Condiment Add & Subtract ActionListeners
		// ***********************************************

		// Cream Add Button
		btnAddCream.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (creamWanted + 1 <= cream.getInventory()) {
					creamWanted++;
					order.add(cream);
					btnSubtractCream.setEnabled(true);
					textLeft.setText("");
					textLeft.append("Added: Cream\n");
					textLeft.append("" + creamWanted + "\n");
				}
				if (creamWanted == cream.getInventory()) {
					btnSubtractCream.setEnabled(false);
				}
				if (creamWanted > 0) {
					btnAddCream.setEnabled(true);
				}
			}
		});// end cream add button ActionListener

		// Cream Subtract Button
		btnSubtractCream.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (creamWanted > 0) {
					creamWanted--;
					order.remove(cream);
					textLeft.setText("");
					textLeft.append("Removed: Cream\n");
					textLeft.append("" + creamWanted + "\n");
				}
				if (creamWanted == 0) {
					btnSubtractCream.setEnabled(false);
				}
				if (creamWanted < cream.getInventory()) {
					btnAddCream.setEnabled(true);
				}
			}
		});// end cream subtract ActionListener

		// Lemon Add Button
		btnAddLemon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (lemonWanted + 1 <= lemon.getInventory()) {
					lemonWanted++;
					order.add(lemon);
					btnSubtractLemon.setEnabled(true);
					textLeft.setText("");
					textLeft.append("Added: Lemon\n");
					textLeft.append("" + lemonWanted + "\n");
				}
				if (lemonWanted == lemon.getInventory()) {
					btnSubtractLemon.setEnabled(false);
				}
				if (lemonWanted > 0) {
					btnAddLemon.setEnabled(true);
				}
			}
		});// end lemon add button ActionListener

		// Lemon Subtract Button
		btnSubtractLemon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (lemonWanted > 0) {
					lemonWanted--;
					order.remove(lemon);
					textLeft.setText("");
					textLeft.append("Removed: Lemon\n");
					textLeft.append("" + lemonWanted + "\n");
				}
				if (lemonWanted == 0) {
					btnSubtractLemon.setEnabled(false);
				}
				if (lemonWanted < lemon.getInventory()) {
					btnAddLemon.setEnabled(true);
				}
			}
		});// end lemon subtract ActionListener

		// Sugar Add Button
		btnAddSugar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (sugarWanted + 1 <= sugar.getInventory()) {
					sugarWanted++;
					order.add(sugar);
					btnSubtractSugar.setEnabled(true);
					textLeft.setText("");
					textLeft.append("Added: Sugar\n");
					textLeft.append("" + sugarWanted);
				}
				if (sugarWanted == sugar.getInventory()) {
					btnAddSugar.setEnabled(false);
				}
				if (sugarWanted > 0) {
					btnSubtractSugar.setEnabled(true);
				}
			}
		});// end sugar add button ActionListener

		// Sugar Subtract Button
		btnSubtractSugar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (sugarWanted > 0) {
					sugarWanted--;
					order.remove(sugar);
					textLeft.setText("");
					textLeft.append("Remove: Sugar\n");
					textLeft.append("" + sugarWanted);
				}
				if (sugarWanted == 0) {
					btnSubtractSugar.setEnabled(false);
				}
				if (sugarWanted < sugar.getInventory()) {
					btnAddSugar.setEnabled(true);
				}
			}
		});// end sugar subtract ActionListener
	}// end constructor
}// end class
