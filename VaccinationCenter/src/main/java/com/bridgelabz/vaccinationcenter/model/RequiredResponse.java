package com.bridgelabz.vaccinationcenter.model;

import com.bridgelabz.vaccinationcenter.entity.VaccinationCenter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RequiredResponse {
    private VaccinationCenter center;
    private List<Citizen> citizens;
}
