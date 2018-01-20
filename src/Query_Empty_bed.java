import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import bean.DormBean;
import dao.Student_Dorm_Dao;

import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;

public class Query_Empty_bed {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query_Empty_bed window = new Query_Empty_bed();
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
	public Query_Empty_bed() {
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
		
		
        
        
        
		
		
		
		
		JLabel label = new JLabel("\u7A7A\u5E8A\u4FE1\u606F\u5982\u4E0B\uFF1A");
		label.setForeground(Color.RED);
		label.setBounds(364, 147, 210, 35);
		frame.getContentPane().add(label);
		label.setFont(new Font("楷体", Font.PLAIN, 30));
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(553, 425, 72, 35);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Student_dormitory window = new Student_dormitory();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 15));
		
		List <DormBean> list = new ArrayList<DormBean>(); 
		try {
			list = new Student_Dorm_Dao().query();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		Object [][] data = new Object[list.size()][2];
		for (int i =0;i<list.size();i++) {
			for (int j1=0;j1<4;j1++) {
				data[i][0] = list.get(i).getDdor();
				data[i][1] = list.get(i).getDunused();
			}
		}
		
		String head[] = new String [] {"宿舍号","空床数目"};
		JTable table = new JTable(data, head );
		
		JScrollPane scrollPane_1 = new JScrollPane(table);
		table.setFillsViewportHeight(true); 
		table.setFont(new Font("楷体", Font.PLAIN, 15));
        scrollPane_1.setBounds(304, 215, 321, 186);
		frame.getContentPane().add(scrollPane_1);
		
		
		
		
	}
}
