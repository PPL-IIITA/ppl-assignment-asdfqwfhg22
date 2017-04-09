/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;

import static java.lang.Math.exp;
import static java.lang.Math.log;
import java.util.ArrayList;

/**
 *
 * @author Ankita
 */
public class girl {
    String name;
    boy bf;
    int commit = 0;
    int face;
    int kharcha;
    int iq;
    String type;
    double happinessLevel;
    ArrayList<gift> gifting = new ArrayList<>();


    public girl(String name, int face, int kharcha, int iq,String type) {
        this.name = name;
        //this.bf = bf;
        //this.status = status;
        this.face = face;
        this.kharcha = kharcha;
        this.iq = iq;
        this.type = type;
}
    
   int choose(int budget){
	if (this.kharcha <= budget) {
		return 1;
		}
	else {
		return 0;
            }
        }
   public void setHappiness()
   {
        happinessLevel = 0;
       int i,sum = 0;
       if("Choosy".equals(type))
       {
           for(i=0;i<gifting.size();i++)
        {
            if(gifting.get(i).type.equalsIgnoreCase("Luxury"))
                sum += 2*(gifting.get(i).price);
            else
                sum+=gifting.get(i).price;
        }
        happinessLevel = log(sum);
       }
       else if("Desparate".equals(type))
       {
        for(i=0;i<gifting.size();i++)
        {
            sum += gifting.get(i).price;
        }
         happinessLevel = exp(sum);
       }
       else if("Normal".equals(type))
       {
           for(i=0;i<gifting.size();i++)
        {
            sum += (gifting.get(i).price + gifting.get(i).value);
        }
        happinessLevel = sum;
       }
   }
}
