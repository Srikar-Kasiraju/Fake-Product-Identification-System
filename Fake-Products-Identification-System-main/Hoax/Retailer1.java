package hoax;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import net.proteanit.sql.DbUtils;
import java.sql.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Retailer1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Retailer1 frame = new Retailer1();
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
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public void Connect()
	{
	try {
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost/product", "root","");
	}
	catch (ClassNotFoundException ex)
	{
	ex.printStackTrace();
	}
	catch (SQLException ex)
	{
	ex.printStackTrace();
	}
	}
	public Retailer1() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 604);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRODUCT NAME");
		lblNewLabel.setFont(new Font("Open Sans Semibold", Font.PLAIN, 18));
		lblNewLabel.setBounds(91, 183, 146, 38);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(255, 183, 210, 44);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(255, 251, 210, 44);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(255, 319, 210, 44);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(255, 384, 210, 44);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String a1="";String a2="";String a3="";String a4="";
				a1=textField.getText();a2=textField_1.getText();a3=textField_2.getText();a4=textField_3.getText();

				try {
					pst = con.prepareStatement("insert into	product_detail(product_name,category,barcode,description)values(?,?,?,?)");
					pst.setString(1,a1);pst.setString(2,a2);pst.setString(3,a3);pst.setString(4,a4);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added to the Database");
					//table_load("select * from patient");
					textField.setText("");textField_1.setText("");textField_2.setText("");textField_3.setText("");
					textField.requestFocus();
					}
					catch (SQLException e1)
					{
					e1.printStackTrace();
					}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(359, 458, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblCategoru = new JLabel("CATEGORY");
		lblCategoru.setFont(new Font("Open Sans Semibold", Font.PLAIN, 18));
		lblCategoru.setBounds(91, 251, 146, 38);
		contentPane.add(lblCategoru);
		
		JLabel lblBarcode = new JLabel("BARCODE");
		lblBarcode.setFont(new Font("Open Sans Semibold", Font.PLAIN, 18));
		lblBarcode.setBounds(91, 319, 146, 38);
		contentPane.add(lblBarcode);
		
		JLabel lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setFont(new Font("Open Sans Semibold", Font.PLAIN, 18));
		lblDescription.setBounds(91, 384, 146, 38);
		contentPane.add(lblDescription);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hoax11 c=new Hoax11();
				c.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(118, 460, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\priyatham\\Downloads\\Untitled design (3).png"));
		lblNewLabel_1.setBounds(0, 0, 886, 567);
		contentPane.add(lblNewLabel_1);
	}
}
