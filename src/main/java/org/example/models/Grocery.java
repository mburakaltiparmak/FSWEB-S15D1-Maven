package org.example.models;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList=new ArrayList<>();

    Scanner scanner=new Scanner(System.in);

    public void startGrocery(){
        int choice;

        do{
            System.out.println("Yapılmak istenen operasyonu seçin(0: çıkış, 1: ekleme, 2: çıkarma)");
            choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz");
                    String itemsToAdd=scanner.nextLine();
                    addItems(itemsToAdd);
                    break;
                case 2:
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                    String itemsToRemove=scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;
            }
        }
        while(choice!=0);
        scanner.close();

    }

    public static void addItems(String items){
        String[] splittedItems=items.split(",");
        for(String item:splittedItems){
            String trimmed=item.trim();
            if(checkItemsInList(trimmed)){
                System.out.println("Girilen item listede mevcut: "+trimmed);
            }else{
                groceryList.add(trimmed);
                printSorted();
            }
        }
    }

    public static void removeItems(String items){
        String[] splittedItems=items.split(",");
        for(String item:splittedItems){
            String trimmed=item.trim();
            if(!checkItemsInList(trimmed)){
                System.out.println("Girilen item listede mevcut değil: "+trimmed);
            }else{
                groceryList.remove(trimmed);
            }
        }
    }

    public static void printSorted(){
        System.out.println("Mevcut pazar listesi: ");
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }



    private static boolean checkItemsInList(String item) {
        return groceryList.contains(item);
    }
}