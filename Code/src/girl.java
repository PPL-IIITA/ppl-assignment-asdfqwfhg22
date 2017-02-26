/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ankita
 */
public class girl {
    String name;
    int bf;
    int commit = 0;
    int face;
    int kharcha;
    int iq;
    String type;

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
}
