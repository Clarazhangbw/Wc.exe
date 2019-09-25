package clara.wc;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.util.*;
import java.lang.String;
import javax.swing.*;

public class test {
	 public static void main(String[] args)throws Exception{
		    String temp=null;

	   	 
		    System.out.println("-c:返回文件的字符数");
		    System.out.println("-w:返回文件的词数");
		    System.out.println("-l:返回文件的行数");
		    System.out.println("-a:返回文件的空行、注释行、代码行");
		    System.out.println("-x:图形界面");
		    
		    while(true) {
		    	Scanner scanner =new Scanner(System.in);
		    	//scanner类用来获取用户输入
		    	System.out.println("请输入文件名：");
		    	
				File file=new File(scanner.nextLine());
				//String str1=scanner.next();
				//scanner.nextline 可以扫描一行字符内容并作为一个字符串获取！
		    	if(file.getName().equals("-x")) {
		    		 gui0 gui00=new gui0();
		    	}
		    	else {
		    	    	if(file.exists()==false)
		    		 		{
		    		 			System.out.println("文件不存在");
		    		
		    		 		}
		    	    	else {
//		    	if(file.canRead()==false)
//		    		 		{
//		    		 			System.out.println("文件不可读");
//		    		 			break;
//		    		 		}	
//		    	
		    
		    		//}
	    //读入文件
		    	 Scanner scanner2=new Scanner(System.in);
		     	 System.out.println("请输入要执行的操作：");
		    	 String string=new String(scanner2.nextLine());
		    	 String[] strings=string.split(" "); 
		    
		    	 wc wc1=new wc(file);
		    	 //将"要执行的操作"以字符串的形式输入并用空格隔开，以空格分割成字符串数组
		    	 int len=strings.length;
		    	 for (int i=0;i<len;i++) {
		    		 if(strings[i].equals("-c")) {
		    			 System.out.println("字符数："+wc1.chars);
		    		 }
		    		 
		    		 if(strings[i].equals("-w")) {
		    			 System.out.println("单词数目："+wc1.words);
		    		 }
		    		 if(strings[i].equals("-l")) {
		    			 System.out.println("行数："+wc1.rows);
		    		 }
		    		 if(strings[i].equals("-a")) {
		    			 System.out.println("空行："+wc1.nulline);
		    			 System.out.println("代码行："+wc1.codeline);
		    			 System.out.println("注释行："+wc1.noteline);
		    		 }
		    		 
		    		
		    	 }
		    	}
		    }
	 }
	 }	 
}
