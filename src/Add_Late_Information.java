import java.awt.Color;
import dao.Student_Dorm_Dao;
import java.awt.EventQueue;
import dao.StudentDao;
import dao.Late_informationDao;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;

import bean.Come_back_lateBean;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_Late_Information {

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
					Add_Late_Information window = new Add_Late_Information();
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
	public Add_Late_Information() {
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
		Student_Dorm_Dao ddao = new Student_Dorm_Dao();
		
		Late_informationDao ldao = new Late_informationDao();
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u665A\u5F52\u5B66\u751F\u7684\u4FE1\u606F");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 25));
		label.setBounds(307, 124, 294, 46);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5B66\u53F7");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		label_1.setBounds(259, 220, 47, 15);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(343, 217, 74, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BBF\u820D\u53F7");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		label_2.setBounds(427, 220, 54, 15);
		frame.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(508, 217, 78, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u665A\u5F52\u65F6\u95F4");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		label_3.setBounds(259, 267, 60, 15);
		frame.getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(343, 264, 74, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("\u665A\u5F52\u539F\u56E0");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("楷体", Font.PLAIN, 15));
		label_4.setBounds(427, 267, 67, 15);
		frame.getContentPane().add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(508, 264, 78, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Life_Log window = new Life_Log();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton.setBounds(343, 324, 74, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				Integer sno = Integer.valueOf(str);
				Boolean bool = null;
				try {
					bool = dao.querySno(sno);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (bool == false) {
					JOptionPane.showMessageDialog(null, "不存在此学号！");
					Add_Late_Information window = new Add_Late_Information();
					window.frame.setVisible(true);
					frame.dispose();
				}else {
					String str1 = textField_1.getText();
					Integer dddor = Integer.valueOf(str1);
					try {
						Boolean bool2 = ddao.query_Sno_ByDno(dddor);
						if (bool2 == false) {
							JOptionPane.showMessageDialog(null, "学号与宿舍号不对应！");
							Add_Late_Information window = new Add_Late_Information();
							window.frame.setVisible(true);
							frame.dispose();
						}else {
							Come_back_lateBean cbl = new Come_back_lateBean();
							cbl.setSno(sno);
							cbl.setDdor(Integer.valueOf(textField_1.getText()));
							cbl.setLtime(textField_2.getText());
							cbl.setDrea(textField_3.getText());
							try {
								ldao.addCom_back_late(cbl);
								JOptionPane.showMessageDialog(null, "操作成功！");
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					
				}
			
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(508, 324, 74, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
