import java.awt.Color;
import java.awt.EventQueue;

import dao.Method;

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

public class Query_Sanitary {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query_Sanitary window = new Query_Sanitary();
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
	public Query_Sanitary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 900, 600);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setFont(new Font("楷体", Font.PLAIN, 15));
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
		Method method = new Method();
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u67E5\u8BE2\u7684\u5BBF\u820D\u53F7\uFF1A");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 20));
		label.setBounds(275, 146, 236, 57);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(276, 213, 73, 30);
		textField.setText("");
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(276, 312, 73, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				if (str.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入宿舍号：");
					Query_Sanitary window = new Query_Sanitary();
					window.frame.setVisible(true);
					frame.dispose();
					
				}else {
					Integer sws = Integer.valueOf(str);
					boolean bool = method.Query_dorm_Dno(sws);
					if (bool == false) {
						JOptionPane.showMessageDialog(null, "没有此宿舍号，请重新输入！");
						Query_Sanitary window = new Query_Sanitary();
						window.frame.setVisible(true);
						frame.dispose();
					}else {
						String score = null;
						try {
							score = method.Sanitary_query(sws);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
						}
						textField_1.setText(score);
					}
				}
	
			
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton.setBounds(455, 210, 78, 30);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label_1 = new JLabel("\u8BE5\u5BBF\u820D\u7684\u536B\u751F\u6210\u7EE9\u4E3A\uFF1A");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("楷体", Font.PLAIN, 20));
		label_1.setBounds(276, 247, 213, 43);
		frame.getContentPane().add(label_1);
		
		
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Studentview window = new Studentview();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 20));
		button.setBounds(455, 311, 78, 30);
		frame.getContentPane().add(button);
	}
}
