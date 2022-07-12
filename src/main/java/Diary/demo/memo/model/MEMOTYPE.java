package Diary.demo.memo.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MEMOTYPE {
    TRAVEL("여행"),
    STUDY("공부");

    private final String title;

}
