 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pitypang;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
            //szerintem ez fontos:
            okos.close();
            System.out.println("---MÁSODIK FELADAT---");
            Integer maxEjszakak=+0;
            Integer sorszam=0;
            for (int i = 0; i < 984; i++) {
                if ((darabolt[3][i]-darabolt[2][i])>maxEjszakak) {
                    maxEjszakak=(darabolt[3][i]-darabolt[2][i]);
                    sorszam=darabolt[0][i];
                }
            }
            System.out.println(nevek[sorszam-1]+" ("+darabolt[2][sorszam-1]+") - "+maxEjszakak);
            
            System.out.println("---HARMADIK FELADAT---");
            FileWriter butaIro= new FileWriter("bevetel.txt");
            PrintWriter okosIro= new PrintWriter(butaIro);
            Integer osszeg;
            Integer ejszakaszam= 0;
            Integer szemelyek= 0;
            //darabolt.length=6 hogy lehet másképp megadni?
            for (int i = 0; i < 984; i++) {
                
                osszeg=0;
                ejszakaszam=(darabolt[3][i]-darabolt[2][i]);
                szemelyek=darabolt[4][i];
                
                if (darabolt[2][i]<121) {
                    osszeg=ejszakaszam*9000;
                    if (darabolt[4][i]>2) {
                        osszeg=osszeg+(2000*ejszakaszam);
                    }
                    if (darabolt[5][i]==1) {
                        osszeg=osszeg+(szemelyek*ejszakaszam*1100);
                    }
                }
                if (darabolt[2][i]>=121) {
                    osszeg=ejszakaszam*10000;
                    if (darabolt[4][i]>2) {
                        osszeg=osszeg+(2000*ejszakaszam);
                    }
                    if (darabolt[5][i]==1) {
                        osszeg=osszeg+(szemelyek*ejszakaszam*1100);
                    }
                }
                if (darabolt[2][i]>=244) {
                    osszeg=ejszakaszam*8000;
                    if (darabolt[4][i]>2) {
                        osszeg=osszeg+(2000*ejszakaszam);
                    }
                    if (darabolt[5][i]==1) {
                        osszeg=osszeg+(szemelyek*ejszakaszam*1100);
                    }
                }
                okosIro.println(darabolt[0][i]+":"+osszeg);
            }
            okosIro.close();
            
            System.out.println("---NEGYEDIK FELADAT---");
            
        } catch (FileNotFoundException ex) {
            System.out.println("Hiba a file-nál!");
        } catch (IOException ex) {
            System.out.println("Kiolvasásnál a hiba!");
        }
        
    }
    
}
