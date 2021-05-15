package com.labforword.codingassesment.models;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotebookTextDTO {
  private String word;
  private String notebookText;
  private int wordFrequency;
  private List<String> similarWords;

}
