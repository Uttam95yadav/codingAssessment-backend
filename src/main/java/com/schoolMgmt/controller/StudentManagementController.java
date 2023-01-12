package com.schoolMgmt.controller;

import com.schoolMgmt.models.StudentSignupRequest;
import com.schoolMgmt.models.Response;
import com.schoolMgmt.service.StudentManagementService;
import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schoolmgmt")
@CrossOrigin
public class StudentManagementController {
  private final StudentManagementService studentManagementService;

  @PostMapping("/createstudent")
  public Response<?> studentSignup(
      @Valid @RequestBody StudentSignupRequest studentSignupRequest) {
    try {
      return Response.builder()
          .response(studentManagementService.studentSignUp(studentSignupRequest))
          .responseCode(200)
          .responseMessage("Success")
          .build();
    } catch (Exception ex) {
      return Response.builder()
          .responseCode(500)
          .responseMessage("internal server error while getting the Frequency and Similar Words")
          .build();
    }
  }
  @GetMapping("/students")
  public Response<?> getStudentsList() {
    try {
      return Response.builder()
              .response(studentManagementService.getStudentsList())
              .responseCode(200)
              .responseMessage("Success")
              .build();
    } catch (Exception ex) {
      return Response.builder()
              .responseCode(500)
              .responseMessage("internal server error while getting the Frequency and Similar Words")
              .build();
    }
  }
  @GetMapping("/student/id")
  public Response<?> getStudentById(
          @Valid @RequestBody Integer id) {
    try {
      return Response.builder()
              .response(studentManagementService.getStudentById(id))
              .responseCode(200)
              .responseMessage("Success")
              .build();
    } catch (Exception ex) {
      return Response.builder()
              .responseCode(500)
              .responseMessage("internal server error while getting the Frequency and Similar Words")
              .build();
    }
  }

}
