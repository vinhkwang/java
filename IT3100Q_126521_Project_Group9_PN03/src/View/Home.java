package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.BillboardList;
import Controller.CustomerList;
import Controller.OrderList;
import Model.Billboard;
import Model.Customer;
import Model.Order;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Address;
	private JTextField PhoneNumber;
	private JTextField Content;
	private JTextField Color;
	private JTextField Size;
	private JTable customerTable;
	private JTable billboardTable;
	private JTable table_2;
//	private String[] menu = {"Popular(rectangle)", "Triangle", "Circle"};
//	private JComboBox<String> comboBox;
	
	private DefaultTableModel customerTableModel;
	private String[] csColumn = {"ID", "NAME", "ADDRESS", "PHONE NUMBER"};
	
	private DefaultTableModel billboardTableModel;
	private String[] bbColumn = {"ID", "CONTENT", "COLOR", "SHAPE"};
	
	
	
	private CustomerList csList = new CustomerList();
	private BillboardList bbList = new BillboardList();
	private OrderList orderList = new OrderList(csList, bbList);
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
    //	load customer to table
    public Customer getCustomer() {
    	Customer cs = new Customer();
    	cs.setName(Name.getText());
    	cs.setAddress(Address.getText());
    	cs.setPhoneNumber(PhoneNumber.getText());
    	return cs;
    }
    
    public void loadCustomer() {
    	csList.add(getCustomer());
    	int i = 1;
    	DefaultTableModel customerTableModel = (DefaultTableModel) customerTable.getModel();
    	customerTableModel.setNumRows(0);
    	for (Customer cs:csList.getCs()) {
    		customerTableModel.addRow(new Object[] {
    				i++, cs.getName(), cs.getAddress(), cs.getPhoneNumber()
    		});
    	}
    	
    }
    public void deleteCustomer() {
    	int indexCs = customerTable.getSelectedRow();
    	while (indexCs >= 0) {
    		csList.delete(csList.getCs().get(indexCs));
    		customerTableModel.removeRow(indexCs);
		}
    }
