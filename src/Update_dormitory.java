import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;

import bean.DormBean;
import dao.DormDao;
import dao.Method;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Update_dormitory {

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
					Update_dormitory window = new Update_dormitory();
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
	public Update_dormitory() {
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
		DormDao dao = new DormDao();
		Method method = new Method();
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u7684\u5BBF\u820D\u4FE1\u606F");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 25));
		label.setBounds(310, 117, 275, 53);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("\u5BBF\u820D\u53F7");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 15));
		lblNewLabel.setBounds(266, 226, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(349, 223, 83, 21);
		textField.setText("");
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u697C\u53F7");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		label_1.setBounds(463, 226, 40, 15);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(535, 223, 83, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u603B\u5E8A\u4F4D\u6570");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		label_2.setBounds(266, 281, 60, 15);
		frame.getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(349, 278, 83, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("\u672A\u7528\u5E8A\u4F4D\u6570");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		label_3.setBounds(442, 281, 83, 15);
		frame.getContentPane().add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(535, 278, 83, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dormitory_manager window = new Dormitory_manager();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton.setBounds(322, 356, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.setForeground(Color.RED);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				if (str.equals("")) {
					JOptionPane.showMessageDialog(null, "宿舍号不能为空！");
					Update_dormitory window = new Update_dormitory();
					window.frame.setVisible(true);
					frame.dispose();
				}else {
					Integer dno = Integer.valueOf(str);
					boolean bool = false;
					bool = method.Query_dorm_Dno(dno);
					if (bool == false) {
						JOptionPane.showMessageDialog(null, "没有这个宿舍号");
						Update_dormitory window = new Update_dormitory();
						window.frame.setVisible(true);
						frame.dispose();
					}else {
						Integer dbuil = Integer.valueOf(textField_1.getText());
						Integer dbednum = Integer.valueOf(textField_2.getText());
						Integer dunused = Integer.valueOf(textField_3.getText());
						
						if (dbednum < dunused ) {
							JOptionPane.showMessageDialog(null, "未用床数不能大于总床数!");
							Update_dormitory window = new Update_dormitory();
							window.frame.setVisible(true);
							frame.dispose();
						}else {
							try {
								dao.updateDrom(dno, dbuil, dbednum, dunused);
								JOptionPane.showMessageDialog(null, "修改成功");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 15));
		button.setBounds(508, 356, 93, 23);
		frame.getContentPane().add(button);
	}

}
