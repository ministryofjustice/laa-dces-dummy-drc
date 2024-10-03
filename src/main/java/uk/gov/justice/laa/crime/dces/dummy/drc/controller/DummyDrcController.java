package uk.gov.justice.laa.crime.dces.dummy.drc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@Slf4j
@RestController
@RequestMapping("/api/v1")

public class DummyDrcController {
  @Operation(description = "Test GET endpoint to use with DCES integration.")
  @GetMapping(value = "/test")
  public String test() {
    log.info("Get Request received to test");
    return "Received GET request";
  }

  @Operation(description = "Test POST endpoint to use with DCES integration.")
  @ApiResponse(responseCode = "200",
      content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
          schema = @Schema(implementation = String.class)))
  @ApiResponse(responseCode = "400",
      description = "Bad request.",
      content = @Content(mediaType = MediaType.APPLICATION_PROBLEM_JSON_VALUE,
          schema = @Schema(implementation = ErrorResponse.class)))
  @ApiResponse(responseCode = "500",
      description = "Server Error.",
      content = @Content(mediaType = MediaType.APPLICATION_PROBLEM_JSON_VALUE,
          schema = @Schema(implementation = ErrorResponse.class)))

  @PostMapping(value = "/test")
  public ResponseEntity<String> test(@RequestBody final int requestedHttpStatus) {
    log.info("Received POST request of status {}", requestedHttpStatus);
    if (requestedHttpStatus != 200) {
      return ResponseEntity.status(HttpStatusCode.valueOf(requestedHttpStatus)).body("Received POST request with status " + requestedHttpStatus);
    }
    return ResponseEntity.ok("Received test POST request");
  }
}
