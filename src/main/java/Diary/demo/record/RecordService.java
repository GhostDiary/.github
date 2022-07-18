package Diary.demo.record;

import Diary.demo.record.model.GetRecordRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class RecordService {

    private final RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public GetRecordRes getRecordByDayEmotionId(int dayEmotionId){
        return recordRepository.getRecordByDayEmotionId(dayEmotionId);
    }

    public List<GetRecordRes> getRecordListByDateEmotion(int userId, int dateEmotion,String monthName){
        return recordRepository.getRecordListByDateEmotion(userId, dateEmotion, monthName);
    }


}
