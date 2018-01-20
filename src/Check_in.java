import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;

import bean.StudentBean;
import bean.Student_dormBean;
import dao.StudentDao;
import dao.Student_Dorm_Dao;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;

public class Check_in {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Check_in window = new Check_in();
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
	public Check_in() {
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
		Student_Dorm_Dao ddao = new Student_Dorm_Dao();
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u5B66\u751F\u4F4F\u5BBF\u4FE1\u606F");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 20));
		label.setBounds(369, 146, 212, 36);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5B66\u53F7");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		label_1.setBounds(305, 227, 34, 15);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(369, 224, 66, 21);
		textField.setText("");
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u697C\u53F7");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		label_2.setBounds(460, 227, 40, 15);
		frame.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(517, 224, 66, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5BBF\u820D\u53F7");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		label_3.setBounds(294, 281, 45, 15);
		frame.getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(369, 278, 66, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
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
		btnNewButton.setBounds(369, 334, 66, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				if (str.equals("") ) {
					JOptionPane.showMessageDialog(null, "学号不能为空！");
					Check_in window = new Check_in();
					window.frame.setVisible(true);
					frame.dispose();
				}else {
					Integer sno = Integer.valueOf(str);
					Boolean bool = null;
					try {
						bool = new StudentDao().querySno(sno);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (bool == false) {
						JOptionPane.showMessageDialog(null, "此学号不存在，不能入住！");
						Check_in window = new Check_in();
						window.frame.setVisible(true);
						frame.dispose();
					}else {
						Boolean bool1 = null;
						try {
							bool1 = ddao.query_Sno(sno);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (bool1 == false) {
							JOptionPane.showMessageDialog(null, "输入的学号已经存在！");
							Check_in window = new Check_in();
							window.frame.setVisible(true);
							frame.dispose();
						}else {
							Student_dormBean sdb = new Student_dormBean();
							sdb.setSno(Integer.valueOf(textField.getText()));
							sdb.setDbuil(Integer.valueOf(textField_1.getText()));
							sdb.setDdor(Integer.valueOf(textField_2.getText()));
							sdb.setCheck_in(new Date().toString());
							try {
								Boolean bool2 = new Student_Dorm_Dao().query_Unused(sdb.getDdor());
								if (bool2 == false) {
								JOptionPane.showMessageDialog(null, "宿舍不存在或没有空床！");
								Check_in window = new Check_in();
								window.frame.setVisible(true);
								frame.dispose();
								}else {

									new Student_Dorm_Dao().Check_in(sdb);
									new Student_Dorm_Dao().update_SD(sdb.getDdor());
									JOptionPane.showMessageDialog(null, "操作成功！");
								}
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							
						}
					}
				}
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(517, 334, 66, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
