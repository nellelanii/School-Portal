package graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private String Role [] = {"Select", "Staff", "Student"};
	private String choice [] = {"Select", "New", "Existing"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setBackground(new Color(128, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Status = new JPanel();
		Status.setBackground(new Color(32, 178, 170));
		Status.setBounds(0, 0, 662, 352);
		contentPane.add(Status);
		Status.setLayout(null);
		
		JLabel lblHomeAway = new JLabel("Home & Away Educational Institute");
		lblHomeAway.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		lblHomeAway.setBounds(6, 239, 340, 30);
		Status.add(lblHomeAway);
		
		JLabel lblSelectStatusTo = new JLabel("Select status to access portal");
		lblSelectStatusTo.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblSelectStatusTo.setBounds(404, 67, 198, 27);
		Status.add(lblSelectStatusTo);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblStatus.setBounds(349, 192, 61, 16);
		Status.add(lblStatus);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblRole.setBounds(349, 134, 61, 16);
		Status.add(lblRole);
		
		JComboBox role = new JComboBox(Role);
		role.setBounds(438, 130, 164, 27);
		Status.add(role);
		
		JComboBox status = new JComboBox(choice);
		status.setBounds(438, 188, 164, 27);
		Status.add(status);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (role.getSelectedItem().equals("Select") || status.getSelectedItem().equals("Select"))
						{
					JOptionPane.showMessageDialog(null, "Enter required fields to continue");
						}
				
				 if (role.getSelectedItem().equals("Student"))
				{
				
					if (status.getSelectedItem().equals("Existing"))
					{
					Login login = new Login();
					login.setVisible(true);
					
					}	
					else if (status.getSelectedItem().equals("New"))
					{
					Registration reg = new Registration();
					reg.setVisible(true);
					}
				}
				
				else if (role.getSelectedItem().equals("Staff"))
				{
					if (status.getSelectedItem().equals("Existing"))
					{
					staffLogin login = new staffLogin();
					login.setVisible(true);
					
					}	
					else if (status.getSelectedItem().equals("New"))
					{
					staffReg reg = new staffReg();
					reg.setVisible(true);
					}
				}
					
				}
			
			
				
				
		});
		btnDone.setBounds(385, 281, 117, 29);
		Status.add(btnDone);
		
		JButton btnExit = new JButton("Exit System (F1)");
		btnExit.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		btnExit.setBounds(514, 281, 129, 29);
		Status.add(btnExit);
		btnExit.setMnemonic(KeyEvent.VK_F1);
		
		JLabel lblIcon = new JLabel("");
		
		Image img = new ImageIcon(this.getClass().getResource("/crop.png")).getImage();
		lblIcon.setIcon(new ImageIcon(img));
		
		
		lblIcon.setBounds(13, 0, 236, 265);
		Status.add(lblIcon);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		
	}


}

