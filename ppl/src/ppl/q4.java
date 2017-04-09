/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import static ppl.q3.happycoup;

/**
 *
 * @author Ankita
 */
public class q4 extends q3{
    public static void breakup(int k){
        int i;
        for(i=happycoup.size();i>happycoup.size()-k;i--)
        {
            happycoup.get(i).commit=0;
            happycoup.get(i).bf.commit=0;
        }
    }
    public static void update(){
        int i;
        int j;
        for(i=0;i<happycoup.size();i++){
            for(j=0;j<g.size();j++)
            {
                if(happycoup.get(i).equals(g.get(j)))
                {
                    g.get(i).commit=happycoup.get(i).commit;
                    g.get(i).bf=happycoup.get(i).bf;
                    g.get(i).bf.commit=happycoup.get(i).bf.commit;
                }
            }
        }
    }
    public static void commitThem2() throws IOException{
        int i,j;
		i=0;
		j=0;
                FileWriter x = new FileWriter("commitment_log.txt");
		 for(j=0;j<g.size();j++){
                        for(i=0;i<b.size()&&(g.get(j).commit==0);i++){ 
                        if(b.get(i).equals(g.get(i).bf))
                                continue;
                            if((b.get(i).commit==0)&&g.get(j).commit==0){
                            if((b.get(i).budget>=g.get(j).kharcha)&&(g.get(j).face>=b.get(i).min_looks_cutoff)){
                                    b.get(i).commit = 1;
                                    g.get(j).commit = 1;
                                    b.get(i).gf = g.get(j);
                                    g.get(j).bf = b.get(i);
                                    c++;
                                    DateFormat df = new SimpleDateFormat("HH:mm:ss");
                                    Date ob = new Date();
                                    
                                    x.write(b.get(i).name+" got committed to "+g.get(j).name+"in"+df.format(ob)+'\r'+'\n');
                                }
                            }
                        }
                 }
                 x.close();
        }
    public static void main(String[] args) throws IOException {
        guy();
        girl();
        commitThem();  //boys and girls get committed 
        readGifts();   //function to read gifts
        sort();         
        exchange();    //gifts are presented
        calcHappiness();//happiness is examined 
        int k; 
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a number: ");
        k = reader.nextInt(); // Scans the next token of the input as an int.
        if(k>happycoup.size())
        {
            k=happycoup.size();
        }
        breakup(k); //k least happy couples are broken up
        update();//list is updated 
        commitThem2(); //the new couples are formed
        int i;
        for(i=0;i<g.size();i++){
            if(g.get(i).commit==1){
                System.out.println(g.get(i).name+ " -> "+g.get(i).bf.name);
            }
        }
    }
}
