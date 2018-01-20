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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Studentview {

	JFrame frame;
	private JButton button;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studentview window = new Studentview();
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
	public Studentview() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 900, 600);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setFont(new Font("宋体", Font.PLAIN, 25));
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
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u60A8\u7684\u4F7F\u7528");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 30));
		lblNewLabel.setBounds(367, 122, 260, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2\u536B\u751F\u60C5\u51B5");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Query_Sanitary window = new Query_Sanitary();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(357, 196, 185, 33);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u4E0A\u62A5\u635F\u574F\u7269\u54C1");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Report_damage window = new Report_damage();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton_2.setBounds(357, 239, 185, 37);
		frame.getContentPane().add(btnNewButton_2);
		
		button = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Exit window = new Exit();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 20));
		button.setBounds(357, 330, 188, 37);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("\u4FEE\u6539\u7528\u6237\u540D\u5BC6\u7801");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Student_user_password window = new Student_user_password();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 20));
		button_1.setBounds(357, 286, 185, 34);
		frame.getContentPane().add(button_1);
		
		
	}
}
