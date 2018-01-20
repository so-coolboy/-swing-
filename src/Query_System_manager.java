import java.awt.EventQueue;
import dao.ManagerDao;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Query_System_manager {

	JFrame frame;
	private JTextField textField;
	private static Integer mno = 0;

	public static Integer getMno() {
		return mno;
	}

	public static void setMno(Integer mno) {
		Query_System_manager.mno = mno;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query_System_manager window = new Query_System_manager();
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
	public Query_System_manager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 900, 600);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setFont(new Font("宋体", Font.PLAIN, 20));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ManagerDao dao = new ManagerDao();
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u67E5\u8BE2\u7684\u7BA1\u7406\u5458\u53F7");
		label.setFont(new Font("楷体", Font.PLAIN, 20));
		label.setBounds(80, 36, 264, 45);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(191, 91, 113, 37);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
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
		btnNewButton.setBounds(80, 169, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mno = Integer.valueOf(textField.getText());
				try {
					Boolean bool = dao.queryMno(mno);
					if (bool == false) {
						JOptionPane.showMessageDialog(null, "不存在此管理员号！");
						Query_System_manager window = new Query_System_manager();
						window.frame.setVisible(true);
						frame.dispose();
					}else {
						Query_System_manager2 window = new Query_System_manager2();
						window.frame.setVisible(true);
						frame.dispose();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(211, 169, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel label_1 = new JLabel("\u7BA1\u7406\u5458\u53F7\uFF1A");
		label_1.setFont(new Font("楷体", Font.PLAIN, 20));
		label_1.setBounds(80, 91, 101, 37);
		frame.getContentPane().add(label_1);
	}

}
