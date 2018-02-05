package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    private static final char SEPARATOR = '|';
    private static final String SEPARATOR_REGEX = "\\|";
    private static final char NEW_LINE = '\n';

    private String _failoVardas = "duomenys.txt";
    private FileReader _in;
    private BufferedReader _bufferis;
    private Scanner _sc;
    private FileWriter _out;


    public static void main(String[] args) {
        // write your code here
        Dot taskas1;
        Dot taskas2;
        Dot taskas3;

        taskas1 = new Dot(3, 4);
        taskas2 = new Dot(-10, 10, "raudona");
        taskas3 = new Dot("melyna");

        System.out.println(taskas1);
        System.out.println(taskas2);
        System.out.println(taskas3);
        System.out.println("atstumas tarp tasko 1 ir 3 " + taskas1.getDistance(taskas3));
        System.out.println("ar taspats ketvirtis tasko 1 ir 3 " + taskas1.isSameQuarter(taskas3));
        System.out.println("ar taspats ketvirtis tasko 1 ir 2 " + taskas1.isSameQuarter(taskas2));

        Dot taskas4 = new Dot(10, 10, "raudona");
        System.out.println("ar vienodi taskai 2 ir 4 " + taskas4.equals(taskas2));

        //tekstiniame faile yra informacija tokiu formatu
        //x|y| spalva bent 10 eiluciu
        //nustatyti visus taskus i tasku masyva
        //rasti didziausia atstuma tarp dvieju tasku
        //atspausdinti abu taskus i ekrana
        //masyvas[i] = new Dot (Doub;e.parseDouble(zodziai[0], Double.parseDouble(zodziai[1]), zodziai[2]);
        Main objektas = new Main();
        objektas.skaitymasIsFailo();
    }

    //atidaryti faila nuskaitymui
    public void atidarytiFaila() {
        try {
            _in = new FileReader(_failoVardas);
            _bufferis = new BufferedReader(_in);
        } catch (Exception e) {

        }
    }

    //skaityti faila
    public void skaitymasIsFailo() {
        atidarytiFaila();
        int eiluciuKiekis = gaukFailoEiluciuKieki();
        atidarytiFaila();
        Dot[] masyvas = new Dot[eiluciuKiekis];
        try {
            String eilute = _bufferis.readLine();
            int i = 0;
            while (eilute != null) {
                String[] zodziai = eilute.split(SEPARATOR_REGEX);
                masyvas[i] = new Dot(Double.parseDouble(zodziai[0]), Double.parseDouble(zodziai[1]), zodziai[2]);
                i++;
                eilute = _bufferis.readLine();
            }
            _bufferis.close();
            _in.close();
            skaiciavimas(masyvas);
        } catch (Exception e) {

        }
    }

    private int gaukFailoEiluciuKieki() {
        atidarytiFaila();
        int rezultatas = 0;
        try {
            String eilute = _bufferis.readLine();
            while (eilute != null) {
                rezultatas++;
                eilute = _bufferis.readLine();
            }
            _bufferis.close();
            _in.close();
        } catch (Exception e) {

        }
        return rezultatas;
    }

    public void skaiciavimas(Dot[] masyvas) {
        double atstumas = 0;
        Dot pirmas=null;
        Dot antras=null;
        for (int i = 0; i < masyvas.length - 1; i++) {

            for (int j = 1; j < masyvas.length; j++) {
                if (masyvas[i].getDistance(masyvas[j])>atstumas){
                    atstumas=masyvas[i].getDistance(masyvas[j]);
                    pirmas = masyvas[i];
                    antras = masyvas[j];
                }
            }
        }
        System.out.println("dydziausias atstumas: "+ atstumas);
        System.out.println(pirmas);
        System.out.println(antras);
    }


//sukelti eilutes i masyva
//pereiti per masyva
//rasti atstuma tarp 2 tasku
}
