package clara.wc;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.*;

public class gui extends JFrame implements ActionListener {
	//定义组件
		JTextArea jta;
//		JMenuBar jmb;
//		JMenu jm1,jm2,jm3,jm4,jm5;
		JButton jb1,jb2,jb3,jb4,jb5,jb6;
		JPanel jp1,jp2;
		JScrollPane jsp;
		Container contentPane=this.getContentPane();
		int chars1=0;
		int words1=0;
		int rows1=0;
		int nulline1=0;
		int codeline1=0;
		int noteline1=0;
		File f2;
		
		public static void main(String[] args) throws Exception {
			gui tx=new gui(null);
		}
	 //构造函数
	    public gui(File f) throws Exception{
	    	
	 //创建组件
	    	File f1=f;
	    	f2=f1;
	        jta=new JTextArea(400,400);
	        jsp=new JScrollPane();
	        jb1=new JButton("字符数");
	        jb2=new JButton("单词数");
	        jb3=new JButton("行数");
	        jb4=new JButton("特殊行统计");
	        jb5=new JButton("全部");
	        jb6=new JButton("更换统计文件");
	    	jp1=new JPanel();  
	    	jp2=new JPanel(); 
	    	
	 //添加组件
	        jp1.add(jb1);
	        jp1.add(jb2);
	        jp1.add(jb3);
	        jp1.add(jb4);
	        jp1.add(jb5);
//	        JScrollPane jsp=new JScrollPane(jtf);
//	        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//	        jp2.add(jsp);
	        jsp.add(jta);
	        contentPane.setLayout(new BorderLayout());
	        contentPane.add(jsp);
	        
	        jp2.add(jb6);
	 //加入到JFrame
	        this.add(jp1);
	        this.add(jsp);
	        this.add(jp2);
	   //     this.add(jp2);
	        jp1.setLayout(new GridLayout(1,5,0,0));
	        this.add(jp1,BorderLayout.NORTH);
	        this.add(jsp,BorderLayout.CENTER);
	        this.add(jp2,BorderLayout.SOUTH);
	        
	 //对窗体设置
	        //jp2.setBounds(200,100,100,100);
	       // jp2.setLayout(null);
	        jta.setTabSize(4);
	        jta.setBounds(0,10,500,500);
	        jta.setFont(new Font("宋体",Font.PLAIN,20));
	        jta.setLineWrap(true);//激活自动换行功能
	        jta.setWrapStyleWord(true);//激活断行不断字功能
	        
	        
	       // jp2.add(jta);
	        this.setSize(500, 500);
	        this.setTitle("wc文件统计");
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setVisible(true);
	
	        wc wc2=new wc(f);
	        chars1=wc2.chars;
	        words1=wc2.words;
	        rows1=wc2.rows;
	        nulline1=wc2.nulline;
			codeline1=wc2.codeline;
			noteline1=wc2.noteline;
	//监听  
	        jb1.setActionCommand("chars");
	        jb1.addActionListener(this);
	        jb2.setActionCommand("words");
	        jb2.addActionListener(this);
	        jb3.setActionCommand("line");
	        jb3.addActionListener(this);
	        jb4.setActionCommand("special");
	        jb4.addActionListener(this);
	        jb5.setActionCommand("allin");
	        jb5.addActionListener(this);
	        jb6.setActionCommand("change");
	        jb6.addActionListener(this);
	    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("chars")) {
			jta.setText(f2+"\n字符数："+chars1);
		}
		if(e.getActionCommand().equals("words")) {
			jta.setText(f2+"\n单词数："+words1);
		}
		if(e.getActionCommand().equals("line")) {
			jta.setText(f2+"\n行数："+rows1);
		}
		if(e.getActionCommand().contentEquals("special")) {
			jta.setText(f2+"\n空行："+nulline1+"\n"+"代码行："+codeline1+"\n"+"注释行："+noteline1+"\n");
			
		}
		if(e.getActionCommand().contentEquals("allin")) {
			jta.setText(f2+"\n字符数："+chars1);
			jta.append("\n单词数："+words1);
			jta.append("\n行数："+rows1);
			jta.append("\n代码行："+codeline1);
			jta.append("\n空行："+nulline1);
			jta.append("\n注释行："+noteline1);
		}
		if(e.getActionCommand().contentEquals("change")) {
			gui0 gui01=new gui0();
		}
	}
		
}

