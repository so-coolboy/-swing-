import java.awt.Color;
import java.awt.EventQueue;
import bean.VisitorBean;
import dao.VisitorDao;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Query_visitors {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query_visitors window = new Query_visitors();
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
	public Query_visitors() throws SQLException {
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
		
		/*JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("楷体", Font.PLAIN, 15));
		scrollPane_1.setViewportView(textArea);*/
		
		VisitorDao dao = new VisitorDao();
		
		List <VisitorBean> list = new ArrayList<VisitorBean>();
		list = dao.query();
		
		Object [][] data = new Object[list.size()][4];
		for (int i =0;i<list.size();i++) {
			for (int j1=0;j1<4;j1++) {
				data[i][0] = list.get(i).getVname();
				data[i][1] = list.get(i).getSname();
				data[i][2] = list.get(i).getVtel();
				data[i][3] = list.get(i).getVtime();
			}
		}
		String head[] = new String [] {"Vname","Sname","Vtel","Vtime"};
		
	
		JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(305, 163, 321, 208);
		frame.getContentPane().add(scrollPane_1);
		
		
		JTable table = new JTable(data, head );
		scrollPane_1.setViewportView(table);
		table.setFillsViewportHeight(true); 
		
		
		/*textArea.append("来访者    被访者      电话      来访时间");
		textArea.append("\n");*/
		for (VisitorBean v : list) {
			/*textArea.append(String.format("%-12s", v.getVname())+String.format("%-10s", v.getSname())
			+String.format("%-9s", v.getVtel()) +String.format("%-7s", v.getVtime()));
			textArea.append("\n"); */
			
			
		}
      
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dorm_manager window = new Dorm_manager();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 15));
		btnNewButton.setBounds(310, 417, 112, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
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
		btnNewButton_1.setBounds(509, 417, 117, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel label = new JLabel("\u6765\u8BBF\u8005\u767B\u8BB0\u4FE1\u606F\u5982\u4E0B");
		label.setForeground(Color.RED);
		label.setBounds(344, 88, 321, 30);
		frame.getContentPane().add(label);
		label.setFont(new Font("楷体", Font.PLAIN, 25));
	}

}
