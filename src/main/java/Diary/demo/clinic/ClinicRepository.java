package Diary.demo.clinic;

import Diary.demo.clinic.model.GetSleepingRecord;
import Diary.demo.clinic.model.GetSleepingRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ClinicRepository {
    private JdbcTemplate jdbcTemplate;
    private List<GetSleepingRecord> getSleepingRes;

    @Autowired
    public ClinicRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public GetSleepingRes getSleepingTimesInfo(int userId, String monthName) {
        String query = "SELECT IF(TIME_TO_SEC(AVG(TIME(sleepEnd)))>AVG(TIME_TO_SEC(timediff(sleepEnd,sleepStart))),\n" +
                "           SEC_TO_TIME(TIME_TO_SEC((AVG(TIME(sleepEnd))))-AVG(TIME_TO_SEC(TIMEDIFF(sleepEnd,sleepStart))))\n" +
                "           ,TIMEDIFF(TIME('24:00:00'),SEC_TO_TIME(AVG(TIME_TO_SEC(TIMEDIFF(sleepEnd,sleepStart)))-TIME_TO_SEC((AVG(TIME(sleepEnd))))))) as sleepStartTime,\n" +
                "    TIME_FORMAT(SEC_TO_TIME(AVG(TIME_TO_SEC(timediff(sleepEnd,sleepStart)))),'%H:%i:%s') as sleepingTime,\n" +
                "    TIME_FORMAT(TIME(AVG(TIME(sleepEnd))),'%H:%i:%s') as wakeUpTime\n" +
                "\n" +
                "FROM dayInCalendar\n" +
                "where userId =? and MONTHNAME(date) = ?;";
        Object[] params = {userId, monthName};
        return jdbcTemplate.queryForObject(query,
                (rs, rowNum) -> new GetSleepingRes(
                        rs.getTime("sleepStartTime"),
                        rs.getTime("sleepingTime"),
                        rs.getTime("wakeUpTime"),
                        getSleepingRes = jdbcTemplate.query("SELECT date, TIMEDIFF(sleepEnd,sleepStart) as sleepingTime\n" +
                                        "FROM dayInCalendar\n" +
                                        "WHERE userId =? and MONTHNAME(date) =?",
                                (rk, rowNum1) -> new GetSleepingRecord(
                                        rk.getDate("date"),
                                        rk.getTime("sleepingTime")
                                )
                                , params)
                ), params);

    }

}
