package Diary.demo.memo;

import Diary.demo.memo.model.GetMemoRes;
import Diary.demo.memo.model.PostMemoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MemoRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MemoRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int createMemo(String type, String title, String text, int userId) {

        String query = "insert into memo(userId,type,title,text) values(?,?,?,?)";
        Object[] params = {userId, type, title, text};
        jdbcTemplate.update(query, params);
        return jdbcTemplate.queryForObject("select last_insert_id()", int.class);
    }

    public GetMemoRes getMemoByMemoId(int memoId) {
        String query = "SELECT * FROM memo WHERE memoId=?";
        int param = memoId;
        return jdbcTemplate.queryForObject(query,
                (rs, rowNum) -> new GetMemoRes(
                        rs.getInt("memoId"),
                        rs.getString("type"),
                        rs.getString("title"),
                        rs.getString("text")
                )
                , param);
    }

    public List<GetMemoRes> getMemoListByUserId(int userId) {
        String query = "SELECT * FROM memo WHERE userId= ?";
        int param = userId;
        return jdbcTemplate.query(query, (
                (rs, rowNum) -> new GetMemoRes(
                        rs.getInt("memoId"),
                        rs.getString("type"),
                        rs.getString("title"),
                        rs.getString("text")
                )
        ), param);
    }

    public List<GetMemoRes> getMemoListByType(String type) {
        String query = "SELECT * FROM memo WHERE type= ?";
        String param = type;
        return jdbcTemplate.query(query, (
                (rs, rowNum) -> new GetMemoRes(
                        rs.getInt("memoId"),
                        rs.getString("type"),
                        rs.getString("title"),
                        rs.getString("text")
                )
        ), param);
    }

    public int updateMemo(int memoId, String type, String title, String text) {
        String query = "UPDATE memo SET type =? ,title =? , text =? where memoId =?";
        Object[] params = {type, title, text, memoId};

        return jdbcTemplate.update(query, params);
    }

    public int deleteMemo(int memoId) {
        String query = "delete from memo where memoId =?";
        int param = memoId;

        return jdbcTemplate.update(query, param);
    }
}
