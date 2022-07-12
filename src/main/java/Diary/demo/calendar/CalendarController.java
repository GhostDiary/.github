package Diary.demo.calendar;

import Diary.demo.calendar.model.GetCalendarRes;
import Diary.demo.calendar.model.GetDayDetails;
import Diary.demo.calendar.model.PostCalendar;
import Diary.demo.calendar.model.PostCalendarRes;
import Diary.demo.config.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    private final CalendarService calendarService;

    @Autowired
    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @PostMapping("")    //캘린더 생성 api
    public BaseResponse<PostCalendarRes> createDayEmotion(@RequestBody PostCalendar postCalendar) {
        PostCalendarRes response = calendarService.createDayEmotion(postCalendar);
        return new BaseResponse<>(response);
    }

    @GetMapping("/lists/{userId}")   //캘린더 월별 조회 api
    public BaseResponse<List<GetCalendarRes>> getDayEmotionList(@PathVariable int userId, @RequestParam String monthName) {
        return new BaseResponse<>(calendarService.getDayEmotionList(userId, monthName));
    }

    @GetMapping("/{userId}/{dayEmotionId}")     //캘린더 일별 상세 내용 조회 api
    public BaseResponse<GetDayDetails> getDayDetails(@PathVariable int userId, @PathVariable int dayEmotionId) {
        return new BaseResponse<>(calendarService.getDayDetails(userId, dayEmotionId));
    }

    @PutMapping("/{dayEmotionId}") //캘린더 일별 내용 수정 api
    public BaseResponse<PostCalendarRes> modifyDayDetails(@RequestBody PostCalendar postCalendar, @PathVariable int dayEmotionId) {
        return new BaseResponse<>(calendarService.modifyDayDetails(postCalendar, dayEmotionId));
    }

    @DeleteMapping("/{dayEmotionId}")  //캘린더 일별 내용 삭제 api
    public BaseResponse<String> deleteDayEmotion(@PathVariable int dayEmotionId) {
        calendarService.deleteDayEmotion(dayEmotionId);
        return new BaseResponse<>("삭제가 완료되었습니다.");
    }

    @GetMapping("/emotion/{userId}/{dateEmotion}") //캘린더 월별 감정으로 조회
    public BaseResponse<List<GetCalendarRes>> getDayEmotionListByEmotion(@PathVariable int userId, @RequestParam String monthName,@PathVariable int dateEmotion) {
        return new BaseResponse<>(calendarService.getDayEmotionListByEmotion(userId, monthName,dateEmotion));
    }
}
