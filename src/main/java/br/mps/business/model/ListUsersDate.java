package br.mps.business.model;

import java.util.Set;
import java.util.TreeSet;

public class ListUsersDate {
  public void listUsersByDate(Set<User> users) {
    Set<User> test_data = new TreeSet<User>(new ComparadorData());
        
        for (User user : users) {
            test_data.add(user);
        }

        String data_string = "";
        for (User user : test_data) {
            System.out.print(user.getLogin());
            data_string = user.getDataNascimento();
            System.out.println(data_string);
        }
  } 
}