package br.mps.business.model;

import java.util.Set;

public class ListUsers {
  public void listUsersName(Set<User> users) {
    for (User user : users) {
      System.out.println(user.getLogin());
  }
  }
}