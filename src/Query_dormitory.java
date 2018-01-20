import java.awt.Color;
import java.awt.EventQueue;
import dao.DormDao;
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

public class Query_dormitory {

	JFrame frame;
	private JTextField textField;
	private static Integer dno = 0;

	public  Integer getDno() {
		return dno;
	}

	public  void setDno(Integer dno) {
		Query_dormitory.dno = dno;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query_dormitory window = new Query_dormitory();
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
	public Query_dormitory() {
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
		DormDao dao = new DormDao();

		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u67E5\u8BE2\u7684\u5BBF\u820D\u53F7");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 25));
		label.setBounds(329, 140, 305, 47);
		frame.getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(452, 238, 111, 36);
		textField.setText("");
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("\u5BBF\u820D\u53F7\uFF1A");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("楷体", Font.PLAIN, 25));
		label_1.setBounds(341, 238, 121, 36);
		frame.getContentPane().add(label_1);

		JButton button = new JButton("\u8FD4\u56DE");
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
		button.setBounds(339, 331, 92, 36);
		frame.getContentPane().add(button);

		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				if (str.equals("")) {
					JOptionPane.showMessageDialog(null, "宿舍号不能为空！");
					Query_dormitory window = new Query_dormitory();
					window.frame.setVisible(true);
					frame.dispose();
				}else {
					dno = Integer.valueOf(textField.getText());
					
				    Boolean bool = null;
					bool = new Method().Query_dorm_Dno(dno);
				    if (bool == false) {
				    	JOptionPane.showMessageDialog(null, "不存在此宿舍号");
				    	Query_dormitory window = new Query_dormitory();
						window.frame.setVisible(true);
				    	frame.dispose();
				    }else {
				    	Query_dormitory2 window = new Query_dormitory2();
						window.frame.setVisible(true);
						frame.dispose();
				    }
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton.setBounds(471, 331, 92, 36);
		frame.getContentPane().add(btnNewButton);
	}

}
