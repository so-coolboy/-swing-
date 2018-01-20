import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;

import dao.Method;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Manager_user_password1 {

	JFrame frame;
	private JTextField textField_1;
	private static Integer a = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_user_password1 window = new Manager_user_password1();
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
	public Manager_user_password1() {
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
		Manager_user_password mup = new Manager_user_password();
		a = mup.getA();
		
		
		JLabel label = new JLabel("\u8BF7\u5728\u4E0B\u9762\u8F93\u5165\u65B0\u7684\u5BC6\u7801");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 25));
		label.setBounds(315, 147, 313, 65);
		frame.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("楷体", Font.PLAIN, 20));
		label_2.setBounds(315, 240, 60, 45);
		frame.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_1.setBounds(427, 238, 159, 48);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Manager_user_password window = new Manager_user_password();
				window.frame.setVisible(true);
				frame.dispose();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton.setBounds(318, 335, 84, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String str2 = textField_1.getText();
				if (str2.equals("") ) {
					JOptionPane.showMessageDialog(null, "输入错误!请重新输入！");
					Manager_user_password1 window = new Manager_user_password1();
					window.frame.setVisible(true);
					frame.dispose();
				}else {
					
					try {
						new Method().updateUP_Dorm(a, str2);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "修改成功！");
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(467, 335, 100, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
