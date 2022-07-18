package Diary.demo.clinic;

import Diary.demo.clinic.model.GetSleepingRecord;
import Diary.demo.clinic.model.GetSleepingRes;
import Diary.demo.config.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clinic")
public class ClinicController {
    private ClinicService clinicService;

    @Autowired
    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping("/sleep/{userId}")
    public BaseResponse<GetSleepingRes> getSleepingTimes(@PathVariable int userId, @RequestParam String monthName){
        GetSleepingRes sleepingTimesInfo = clinicService.getSleepingTimesInfo(userId, monthName);
        return new BaseResponse<>(sleepingTimesInfo);
    }

}
