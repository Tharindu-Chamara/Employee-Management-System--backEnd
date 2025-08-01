package edu.icet.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {


   private String firstName;
   private String lastName;
   private String email;
   private String departmentID;
   private String roleID;

}
