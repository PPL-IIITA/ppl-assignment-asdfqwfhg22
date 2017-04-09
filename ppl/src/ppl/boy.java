/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ankita
 */
public class boy {
        String name;
        String type;
	girl gf;
	int commit = 0; //relationship status of the boy
        int iq;//intelligence level of the boy
	int looks;//attractiveness of the boy
	int min_looks_cutoff;//the level of attractive girl the boy wants
	int budget;//boy's budget
        double happinessLevel;//how happy the boy is
        int expense;//how much the boy spends

    public boy(String name, int iq, int looks, int min_looks_cutoff, int budget,String type) {   //constructor 
        this.name = name;
        this.iq = iq;
        this.looks = looks;
        this.min_looks_cutoff = min_looks_cutoff;
        this.budget = budget;
        this.type = type;
}
    
    public void setHappiness() //sets the happiness level of the boy according to his type
    {
     if("Miser".equals(type))
            {
              happinessLevel = budget - expense; 
            }
     if("Geek".equals(type))
     {
         happinessLevel = gf.iq;
     }
     if("Generous".equals(type))
     {
         happinessLevel=gf.happinessLevel;
     }
    }
    public void giftit(girl g,ArrayList<gift> gift)
    {int j;
    int sum = 0;
    
     File out = new File("Gift.txt");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,false))) {
			//String content = b.get_Bname()+" is "+c+"happiest with "+b.get_GF().getGname();
                            bw.write("");
                            
                        } catch (IOException e) {
                            }
     if(type.equalsIgnoreCase("Miser")){
                        
                        for(j=0;j<gift.size();j++){
                            if(sum<g.kharcha){
                                sum+=gift.get(j).price;
                                if(sum>budget&&!(g.gifting.isEmpty())){
                                        budget = sum;
                                
                                
                            }
                               g.gifting.add(gift.get(j));
                               String line =name+" gifted  "+gift.get(j)+" -> "+g.name+" "+'\r'+'\n';
                               System.out.print(line);
                               try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,true))) {
                                bw.write(line);
                               // bw.newLine();
                            } catch (IOException e) {
                                }        
                                
                            }
                            
                            else
                                break;
                        }
                        
    }
           else if(type.equalsIgnoreCase("Generous")){
                for(j=0;j<gift.size();j++){
                            if(sum<budget){
                                 
                                sum+=gift.get(j).price;
                                if(sum>budget&&!(g.gifting.isEmpty())){
                                sum-=gift.get(j).price;
                                
                            }
                                else{
                                g.gifting.add(gift.get(j));
                                String line=name+" gifted "+gift.get(j)+" -> "+g.name+" "+'\r'+'\n';
                                System.out.print(line);
                                try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,true))) {
                                bw.write(line);
                                //bw.newLine();
                            } catch (IOException e) {
                                } 
                            }
                            }
                            else
                                break;
                        }
    }
    else if(type.equalsIgnoreCase("Geek")){
                        for(j=0;j<gift.size();j++){
                            if(sum<g.kharcha){
                                sum+=gift.get(j).price;
                                if(sum>budget&&!(g.gifting.isEmpty())){
                                budget=sum;
                                
                            }
                                
                                
                                    g.gifting.add(gift.get(j));
                                    String line =name+" gifted "+gift.get(j)+" -> "+g.name+" "+'\r'+'\n';
                                    System.out.print(line);
                                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,true))) {
                                    bw.write(line);
                                    //bw.newLine();
                                    } catch (IOException e) {
                                    } 
                                
                                
                            }
                           
                            else 
                                break;
                         }
               
                         
                        for(;j<gift.size();j++){
                            if(gift.get(j).type.equalsIgnoreCase("Luxury"))
                            {   sum+=gift.get(j).price;
                            if(sum<=budget){
                                g.gifting.add(gift.get(j));
                                String line =name+" gifted "+gift.get(j)+" -> "+g.name+" "+'\r'+'\n';
                                System.out.print(line);
                                try (BufferedWriter bw = new BufferedWriter(new FileWriter(out,true))) {
                                bw.write(line);
                                //bw.newLine();
                            } catch (IOException e) {
                                } 
                            
                                break;}
                            else
                                sum-=gift.get(j).price;}
                        } 
                    
    }
    }
}
