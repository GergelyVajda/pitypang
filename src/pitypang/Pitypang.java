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
import java.util.Scanner;
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
            FileReader buta = new FileReader("pitypang.txt");
            BufferedReader okos = new BufferedReader(buta);
            String osszes;
            osszes = okos.readLine();
            int sorokSzama = Integer.parseInt(osszes);
            Integer[][] darabolt = new Integer[6][sorokSzama];
            String[] nevek = new String[sorokSzama];
            String[] ideiglenes = new String[7];
            for (int i = 0; i < 1000; i++) {
                osszes = okos.readLine();
                if (osszes == null) {
                    break;
                }
                //System.out.println(osszes);
                ideiglenes = osszes.split(" ");
                darabolt[0][i] = Integer.parseInt(ideiglenes[0]);
                darabolt[1][i] = Integer.parseInt(ideiglenes[1]);
                darabolt[2][i] = Integer.parseInt(ideiglenes[2]);
                darabolt[3][i] = Integer.parseInt(ideiglenes[3]);
                darabolt[4][i] = Integer.parseInt(ideiglenes[4]);
                darabolt[5][i] = Integer.parseInt(ideiglenes[5]);
                nevek[i] = ideiglenes[6];
            }
            //szerintem ez fontos:
            okos.close();
            System.out.println("---MÁSODIK FELADAT---");
            Integer maxEjszakak = +0;
            Integer sorszam = 0;
            for (int i = 0; i < 984; i++) {
                if ((darabolt[3][i] - darabolt[2][i]) > maxEjszakak) {
                    maxEjszakak = (darabolt[3][i] - darabolt[2][i]);
                    sorszam = darabolt[0][i];
                }
            }
            System.out.println(nevek[sorszam - 1] + " (" + darabolt[2][sorszam - 1] + ") - " + maxEjszakak);

            System.out.println("---HARMADIK FELADAT---");
            FileWriter butaIro = new FileWriter("bevetel.txt");
            PrintWriter okosIro = new PrintWriter(butaIro);
            Integer osszeg;
            Integer teljesBevetel = 0;
            Integer ejszakaszam = 0;
            Integer szemelyek = 0;
            //darabolt.length=6 hogy lehet másképp megadni?
            for (int i = 0; i < 984; i++) {

                osszeg = 0;
                ejszakaszam = (darabolt[3][i] - darabolt[2][i]);
                szemelyek = darabolt[4][i];

                if (darabolt[2][i] < 121) {
                    osszeg = ejszakaszam * 9000;
                    if (darabolt[4][i] > 2) {
                        osszeg = osszeg + (2000 * ejszakaszam);
                    }
                    if (darabolt[5][i] == 1) {
                        osszeg = osszeg + (szemelyek * ejszakaszam * 1100);
                    }
                }
                if (darabolt[2][i] >= 121) {
                    osszeg = ejszakaszam * 10000;
                    if (darabolt[4][i] > 2) {
                        osszeg = osszeg + (2000 * ejszakaszam);
                    }
                    if (darabolt[5][i] == 1) {
                        osszeg = osszeg + (szemelyek * ejszakaszam * 1100);
                    }
                }
                if (darabolt[2][i] >= 244) {
                    osszeg = ejszakaszam * 8000;
                    if (darabolt[4][i] > 2) {
                        osszeg = osszeg + (2000 * ejszakaszam);
                    }
                    if (darabolt[5][i] == 1) {
                        osszeg = osszeg + (szemelyek * ejszakaszam * 1100);
                    }
                }
                teljesBevetel = teljesBevetel + osszeg;
                okosIro.println(darabolt[0][i] + ":" + osszeg);
            }
            okosIro.close();
            System.out.println("A szálloda teljes évi bevétele " + teljesBevetel + " Ft.");

            System.out.println("---NEGYEDIK FELADAT---");
            //a hónapok sorszáma 1-31, 2-59, 3-90, 4-120, 5-151, 6-181, 7-212, 8-243, 9-273, 10-304, 11-334, 12-365
            Integer jan = 0;
            Integer feb = 0;
            Integer mar = 0;
            Integer apr = 0;
            Integer maj = 0;
            Integer jun = 0;
            Integer jul = 0;
            Integer aug = 0;
            Integer sep = 0;
            Integer okt = 0;
            Integer nov = 0;
            Integer dec = 0;

            for (int i = 0; i < 984; i++) {
                ejszakaszam = (darabolt[3][i] - darabolt[2][i]);
                szemelyek = darabolt[4][i];
                for (int j = 0; j < ejszakaszam; j++) {
                    if (darabolt[3][i] - ejszakaszam <= 31) {
                        jan = jan + szemelyek;
                    }
                    if (darabolt[3][i] - ejszakaszam >= 32 && darabolt[3][i] - ejszakaszam <= 59) {
                        feb = feb + szemelyek;
                    }
                    if (darabolt[3][i] - ejszakaszam >= 60 && darabolt[3][i] - ejszakaszam <= 90) {
                        mar = mar + szemelyek;
                    }
                    if (darabolt[3][i] - ejszakaszam >= 91 && darabolt[3][i] - ejszakaszam <= 120) {
                        apr = apr + szemelyek;
                    }
                    if (darabolt[3][i] - ejszakaszam >= 121 && darabolt[3][i] - ejszakaszam <= 151) {
                        maj = maj + szemelyek;
                    }
                    if (darabolt[3][i] - ejszakaszam >= 152 && darabolt[3][i] - ejszakaszam <= 181) {
                        jun = jun + szemelyek;
                    }
                    if (darabolt[3][i] - ejszakaszam >= 182 && darabolt[3][i] - ejszakaszam <= 212) {
                        jul = jul + szemelyek;
                    }
                    if (darabolt[3][i] - ejszakaszam >= 213 && darabolt[3][i] - ejszakaszam <= 243) {
                        aug = aug + szemelyek;
                    }
                    if (darabolt[3][i] - ejszakaszam >= 244 && darabolt[3][i] - ejszakaszam <= 273) {
                        sep = sep + szemelyek;
                    }
                    if (darabolt[3][i] - ejszakaszam >= 274 && darabolt[3][i] - ejszakaszam <= 304) {
                        okt = okt + szemelyek;
                    }
                    if (darabolt[3][i] - ejszakaszam >= 305 && darabolt[3][i] - ejszakaszam <= 334) {
                        nov = nov + szemelyek;
                    }
                    if (darabolt[3][i] - ejszakaszam >= 335 && darabolt[3][i] - ejszakaszam <= 365) {
                        dec = dec + szemelyek;
                    }
                    ejszakaszam--;
                }

            }
            System.out.println("1:" + jan);
            System.out.println("2:" + feb);
            System.out.println("3:" + mar);
            System.out.println("4:" + apr);
            System.out.println("5:" + maj);
            System.out.println("6:" + jun);
            System.out.println("7:" + jul);
            System.out.println("8:" + aug);
            System.out.println("9:" + sep);
            System.out.println("10:" + okt);
            System.out.println("11:" + nov);
            System.out.println("12:" + dec);

            System.out.println("---ÖTÖDIK FELADAT---");
            Scanner sc = new Scanner(System.in);
            System.out.println("Kérem adja meg az új foglalás kezdő napjának sorszámát (1-365)!");
            Integer kezdoNap = sc.nextInt();
            System.out.println("Kérem adja meg az eltöltendő éjszakák számát!");
            ejszakaszam = sc.nextInt();
            
            Integer[] szabad = new Integer[ejszakaszam];
            
            //feltöltöm 0-val a null helyett
            for (int i = 0; i < ejszakaszam; i++) {
                szabad[i]=0;
            }
            
            for (int i = 0; i < ejszakaszam; i++) {
                
                for (int j = 0; j < 984; j++) {
                    if (darabolt[2][j] == kezdoNap) {
                        szabad[i]++;
                    }
                }
                kezdoNap++;
            }
            //megnézem hogy melyik a legkisebb
            Integer legkisebb=27;
            for (int i = 0; i < ejszakaszam; i++) {
                if (szabad[i]<legkisebb) {
                    legkisebb=szabad[i];
                }
            }
            System.out.println("A megadoatt időszak teljes időtartamában "+legkisebb+" db. szoba szabad.");

        } catch (FileNotFoundException ex) {
            System.out.println("Hiba a file-nál!");
        } catch (IOException ex) {
            System.out.println("Kiolvasásnál a hiba!");
        }

    }

}
