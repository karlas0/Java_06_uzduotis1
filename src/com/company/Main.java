package com.company;

public class Main {

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
        System.out.println("atstumas tarp tasko 1 ir 3 "+ taskas1.getDistance(taskas3));
        System.out.println("ar taspats ketvirtis tasko 1 ir 3 "+ taskas1.isSameQuarter(taskas3));
        System.out.println("ar taspats ketvirtis tasko 1 ir 2 "+ taskas1.isSameQuarter(taskas2));

        Dot taskas4 = new Dot(10,10,"raudona");
        System.out.println("ar vienodi taskai 2 ir 4 "+taskas4.equals(taskas2));
    }
}
