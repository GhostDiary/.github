package Diary.demo.memo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class GetMemoRes {
    public GetMemoRes() {

    }

    private int memoId;
    private String type;
    private String title;
    private String text;
}
