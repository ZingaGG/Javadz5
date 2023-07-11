// Написать простой класс Телефонный Справочник (с помощью HashMap), который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
// тогда при запросе такой фамилии должны выводиться все телефоны.

// ***Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
// взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного справочника.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class catalog<K,V> extends HashMap<K,V>{
    
    HashMap<String, ArrayList<Integer>> person;

    public catalog(HashMap<String, ArrayList<Integer>> person){
        this.person = person;
    }

    public void add(String surName, ArrayList<Integer> lst){
        person.put(surName, lst);
    }

    public void getNumber(String surName){
        if (person.containsKey(surName)){
            for(Map.Entry<String, ArrayList<Integer>> el : person.entrySet()){
                if(el.getKey().equals(surName)){
                    System.out.println(el.getValue());
                } 
            }

        } else {
            System.out.println("Wrong Surname!");
        }
    }

    public void printHash(){
        for (Map.Entry<String, ArrayList<Integer>> el : person.entrySet()) {
            System.out.println("Surname = " + el.getKey());
            System.out.println("Number = " + el.getValue());
            System.out.println();
        }
    }

    public ArrayList<Integer> getValue(String key) {
        return person.get(key);
    }

    public boolean checkKey(String key) {
        return person.containsKey(key);
    }


}