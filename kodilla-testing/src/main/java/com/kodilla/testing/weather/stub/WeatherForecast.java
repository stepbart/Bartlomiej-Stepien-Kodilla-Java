package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double averageTemperature() {
        double temperatureCounting = 0;
        int counter = 0;
        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            temperatureCounting += temperature.getValue();
            counter++;
        }
        return temperatureCounting/counter;
    }


    public double medianTemperature() {
        List<Double> temperatureList = new ArrayList<>();
        double medianTemp = 0;

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            temperatureList.add(temperature.getValue());
        }
        Collections.sort(temperatureList);
        int tempListSize = temperatureList.size();

        if (temperatureList.size() % 2 != 0) {
            medianTemp = temperatureList.get((tempListSize-1) / 2);
        }
        else {
            medianTemp = temperatureList.get(temperatureList.size() / 2) + temperatureList.get((temperatureList.size() - 2) / 2);
            medianTemp /= 2;
        }
        return medianTemp;
    }
}