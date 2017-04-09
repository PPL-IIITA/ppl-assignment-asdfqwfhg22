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
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import static ppl.q1.commitThem;
import static ppl.q1.girl;
import static ppl.q1.guy;
import static ppl.q3.calcHappiness;
import static ppl.q3.exchange;
import static ppl.q3.happycoup;
import static ppl.q3.readGifts;
import static ppl.q3.sort;

/**
 *
 * @author Ankita
 */
public class q5 extends q3{
    static ArrayList<girl> girls = new ArrayList<girl>();
    static ArrayList<boy> boys = new ArrayList<boy>();

    public static void sort2()  ////boys and girls are sorted according to maintaenaence and attractiveness
    {
        int i,j;
        for(i=0;i<girls.size();i++){
            for(j=0;j<girls.size()-1-i;j++){
                
                if(girls.get(j).kharcha>girls.get(j+1).kharcha){
                    girl temp = girls.get(j);
                    girls.remove(j) ;
                    girls.add(j,girls.get(j+1));
                    girls.remove(j+1);
                    girls.add(j+1,temp);
                }
            }
    }
        for(i=0;i<boys.size();i++){
            for(j=0;j<boys.size()-1-i;j++){
                
                if(boys.get(j).looks>boys.get(j+1).looks){
                    boy temp = boys.get(j);
                    boys.remove(j) ;
                    boys.add(j,boys.get(j+1));
                    boys.remove(j+1);
                    boys.add(j+1,temp);
                }
            }
        }
    }

    /**
     *
     * @throws IOException
     */
    public static void commitThem3() throws IOException{
        int i,j,k,turn;
        turn=0;
		i=0;
		j=0;
                FileWriter x = new FileWriter("commitment_log.txt");
		while(j<g.size()&&i<b.size()) {  //commits girls and boys one by one
                if(turn==0){
                    if(g.get(j).commit==1)
                    {
                        j++;
                        continue;
                    }
                        for(k=0;k<b.size()&&(g.get(j).commit==0);k++){ 
                            if((b.get(k).commit==0)&&g.get(j).commit==0){
                            if((b.get(k).budget>=g.get(j).kharcha)&&(g.get(j).face>=b.get(k).min_looks_cutoff)){
                                    b.get(k).commit = 1;
                                    g.get(j).commit = 1;
                                    b.get(k).gf = g.get(j);
                                    g.get(j).bf = b.get(k);
                                    c++;
                                    DateFormat df = new SimpleDateFormat("HH:mm:ss");
                                    Date ob = new Date();
                                    x.write(b.get(k).name+" got committed to "+g.get(j).name+"@"+df.format(ob)+'\r'+'\n');
                                    j++;
                                    turn=1;
                                }
                            }
                        }
                 }
                else if(turn==1){
                    if(b.get(i).commit==1){
                        i++;
                        continue;
                    }
                    for(k=0;k<g.size()&&(b.get(i).commit==0);k++){ 
                        int maximum = -1; 
                        int a = -1,h;
                        for(h=0;h<g.size();h++){
                        if(b.get(i).budget<g.get(i).kharcha)
                            break;
                        if(g.get(h).commit==0){
                          if(maximum<g.get(h).face){
                            maximum = g.get(h).face;
                        a = k;
                   }
               }
           } 
                            if(a!=-1&&g.get(k).face>b.get(i).min_looks_cutoff){
                            if((g.get(k).commit==0)&&b.get(i).commit==0){
                                    b.get(i).commit = 1;
                                    g.get(k).commit = 1;
                                    g.get(k).bf = b.get(i);
                                    b.get(i).gf = g.get(k);
                                    c++;
                                    DateFormat df = new SimpleDateFormat("HH:mm:ss");
                                    Date ob = new Date();
                                    x.write(b.get(i).name+" got committed to "+g.get(k).name+"in"+df.format(ob)+'\r'+'\n');
                                    i++;
                                    turn=0;
                                }
                }
                    }
                }
                 x.close();
        }
    }
public static void main(String[] args) throws IOException {
        guy();
        girl();
        sort2(); //boys and girls are sorted according to maintaenaence and attractiveness
        commitThem3(); //commit couples according to specified  conditions 
        readGifts(); //function to read books
        exchange(); //give gifts to the girlfriends
        calcHappiness(); //calculate the couples' happiness
        int i,k;
        for(i=0;i<g.size();i++){
            if(g.get(i).commit==1){
                System.out.println(g.get(i).name+ " -> "+g.get(i).bf.name);
            }
        }
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter k: ");
        k = reader.nextInt(); // Scans the next token of the input as an int.
        if(k>happycoup.size())
        {
            k=happycoup.size(); //if k is larger than the actual number of couples then the number of couples is the value of k
        }
        for(i=0;i<k;i++)
        {
            System.out.println(happycoup.get(i).name+" "+happycoup.get(i).bf.name); //prints k happy couples' names
        }
    }
}

