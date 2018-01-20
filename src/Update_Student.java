import java.awt.Color;
import java.awt.EventQueue;
import dao.StudentDao;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update_Student {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Student window = new Update_Student();
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
	public Update_Student() {
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
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u7684\u5B66\u751F\u7684\u4FE1\u606F");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 25));
		lblNewLabel.setBounds(284, 95, 319, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u5B66\u53F7");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 15));
		label.setBounds(271, 186, 47, 21);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(328, 186, 90, 21);
		textField.setText("");
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		label_1.setBounds(449, 189, 54, 15);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(513, 186, 90, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		label_2.setBounds(270, 245, 36, 15);
		frame.getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(328, 242, 90, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("\u73ED\u7EA7");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		label_3.setBounds(452, 245, 36, 15);
		frame.getContentPane().add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(516, 242, 87, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("\u7CFB\u540D");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("楷体", Font.PLAIN, 15));
		label_4.setBounds(270, 303, 36, 15);
		frame.getContentPane().add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(328, 300, 90, 21);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_5 = new JLabel("\u7535\u8BDD");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("楷体", Font.PLAIN, 15));
		label_5.setBounds(452, 303, 36, 15);
		frame.getContentPane().add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(516, 300, 87, 21);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setForeground(Color.RED);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Student_manager window = new Student_manager();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 15));
		button.setBounds(300, 356, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u786E\u8BA4");
		button_1.setForeground(Color.RED);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				if (str.equals("")) {
					JOptionPane.showMessageDialog(null, "学号不能为空！");
					Update_Student window = new Update_Student();
					window.frame.setVisible(true);
					frame.dispose();
				}else {
					Integer sno = Integer.valueOf(str);
					boolean bool = false;
					try {
						bool = dao.querySno(sno);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (bool == false) {
						JOptionPane.showMessageDialog(null, "没有这个学号！");
						Update_Student window = new Update_Student();
						window.frame.setVisible(true);
						frame.dispose();
					}else {
						String sname = textField_1.getText();
						String ssex = textField_2.getText();
						String sclass = textField_3.getText();
						String sdept = textField_4.getText();
						String stel = textField_5.getText();
						try {
							dao.updateStudent(sno, sname, ssex, sclass, sdept, stel);
							JOptionPane.showMessageDialog(null, "修改成功");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 15));
		button_1.setBounds(510, 356, 93, 23);
		frame.getContentPane().add(button_1);
	}
}
