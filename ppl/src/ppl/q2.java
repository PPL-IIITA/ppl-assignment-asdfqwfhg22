package ppl;

import java.io.File;
import java.io.IOException;
import static java.lang.Math.abs;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import static ppl.q1.b;
import java.util.Scanner; 
import static ppl.q1.girl;

public class q2{
    static ArrayList<gift> present=new ArrayList<gift>();
    static ArrayList<girl> compList=new ArrayList<girl>();
    static ArrayList<girl> happycoup = new ArrayList<girl>();
    public static void readGifts() throws IOException{
        File file = new File("gift.csv");
            List<String> lines = Files.readAllLines(file.toPath(), 
            StandardCharsets.UTF_8);
            for (String line : lines) {
                    
                    String[] array = line.split(",");
                    String type = array[0];
                    int price = Integer.parseInt(array[1]);
                    int value = Integer.parseInt(array[2]);
                    present.add(new gift(type,price, value));
            
    }
    }
    public static void sort(){
        int i;
        int j;
        for(i=0;i<present.size();i++)
            for(j=0;j<present.size()-1-i;j++){
                if(present.get(j).price<present.get(j+1).price){
                    gift temp = present.get(j);
                    present.remove(j) ;
                    present.add(j,present.get(j+1));
                    present.remove(j+1);
                    present.add(j+1,temp);
                }
            }
    }
    public static void exchange(){
        int i;
        for(i=0;i<q1.g.size();i++){
            if((q1.g.get(i).commit==1)){
                q1.g.get(i).bf.giftit(q1.g.get(i), present);
            }
        }
    }
    public static void calcHappiness()
    {
        int i;
                for(i=0;i<q1.g.size();i++){
            if((q1.g.get(i).commit==1)){
                q1.g.get(i).setHappiness();
                q1.g.get(i).bf.setHappiness();
            }
                }
            int j;
            for(i=0;i<q1.g.size();i++){
                if(q1.g.get(i).commit==1){
                    happycoup.add(q1.g.get(i));
                }
            }
            for(i=0;i<happycoup.size();i++){
            for(j=0;j<happycoup.size()-1-i;j++){
                
                if(happycoup.get(j).happinessLevel+happycoup.get(j).bf.happinessLevel>happycoup.get(j+1).happinessLevel+happycoup.get(j+1).bf.happinessLevel){
                    girl temp = happycoup.get(j);
                    happycoup.remove(j) ;
                    happycoup.add(j,happycoup.get(j+1));
                    happycoup.remove(j+1);
                    happycoup.add(j+1,temp);
                }
            }
            
    }
                
    }
    
    public static void compatibility()
    {
     int j,i;
            for(i=0;i<q1.g.size();i++){
                if(q1.g.get(i).commit==1){
                    compList.add(q1.g.get(i));
                }
            }
            for(i=0;i<compList.size();i++){
            for(j=0;j<compList.size()-1-i;j++){
                
                if(comp(compList.get(j))>comp(compList.get(j+1))){
                    girl temp = compList.get(j);
                    compList.remove(j) ;
                    compList.add(j,compList.get(j+1));
                    compList.remove(j+1);
                    compList.add(j+1,temp);
                }
            }}   
    }
    public static int comp(girl Girl){
            int att;
            att = Girl.face - Girl.bf.looks;
            int intel;
            intel = Girl.iq - Girl.bf.iq;
            int money;
            money = Girl.bf.budget - Girl.kharcha;
            int sum = abs(money)+abs(intel)+abs(att);
            return sum;
        }
    public static void main(String[] args) throws IOException {
        q1.guy();
        q1.girl();
        q1.commitThem();
        readGifts();
        sort();
        exchange();
        calcHappiness();
        compatibility();
        
        int i;
        int k;
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a number: ");
        k = reader.nextInt(); // Scans the next token of the input as an int.
        if(k>happycoup.size())
        {
            k=happycoup.size();
        }
        for(i=0;i<k;i++)
        {
            System.out.println(happycoup.get(i).name+" "+happycoup.get(i).bf.name); //prints happy couples' names
        }
        for(i=0;i<k;i++)
        {
            System.out.println(compList.get(i).name+" "+compList.get(i).bf.name); //prints happy couples' names
        }
    }
        
}