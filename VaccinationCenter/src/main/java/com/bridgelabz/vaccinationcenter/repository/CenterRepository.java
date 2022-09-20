package com.bridgelabz.vaccinationcenter.repository;

import com.bridgelabz.vaccinationcenter.entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepository extends JpaRepository<VaccinationCenter,Integer> {

}
