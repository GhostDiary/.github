package Diary.demo.record.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class GetRecordRes {

    public GetRecordRes() {
    }

    private int dayEmotionId;
    private Date date;
    private String imgUrl;
    private String whatText;

}
