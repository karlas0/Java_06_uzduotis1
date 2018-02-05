package com.company;

import java.util.Scanner;

public class Dot {
    Scanner sc = new Scanner(System.in);
    public double x = 0;
    public double y = 0;
    public String spalva;

    public Dot() {

    }

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Dot(double x, double y, String spalva) {
        this.x = x;
        this.y = y;
        this.spalva = spalva;
    }

    public Dot(String spalva) {
        this.spalva = spalva;
    }


    public double getDistance(Dot taskas) {
        double result = 0;
        //cia det formules skaiciavimui
        //c=Kvadratine saknis is ((x2-x1)^2 + (y2-y1)^2)
        result = Math.sqrt(Math.pow(this.x - taskas.x, 2) + Math.pow(this.y - taskas.y, 2));
        return result;
    }

    public int getQuarter() {
        int result = -1;
        //cia deti furmules skaiciavima
        if (this.x >= 0 && this.y >= 0) {
            result = 0;
        }
        if (this.x > 0 && this.y < 0) {
            result = 1;
        }
        if (this.x < 0 && this.y < 0) {
            result = 2;
        }
        if (this.x < 0 && this.y >= 0) {
            result = 3;
        }

        return result;
    }

    public boolean isSameQuarter(Dot taskas) {
        boolean result = false;
        result = this.getQuarter()==taskas.getQuarter();
        //cia deti logika
        return result;
    }

    public String toString() {
        return "Spalva: " + this.spalva + " x: " + this.x + " y: " + this.y;
    }

    public boolean equals(Dot taskas) {
        boolean result = this.getQuarter() == taskas.getQuarter();
        if (this.x != taskas.x) {
            result = false;
        }
        if (this.y != taskas.y) {
            result = false;
        }
        if (this.spalva.equals(taskas.spalva)) {
            result = false;
        }

        return result;
    }
}


