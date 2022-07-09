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

    @PostMapping("")
    public BaseResponse<PostCalendarRes> createDayEmotion(@RequestBody PostCalendar postCalendar) {
        PostCalendarRes response = calendarService.createDayEmotion(postCalendar);
        return new BaseResponse<>(response);
    }

    @GetMapping("/lists")
    public BaseResponse<List<GetCalendarRes>> getDayEmotionList(@RequestParam int userId,@RequestParam String monthName) {
        return new BaseResponse<>(calendarService.getDayEmotionList(userId,monthName));
    }

    @GetMapping("")
    public BaseResponse<GetDayDetails> getDayDetails(@RequestParam int userId, @RequestParam int dayEmotionId) {
        return new BaseResponse<>(calendarService.getDayDetails(userId,dayEmotionId));
    }
}
