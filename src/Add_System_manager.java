import java.awt.Color;
import java.awt.EventQueue;
import bean.ManagementBean;
import dao.ManagerDao;

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

public class Add_System_manager {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_System_manager window = new Add_System_manager();
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
	public Add_System_manager() {
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
		ManagementBean mb = new ManagementBean();
		ManagerDao dao = new ManagerDao();
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u7BA1\u7406\u5458\u4FE1\u606F");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 25));
		label.setBounds(326, 103, 234, 39);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u7BA1\u7406\u5458\u53F7\uFF1A");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("楷体", Font.PLAIN, 15));
		label_1.setBounds(252, 185, 75, 21);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(357, 185, 66, 21);
		textField.setText("");
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u59D3\u540D\uFF1A");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("楷体", Font.PLAIN, 15));
		
		label_2.setBounds(452, 188, 54, 15);
		frame.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(516, 185, 75, 21);
		textField_1.setText("");
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6027\u522B\uFF1A");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("楷体", Font.PLAIN, 15));
		label_3.setBounds(261, 235, 45, 15);
		frame.getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(357, 232, 66, 21);
		textField_2.setText("");
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("\u7535\u8BDD\uFF1A");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("楷体", Font.PLAIN, 15));
		label_4.setBounds(452, 228, 45, 28);
		frame.getContentPane().add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(516, 232, 75, 21);
		textField_3.setText("");
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_5 = new JLabel("\u6240\u7BA1\u697C\u53F7\uFF1A");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("楷体", Font.PLAIN, 15));
		label_5.setBounds(252, 282, 75, 15);
		frame.getContentPane().add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(356, 279, 66, 21);
		textField_4.setText("");
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setForeground(Color.RED);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HouseParent window = new HouseParent();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 15));
		button.setBounds(356, 344, 66, 23);
		frame.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mno = textField.getText();
				String mname = textField_1.getText();
				String msex = textField_2.getText();
				String mtel = textField_3.getText();
				String dbuil = textField_4.getText();
				
				if (mno.equals("") || mname.equals("") || msex.equals("") || mtel.equals("") ||dbuil.equals("")) {
					JOptionPane.showMessageDialog(null, "信息都不能为空");
					Add_System_manager window = new Add_System_manager();
					window.frame.setVisible(true);
					frame.dispose();
				}else{
					Integer mno1 = Integer.valueOf(mno);
					Integer dbuil1 = Integer.valueOf(dbuil);
					mb.setMno(mno1);
					mb.setMname(mname);
					mb.setMsex(msex);
					mb.setMtel(mtel);
					mb.setDbuil(dbuil1);
					Boolean bool = null;
					try {
						bool = dao.queryMno(mno1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (bool == false) {
						try {
							dao.addManager(mb);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "操作成功！");
					}else {
						JOptionPane.showMessageDialog(null, "已存在管理员信息！");
						Add_System_manager window = new Add_System_manager();
						window.frame.setVisible(true);
						frame.dispose();
					}
					
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton.setBounds(525, 344, 66, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
