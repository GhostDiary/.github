package Diary.demo.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
public class GetSleepingRecord {
    public GetSleepingRecord() {

    }

    private Date date;
    private Time sleepingTime;

}
