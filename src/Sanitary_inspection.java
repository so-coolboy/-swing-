import java.awt.Color;
import java.awt.EventQueue;
import dao.Method;
import dao.Sanitary;

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

public class Sanitary_inspection {

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
					Sanitary_inspection window = new Sanitary_inspection();
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
	public Sanitary_inspection() {
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
		Sanitary sa = new Sanitary();
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u5BBF\u820D\u53F7\u548C\u536B\u751F\u60C5\u51B5");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 25));
		label.setBounds(313, 162, 317, 41);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(318, 246, 115, 29);
		textField.setText("");
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.setForeground(Color.RED);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Life_Log window = new Life_Log();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 15));
		button.setBounds(318, 331, 113, 23);
		frame.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				String str1 = textField_1.getText();
				if (str.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入宿舍号！");
					Sanitary_inspection window = new Sanitary_inspection();
					window.frame.setVisible(true);
					frame.dispose();
				}else {
					Integer dno = Integer.valueOf(str);
					Boolean bool = method.Query_dorm_Dno(dno);
					if (bool == false) {
						JOptionPane.showMessageDialog(null, "没有这个宿舍号！");
						Sanitary_inspection window = new Sanitary_inspection();
						window.frame.setVisible(true);
						frame.dispose();
					}else {
						try {
							sa.updateSanitary(str1, dno);
							JOptionPane.showMessageDialog(null, "操作成功！");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton.setBounds(500, 331, 102, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(500, 246, 102, 29);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
