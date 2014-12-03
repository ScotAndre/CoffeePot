import java.awt.Color;
import java.awt.GridLayout;
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

	/**
	 * Create the frame.
	 */
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
		}

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
		JButton addCream = new JButton("+");
		JButton subtractCream = new JButton("-");
		JButton addLemon = new JButton("+");
		JButton subtractLemon = new JButton("-");
		JButton addSugar = new JButton("+");
		JButton subtractSugar = new JButton("-");
		bottomCondPanel.add(addCream);
		bottomCondPanel.add(subtractCream);
		bottomCondPanel.add(addLemon);
		bottomCondPanel.add(subtractLemon);
		bottomCondPanel.add(addSugar);
		bottomCondPanel.add(subtractSugar);
		addCream.setEnabled(false);
		subtractCream.setEnabled(false);
		addLemon.setEnabled(false);
		subtractLemon.setEnabled(false);
		addSugar.setEnabled(false);
		subtractSugar.setEnabled(false);

		// payment control panel
		JPanel paymentPanel = new JPanel();
		JPanel paymentTop = new JPanel();
		JPanel paymentBottom = new JPanel();
		contentPane.add(paymentPanel);
		paymentPanel.add(paymentTop);
		paymentPanel.add(paymentBottom);

		// payment buttons
		JButton btnRCard = new JButton("rCard");
		JButton bthCash = new JButton("Cash");
		paymentTop.add(btnRCard);
		paymentTop.add(bthCash);

		// coin buttons
		JButton btnNickel = new JButton(".05");
		JButton btnDime = new JButton(".10");
		JButton btnQuarter = new JButton(".25");
		JButton btnDollar = new JButton("1.00");
		paymentBottom.add(btnNickel);
		paymentBottom.add(btnDime);
		paymentBottom.add(btnQuarter);
		paymentBottom.add(btnDollar);

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
	}
}
