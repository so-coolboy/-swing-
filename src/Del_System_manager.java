import java.awt.Color;
import java.awt.EventQueue;
import dao.ManagerDao;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Del_System_manager {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Del_System_manager window = new Del_System_manager();
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
	public Del_System_manager() {
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
		
		//��ȡ���ڵĵڶ��㣬��label����
		frame.getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));  
		
		//��ȡframe�Ķ�������,������Ϊ͸��
		JPanel j=(JPanel)frame.getContentPane();  
        j.setOpaque(false);  
        
        JPanel panel=new JPanel();
        panel.setForeground(new Color(255, 0, 0));
  
        //��������Ϊ͸���ġ����򿴲���ͼƬ  
        panel.setOpaque(false);  
  
        frame.getContentPane().add(panel);  
        frame.getContentPane().add(panel);
        panel.setLayout(null);
		ManagerDao dao = new ManagerDao();
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u7684\u7BA1\u7406\u5458\u53F7");
		label.setForeground(Color.RED);
		label.setFont(new Font("����", Font.PLAIN, 25));
		label.setBounds(316, 143, 287, 49);
		frame.getContentPane().add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("����", Font.PLAIN, 20));
		textArea.setBounds(350, 231, 187, 40);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HouseParent window = new HouseParent();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 15));
		btnNewButton.setBounds(324, 331, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textArea.getText();
				if (str.equals("")) {
					JOptionPane.showMessageDialog(null, "���������Ա�ţ�");
				}else {
					Integer mno = Integer.valueOf(str);
					try {
						boolean bool = dao.queryMno(mno);
						if (bool == false) {
							Del_System_manager window = new Del_System_manager();
							window.frame.setVisible(true);
							frame.dispose();
						}else {
							dao.delManager(mno);
							JOptionPane.showMessageDialog(null, "ɾ���ɹ�!");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 15));
		btnNewButton_1.setBounds(492, 331, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
