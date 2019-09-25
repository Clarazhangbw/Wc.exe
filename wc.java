package clara.wc;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.util.*;
import java.lang.String;
import javax.swing.*;

public class wc {


    	 int a;
    	 int word=0;
    	 int lian=0;
    	 int chars=0;
    	 int words=0;
    	 int rows=0;
    	 String s="";
    	 BufferedReader reader=null;
         String cstring,b=null;
    	 int line=0;
    	 int nulline=0;
    	 int codeline=0;
    	 int noteline=0;
    	 boolean note=false;
    	 BufferedReader br=null;
    	 
    	 public wc(File file)throws Exception{

	    	 FileReader fr=null;
	     	 try {
	     		 fr=new FileReader(file);
	     	 }catch(FileNotFoundException e) {
	     		 e.printStackTrace();
	     	 }
	     	 
    	     try {
    		 while((a=fr.read())!=-1) {
    			 if((a>='A'&&a<='Z')||(a>='a'&&a<='z')) {
    				 lian++;
    			 }
    			 if(lian>=2&&word==0){
    				 words++;
    				 lian=0;
    				 word++;
    			 }
    			 if(!(a!=' ')) {
    				 word=0;
    			 }
    			 if(lian<2&&(!((a>='A'&&a<='Z')||(a>='a'&&a<='z')))) {
    				 lian=0;
    			 }
                 if(a!=' '&&a!='\n') {
                	 chars++;
          
                 }
    		 }//如果用这个来算行数的话，如果我最后没按回车键会少一行
    	 }catch(IOException e) {
    		 e.printStackTrace();
    	 }
    	 
         
         try  {
        	 br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        	 while((s=br.readLine())!=null)
        	 {
        		 rows++;
        	 }
         }catch(FileNotFoundException e) {
        	 e.printStackTrace();
         }finally {
        	 br.close();
         }
         

         try {
        	 reader=new BufferedReader(new FileReader(file));
        
        	 
        	 while((cstring=reader.readLine())!=null) {
        		line++;
        		if(cstring.length()==0) {
        				 nulline++;
        			 }
        		cstring=cstring.trim();
        		if(cstring.startsWith("/*")&&!cstring.endsWith("*/")){
        			noteline++;
        			note=true;
        		}else if(note) {
        			noteline++;
        			if(cstring.endsWith("*/")) {
        				note=false;
        			}
        		}else if(cstring.startsWith("/*")&&cstring.endsWith("/*")) {
        			noteline++;
        		}else if(cstring.startsWith("//")) {
        			noteline++;
        		}
        		codeline=line-nulline-noteline;
        	 }
         }catch(IOException e) {
        	 e.printStackTrace();
         }finally {
        	 reader.close();
         }
         
    	 }
    	
    	
    	 }
 