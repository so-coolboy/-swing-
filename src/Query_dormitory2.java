import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;

import bean.DormBean;
import dao.DormDao;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Query_dormitory2 {

	JFrame frame;
	private JTextField textField;
	private JLabel label_2;
	private JTextField textField_1;
	private JLabel label_3;
	private JTextField textField_2;
	private JLabel label_4;
	private JTextField textField_3;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query_dormitory2 window = new Query_dormitory2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Query_dormitory2()  {
		try {
			initialize();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
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
		JLabel label = new JLabel("\u8BE5\u5BBF\u820D\u7684\u4FE1\u606F\u4E3A");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 25));
		label.setBounds(346, 152, 197, 36);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BBF\u820D\u53F7");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		label_1.setBounds(240, 240, 54, 15);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(321, 237, 76, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		label_2 = new JLabel("\u697C\u53F7");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		label_2.setBounds(429, 240, 54, 15);
		frame.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(516, 237, 87, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		label_3 = new JLabel("\u603B\u5E8A\u4F4D\u6570");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		label_3.setBounds(228, 290, 66, 15);
		frame.getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(321, 287, 76, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		label_4 = new JLabel("\u672A\u7528\u5E8A\u4F4D\u6570");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("楷体", Font.PLAIN, 15));
		label_4.setBounds(407, 290, 85, 15);
		frame.getContentPane().add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(516, 287, 87, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		Query_dormitory qd = new Query_dormitory();
		Integer dno = qd.getDno();
		
		DormBean dorm = new DormBean();
		DormDao dao = new DormDao();
		
		dorm =  dao.get(dno);
		
		textField.setText(String.valueOf(dorm.getDdor()));
		textField_1.setText(String.valueOf(dorm.getDbuil()));
		textField_2.setText(String.valueOf(dorm.getDbednum()));
		textField_3.setText(String.valueOf(dorm.getDunused()));
		
		
		button = new JButton("\u8FD4\u56DE");
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
		button.setBounds(526, 367, 93, 23);
		frame.getContentPane().add(button);
	}

}
