package com.schoolMgmt.controller;

import com.schoolMgmt.controller.StudentManagementController;
import com.schoolMgmt.models.Student;
import com.schoolMgmt.models.StudentSignupRequest;
import com.schoolMgmt.models.Response;
import com.schoolMgmt.service.StudentManagementService;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = StudentManagementController.class)
@WebMvcTest
public class StudentManagementControllerTest {

  @Autowired private StudentManagementController studentManagementController;

  @MockBean private StudentManagementService studentManagementService;

  @Test
  public void whenCalculateFrequesncyAndSimilarWordsIsCalled_CheckWhetherSuccessResponseIsReturned() {
    List<String> similarWords = new ArrayList<>();
    similarWords.add("word");
    similarWords.add("wor");
    similarWords.add("words");
    Student student =
        Student.builder()
            .firstName("uttam")
            .lastName("yadav")
            .email("uttamkumaryadav95@gmail.com")
            .garde("7th")
            .build();
    StudentSignupRequest studentSignupRequest =
        StudentSignupRequest.builder().firstName("word").lastName("word wor words").build();
    Response expectedResponse =
        Response.builder()
            .responseCode(200)
            .responseMessage("Success")
            .response(student)
            .build();
    doReturn(student).when(studentManagementService).studentSignUp(any());
    Response actualResponse =
        studentManagementController.calculateFrequencyAndSimilarWords(studentSignupRequest);
    assertEquals(expectedResponse.getResponseCode(), actualResponse.getResponseCode());
    assertEquals(expectedResponse.getResponseMessage(), actualResponse.getResponseMessage());
    assertEquals(expectedResponse.getResponse(), actualResponse.getResponse());
  }
}
