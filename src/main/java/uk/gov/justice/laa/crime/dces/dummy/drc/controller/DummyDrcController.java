package uk.gov.justice.laa.crime.dces.dummy.drc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
  @GetMapping(value = "/test")
  public String test() {
    log.info("Get Request received to test");
    return "Received GET request";
  }

  @PostMapping(value = "/test")
  public ResponseEntity<String> test(@RequestBody final int requestedHttpStatus) {
    log.info("Received POST request of status {}", requestedHttpStatus);
    if (requestedHttpStatus != 200) {
      return ResponseEntity.status(HttpStatusCode.valueOf(requestedHttpStatus)).body("Received POST request with status " + requestedHttpStatus);
    }
    return ResponseEntity.ok("Received test POST request");
  }
}
