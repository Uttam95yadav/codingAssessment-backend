package com.schoolMgmt.service;

import com.schoolMgmt.models.Student;
import com.schoolMgmt.models.StudentSignupRequest;
import com.schoolMgmt.utils.LevenshteinDistance;
import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentManagementService {
  private final LevenshteinDistance levenshteinDistance;

  public Student studentSignUp(
      StudentSignupRequest studentSignupRequest) {
    return Student.builder()
            .firstName(studentSignupRequest.getFirstName())
            .lastName(studentSignupRequest.getLastName())
            .email(studentSignupRequest.getEmail())
            .admissionDate(studentSignupRequest.getAdmissionDate())
            .garde(studentSignupRequest.getGarde())
        .build();
  }

  public List<String> getStudentsList() {
    List<String> similarWords = new ArrayList<String>();

    return similarWords;
  }
  public List<String> getStudentById(int id) {
    List<String> similarWords = new ArrayList<String>();

    return similarWords;
  }

}
