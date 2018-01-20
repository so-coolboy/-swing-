import java.awt.Color;
import java.awt.EventQueue;
import bean.Damage_goodsBean;
import dao.Method;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Check_items {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Check_items window = new Check_items();
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
	public Check_items() throws SQLException {
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
		
		JLabel label = new JLabel("\u5404\u5BBF\u820D\u7269\u54C1\u635F\u574F\u4FE1\u606F\u5982\u4E0B");
		label.setForeground(Color.RED);
		label.setFont(new Font("楷体", Font.PLAIN, 20));
		label.setBounds(314, 134, 257, 36);
		frame.getContentPane().add(label);
		
		
		
		
		Method method = new Method();
		Damage_goodsBean dgb = new Damage_goodsBean();
		List<Damage_goodsBean> list = new ArrayList<Damage_goodsBean>();
		list = method.query();
		
		Object [][] data = new Object[list.size()][4];
		for (int i =0;i<list.size();i++) {
			for (int j1=0;j1<4;j1++) {
				data[i][0] = list.get(i).getDno();
				data[i][1] = list.get(i).getDdor();
				data[i][2] = list.get(i).getDgoods();
				data[i][3] = list.get(i).getDtime();
			}
		}
		  String head[] = new String [] {"编号","宿舍号","损坏物品","时间"};
         JTable table = new JTable(data, head );
         table.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JScrollPane scrollPane_1 = new JScrollPane(table);
		table.setFillsViewportHeight(true); 
        scrollPane_1.setBounds(268, 204, 321, 158);
		frame.getContentPane().add(scrollPane_1);
		
		
		
		JButton button = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		button.setForeground(Color.RED);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dorm_manager window = new Dorm_manager();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 15));
		button.setBounds(269, 392, 118, 30);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		button_1.setForeground(Color.RED);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Life_Log window = new Life_Log();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 15));
		button_1.setBounds(469, 393, 118, 28);
		frame.getContentPane().add(button_1);
	}

}
