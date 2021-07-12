package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;

    @BeforeEach
    void buildTestMap() {
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

    }

    @Test
    void testCalculateForecastWithMock() {

        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void testAverageTemperature(){
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double result = weatherForecast.averageTemperature();
        double expectedResult = 127.8 / 5;

        //Then
        Assertions.assertEquals(result, expectedResult);
    }

    @Test
    void testMedianTempretureIfOddMapValues() {

        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double result = weatherForecast.medianTemperature();
        double expectedResult = 25.5;

        //Then
        Assertions.assertEquals(result, expectedResult);
    }

    @Test
    void testMedianTempretureIfEvenMapValues() {

        //Given
        Map<String, Double> temperaturesMap2 = new HashMap<>();
        temperaturesMap2.put("Rzeszow", 25.5);
        temperaturesMap2.put("Krakow", 26.2);
        temperaturesMap2.put("Wroclaw", 24.8);
        temperaturesMap2.put("Warszawa", 25.2);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap2);
        WeatherForecast weatherForecast2 = new WeatherForecast(temperaturesMock);

        //When
        double result = weatherForecast2.medianTemperature();
        double expectedResult = 25.35;

        //Then
        Assertions.assertEquals(result, expectedResult);
    }
}