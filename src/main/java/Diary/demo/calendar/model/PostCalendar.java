package Diary.demo.calendar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Data
public class PostCalendar {

    public PostCalendar() {

    }

    private int userId;
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
