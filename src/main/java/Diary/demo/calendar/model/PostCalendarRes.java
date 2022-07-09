package Diary.demo.calendar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class PostCalendarRes {
    public PostCalendarRes() {
    }

    private int dayEmotionId;
    private Date date;
    private int dateEmotion;


}
