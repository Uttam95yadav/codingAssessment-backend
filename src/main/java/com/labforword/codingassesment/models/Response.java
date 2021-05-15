package com.labforword.codingassesment.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Response<T> {

  /** Stores the response code of each Response eg., 200, 800 */
  private Integer responseCode;
  /** Stores the response message of each Response eg., Unidentified error, Databasef Fetch Error */
  private String responseMessage;
  /** Stores the output response of any passed class type eg., List, String, EnvironmentResponse, */
  private T response;
}

