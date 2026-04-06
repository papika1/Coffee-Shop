package CoffeeShop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTable;

public class CoffeeShopMainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblDateValue;
	private JLabel lblTimeValue;
	private JLabel lblOrdersValue;
	private JLabel lblRevenueValue;
	private int ordersTodayCount = 0;
	private double revenueToday = 0.0;
	private JSpinner spinnerQuantity;
	
	private JComboBox<CoffeeType> comboBoxCoffeeType;
	

	private JLabel lblUnitPriceValue;
	private JLabel lblSubtotalValue;
	private JLabel lblCartTotalValue;


	private List<OrderItem> cart = new ArrayList<>();
	private JTable cartTable;
	private DefaultTableModel tableModel;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeShopMainWindow frame = new CoffeeShopMainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CoffeeShopMainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 900, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Coffee Shop");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblTitle.setBounds(10, 10, 250, 37);
		contentPane.add(lblTitle);
		
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDate.setBounds(10, 57, 139, 37);
		contentPane.add(lblDate);
		
		lblDateValue = new JLabel();
		lblDateValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDateValue.setBounds(80, 57, 180, 37);
		contentPane.add(lblDateValue);
		
		JLabel lblOrdersTitle = new JLabel("Orders Today: ");
		lblOrdersTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOrdersTitle.setBounds(341, 57, 199, 37);
		contentPane.add(lblOrdersTitle);
		
		lblOrdersValue = new JLabel();
		lblOrdersValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOrdersValue.setBounds(480, 57, 80, 37);
		contentPane.add(lblOrdersValue);
		
		JLabel lblRevenueTitle = new JLabel("Revenue:");
		lblRevenueTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRevenueTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRevenueTitle.setBounds(620, 57, 100, 28);
		contentPane.add(lblRevenueTitle);
		
		lblRevenueValue = new JLabel();
		lblRevenueValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRevenueValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRevenueValue.setBounds(730, 57, 146, 28);
		contentPane.add(lblRevenueValue);
		
		JLabel lblTimeTitle = new JLabel("Time:");
		lblTimeTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTimeTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTimeTitle.setBounds(650, 10, 70, 29);
		contentPane.add(lblTimeTitle);

		lblTimeValue = new JLabel();
		lblTimeValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTimeValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTimeValue.setBounds(730, 10, 146, 29);
		contentPane.add(lblTimeValue);
		
		JLabel lblProductSelection = new JLabel("Product Selection");
		lblProductSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductSelection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblProductSelection.setBounds(10, 136, 250, 37);
		contentPane.add(lblProductSelection);
		
		comboBoxCoffeeType = new JComboBox<>();
		comboBoxCoffeeType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxCoffeeType.setModel(new DefaultComboBoxModel<>(CoffeeType.values()));
		comboBoxCoffeeType.setBounds(10, 223, 250, 28);
		contentPane.add(comboBoxCoffeeType);
		
		JLabel lblCoffeeChoosing = new JLabel("Coffee:");
		lblCoffeeChoosing.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCoffeeChoosing.setBounds(10, 183, 250, 30);
		contentPane.add(lblCoffeeChoosing);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuantity.setBounds(10, 261, 250, 30);
		contentPane.add(lblQuantity);
		
		spinnerQuantity = new JSpinner(new SpinnerNumberModel(1, 1, 50, 1));
		spinnerQuantity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spinnerQuantity.setBounds(10, 301, 250, 28);
		contentPane.add(spinnerQuantity);
		
		
		JLabel lblUnitPriceTitle = new JLabel("Unit Price:");
		lblUnitPriceTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUnitPriceTitle.setBounds(10, 339, 139, 30);
		contentPane.add(lblUnitPriceTitle);
		
		lblUnitPriceValue = new JLabel("");
		lblUnitPriceValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUnitPriceValue.setBounds(159, 339, 101, 30);
		contentPane.add(lblUnitPriceValue);
		
		JLabel lblSubtotalTitle = new JLabel("Subtotal:");
		lblSubtotalTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubtotalTitle.setBounds(10, 379, 139, 30);
		contentPane.add(lblSubtotalTitle);
		
		lblSubtotalValue = new JLabel("");
		lblSubtotalValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubtotalValue.setBounds(159, 379, 101, 30);
		contentPane.add(lblSubtotalValue);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 112, 866, 14);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(313, 124, 2, 388);
		contentPane.add(separator_1);
		
		JButton btnAddToCart = new JButton("Add To Cart");
		btnAddToCart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddToCart.setBounds(80, 431, 159, 37);
		contentPane.add(btnAddToCart);
		
		JLabel lblCartTotalTitle = new JLabel("Cart Total:");
		lblCartTotalTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCartTotalTitle.setBounds(325, 545, 120, 30);
		contentPane.add(lblCartTotalTitle);

		lblCartTotalValue = new JLabel("$0.00");
		lblCartTotalValue.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCartTotalValue.setBounds(455, 545, 120, 30);
		contentPane.add(lblCartTotalValue);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 522, 866, 2);
		contentPane.add(separator_2);
		
		String[] columns = {"Coffee", "Qty", "Unit Price", "Subtotal"};

		tableModel = new DefaultTableModel(columns, 0);

		cartTable = new JTable(tableModel);
		cartTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cartTable.setRowHeight(25);
		cartTable.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(cartTable);
		scrollPane.setBounds(325, 194, 551, 299);
		contentPane.add(scrollPane);
		
		JLabel lblCartLabel = new JLabel("Cart");
		lblCartLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblCartLabel.setBounds(470, 136, 250, 37);
		contentPane.add(lblCartLabel);
		
		JButton btnRemoveSelected = new JButton("Remove Selected");
		btnRemoveSelected.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemoveSelected.setBounds(90, 627, 180, 37);
		contentPane.add(btnRemoveSelected);

		JButton btnClearCart = new JButton("Clear Cart");
		btnClearCart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClearCart.setBounds(363, 627, 150, 37);
		contentPane.add(btnClearCart);

		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPlaceOrder.setBounds(622, 627, 186, 37);
		contentPane.add(btnPlaceOrder);

		
		updatePriceLabels();
		updateCartTotal();
		
		startClock();
		loadTodaySummaryFromDatabase();
		
		comboBoxCoffeeType.addActionListener(e -> updatePriceLabels());
		spinnerQuantity.addChangeListener(e -> updatePriceLabels());
		
		btnAddToCart.addActionListener(e -> addToCart());
		btnRemoveSelected.addActionListener(e -> removeSelectedItem());
		btnClearCart.addActionListener(e -> clearCart());
		btnPlaceOrder.addActionListener(e -> placeOrder());
		

	}
	
	private void removeSelectedItem() {
	    int selectedRow = cartTable.getSelectedRow();

	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(this, "Please select an item.");
	        return;
	    }

	    cart.remove(selectedRow);
	    tableModel.removeRow(selectedRow);

	    updateCartTotal();
	}
	
	private void clearCart() {
	    cart.clear();
	    tableModel.setRowCount(0);
	    updateCartTotal();
	}
	
	private CoffeeType getSelectedCoffeeType() {
	    return (CoffeeType) comboBoxCoffeeType.getSelectedItem();
	}
	
	private int getSelectedQuantity() {
	    return (int) spinnerQuantity.getValue();
	}
	
	private void updateUnitPrice() {
	    CoffeeType selectedCoffee = getSelectedCoffeeType();

	    if (selectedCoffee != null) {
	        lblUnitPriceValue.setText(String.format("$%.2f", selectedCoffee.getPrice()));
	    }
	}
	
	private void updateSubtotal() {
	    CoffeeType selectedCoffee = getSelectedCoffeeType();
	    int quantity = getSelectedQuantity();

	    if (selectedCoffee != null) {
	        double subtotal = selectedCoffee.getPrice() * quantity;
	        lblSubtotalValue.setText(String.format("$%.2f", subtotal));
	    }
	}
	
	private void updatePriceLabels() {
	    updateUnitPrice();
	    updateSubtotal();
	}
	
	private double calculateCartTotal() {
	    double total = 0.0;

	    for (OrderItem item : cart) {
	        total += item.getSubtotal();
	    }

	    return total;
	}
	
	private void placeOrder() {

		if (cart.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Cart is empty!");
	        return;
	    }

	    Order order = new Order(LocalDateTime.now());

	    for (OrderItem item : cart) {
	        order.addItem(item);
	    }

	    order.calculateTotal();

	    try {
	        
	        OrderDAO dao = new OrderDAO();
	        dao.saveOrder(order);

	        loadTodaySummaryFromDatabase();

	        cart.clear();
	        tableModel.setRowCount(0);
	        updateCartTotal();

	        JOptionPane.showMessageDialog(this, "Order saved to database!");

	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
	    }
	}
	
	private void updateCartTotal() {
	    double total = calculateCartTotal();
	    lblCartTotalValue.setText(String.format("$%.2f", total));
	}
	
	private void addToCart() {
	    CoffeeType selectedCoffee = getSelectedCoffeeType();
	    int quantity = getSelectedQuantity();

	    if (selectedCoffee == null) {
	        return;
	    }

	    OrderItem item = new OrderItem(selectedCoffee, quantity);
	    cart.add(item);

	    spinnerQuantity.setValue(1);
	    updatePriceLabels();
	    
	    tableModel.addRow(new Object[]{
	            selectedCoffee.getLabel(),
	            quantity,
	            item.getUnitPrice(),
	            item.getSubtotal()
	    });
	    
	    JOptionPane.showMessageDialog(this,
	            selectedCoffee.getLabel() + " added to cart.");
	    updateCartTotal();
	}
	
	private void startClock() {
	    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	    Timer timer = new Timer(1000, e -> {
	        lblTimeValue.setText(LocalTime.now().format(timeFormatter));
	        lblDateValue.setText(LocalDate.now().format(dateFormatter));
	    });

	    timer.start();
	}
	
	private void refreshSummaryLabels() {
	    lblOrdersValue.setText(String.valueOf(ordersTodayCount));
	    lblRevenueValue.setText(String.format("$%.2f", revenueToday));
	}
	
	private void loadTodaySummaryFromDatabase() {
	    try {
	        OrderDAO dao = new OrderDAO();

	        ordersTodayCount = dao.getTodayOrderCount();
	        revenueToday = dao.getTodayRevenue();

	        refreshSummaryLabels();

	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Failed to load summary data: " + e.getMessage());
	    }
	}
	
}
