package Diary.demo.record;

import Diary.demo.record.model.GetRecordRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RecordRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RecordRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public GetRecordRes getRecordByDayEmotionId(int dayEmotionId){
        String query = "SELECT*FROM dayInCalendar WHERE dayEmotionId = ?";
        int param = dayEmotionId;

        return jdbcTemplate.queryForObject(query,
                (rs, rowNum) -> new GetRecordRes(
                        rs.getInt("dayEmotionId"),
                        rs.getDate("date"),
                        rs.getString("imgUrl"),
                        rs.getString("whatText")
                )
                , param);
    }

    public List<GetRecordRes> getRecordListByDateEmotion(int userId, int dateEmotion, String monthName) {
        String query = "SELECT*FROM dayInCalendar WHERE userId = ? and dateEmotion = ? and monthName(date) = ?";
        Object[] params = {userId, dateEmotion, monthName};

        return jdbcTemplate.query(query,
                (rs, rowNum) -> new GetRecordRes(
                        rs.getInt("dayEmotionId"),
                        rs.getDate("date"),
                        rs.getString("imgUrl"),
                        rs.getString("whatText")
                )
                , params);

    }
}
