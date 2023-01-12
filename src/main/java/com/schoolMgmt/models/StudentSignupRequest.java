package com.schoolMgmt.models;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentSignupRequest {
  @NotEmpty
  private String firstName;
  private String lastName;
  @NotEmpty
  private String email;

  private Data admissionDate;
  @NotEmpty
  private String garde;
}
