package com.example.springboot.services;

import com.example.springboot.dtos.VinhosDto;
import com.example.springboot.models.VinhoModel;

public interface VinhoService {
    public VinhoModel saveVinho(VinhosDto vinhosDto);
}
