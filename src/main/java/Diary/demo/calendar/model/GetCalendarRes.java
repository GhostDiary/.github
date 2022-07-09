package Diary.demo.calendar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
public class GetCalendarRes {

    public GetCalendarRes() {
    }

    private int userId;
    private int dayEmotionId;
    private Date date;
    private int dateEmotion;
}