//    public void editCustomer() {
//    	int indexCs = customerTable.getSelectedRow();
//    	while (indexCs >= 0) {
//    		csList.edit(csList.getCs().get(indexCs), getCustomer());
//		}
//    }
//	load order to table
    public Billboard getBillboard() {
    	Billboard bb = new Billboard();
    	bb.setContent(Content.getText());
    	bb.setColor(Color.getText());
    	bb.setSize(Double.parseDouble(Size.getText()));
//    	bb.setShape(Integer.toString(comboBox.getSelectedIndex()));
    	return bb;
    }
    
    public void loadBillboard() {
    	bbList.add(getBillboard());
    	int i = 1;
    	DefaultTableModel  billboardTableModel = (DefaultTableModel) billboardTable.getModel();
    	 billboardTableModel.setNumRows(0);
    	for (Billboard bb:bbList.getBb()) {
    		 billboardTableModel.addRow(new Object[] {
    				i++, bb.getContent(), bb.getColor(), bb.getSize(), bb.getShape()
    		});
    	}
    	
    }
    public void deleteBillboard() {
    	int indexBb = billboardTable.getSelectedRow();
    	while (indexBb >= 0) {
    		bbList.delete(bbList.getBb().get(indexBb));
    		billboardTableModel.removeRow(indexBb);
		}
    }
    
    //search 
    
    public void byName() {
    	orderList.searchOrderByCustomerName(textField.getText());
    }
    public void byAddress() {
    	orderList.searchOrderByCustomerAddress(textField.getText());
    }
    public void byShape() {
    	orderList.searchOrderByShapeOfBillboard(textField.getText());
    }
    public void byPrice() {
    	orderList.searchOrderByPrice(Double.parseDouble(textField.getText()));
    }
	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 880);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADVERTISING AGENCY");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 0, 1604, 53);
		contentPane.add(lblNewLabel);
		
		JPanel customer = new JPanel();
		customer.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		customer.setBounds(42, 86, 627, 261);
		contentPane.add(customer);
		customer.setLayout(null);
		
		Name = new JTextField();
		Name.setBounds(185, 11, 400, 30);
		customer.add(Name);
		Name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setLabelFor(Name);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(42, 11, 113, 30);
		customer.add(lblNewLabel_1);
		
		Address = new JTextField();
		Address.setBounds(185, 76, 400, 30);
		customer.add(Address);
		Address.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Address:");
		lblNewLabel_2.setLabelFor(Address);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(42, 76, 113, 30);
		customer.add(lblNewLabel_2);
		
		PhoneNumber = new JTextField();
		PhoneNumber.setBounds(185, 142, 400, 30);
		customer.add(PhoneNumber);
		PhoneNumber.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Phone number:");
		lblNewLabel_3.setLabelFor(PhoneNumber);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(25, 142, 130, 30);
		customer.add(lblNewLabel_3);
		
		JPanel billboard = new JPanel();
		billboard.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		billboard.setBounds(760, 86, 806, 261);
		contentPane.add(billboard);
		
		JLabel lblNewLabel_4 = new JLabel("CUSTOMER");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setLabelFor(customer);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadCustomer();
			}
		});
		btnNewButton.setBounds(375, 199, 100, 30);
		customer.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EDIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				editCustomer();
			}
		});
		btnNewButton_1.setBounds(485, 199, 100, 30);
		customer.add(btnNewButton_1);
		lblNewLabel_4.setBounds(42, 52, 627, 26);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("BILLBOARD");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setLabelFor(billboard);
		billboard.setLayout(null);
		
		Content = new JTextField();
		Content.setBounds(117, 33, 300, 30);
		billboard.add(Content);
		Content.setColumns(10);
		
		Color = new JTextField();
		Color.setBounds(117, 105, 300, 30);
		billboard.add(Color);
		Color.setColumns(10);
		
		Size = new JTextField();
		Size.setBounds(577, 33, 200, 30);
		billboard.add(Size);
		Size.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Content:");
		lblNewLabel_6.setLabelFor(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(10, 33, 85, 30);
		billboard.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Color:");
		lblNewLabel_7.setLabelFor(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(10, 105, 85, 30);
		billboard.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Size:");
		lblNewLabel_8.setLabelFor(Size);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(470, 33, 85, 30);
		billboard.add(lblNewLabel_8);
		
//		comboBox = new JComboBox<String>(menu);
//		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		comboBox.setBounds(577, 105, 200, 26);
//		billboard.add(comboBox);
		
		JLabel lblNewLabel_9 = new JLabel("Shape:");
//		lblNewLabel_9.setLabelFor(comboBox);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(470, 105, 85, 26);
		billboard.add(lblNewLabel_9);
		
		JButton btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadBillboard();
			}
		});
		btnNewButton_2.setBounds(567, 201, 100, 30);
		billboard.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("EDIT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(677, 201, 100, 30);
		billboard.add(btnNewButton_3);
		lblNewLabel_5.setBounds(760, 52, 787, 26);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_10 = new JLabel("CUSTOMER LIST");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_10.setBounds(42, 385, 627, 26);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("ORDER LIST");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_11.setBounds(760, 385, 806, 26);
		contentPane.add(lblNewLabel_11);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 422, 627, 183);
		contentPane.add(scrollPane);
		customerTable = new JTable();
		customerTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = customerTable.getSelectedRow();
				Name.setText(customerTableModel.getValueAt(i,1).toString());
				Address.setText(customerTableModel.getValueAt(i,2).toString());
				PhoneNumber.setText(customerTableModel.getValueAt(i,3).toString());
			}
		});
		customerTableModel = new DefaultTableModel(){

			   @Override
			   public boolean isCellEditable(int row, int column) {
				   //all cells false
			       return false;
			   }
			};;
		customerTableModel.setColumnIdentifiers(csColumn);
		customerTable.setModel(customerTableModel);
		
		scrollPane.setViewportView(customerTable);
		
		JLabel lblNewLabel_12 = new JLabel("BILLBOARD LIST");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(42, 639, 627, 26);
		contentPane.add(lblNewLabel_12);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(42, 676, 627, 153);
		contentPane.add(scrollPane_1);
		
		billboardTable = new JTable();
		billboardTableModel = new DefaultTableModel();
		billboardTableModel.setColumnIdentifiers(bbColumn);
		billboardTable.setModel(billboardTableModel);
		
		scrollPane_1.setViewportView(billboardTable);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(760, 422, 806, 345);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"ID", "NAME OF CUSTOMER", "NUMBER OF BILLBOARD", "TOTAL PRICE"
			}
		));
		table_2.getColumnModel().getColumn(1).setPreferredWidth(113);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(130);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(101);
		scrollPane_2.setViewportView(table_2);
		
		JButton btnNewButton_4 = new JButton("DELETE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCustomer();
			}
		});
		btnNewButton_4.setBounds(580, 391, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("DELETE");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteBillboard();
			}
		});
		btnNewButton_5.setBounds(580, 642, 89, 23);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_13 = new JLabel("By name: ");
		lblNewLabel_13.setBounds(760, 778, 74, 14);
		contentPane.add(lblNewLabel_13);
		
		textField = new JTextField();
		textField.setBounds(828, 775, 152, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_6 = new JButton("SEARCH");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_6.setBounds(990, 774, 89, 23);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_14 = new JLabel("By address:");
		lblNewLabel_14.setBounds(760, 815, 57, 14);
		contentPane.add(lblNewLabel_14);
		
		textField_1 = new JTextField();
		textField_1.setBounds(828, 809, 152, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_7 = new JButton("SEARCH");
		btnNewButton_7.setBounds(990, 806, 89, 23);
		contentPane.add(btnNewButton_7);
		
		JLabel lblNewLabel_15 = new JLabel("By shape:");
		lblNewLabel_15.setBounds(1185, 778, 89, 14);
		contentPane.add(lblNewLabel_15);
		
		textField_2 = new JTextField();
		textField_2.setBounds(1257, 778, 133, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Price");
		lblNewLabel_16.setBounds(1185, 812, 63, 14);
		contentPane.add(lblNewLabel_16);
		
		textField_3 = new JTextField();
		textField_3.setBounds(1257, 812, 133, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_8 = new JButton("SEARCH");
		btnNewButton_8.setBounds(1409, 777, 89, 23);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("SEACH");
		btnNewButton_9.setBounds(1409, 811, 89, 23);
		contentPane.add(btnNewButton_9);
	}
}
