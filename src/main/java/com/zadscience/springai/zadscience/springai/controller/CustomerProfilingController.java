package com.zadscience.springai.zadscience.springai.controller;

import com.zadscience.springai.zadscience.springai.dto.CustomerProfilingStrategyDto;
import com.zadscience.springai.zadscience.springai.service.ProfilingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerProfilingController {

    @Autowired
    private ProfilingService service;

    @GetMapping("/about")
    public ResponseEntity<String> generateHaiku(){
        return ResponseEntity.ok(service.tellAboutIt());
    }
    @GetMapping("/strategy")
    public ResponseEntity<CustomerProfilingStrategyDto> getCustomerProfilingByStrategy
            (@RequestParam("strategy") String strategy)
    {
        return ResponseEntity.ok(service.getCustomerProfilingByStrategy(strategy));
    }
}
