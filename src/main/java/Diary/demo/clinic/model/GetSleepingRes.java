package Diary.demo.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class GetSleepingRes {
    private Time sleepStartTime;
    private Time sleepingTime;
    private Time wakeUpTime;
    private List<GetSleepingRecord> getSleepingRecords;

    public GetSleepingRes() {
    }
}
