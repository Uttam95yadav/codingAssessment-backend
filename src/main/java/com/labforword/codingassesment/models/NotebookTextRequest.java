package com.labforword.codingassesment.models;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotebookTextRequest {

  @NotEmpty
  private String word;

  @NotEmpty
  private String notebookText;
}
