import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import bean.ManagementBean;
import dao.ManagerDao;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Query_System_manager2 {

	JFrame frame;
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
					Query_System_manager2 window = new Query_System_manager2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Query_System_manager2() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(200, 200, 900, 600);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setFont(new Font("楷体", Font.PLAIN, 15));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Query_System_manager qy = new Query_System_manager();
		Integer mno = qy.getMno();
		ManagerDao dao = new ManagerDao();
		
		
		JLabel label = new JLabel("\u8BE5\u7BA1\u7406\u5458\u4FE1\u606F\u4E3A");
		label.setFont(new Font("楷体", Font.PLAIN, 25));
		label.setBounds(107, 21, 244, 45);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		label_1.setBounds(57, 76, 54, 15);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(117, 73, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		label_2.setBounds(204, 76, 54, 15);
		frame.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(264, 73, 66, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7535\u8BDD\uFF1A");
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		label_3.setBounds(57, 135, 45, 15);
		frame.getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(117, 132, 66, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("\u697C\u53F7\uFF1A");
		label_4.setFont(new Font("楷体", Font.PLAIN, 15));
		label_4.setBounds(204, 135, 54, 15);
		frame.getContentPane().add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(264, 132, 66, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		ManagementBean mb = new ManagementBean();
		mb = dao.get(mno);
		textField.setText(mb.getMname());
		textField_1.setText(mb.getMsex());
		textField_2.setText(mb.getMtel());
		textField_3.setText(String.valueOf(mb.getDbuil()));
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HouseParent window = new HouseParent();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton.setBounds(264, 183, 66, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
