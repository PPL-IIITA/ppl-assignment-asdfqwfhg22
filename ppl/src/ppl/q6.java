/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

import java.util.Scanner;
import static ppl.q3.happycoup;

/**
 *
 * @author Ankita
 */
public class q6 extends q4{

    /**
     *
     * @param i
     */
    public static void breakup2(int i){  //to break couples up
        happycoup.get(i).commit=0;
        happycoup.get(i).bf.commit=0;
    }
    public static void main(){
        int t; //t days
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter number of days: ");
        t = reader.nextInt(); // Scans the next token of the input as an int.
        int temp,i;
        temp=t;
        calcHappiness(); //happiness calculated 
        for(i=0;i<happycoup.size();i++){
        while(temp<=30)
        {
            if(happycoup.get(i).happinessLevel+happycoup.get(i).bf.happinessLevel<t)
                breakup2(i); //unhappy couples are broken up
                temp+=t;
        }
        }
        for(i=0;i<happycoup.size();i++)
        {
            System.out.println(happycoup.get(i).name+" "+happycoup.get(i).bf.name); //prints happy couples' names
        }
    }
}
