package com.covid.covidsbapp.Service;

import com.covid.covidsbapp.Utility.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class CovidDataService {

    @Autowired
    RestTemplate restTemplate;

    public Integer getCovidData(String cityName) {
        // Fetch the API response
        Map<String, Object> response = restTemplate.getForObject(Util.COVIDAPI, Map.class);

        // Extract the 'data' object
        Map<String, Object> data = (Map<String, Object>) response.get("data");

        // Extract the 'regional' list
        List<Map<String, Object>> regionalList = (List<Map<String, Object>>) data.get("regional");

        // Iterate through the list to find the matching city
        for (Map<String, Object> stateData : regionalList) {
            String stateName = (String) stateData.get("loc");
            if (stateName.equalsIgnoreCase(cityName)) {
                // Return the 'discharged' count for the matching city
                return (Integer) stateData.get("discharged");
            }
        }

        // If no matching city is found, return 0 or handle the case appropriately
        return 0;
    }
}
