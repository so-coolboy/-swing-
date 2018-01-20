import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.Method;

public class Report_damage {

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
					Report_damage window = new Report_damage();
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
	public Report_damage() {
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
		Method method = new Method();
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u5BBF\u820D\u53F7\u548C\u635F\u574F\u7269\u54C1");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 25));
		label.setBounds(334, 133, 317, 61);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BBF\u820D\u53F7\uFF1A");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("楷体", Font.PLAIN, 20));
		label_1.setBounds(348, 216, 87, 36);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(504, 216, 80, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u635F\u574F\u7269\u54C1\uFF1A");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("楷体", Font.PLAIN, 20));
		label_2.setBounds(348, 275, 110, 36);
		frame.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(504, 275, 79, 31);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Studentview window = new Studentview();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton.setBounds(342, 341, 93, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer dno = Integer.valueOf(textField.getText());
				
				String damage = textField_1.getText();
				if (damage.equals("床") || damage.equals("凳子") || damage.equals("柜子")|| damage.equals("灯") ) {
					if (dno!=null && damage!=null) {
						boolean bool = method.Query_dorm_Dno(dno);
						if (bool == false) {
							JOptionPane.showMessageDialog(null, "请输入正确的宿舍号!");
							Report_damage window = new Report_damage();
							window.frame.setVisible(true);
							frame.dispose();
						}else {
							method.Damage_goodsAdd(dno, damage);
							   JOptionPane.showMessageDialog(null, "插入信息成功！");
						}
					   
					}else {
						JOptionPane.showMessageDialog(null, "输入信息有误，请重新输入：");
						Report_damage window = new Report_damage();
						window.frame.setVisible(true);
						frame.dispose();
					}
					
					
				}else {
					JOptionPane.showMessageDialog(null, "不存在此物品！");
					Report_damage window = new Report_damage();
					window.frame.setVisible(true);
					frame.dispose();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(504, 341, 93, 36);
		frame.getContentPane().add(btnNewButton_1);
	}

}
