package com.fiipractic.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

    private final RestClient restClient;

    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherService() {
        this.restClient = RestClient.create();
    }

    public String getWeatherByCoordinates(double lat, double lon) {
        return restClient.get()
                .uri("http://api.weatherapi.com/v1/current.json?key={apiKey}&q={lat},{lon}&aqi={aqi}",
                        apiKey, lat, lon, "no")
                .retrieve()
                .body(String.class);
    }
}