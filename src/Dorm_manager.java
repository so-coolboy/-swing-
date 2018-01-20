import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dorm_manager {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dorm_manager window = new Dorm_manager();
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
	public Dorm_manager() {
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
		JLabel label = new JLabel("\u6B22\u8FCE\u8FDB\u5165\u7BA1\u7406\u7CFB\u7EDF");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 25));
		label.setBounds(337, 94, 222, 50);
		frame.getContentPane().add(label);
		
		JButton btnNewButton = new JButton("\u5B66\u751F\u7BA1\u7406");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Student_manager window = new Student_manager();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton.setBounds(344, 162, 191, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5BBF\u820D\u7BA1\u7406");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dormitory_manager window = new Dormitory_manager();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(344, 205, 191, 32);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5B66\u751F\u4F4F\u5BBF");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Student_dormitory window = new Student_dormitory();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton_2.setBounds(344, 258, 191, 33);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u751F\u6D3B\u8BB0\u5F55");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Life_Log window = new Life_Log();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_3.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton_3.setBounds(344, 313, 191, 33);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u4FEE\u6539\u7528\u6237\u540D\u5BC6\u7801");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Manager_user_password window = new Manager_user_password();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_4.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton_4.setBounds(344, 368, 191, 29);
		frame.getContentPane().add(btnNewButton_4);
	}
}
