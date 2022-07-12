package Diary.demo.memo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostMemoReq {

    public PostMemoReq() {

    }
    private String type;
    private String title;
    private String text;


}
