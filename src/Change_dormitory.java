import java.awt.Color;
import dao.Method;
import java.awt.EventQueue;
import dao.StudentDao;
import dao.Student_Dorm_Dao;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;

import bean.Student_dormBean;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Change_dormitory {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_dormitory window = new Change_dormitory();
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
	public Change_dormitory() {
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
		StudentDao dao = new StudentDao();
		Student_dormBean sdb = new Student_dormBean();
		Student_Dorm_Dao ddao = new Student_Dorm_Dao();
		Method method = new Method();
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u5BF9\u5E94\u4FE1\u606F\uFF1A");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 20));
		label.setBounds(364, 142, 161, 40);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5B66\u751F\u5B66\u53F7\uFF1A");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		label_1.setBounds(250, 229, 75, 18);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(339, 228, 66, 21);
		textField.setText("");
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u73B0\u5BBF\u820D\u53F7\uFF1A");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		label_3.setBounds(250, 283, 75, 15);
		frame.getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(339, 280, 66, 21);
		textField_2.setText("");
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_2 = new JLabel("\u73B0\u697C\u53F7\uFF1A");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		label_2.setBounds(434, 234, 66, 15);
		frame.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(515, 231, 66, 21);
		textField.setText("");
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Student_dormitory window = new Student_dormitory();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton.setBounds(339, 347, 86, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str =textField.getText();
				if (str.equals("")) {
					JOptionPane.showMessageDialog(null, "没有输入学号！");
				}else {
					Integer sno = Integer.valueOf(str);
					try {
						Boolean bool = dao.querySno(sno);
						if (bool == false) {
							JOptionPane.showMessageDialog(null, "不存在此学号");
						}else {
							String dbuil = textField_1.getText();
							String ddor = textField_2.getText();
							
							
							if (dbuil.equals("") || ddor.equals("") ) {
								
								JOptionPane.showMessageDialog(null, "信息不能为空！");
								Change_dormitory window = new Change_dormitory();
								window.frame.setVisible(true);
								frame.dispose();
							}else {
								Integer dbuil1 = Integer.valueOf(dbuil);
								Integer ddor1 = Integer.valueOf(ddor);
								Boolean bool1 = new Student_Dorm_Dao().query_Unused(ddor1);
								if (bool1 == false) {
									JOptionPane.showMessageDialog(null, "新宿舍号不存在或者没有空床!");
									Change_dormitory window = new Change_dormitory();
									window.frame.setVisible(true);
									frame.dispose();
								}else {
									sdb.setSno(sno);
									sdb.setDbuil(dbuil1);
									sdb.setDdor(ddor1);
									ddao.update_SD_bySno(sno);   // 原宿舍号空床加1
									ddao.update_SD(ddor1);       // 现宿舍号空床减1
									ddao.update_Stu_DOrm(sdb);
									
									JOptionPane.showMessageDialog(null, "操作成功！");
								}
								
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(515, 347, 86, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		
	}
}
