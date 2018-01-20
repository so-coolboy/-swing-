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

public class Dormitory_manager {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dormitory_manager window = new Dormitory_manager();
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
	public Dormitory_manager() {
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
		JLabel label = new JLabel("\u5BBF\u820D\u7BA1\u7406");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 30));
		label.setBounds(401, 86, 156, 38);
		frame.getContentPane().add(label);
		
		JButton btnNewButton = new JButton("\u589E\u52A0\u5BBF\u820D\u4FE1\u606F");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Add_dormitory window = new Add_dormitory();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton.setBounds(401, 151, 129, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u5BBF\u820D\u4FE1\u606F");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Del_dormitory window = new Del_dormitory();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(401, 207, 131, 31);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2\u5BBF\u820D\u4FE1\u606F");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Query_dormitory window = new Query_dormitory();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_2.setBounds(401, 263, 129, 31);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u4FEE\u6539\u5BBF\u820D\u4FE1\u606F");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Update_dormitory window = new Update_dormitory();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_3.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_3.setBounds(401, 315, 130, 31);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dorm_manager window = new Dorm_manager();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_4.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_4.setBounds(401, 359, 129, 30);
		frame.getContentPane().add(btnNewButton_4);
	}
}
