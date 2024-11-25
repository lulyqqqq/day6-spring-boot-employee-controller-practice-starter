package com.oocl.springbootemployee.repo;

import com.oocl.springbootemployee.pojo.Company;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyRepository {
    private List<Company> companies = new ArrayList<>();

    public CompanyRepository() {
        companies.add(new Company(1, "OOCL"));
        companies.add(new Company(2, "CargoSmart"));
        companies.add(new Company(3, "TW"));
        companies.add(new Company(4, "IQAX"));
    }

    public List<Company> getAll() {
        return companies;
    }
}
