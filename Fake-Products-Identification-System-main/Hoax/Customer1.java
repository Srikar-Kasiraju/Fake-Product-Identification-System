package hoax;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import com.github.sarxos.webcam.Webcam;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.EventQueue;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Color;




public class Customer1 extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;

	/**
	 * Launch the application.
	 */
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	
	public void table_load(String s_1,String id1)
	{
	try
	{
	pst = con.prepareStatement(s_1);
	pst.setString(1, id1);
	rs = pst.executeQuery();
	table.setModel(DbUtils.resultSetToTableModel(rs));
	
	}
	catch (SQLException e)
	{
	e.printStackTrace();
	}
	}
	
	
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
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer1 frame = new Customer1();
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
	public Customer1() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 255, 255, 200));
		panel.setBounds(86, 25, 741, 518);
		contentPane.add(panel);
		
		JButton btnNewButton_1 = new JButton("Upload");
		btnNewButton_1.setBounds(269, 43, 121, 45);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename = f.getAbsolutePath();
				tf1.setText(filename);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton_1_2 = new JButton("camera");
		btnNewButton_1_2.setBounds(86, 43, 121, 45);
		panel.add(btnNewButton_1_2);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Webcam web=Webcam.getDefault();
				web.open();
				try {
					ImageIO.write(web.getImage(), "JPG", new File("first.JPG"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		tf1 = new JTextField();
		tf1.setBounds(446, 52, 242, 33);
		panel.add(tf1);
		tf1.setColumns(10);
		
		table = new JTable();
		table.setBounds(134, 335, 571, 133);
		panel.add(table);
		
		JButton btnNewButton_1_1 = new JButton("Scan");
		btnNewButton_1_1.setBounds(502, 112, 121, 45);
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a1=tf1.getText();
				System.out.println(a1);
				bar b=new bar(a1);
				
				String a2=b.barcode();
				System.out.println(a2);
				tf2.setText(a2);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("BARCODE:");
		lblNewLabel.setBounds(77, 242, 130, 24);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		tf2 = new JTextField();
		tf2.setBounds(244, 242, 242, 33);
		panel.add(tf2);
		tf2.setColumns(10);
		
		JButton btnNewButton_1_1_1 = new JButton("verify");
		btnNewButton_1_1_1.setBounds(518, 233, 121, 45);
		panel.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String id1=tf2.getText();
					pst = con.prepareStatement("select * from product_detail where barcode = ?");
					pst.setString(1, id1);
					ResultSet rs = pst.executeQuery();
					if(rs.next()==true)
					{
						JOptionPane.showMessageDialog(null, "product is Original!");
						table_load("select * from product_detail where barcode=?",id1);

					}
					else
					{
					JOptionPane.showMessageDialog(null, "No Record Found");
					}
					}
					catch (SQLException ex) {
					}
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblProductName = new JLabel("Product:");
		lblProductName.setBounds(38, 368, 86, 24);
		panel.add(lblProductName);
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\priyatham\\Downloads\\Untitled design (4).png"));
		lblNewLabel_1.setBounds(0, 0, 888, 568);
		contentPane.add(lblNewLabel_1);
		
		
		
		
	}
}
