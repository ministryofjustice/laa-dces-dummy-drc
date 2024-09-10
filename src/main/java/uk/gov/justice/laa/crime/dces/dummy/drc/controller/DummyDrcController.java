package uk.gov.justice.laa.crime.dces.dummy.drc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")

public class DummyDrcController {
  @GetMapping(value = "/test")
  public String test() {
    log.info("Get Request received to test");
    return "GET Test Successful";
  }
}
