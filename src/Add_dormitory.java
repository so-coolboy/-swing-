import java.awt.Color;
import java.awt.EventQueue;
import dao.Method;
import dao.DormDao;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;

import dao.DormDao;
import bean.DormBean;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Add_dormitory {

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
					Add_dormitory window = new Add_dormitory();
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
	public Add_dormitory() {
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
		DormBean dorm = new DormBean();
		Method method = new Method();

		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u589E\u52A0\u7684\u5BBF\u820D\u4FE1\u606F");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 20));
		label.setBounds(344, 130, 244, 36);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("\u5BBF\u820D\u53F7");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		label_1.setBounds(283, 222, 45, 15);
		frame.getContentPane().add(label_1);

		textField = new JTextField();
		textField.setBounds(369, 219, 80, 21);
		textField.setText("");
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel label_2 = new JLabel("\u697C\u53F7");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		label_2.setBounds(508, 222, 45, 15);
		frame.getContentPane().add(label_2);

		textField_1 = new JTextField();
		textField_1.setBounds(570, 219, 90, 21);
		textField_1.setText("");
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel label_3 = new JLabel("\u603B\u5E8A\u4F4D\u6570");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		label_3.setBounds(267, 261, 60, 15);
		frame.getContentPane().add(label_3);

		textField_2 = new JTextField();
		textField_2.setBounds(369, 258, 80, 21);
		textField_2.setText("");
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel label_4 = new JLabel("\u672A\u7528\u5E8A\u4F4D\u6570");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("楷体", Font.PLAIN, 15));
		label_4.setBounds(485, 261, 75, 15);
		frame.getContentPane().add(label_4);

		textField_3 = new JTextField();
		textField_3.setBounds(570, 258, 85, 21);
		textField_3.setText("");
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JButton button = new JButton("\u8FD4\u56DE");
		button.setForeground(Color.RED);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dormitory_manager window = new Dormitory_manager();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 15));
		button.setBounds(369, 353, 93, 23);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\u786E\u8BA4");
		button_1.setForeground(Color.RED);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textField.getText().equals("") || textField_1.getText().equals("") 
						|| textField_2.equals("") || textField_3.equals("")) {
					JOptionPane.showMessageDialog(null, "内容不能为空！");
					Add_dormitory window = new Add_dormitory();
					window.frame.setVisible(true);
					frame.dispose();
				} else {
					Integer dno = Integer.valueOf(textField.getText());
					Integer dbuil = Integer.valueOf(textField_1.getText());
					Integer dbednum = Integer.valueOf(textField_2.getText());
					Integer dunused = Integer.valueOf(textField_3.getText());
					dorm.setDdor(dno);
					dorm.setDbuil(dbuil);
					dorm.setDbednum(dbednum);
					dorm.setDunused(dunused);
					try {
						Boolean bool = method.Query_dorm_Dno(dno);
						if (bool == false) {
							dao.addDorm(dorm);
							JOptionPane.showMessageDialog(null, "操作成功！");
						}else {
							JOptionPane.showMessageDialog(null, "该宿舍号已经存在！");
							Add_dormitory window = new Add_dormitory();
							window.frame.setVisible(true);
							frame.dispose();
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 15));
		button_1.setBounds(535, 353, 93, 23);
		frame.getContentPane().add(button_1);
	}
}
