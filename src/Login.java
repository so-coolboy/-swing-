import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import dao.LoginDao;

public class Login {

	private JFrame frame;
	private String getItem = null;
	private JTextField textField;
	private JTextField textField_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 900, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LoginDao logindao = new LoginDao();
		
		ImageIcon icon = new ImageIcon("./1.jpg");
		JLabel label = new JLabel(icon);
		label.setBounds(0,0,frame.getWidth(),frame.getHeight());
		
		//获取窗口的第二层，将label放入
		frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));  
		
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
        
        JLabel label_2 = new JLabel("");
        label_2.setBounds(217, 5, 0, 0);
        panel.add(label_2);
        
        JLabel label_1 = new JLabel("\u4E2D\u5317\u5927\u5B66\u5BBF\u820D\u7BA1\u7406\u7CFB\u7EDF");
        label_1.setForeground(new Color(255, 0, 0));
        label_1.setFont(new Font("楷体", Font.PLAIN, 30));
        label_1.setBounds(254, 139, 300, 38);
        panel.add(label_1);
        
        JLabel label_3 = new JLabel("\u7528\u6237\u540D\uFF1A");
        label_3.setForeground(new Color(255, 0, 0));
        label_3.setFont(new Font("楷体", Font.PLAIN, 25));
        label_3.setBounds(254, 238, 110, 23);
        panel.add(label_3);
        
        JLabel label_4 = new JLabel("\u5BC6\u7801\uFF1A");
        label_4.setForeground(new Color(255, 0, 0));
        label_4.setFont(new Font("楷体", Font.PLAIN, 25));
        label_4.setBounds(265, 271, 75, 29);
        panel.add(label_4);
        
        textField = new JTextField();
        textField.setBounds(406, 241, 127, 26);
        panel.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(406, 275, 127, 29);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("\u7528\u6237\u6743\u9650\uFF1A");
        lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 25));
        lblNewLabel.setForeground(new Color(255, 0, 0));
        lblNewLabel.setBounds(254, 313, 132, 26);
        panel.add(lblNewLabel);
        
        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setForeground(new Color(255, 0, 0));
        comboBox.setFont(new Font("楷体", Font.PLAIN, 20));
        comboBox.setBounds(406, 314, 127, 29);
        comboBox.addItem("普通用户");
        comboBox.addItem("宿舍管理员");
        comboBox.addItem("系统管理员");
        panel.add(comboBox);
        
        JButton button = new JButton("\u767B\u5F55");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        button.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		getItem = (String) comboBox.getSelectedItem();
        		String users = textField.getText();
    			String pass = textField_1.getText();
        		if (getItem.equals("普通用户")) {
        			//去学生表查询是否匹配用户名和密码
        			
        			try {
						Boolean bool =logindao.getBoolUP(users, pass);
						if (bool == true) {
							Studentview window = new Studentview();
		    				window.frame.setVisible(true);
						}else {
	        				JOptionPane.showMessageDialog(null, "请输入正确的用户名和密码！");
	        				Login window = new Login();
	    					window.frame.setVisible(true);
	        				
	        			}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			
        		}else if(getItem.equals("宿舍管理员")) {
        			//去宿舍管理员匹配用户名和密码
        			try {
						Boolean bool =logindao.getBoolMUP(users, pass);
						if (bool == true) {
							Dorm_manager window = new Dorm_manager();
							window.frame.setVisible(true);
						}else {
	        				JOptionPane.showMessageDialog(null, "请输入正确的用户名和密码！");
	        				Login window = new Login();
	    					window.frame.setVisible(true);
	        			}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			
        		}else if (getItem.equals("系统管理员")) {
        			// 用户名：root  密码：root
        			if (textField.getText().equals("root") && (textField_1.getText().equals("root"))) {
        				HouseParent window = new HouseParent();
    					window.frame.setVisible(true);
        			}else {
        				JOptionPane.showMessageDialog(null, "请输入正确的用户名和密码！");
        				Login window = new Login();
    					window.frame.setVisible(true);
        			}
        		}
        		frame.dispose();
        		
        		
        	}
        });
        button.setFont(new Font("楷体", Font.PLAIN, 20));
        button.setForeground(new Color(255, 0, 0));
        button.setBounds(406, 353, 127, 34);
        panel.add(button);
        
        
        
        frame.setVisible(true);  
		
	}
	
	
	

}
