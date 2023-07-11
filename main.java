// Написать простой класс Телефонный Справочник (с помощью HashMap), который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
// тогда при запросе такой фамилии должны выводиться все телефоны.

// ***Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
// взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного справочника.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.xml.catalog.Catalog;

public class main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        task1();
    }

    public static void task1(){


        boolean flag = true;
        HashMap<String,ArrayList<Integer>> catalog = new HashMap<>();

        String[] numbers = {
            "Григорьев 452",
            "Фокин 152",
            "Шестаков 432",
            "Хохлов 252",
            "Шубин 452",
            "Гущина 433",
            "Брагина 252",
            "Шубин 112",
            "Рыбакова 422",
            "Фокин 432",
            "Бирюков 452",
            "Копылов 444",
            "Горбунов 453",
            "Фокин 152",
            "Соколов 115"
        };

        for (String el : numbers) {
            String[] numberParts = el.split(" ");
            
            int temp = Integer.parseInt(numberParts[1]);

            if(catalog.containsKey(numberParts[0])){
                catalog.get(numberParts[0]).add(temp);
            } else {
                ArrayList<Integer> lst = new ArrayList<>();
                lst.add(temp);
                catalog.put(numberParts[0], lst);
            }
        }

        catalog resCatalog = new catalog(catalog);

        while(flag){
            System.out.println("Input option: add, get, print, exit");
            String op = scanner.nextLine();

            if(op.equals("add")){
                String name = "Фокин";
                ArrayList<Integer> lst = new ArrayList<>();

                if(resCatalog.checkKey(name)){
                    lst = resCatalog.getValue(name);
                    lst.add(333);
                    resCatalog.add(name, lst);
                    resCatalog.printHash();
                } else {
                    resCatalog.add(name, lst);
                    resCatalog.printHash();
                }


            }

            if(op.equals("get")){
                String name = "Фокин";
                resCatalog.getNumber(name);
            }

            if(op.equals("print")){
                resCatalog.printHash();
            }

            if(op.equals("exit")){
                System.out.println("Exiting...");
                flag = false;
            }
        }
    }
}