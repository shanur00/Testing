package com.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(min = 5, message = "Must be At Least 5 characters")
  private String street;

  @NotBlank
  @Size(min = 5, message = "Must be At Least 5 characters")
  public String buildingName;

  @NotBlank
  @Size(min = 5, message = "Must be At Least 5 characters")
  private String city;

  @NotBlank
  @Size(min = 5, message = "Must be At Least 5 characters")
  private String state;

  @NotBlank
  @Size(min = 5, message = "Must be At Least 5 characters")
  private String country;

  @NotBlank
  @Size(min = 5, message = "Must be At Least 5 characters")
  private String zipCode;

  /*
      ToString.Exclude:
          prevents the usersInAddress field from being included in the generated toString() method and
          also prevent recursion.
          This field will not be printed.
   */

  @ToString.Exclude
  @ManyToMany(mappedBy = "addressesInUsers")
  private List<Users> usersInAddress = new ArrayList<>();

  public Address(String street, String buildingName, String city, String state, String country, String zipCode) {
    this.street = street;
    this.buildingName = buildingName;
    this.city = city;
    this.state = state;
    this.country = country;
    this.zipCode = zipCode;
  }
}
