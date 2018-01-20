import java.awt.Color;
import java.awt.EventQueue;
import dao.StudentDao;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;

import bean.StudentBean;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Query_Student2 {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel label_3;
	private JTextField textField_2;
	private JLabel label_4;
	private JTextField textField_3;
	private JLabel label_5;
	private JTextField textField_4;
	private JLabel label_6;
	private JTextField textField_5;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query_Student2 window = new Query_Student2();
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
	public Query_Student2() {
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
		Query_Student qs = new Query_Student();
		Integer sno = qs.getSno();
		
		StudentDao dao = new StudentDao();
		
		JLabel label = new JLabel("\u8BE5\u5B66\u751F\u7684\u4FE1\u606F\u4E3A");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 25));
		label.setBounds(362, 133, 229, 36);
		frame.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("\u5B66\u53F7");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		label_2.setBounds(289, 207, 38, 27);
		frame.getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(354, 210, 89, 21);
		frame.getContentPane().add(textField);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		label_1.setBounds(466, 210, 38, 21);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(528, 210, 99, 21);
		frame.getContentPane().add(textField_1);
		
		label_3 = new JLabel("\u6027\u522B");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		label_3.setBounds(289, 254, 38, 15);
		frame.getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(354, 251, 89, 21);
		frame.getContentPane().add(textField_2);
		
		label_4 = new JLabel("\u73ED\u7EA7");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("楷体", Font.PLAIN, 15));
		label_4.setBounds(466, 254, 38, 15);
		frame.getContentPane().add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(528, 251, 99, 21);
		frame.getContentPane().add(textField_3);
		
		label_5 = new JLabel("\u7CFB\u540D");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("楷体", Font.PLAIN, 15));
		label_5.setBounds(289, 296, 38, 15);
		frame.getContentPane().add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(354, 293, 89, 21);
		frame.getContentPane().add(textField_4);
		
		label_6 = new JLabel("\u7535\u8BDD");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("楷体", Font.PLAIN, 15));
		label_6.setBounds(466, 296, 37, 15);
		frame.getContentPane().add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(528, 293, 99, 21);
		frame.getContentPane().add(textField_5);
		
		StudentBean student = new StudentBean();
		try {
			student = dao.get(sno);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		textField.setText(String.valueOf(student.getSno()));
		textField_1.setText(student.getSname());
		textField_2.setText(student.getSsex());
		textField_3.setText(student.getSclass());
		textField_4.setText(student.getSdept());
		textField_5.setText(student.getStel());
		
		button = new JButton("\u8FD4\u56DE");
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
		button.setBounds(528, 346, 99, 27);
		frame.getContentPane().add(button);
	}

}
