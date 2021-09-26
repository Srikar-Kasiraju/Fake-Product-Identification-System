package hoax;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.UIManager;

public class hoax1 extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hoax1 window = new hoax1();
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
	public hoax1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(new Color(240, 240, 240));
		frame.setBackground(new Color(240, 240, 240));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\priyatham\\Downloads\\qrchimpX1024-removebg-preview.png"));
		frame.setBounds(100, 100, 922, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255,255,255,200));
		panel.setBounds(121, 157, 352, 244);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("CUSTOMER");
		btnNewButton.setIcon(null);
		btnNewButton.setBackground(new Color(237,199,180));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Open Sans Semibold", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer1 c=new Customer1();
				frame.dispose();
				c.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(20, 151, 142, 41);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Open Sans Semibold", Font.PLAIN, 50));
		lblNewLabel_2.setBounds(97, 11, 164, 129);
		panel.add(lblNewLabel_2);
		
		JButton btnRetailer = new JButton("RETAILER");
		btnRetailer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Retailer1 c=new Retailer1();
				frame.dispose();
				c.setVisible(true);
			}
		});
		btnRetailer.setForeground(Color.BLACK);
		btnRetailer.setFont(new Font("Open Sans Semibold", Font.PLAIN, 18));
		btnRetailer.setBackground(new Color(237,199,180));
		btnRetailer.setBounds(190, 151, 142, 41);
		panel.add(btnRetailer);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\priyatham\\Downloads\\image (1).png"));
		lblNewLabel_1.setBounds(619, 200, 230, 122);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\priyatham\\Downloads\\Untitled design (1).png"));
		lblNewLabel.setBounds(0, -28, 908, 574);
		frame.getContentPane().add(lblNewLabel);
	}
}
