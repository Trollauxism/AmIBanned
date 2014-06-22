package aib;

import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class AmIBanned extends JFrame {
	/**
	 *  coded by iobsidian and trollaux
	 * changelog:
	 * optimized some shit and cleaned up code      - trollaux
	 * initial build                                - iobsidian
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel contentPane;
	public static JTextField txtEmail;
	public static JPasswordField passwordField;
	public static JTextPane txtpnWaiting = new JTextPane();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AmIBanned frame = new AmIBanned();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * god damn this was fuckin hard to rewrite but i did it
	 */
	public AmIBanned() {
		setOpacity(1);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		passwordField = new JPasswordField();
		JLabel lblNewLabel = new JLabel("Email");
		JLabel lblPass = new JLabel("Password");
		JButton btnNewButton = new JButton("Am I Banned?");
		btnNewButton.addActionListener(new TestStatus());
		Box horizontalBox = Box.createHorizontalBox();

		txtpnWaiting.setText("Waiting...");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		// This is where it gets messy, but I didn't like having 2000000000000000 extra lines so DEAL WITH IT. Its pretty easy to figure out anyway.
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup().addGap(12).addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel).addComponent(lblPass)).addGap(4).addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE).addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)).addGap(12).addComponent(btnNewButton)).addComponent(txtpnWaiting, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE).addGroup(gl_contentPane.createSequentialGroup().addGap(180).addComponent(horizontalBox, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup().addGap(13).addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup().addGap(3).addComponent(lblNewLabel).addGap(11).addComponent(lblPass)).addGroup(gl_contentPane.createSequentialGroup().addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(7).addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGroup(gl_contentPane.createSequentialGroup().addGap(13).addComponent(btnNewButton))).addGap(13).addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(txtpnWaiting, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE).addGroup(gl_contentPane.createSequentialGroup().addGap(22).addComponent(horizontalBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))));contentPane.setLayout(gl_contentPane);
	}
}
