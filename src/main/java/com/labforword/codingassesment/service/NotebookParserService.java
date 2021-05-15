package com.labforword.codingassesment.service;

import com.labforword.codingassesment.models.NotebookTextDTO;
import com.labforword.codingassesment.models.NotebookTextRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotebookParserService {
  static int compute_Levenshtein_distance(String str1, String str2) {
    if (str1.isEmpty()) {
      return str2.length();
    }
    if (str2.isEmpty()) {
      return str1.length();
    }
    int replace =
        compute_Levenshtein_distance(str1.substring(1), str2.substring(1))
            + NumOfReplacement(str1.charAt(0), str2.charAt(0));

    int insert = compute_Levenshtein_distance(str1, str2.substring(1)) + 1;

    int delete = compute_Levenshtein_distance(str1.substring(1), str2) + 1;
    return minm_edits(replace, insert, delete);
  }

  static int NumOfReplacement(char c1, char c2) {
    return c1 == c2 ? 0 : 1;
  }

  static int minm_edits(int... nums) {
    return Arrays.stream(nums).min().orElse(Integer.MAX_VALUE);
  }

  public NotebookTextDTO getFrequencyAndSimilarWords(NotebookTextRequest notebookTextRequest) {
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
          && compute_Levenshtein_distance(word, notebookWord) <= 1) {
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
