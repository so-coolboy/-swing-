import java.awt.Color;
import java.awt.EventQueue;
import dao.StudentDao;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;

import bean.StudentBean;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_Student {

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
					Add_Student window = new Add_Student();
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
	public Add_Student() {
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
		StudentBean student = new StudentBean();
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u589E\u52A0\u7684\u5B66\u751F\u4FE1\u606F");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 20));
		label.setBounds(319, 106, 220, 43);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5B66\u53F7");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		label_1.setBounds(275, 175, 38, 27);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(343, 178, 89, 21);
		textField.setText("");
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 15));
		lblNewLabel.setBounds(458, 178, 38, 21);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(515, 178, 99, 21);
		textField_1.setText("");
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		label_2.setBounds(275, 230, 38, 15);
		frame.getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(343, 227, 89, 21);
		textField_2.setText("");
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("\u73ED\u7EA7");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		label_3.setBounds(458, 230, 38, 15);
		frame.getContentPane().add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(515, 227, 99, 21);
		textField_3.setText("");
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("\u7CFB\u540D");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("楷体", Font.PLAIN, 15));
		label_4.setBounds(275, 280, 38, 15);
		frame.getContentPane().add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(343, 274, 89, 21);
		textField_4.setText("");
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_5 = new JLabel("\u7535\u8BDD");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("楷体", Font.PLAIN, 15));
		label_5.setBounds(458, 277, 37, 15);
		frame.getContentPane().add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(515, 274, 99, 21);
		textField_5.setText("");
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sname = textField_1.getText();
				String sex = textField_2.getText();
				String sclass = textField_3.getText();
				String sdept = textField_4.getText();
				String stel = textField_5.getText();
				if (textField.getText().equals("") || sname.equals("") || sex.equals("") || sclass.equals("") 
						|| sdept.equals("") || stel.equals("")) {
					JOptionPane.showMessageDialog(null, "信息都不能为空");
				}else {
					Integer sno = Integer.valueOf(textField.getText());
					student.setSno(sno);
					student.setSname(sname);
					student.setSsex(sex);
					student.setSclass(sclass);
					student.setSdept(sdept);
					student.setStel(stel);
					try {
						Boolean bool = dao.querySno(sno);
						if (bool == false) {
							dao.addstudent(student);
							JOptionPane.showMessageDialog(null, "操作成功!");
						}else {
							JOptionPane.showMessageDialog(null, "已存在学生信息！");
							Add_Student window = new Add_Student();
							window.frame.setVisible(true);
							frame.dispose();
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 12));
		btnNewButton.setBounds(515, 337, 99, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Student_manager window = new Student_manager();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(343, 337, 93, 27);
		frame.getContentPane().add(btnNewButton_1);
	}
}
