package br.com.kevinarteldev.bibliosystem.service;

import br.com.kevinarteldev.bibliosystem.repository.LocationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final ObjectMapper objectMapper;
    private final LocationRepository locationRepository;

}
