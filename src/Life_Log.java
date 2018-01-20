import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Life_Log {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Life_Log window = new Life_Log();
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
	public Life_Log() {
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
		JLabel label = new JLabel("\u751F\u6D3B\u8BB0\u5F55");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 30));
		label.setBounds(379, 100, 162, 27);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("\u665A\u5F52\u4FE1\u606F\u8BB0\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Add_Late_Information window = new Add_Late_Information();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 20));
		button.setBounds(246, 190, 162, 27);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u536B\u751F\u68C0\u67E5\u8BB0\u5F55");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				Sanitary_inspection window = new Sanitary_inspection();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 20));
		button_1.setBounds(246, 291, 162, 27);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u67E5\u770B\u7269\u54C1\u635F\u574F");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Check_items window = null;
				try {
					window = new Check_items();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		button_2.setFont(new Font("楷体", Font.PLAIN, 20));
		button_2.setBounds(468, 293, 163, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\u767B\u8BB0\u6765\u8BBF\u4FE1\u606F");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				Register_visitors window = new Register_visitors();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		button_3.setFont(new Font("楷体", Font.PLAIN, 20));
		button_3.setBounds(246, 242, 162, 27);
		frame.getContentPane().add(button_3);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				Dorm_manager window = new Dorm_manager();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(367, 357, 162, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u665A\u5F52\u4FE1\u606F\u67E5\u8BE2");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Query_Late_information window = null;
				try {
					window = new Query_Late_information();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton_2.setBounds(468, 190, 163, 27);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u6765\u8BBF\u4FE1\u606F\u67E5\u8BE2");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Query_visitors window = null;
				try {
					window = new Query_visitors();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_3.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton_3.setBounds(469, 241, 162, 29);
		frame.getContentPane().add(btnNewButton_3);
	}

}
