package com.labforword.codingassesment.controller;

import com.labforword.codingassesment.models.NotebookTextDTO;
import com.labforword.codingassesment.models.NotebookTextRequest;
import com.labforword.codingassesment.models.Response;
import com.labforword.codingassesment.service.NotebookParserService;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = NotebookParserController.class)
@WebMvcTest
@WithMockUser(authorities = {"athena/service/RefreshManagement.TestDriveApp.read"})
public class NotebookParserControllerTest {

  @Autowired private NotebookParserController notebookParserController;

  @MockBean private NotebookParserService notebookParserService;

  @Test
  public void whengetFrequesncyAndSimilarWordsIsCalled_CheckWhetherSuccessResponseIsReturned() {
    List<String> similarwods = new ArrayList<>();
    similarwods.add("word");
    similarwods.add("wor");
    similarwods.add("words");
    NotebookTextDTO notebookTextDTO =
        NotebookTextDTO.builder()
            .word("word")
            .notebookText("word wor words")
            .wordFrequency(1)
            .similarWords(similarwods)
            .build();
    NotebookTextRequest notebookTextRequest =
        NotebookTextRequest.builder().word("word").notebookText("word wor words").build();
    Response expectedResponse =
        Response.builder()
            .responseCode(200)
            .responseMessage("Success")
            .response(notebookTextDTO)
            .build();
    doReturn(notebookTextDTO).when(notebookParserService).getFrequesncyAndSimilarWords(any());
    Response actualResponse =
        notebookParserController.getFrequecncyAndSimilarWords(notebookTextRequest);
    assertEquals(expectedResponse.getResponseCode(), actualResponse.getResponseCode());
    assertEquals(expectedResponse.getResponseMessage(), actualResponse.getResponseMessage());
    assertEquals(expectedResponse.getResponse(), actualResponse.getResponse());
  }
}
