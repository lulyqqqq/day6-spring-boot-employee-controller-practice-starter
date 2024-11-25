package com.oocl.springbootemployee.controller;


import com.oocl.springbootemployee.pojo.Company;
import com.oocl.springbootemployee.repo.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureJsonTesters
@AutoConfigureMockMvc
public class CompanyControllerTest {

    @Autowired
    private MockMvc client;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private JacksonTester<List<Company>> listJson;


    @Test
    void should_return_all_companies_when_getAll_given_companies() throws Exception {
        final List<Company> companyRepositoryList = companyRepository.getAll();
        String companiesJSONString = client.perform(MockMvcRequestBuilders.get("/companies"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(4)))
                .andReturn().getResponse().getContentAsString();

        List<Company> companies = listJson.parseObject(companiesJSONString);
        assertThat(companies)
                .usingRecursiveComparison()
                .isEqualTo(companyRepositoryList);
    }
}
