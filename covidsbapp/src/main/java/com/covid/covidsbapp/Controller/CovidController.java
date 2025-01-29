package com.covid.covidsbapp.Controller;

import com.covid.covidsbapp.Service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid")
public class CovidController {
    @Autowired
    CovidDataService covidDataService;
    @GetMapping("/citywise/{city}")
    public String getCovidCases(@PathVariable String city)
    {
        Integer covidData=covidDataService.getCovidData(city);
//        System.out.println(city);
           return "covid discharged cases in "+city+" = "+covidData;
    }
//to call api we use RestTemplate
}
