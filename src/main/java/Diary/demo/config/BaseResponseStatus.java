package Diary.demo.config;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {
    /**
     * 1000 : 요청성공

     */
    SUCCESS(true,1000,"요청에 성공하였습니다.");

    /**
     * 2000 : Request 오류
     */
    //Common

    /**
     * 3000 : Response 오류
     */


    /**
     * 4000 : Database, Server 오류
     */





    private final boolean isSuccess;
    private final int code;
    private final String message;
    
    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
