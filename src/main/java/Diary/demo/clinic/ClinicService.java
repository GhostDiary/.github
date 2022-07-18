package Diary.demo.clinic;

import Diary.demo.clinic.model.GetSleepingRecord;
import Diary.demo.clinic.model.GetSleepingRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicService {
    private ClinicRepository clinicRepository;

    @Autowired
    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    public GetSleepingRes getSleepingTimesInfo(int userId, String monthName) {
        return clinicRepository.getSleepingTimesInfo(userId, monthName);
    }
}
