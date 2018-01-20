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
import java.awt.Color;

public class Query_Student {

	JFrame frame;
	private JTextField textField;
	private static Integer sno = 0;

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query_Student window = new Query_Student();
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
	public Query_Student() {
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
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u67E5\u8BE2\u7684\u5B66\u751F\u5B66\u53F7");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 25));
		label.setBounds(362, 137, 290, 64);
		frame.getContentPane().add(label);
		
		StudentDao dao = new StudentDao();
		
		JLabel label_1 = new JLabel("\u5B66\u53F7\uFF1A");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("楷体", Font.PLAIN, 25));
		label_1.setBounds(358, 239, 81, 30);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(488, 244, 150, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//frame.dispose();
				Student_manager window = new Student_manager();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton.setBounds(360, 332, 93, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sno = Integer.valueOf(textField.getText());
				
			    Boolean bool = null;
				try {
					bool = dao.querySno(sno);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    if (bool == false) {
			    	JOptionPane.showMessageDialog(null, "不存在此学号");
			    	Query_Student window = new Query_Student();
					window.frame.setVisible(true);
					frame.dispose();
			    }else {
			    	Query_Student2 window = new Query_Student2();
					window.frame.setVisible(true);
					frame.dispose();
			    }
				
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(545, 332, 93, 36);
		frame.getContentPane().add(btnNewButton_1);
	}

}
