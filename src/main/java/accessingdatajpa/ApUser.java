/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accessingdatajpa;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author matia
 */
@Entity
public class ApUser {
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private String username;
  private String password;

  protected ApUser() {}

  public ApUser(String firstName, String lastName) {
    this.username = firstName;
    this.password = lastName;
  }

  @Override
  public String toString() {
    return String.format("Customer[firstName='%s', lastName='%s']",
        username, password);
  }

  public String getUsername() {
    return username;
  }

  public String getLastName() {
    return password;
  }
}