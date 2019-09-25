package clara.wc;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.io.File;

public class gui0 extends JFrame implements ActionListener {
   //定义组件
	JPanel jp0;
	JButton jb0;
	JLabel jl0;
	
	public static void main(String []args) {
		gui0 tx1=new gui0();
	}
	public gui0() {
		jp0=new JPanel();
		jb0=new JButton("选择文件");
		jl0=new JLabel("这里可以选择想要统计的文件哦");
		//创建组件
		
		jp0.add(jl0);
		jp0.add(jb0);
		//添加组件
		this.add(jp0);
		//对窗体设置
		this.setSize(500,200);
		this.setTitle("wc文件统计");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		jb0.setActionCommand("open");
		jb0.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("open")) {
			JFileChooser jf=new JFileChooser();
			jf.showOpenDialog(this); //显示打开的文件对话框
			File f=jf.getSelectedFile();
			try {
				gui gui1=new gui(f);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	    
	    
}