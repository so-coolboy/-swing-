import java.awt.Color;
import java.awt.EventQueue;
import dao.Late_informationDao;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.JTextArea;

import bean.Come_back_lateBean;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Query_Late_information {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query_Late_information window = new Query_Late_information();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Query_Late_information() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
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
		
		Late_informationDao dao = new Late_informationDao();
		
		JLabel label = new JLabel("\u665A\u5F52\u4FE1\u606F\u5982\u4E0B\uFF1A");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 25));
		label.setBounds(321, 131, 191, 32);
		frame.getContentPane().add(label);
		
		
		List <Come_back_lateBean> list = new ArrayList<Come_back_lateBean>();
		list = dao.query();
		Object [][] data = new Object[list.size()][5];
		for (int i =0;i<list.size();i++) {
			for (int j1=0;j1<5;j1++) {
				data[i][0] = list.get(i).getLno();
				data[i][1] = list.get(i).getSno();
				data[i][2] = list.get(i).getDdor();
				data[i][3] = list.get(i).getLtime();
				data[i][4] = list.get(i).getDrea();
			}
		}
		
		String head[] = new String [] {"编号","学号","宿舍号","晚归时间","晚归原因"};
		
		JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(263, 205, 321, 164);
		frame.getContentPane().add(scrollPane_1);
		
		JTable table = new JTable(data, head );
		scrollPane_1.setViewportView(table);
		table.setFillsViewportHeight(true); 
		
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				Dorm_manager window = new Dorm_manager();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton.setBounds(265, 394, 112, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Life_Log window = new Life_Log();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(457, 394, 126, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
