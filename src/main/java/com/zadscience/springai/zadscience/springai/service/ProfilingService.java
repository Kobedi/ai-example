package com.zadscience.springai.zadscience.springai.service;
import com.zadscience.springai.zadscience.springai.dto.CustomerProfilingStrategyDto;


public interface ProfilingService {

    public String tellAboutIt();

    CustomerProfilingStrategyDto getCustomerProfilingByStrategy(String strategy);

}
