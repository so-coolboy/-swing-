import java.awt.Color;
import java.awt.EventQueue;
import dao.Method;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Manager_user_password {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private static Integer a =null;

	public static Integer getA() {
		return a;
	}

	public static void setA(Integer a) {
		Manager_user_password.a = a;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_user_password window = new Manager_user_password();
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
	public Manager_user_password() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 900, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ImageIcon icon = new ImageIcon("./6.jpg");
		JLabel label1 = new JLabel(icon);
		label1.setBounds(0,0,frame.getWidth(),frame.getHeight());
		
		//获取窗口的第二层，将label放入
		frame.getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));  
		
		//获取frame的顶层容器,并设置为透明
		JPanel j=(JPanel)frame.getContentPane();  
        j.setOpaque(false);  
        
        JPanel panel=new JPanel();
        panel.setForeground(new Color(255, 0, 0));
  
        //必须设置为透明的。否则看不到图片  
        panel.setOpaque(false);  
  
        frame.getContentPane().add(panel);  
        frame.getContentPane().add(panel);
        panel.setLayout(null);
		Method method = new Method();
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u539F\u6765\u7684\u7528\u6237\u540D\u548C\u5BC6\u7801");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 25));
		label.setBounds(298, 122, 309, 46);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		label_1.setBounds(364, 215, 70, 15);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(472, 212, 93, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		label_2.setBounds(364, 270, 54, 15);
		frame.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(472, 267, 93, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dorm_manager window = new Dorm_manager();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton.setBounds(313, 334, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String users = textField.getText();
				String pass =textField_1.getText();
				
				try {
					 a = method.getUP_Dorm(users, pass);
					if (a == null) {
						JOptionPane.showMessageDialog(null, "用户名或密码输入错误！");
						Manager_user_password window = new Manager_user_password();
						window.frame.setVisible(true);
						frame.dispose();
					}else {
						Manager_user_password1 window = new Manager_user_password1();
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
		btnNewButton_1.setBounds(514, 334, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
