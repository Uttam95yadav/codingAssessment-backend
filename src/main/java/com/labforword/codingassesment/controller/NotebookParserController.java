package com.labforword.codingassesment.controller;

import com.labforword.codingassesment.models.NotebookTextRequest;
import com.labforword.codingassesment.models.Response;
import com.labforword.codingassesment.service.NotebookParserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/codingasessment")
@CrossOrigin
public class NotebookParserController {
  private final NotebookParserService notebookParserService;

  @PostMapping("/frequencyandsimilarwords")
  public Response<?> calculateFrequencyAndSimilarWords(
      @Valid @RequestBody NotebookTextRequest notebookTextRequest) {
    try {
      return Response.builder()
          .response(notebookParserService.calculateFrequencyAndSimilarWords(notebookTextRequest))
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
