package Diary.demo.record;

import Diary.demo.config.BaseResponse;
import Diary.demo.record.model.GetRecordRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {

    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }


    @GetMapping("/{userId}/{dayEmotionId}") //dayEmotionId 로 record 조회
    public BaseResponse<GetRecordRes> getRecordByDayEmotionId(@PathVariable int userId, @PathVariable int dayEmotionId) {
        GetRecordRes recordByDayEmotionId = recordService.getRecordByDayEmotionId(dayEmotionId);

        return new BaseResponse<>(recordByDayEmotionId);
    }

    @GetMapping("/list/{userId}")   //월별 기록 조회 api
    public BaseResponse<List<GetRecordRes>> getRecordListByDateEmotion(@PathVariable int userId, @RequestParam int dateEmotion, @RequestParam String monthName) {
        List<GetRecordRes> recordListByDateEmotion = recordService.getRecordListByDateEmotion(userId, dateEmotion, monthName);

        return new BaseResponse<>(recordListByDateEmotion);
    }
}
