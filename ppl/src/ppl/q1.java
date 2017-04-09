/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ankita
 */
package ppl;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class q1{
	static ArrayList<boy> b=new ArrayList<boy>();
        static ArrayList<girl> g = new ArrayList<girl>();
        static int c = 0;
        public static void guy() throws IOException{
            File file = new File("boy.csv");
            List<String> lines = Files.readAllLines(file.toPath(), 
            StandardCharsets.UTF_8);
            for (String line : lines) {
                    
                    String[] array = line.split(",");
                    String name = array[0];
                    int iq = Integer.parseInt(array[1]);
                    int looks = Integer.parseInt(array[2]);
                    int min = Integer.parseInt(array[3]);
                    int budget = Integer.parseInt(array[4]);
                    String type = array[5];
                    boy bb = new boy(name,iq,looks,min,budget,type);
                    b.add(bb);
                    
        }
        }
        public static void girl() throws IOException{
            File file = new File("girl.csv");
            List<String> lines = Files.readAllLines(file.toPath(), 
            StandardCharsets.UTF_8);
            for (String line : lines) {
                    
                    String[] array = line.split(",");
                    String name = array[0];
                    int face = Integer.parseInt(array[1]);
                    int kharcha = Integer.parseInt(array[2]);
                    int iq = Integer.parseInt(array[3]);
                    String type = array[4];
                    girl gg = new girl(name,face,kharcha,iq,type);
                    g.add(gg);
                    
        }
        }
        public static void commitThem() throws IOException{
        int i,j;
		i=0;
		j=0;
                FileWriter x = new FileWriter("commitment_log.txt");
		 for(j=0;j<g.size();j++){
                        for(i=0;i<b.size()&&(g.get(j).commit==0);i++){ 
                        
                            if((b.get(i).commit==0)&&g.get(j).commit==0){
                                //System.out.println("k");
                            if((b.get(i).budget>=g.get(j).kharcha)&&(g.get(j).face>=b.get(i).min_looks_cutoff)){
                                    b.get(i).commit = 1;
                                    g.get(j).commit = 1;
                                    b.get(i).gf = g.get(j);
                                    g.get(j).bf = b.get(i);
                                    c++;
                                    DateFormat df = new SimpleDateFormat("HH:mm:ss");
                                    Date ob = new Date();
                                    
                                    x.write(b.get(i).name+" got committed to "+g.get(j).name+"@"+df.format(ob)+'\r'+'\n');
                                }
                            }
                        }
                 }
                 x.close();
        }
	public static void main(String args[]) throws IOException{
	
               guy();
               girl();
               commitThem();
               int i,j;
               for(i=0;i<g.size();i++){
                   if(g.get(i).commit ==1)
                    System.out.println(g.get(i).name+" "+g.get(i).bf.name);
               }
	}
	
}