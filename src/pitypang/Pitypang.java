/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pitypang;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gergely.vajda
 */
public class Pitypang {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FileReader buta= new FileReader("pitypang.txt");
            BufferedReader okos= new BufferedReader(buta);
            String osszes;
            osszes= okos.readLine();
            int sorokSzama= Integer.parseInt(osszes); 
            Integer[][] darabolt= new Integer[6][sorokSzama];
            String[] nevek= new String[sorokSzama];
            String[] ideiglenes= new String[7];
            for (int i = 0; i < 1000; i++) {
                osszes= okos.readLine();
                if (osszes==null) {
                    break;
                }
                //System.out.println(osszes);
                ideiglenes= osszes.split(" ");
                darabolt[0][i]= Integer.parseInt(ideiglenes[0]);
                darabolt[1][i]= Integer.parseInt(ideiglenes[1]);
                darabolt[2][i]= Integer.parseInt(ideiglenes[2]);
                darabolt[3][i]= Integer.parseInt(ideiglenes[3]);
                darabolt[4][i]= Integer.parseInt(ideiglenes[4]);
                darabolt[5][i]= Integer.parseInt(ideiglenes[5]);
                nevek[i]= ideiglenes[6];
            }
            System.out.println("---MÁSODIK FELADAT---");
            Integer maxEjszakak=+0;
            Integer sorszam=0;
            for (int i = 0; i < darabolt.length; i++) {
                if ((darabolt[3][i]-darabolt[2][i])>maxEjszakak) {
                    maxEjszakak=(darabolt[3][i]-darabolt[2][i]);
                    sorszam=darabolt[0][i];
                }
            }
            System.out.println(nevek[sorszam-1]+" ("+darabolt[2][sorszam-1]+") - "+maxEjszakak);
            
             
            
        } catch (FileNotFoundException ex) {
            System.out.println("Hiba a file-nál!");
        } catch (IOException ex) {
            System.out.println("Kiolvasásnál a hiba!");
        }
        
    }
    
}
