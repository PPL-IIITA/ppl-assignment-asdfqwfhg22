/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ankita
 */
public class boy {
	String name;
        String type;
	int gf;
	int commit = 0;
        int iq;
	int looks;
	int min_looks_cutoff;
	int budget;

    public boy(String name, int iq, int looks, int min_looks_cutoff, int budget,String type) {
        this.name = name;
        //this.gf = gf;
        //this.status = status;
        this.iq = iq;
        this.looks = looks;
        this.min_looks_cutoff = min_looks_cutoff;
        this.budget = budget;
        this.type = type;
    }
	
	int choose(int kharcha,int face){
		if (this.budget >= kharcha && this.min_looks_cutoff <= face){
			return 1;
		}else
			return 0;
		}
	}
