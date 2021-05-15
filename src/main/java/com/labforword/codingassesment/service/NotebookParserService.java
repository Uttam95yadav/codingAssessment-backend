package com.labforword.codingassesment.service;

import com.labforword.codingassesment.models.NotebookTextDTO;
import com.labforword.codingassesment.models.NotebookTextRequest;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotebookParserService {
  public NotebookTextDTO getFrequesncyAndSimilarWords(NotebookTextRequest notebookTextRequest) {
    return NotebookTextDTO.builder()
        .word(notebookTextRequest.getWord())
        .notebookText(notebookTextRequest.getNotebookText())
        .wordFrequency(
            getWordFrequency(notebookTextRequest.getWord(), notebookTextRequest.getNotebookText()))
        .similarWords(
            getSimilarWords(notebookTextRequest.getWord(), notebookTextRequest.getNotebookText()))
        .build();
  }

  public List<String> getSimilarWords(String words, String notebookText) {
    List<String> similarWords = new ArrayList<String>();
    for (String word : notebookText.split("\\s+")) {
      if (!similarWords.stream().anyMatch(similarWord -> similarWord.equalsIgnoreCase(word))
          && words.regionMatches(
              true, 0, word, 0, words.length() > word.length() ? word.length() : words.length())) {
        similarWords.add(word);
      }
    }
    return similarWords;
  }

  public Integer getWordFrequency(String words, String notebookText) {
    Integer frequency = 0;
    for (String word : notebookText.split("\\s+")) {
      if (words.equals(word)) {
        frequency++;
      }
    }
    return frequency;
  }
}
