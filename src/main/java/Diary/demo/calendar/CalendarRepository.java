package Diary.demo.calendar;

import Diary.demo.calendar.model.GetCalendarRes;
import Diary.demo.calendar.model.GetDayDetails;
import Diary.demo.calendar.model.PostCalendar;
import Diary.demo.calendar.model.PostCalendarRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Repository
public class CalendarRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CalendarRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public PostCalendarRes insertDayEmotion(PostCalendar p){
        String query = "insert into dayInCalendar(userId,date,dateEmotion,whoEmo,whoText,whatEmo," +
                "whatText,moodEmo,moodText,sentimentEmo,sentimentText,sleepStart,sleepEnd,menses,others) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Object[] params = new Object[]{p.getUserId(), p.getDate(), p.getDateEmotion(), p.getWhoEmo(), p.getWhoText()
        ,p.getWhatEmo(),p.getWhatText(),p.getMoodEmo(),p.getMoodText(),p.getSentimentEmo(),p.getSentimentText(),p.getSleepStart(),p.getSleepEnd(),
                p.getMenses(),p.getOthers()
        };
        jdbcTemplate.update(query, params);
        int param = jdbcTemplate.queryForObject("select last_insert_id()", int.class);

        String queryForReturn = "select dayEmotionId,date,dateEmotion\n" +
                "from dayInCalendar\n" +
                "where dayEmotionId =?\n";


        return jdbcTemplate.queryForObject(queryForReturn,
                (rs, rowNum) -> new PostCalendarRes(
                        rs.getInt("dayEmotionId"),
                        rs.getDate("date"),
                        rs.getInt("dateEmotion")

                ), param);
    }

    public List<GetCalendarRes> getDayEmotionInfoByUserId(int userId,String monthName) {
        String query = "SELECT userId,dayEmotionId,date,dateEmotion FROM dayInCalendar where userId = ? and MONTHNAME(date) = ?";
        Object[] params = {userId,monthName};

        return jdbcTemplate.query(query,
                (rs, rowNum) -> new GetCalendarRes(
                        rs.getInt("userId"),
                        rs.getInt("dayEmotionId"),
                        rs.getDate("date"),
                        rs.getInt("dateEmotion")
                ),params
        );
    }

    public GetDayDetails getDayDetailsInfo(int userId, int dayEmotionId){
        String query = "select*FROM dayInCalendar WHERE userId =? and dayEmotionId =?";
        Object[] params = {userId, dayEmotionId};

        return jdbcTemplate.queryForObject(query,
                (rs, rowNum) -> new GetDayDetails(
                        rs.getInt("dayEmotionId"),
                        rs.getDate("date"),
                        rs.getInt("dateEmotion"),
                        rs.getInt("whoEmo"),
                        rs.getString("whoText"),
                        rs.getInt("whatEmo"),
                        rs.getString("whatText"),
                        rs.getInt("whereEmo"),
                        rs.getString("whereText"),
                        rs.getInt("moodEmo"),
                        rs.getString("moodText"),
                        rs.getInt("sentimentEmo"),
                        rs.getString("sentimentText"),
                        rs.getTime("sleepStart"),
                        rs.getTime("sleepEnd"),
                        rs.getInt("menses"),
                        rs.getString("others")
                )
                , params);
    }


    public PostCalendarRes updateDayEmotion(PostCalendar p,int dayEmotionId){
        String query = "update dayInCalendar set userId=? ,date=?,dateEmotion=?,whoEmo=?,whoText=?,whatEmo=?," +
                "whatText=?,moodEmo=?,moodText=?,sentimentEmo=?,sentimentText=?,sleepStart=?,sleepEnd=?,menses=?,others=? " +
                "where dayEmotionId=?";

        Object[] params = new Object[]{p.getUserId(), p.getDate(), p.getDateEmotion(), p.getWhoEmo(), p.getWhoText()
                ,p.getWhatEmo(),p.getWhatText(),p.getMoodEmo(),p.getMoodText(),p.getSentimentEmo(),p.getSentimentText(),p.getSleepStart(),p.getSleepEnd(),
                p.getMenses(),p.getOthers(),dayEmotionId
        };

        jdbcTemplate.update(query, params);

        String queryForReturn = "select dayEmotionId,date,dateEmotion\n" +
                "from dayInCalendar\n" +
                "where dayEmotionId =?\n";

        int param = dayEmotionId;

        return jdbcTemplate.queryForObject(queryForReturn,
                (rs, rowNum) -> new PostCalendarRes(
                        rs.getInt("dayEmotionId"),
                        rs.getDate("date"),
                        rs.getInt("dateEmotion")

                ), param);
    }

    public int deleteDayEmotionId(int dayEmotionId) {
        String query = "delete from dayInCalendar where dayEmotionId =?";
        int param = dayEmotionId;

        return jdbcTemplate.update(query,param);
    }

    public List<GetCalendarRes> getDayEmotionListByDateEmotion(int userId, String monthName, int dateEmotion){
        String query = "SELECT userId,dayEmotionId,date,dateEmotion FROM dayInCalendar where userId = ? and MONTHNAME(date) = ? and dateEmotion =?";
        Object[] params = {userId,monthName,dateEmotion};

        return jdbcTemplate.query(query,
                (rs, rowNum) -> new GetCalendarRes(
                        rs.getInt("userId"),
                        rs.getInt("dayEmotionId"),
                        rs.getDate("date"),
                        rs.getInt("dateEmotion")
                ),params
        );
    }

}
