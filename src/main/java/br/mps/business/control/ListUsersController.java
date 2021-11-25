package br.mps.business.control;

import java.util.Set;

import br.mps.business.model.User;
import br.mps.business.model.ListUsers;
import br.mps.business.model.ListUsersDate;

public class ListUsersController extends ListUsers {
  private ListUsersDate listUsersDate;
  Set<User> users;

  public ListUsersController(ListUsersDate listUsersDate, Set<User> users) {
    this.listUsersDate = listUsersDate;
    this.users = users;
  }

  public void listUsersByDate() {
    listUsersDate.listUsersByDate(users);
  }
}
