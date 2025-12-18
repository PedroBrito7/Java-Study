package javacore.Tresourcebundle.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest01 {
    public static void main(String[] args) {
        System.out.println(Locale.getDefault());
        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle.getString("good.morning"));
        System.out.println(bundle.getString("hi"));
        bundle = ResourceBundle.getBundle("messages",new Locale("pt", "BR"));
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle.getString("good.morning"));

        // caso ele nao ache uma locale do bundle ele vai
        // locale("fr", "CA"); supor que queira essa
        // messages_fr_CA.propeties; nao achou isso ele procura >
        // messages_fr.propeties;  nao achou isso ele procura >
        // messages_en_US.propeties; linguagem padrao, nao achou ? vai para >
        // messages_en.propeties; dps dessa forma >
        // messages.propeties; finaliza aq
        System.out.println(bundle.getString("hi"));



    }
}
