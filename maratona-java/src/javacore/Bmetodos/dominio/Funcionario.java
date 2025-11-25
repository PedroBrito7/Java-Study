package javacore.Bmetodos.dominio;

public class Funcionario {
    private String name;
    private int age;
    private double [] wages;
    private double media =0;

    public void printDatas(){
        System.out.println("##############");
        System.out.println(this.name);
        System.out.println(this.age);
        if(wages ==null) {
            return;
        }
            for (double wage : wages) {
                System.out.println(wage + " ");
            }
      mediaWage();

    }
    public void mediaWage(){
        if (wages ==null){
            return;
        }
            for (double wage : wages) {
                media += wage;
            }
            media /= wages.length;

        System.out.println("\nMedia salarial:" +media);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWages(double[] wages) {
        this.wages = wages;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double[] getWages() {
        return wages;
    }

    public double getMedia() {
        return media;
    }
}

