package com.zadscience.springai.zadscience.springai.service.impl;

import com.zadscience.springai.zadscience.springai.dto.CustomerProfilingStrategyDto;
import com.zadscience.springai.zadscience.springai.service.ProfilingService;
import org.springframework.ai.client.AiClient;
import org.springframework.ai.client.AiResponse;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.ai.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfilingServiceImpl implements ProfilingService {


    public static final String ABOUT_CUSTOMER_PROFILING = """
        Tell me a bit about Customer Profiling""";

    @Autowired
    private AiClient aiClient;
    @Override
    public String tellAboutIt() {
        return aiClient.generate(ABOUT_CUSTOMER_PROFILING);
    }

    @Override
    public CustomerProfilingStrategyDto getCustomerProfilingByStrategy(String strategy) {
        BeanOutputParser<CustomerProfilingStrategyDto> customerProfilingDtoBeanOutputParser =
                new BeanOutputParser<>(CustomerProfilingStrategyDto.class);
        String promptString = """
                Write me about the customer profiling {strategy} strategies
                {format}
                """;
        PromptTemplate promptTemplate = new PromptTemplate(promptString);
        promptTemplate.add("strategy", strategy);
        promptTemplate.add("format", customerProfilingDtoBeanOutputParser.getFormat());
        promptTemplate.setOutputParser(customerProfilingDtoBeanOutputParser);
        AiResponse response = aiClient.generate(promptTemplate.create());
        System.out.println("Text::: " + response.getGeneration().getText());
        return customerProfilingDtoBeanOutputParser.parse(response.getGeneration().getText());
    }


}
