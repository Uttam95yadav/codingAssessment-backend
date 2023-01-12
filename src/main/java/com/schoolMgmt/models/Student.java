package com.schoolMgmt.models;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
  private int studentId;
  private String firstName;
  private String lastName;
  private String email;
  private Data admissionDate;
  private String garde;

}
