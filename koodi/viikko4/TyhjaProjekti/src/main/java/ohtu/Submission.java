package ohtu;

import java.util.ArrayList;

public class Submission {
    private String student_number;
    private int id;
    private String last_name;
    private String first_name;
    private int points;
    private int week;
    private int hours;
    private int pointsCalc=0;
    private int muuttuja;
    
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    
    ArrayList<Integer> exer = new ArrayList();
    ArrayList<Integer> exer2 = new ArrayList();

    public boolean getA1() {
        exer2.add(1);
        if(a1) {
            exer.add(1);
        }
        return a1;
    }

    public void setA1(boolean a1) {
        this.a1 = a1;
    }

    public boolean getA2() {
        exer2.add(2);
        if(a2) {
            exer.add(2);
        }
        return a2;
    }

    public void setA2(boolean a2) {
        this.a2 = a2;
    }

    public boolean getA3() {
        exer2.add(3);
        if(a3) {
            exer.add(3);
        }  
        return a3;
    }

    public void setA3(boolean a3) {
        this.a3 = a3;
    }

    public boolean getA4() {
        exer2.add(4);
         if(a4) {
            exer.add(4);
        }
        return a4;
    }

    public void setA4(boolean a4) {
        this.a4 = a4;
    }

    public boolean getA5() {
        exer2.add(5);
                if(a5) {
            exer.add(5);
        }
        return a5;
    }

    public void setA5(boolean a5) {
        this.a5 = a5;
    }

    public boolean getA6() {
        exer2.add(6);
              if(a6) {
            exer.add(6);
        }
        return a6;
    }

    public void setA6(boolean a6) {
        this.a6 = a6;
    }

    public boolean getA7() {
        exer2.add(7);
               if(a7) {
            exer.add(7);
        }
        return a7;
    }

    public void setA7(boolean a7) {
        this.a7 = a7;
    }

    public boolean getA8() {
        exer2.add(8);
                if(a8) {
            exer.add(8);
        }
        return a8;
    }

    public void setA8(boolean a8) {
        this.a8 = a8;
    }

    public boolean getA9() {
        exer2.add(9);
                if(a9) {
            exer.add(9);
        }
        return a9;
    }

    public void setA9(boolean a9) {
        this.a9 = a9;
    }

    public boolean getA10() {
        exer2.add(10);
                if(a10) {
            exer.add(10);
        }
        return a10;
    }

    public void setA10(boolean a10) {
        this.a10 = a10;
    }

    public boolean getA11() {
        exer2.add(11);
                if(a11) {
            exer.add(11);
            
        }
        return a11;
    }

    public void setA11(boolean a11) {
        this.a11 = a11;
    }

    public boolean getA12() {
        exer2.add(12);
                if(a12) {
            exer.add(12);
            
        }
        return a12;
    }

    public void setA12(boolean a12) {
        this.a12 = a12;
    }

    public boolean getA13() {
        
                if(a13) {
            exer.add(13);
           
        }
        return a13;
    }

    public void setA13(boolean a13) {
        this.a13 = a13;
    }
    
    public void setHours(int hours) {
        this.hours=hours;
    }

    public int getAllA() {
        if(getA1()==true) {
            
            pointsCalc++;
            
        }
        if(getA2()==true) {
            pointsCalc++;
        }        
        if(getA3()==true) {
            pointsCalc++;
        }
        if(getA4()==true) {
            pointsCalc++;
        }
        if(getA5()==true) {
            pointsCalc++;
        }
        if(getA6()==true) {
            pointsCalc++;
        }
        if(getA6()==true) {
            pointsCalc++;
        }
        if(getA7()==true) {
            pointsCalc++;
        }
        if(getA8()==true) {
            pointsCalc++;
        }
        if(getA9()==true) {
            pointsCalc++;
        }
        if(getA10()==true) {
            pointsCalc++;
        }
        if(getA11()==true) {
            pointsCalc++;
        }
        if(getA12()==true) {
            pointsCalc++;
        }        
        return pointsCalc;
    }
    public int getHours() {
        return hours;
    }
    public void setWeek(int week) {
        this.week=week;
    }
    public int getWeek() {
        return week;
    }


    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }
    public String getStudent_number() {
        return student_number;
    }
    public String doneExer() {
        String all = " ";
        for(Integer exersice : exer) {
          all += exersice + " ";  
        }
        return all;
    }
    public int hoursAmount() {
        muuttuja+=getHours();
        return muuttuja;
    }

    
 
    

    @Override
    public String toString() {
        
//        getA1();
//        getA2();
//        getA3();
//        getA4();
//        getA5();
//        getA6();
//        getA7();
//        getA8();
//        getA9();
//        getA10();
//        getA11();
//        getA12();
        return "viikko " + week +":" + " tehtyjä tehtäviä yhteensä: " + getAllA() + " (maksimi " +exer2.size() + ")"+", aikaa kului " + hours + " tuntia, tehdyt tehtävät: " + doneExer();
    }
    
}