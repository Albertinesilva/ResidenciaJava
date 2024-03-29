package com.documentation.crud_user_test.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user")
public class User extends AbstractEntity {

  private String name;
  private String email;
  private String cpf;
  private String phone;
  private String password;
}
