package com.labforword.codingassesment.service;

import com.labforword.codingassesment.models.NotebookTextDTO;
import com.labforword.codingassesment.models.NotebookTextRequest;
import com.labforword.codingassesment.utils.LevenshteinDistance;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotebookParserService {
  private final LevenshteinDistance levenshteinDistance;

  public NotebookTextDTO calculateFrequencyAndSimilarWords(
      NotebookTextRequest notebookTextRequest) {
    return NotebookTextDTO.builder()
        .word(notebookTextRequest.getWord())
        .notebookText(notebookTextRequest.getNotebookText())
        .wordFrequency(
            getWordFrequency(notebookTextRequest.getWord(), notebookTextRequest.getNotebookText()))
        .similarWords(
            getSimilarWords(notebookTextRequest.getWord(), notebookTextRequest.getNotebookText()))
        .build();
  }

  public List<String> getSimilarWords(String word, String notebookText) {
    List<String> similarWords = new ArrayList<String>();
    for (String notebookWord : notebookText.split("\\s+")) {
      if (!similarWords.stream().anyMatch(similarWord -> similarWord.equalsIgnoreCase(notebookWord))
          && levenshteinDistance.compute_Levenshtein_distance(word, notebookWord) <= 1) {
        similarWords.add(notebookWord);
      }
    }
    return similarWords;
  }

  public Integer getWordFrequency(String word, String notebookText) {
    Integer frequency = 0;
    for (String notebookWord : notebookText.split("\\s+")) {
      if (word.equals(notebookWord)) {
        frequency++;
      }
    }
    return frequency;
  }
}
