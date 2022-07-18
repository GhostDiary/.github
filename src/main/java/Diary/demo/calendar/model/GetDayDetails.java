package Diary.demo.calendar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;


@Getter
@Setter
@AllArgsConstructor
public class GetDayDetails {

    public GetDayDetails() {
    }

    private String imgUrl;
    private int dayEmotionId;
    private Date date;
    private int dateEmotion;
    private int whoEmo;
    private String whoText;
    private int whatEmo;
    private String whatText;
    private int whereEmo;
    private String whereText;
    private int moodEmo;
    private String moodText;
    private int sentimentEmo;
    private String sentimentText;
    private Time sleepStart;
    private Time sleepEnd;
    private int menses;
    private String others;

}
