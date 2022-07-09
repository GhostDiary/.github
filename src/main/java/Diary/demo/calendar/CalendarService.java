package Diary.demo.calendar;

import Diary.demo.calendar.model.GetCalendarRes;
import Diary.demo.calendar.model.GetDayDetails;
import Diary.demo.calendar.model.PostCalendar;
import Diary.demo.calendar.model.PostCalendarRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CalendarService {

    private final CalendarRepository calendarRepository;

    @Autowired
    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public PostCalendarRes createDayEmotion(PostCalendar postCalendar){
        return calendarRepository.insertDayEmotion(postCalendar);
    }

    public List<GetCalendarRes> getDayEmotionList(int userId,String monthName) {
        return calendarRepository.getDayEmotionInfoByUserId(userId,monthName);
    }

    public GetDayDetails getDayDetails(int userId, int dayEmotionId){
        return calendarRepository.getDayDetailsInfo(userId, dayEmotionId);
    }
}
