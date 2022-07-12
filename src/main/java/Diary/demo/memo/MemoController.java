package Diary.demo.memo;

import Diary.demo.config.BaseResponse;
import Diary.demo.memo.model.GetMemoRes;
import Diary.demo.memo.model.PostMemoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("memo")
public class MemoController {

    private final MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping("/{userId}")    //메모 생성 api
    public BaseResponse<Integer> createMemo(@RequestBody PostMemoReq postMemoReq, @PathVariable int userId) {
        int memoId = memoService.createMemo(postMemoReq, userId);
        return new BaseResponse<>(memoId);
    }

    @GetMapping("/{userId}/{memoId}")     //특정 메모 조회 api (특정 메모 상세 내용 보는 api)
    public BaseResponse<GetMemoRes> getMemoByMemoId(@PathVariable int userId, @PathVariable int memoId) {
        GetMemoRes result = memoService.getMemoByMemoId(userId, memoId);
        return new BaseResponse<>(result);
    }

    @GetMapping("/lists/{userId}")   //특정 유저의 전체 메모 조회
    public BaseResponse<List<GetMemoRes>> getMemoList(@PathVariable int userId) {
        List<GetMemoRes> result = memoService.getMemoListByUserId(userId);
        return new BaseResponse<>(result);
    }

    @GetMapping("/lists/type/{userId}")   // memo type 으로 메모 조회
    public BaseResponse<List<GetMemoRes>> getMemoListByType(@PathVariable int userId, @RequestParam String type) {
        List<GetMemoRes> result = memoService.getMemoListByType(userId, type);
        return new BaseResponse<>(result);
    }

    @PutMapping("/{memoId}")    //memo 수정 api
    public BaseResponse<Integer> modifyMemo(@PathVariable int memoId,@RequestBody PostMemoReq postMemoReq) {
        memoService.modifyMemo(memoId,postMemoReq);
        return new BaseResponse<>(memoId);
    }

    @DeleteMapping("/{memoId}")  //캘린더 일별 내용 삭제 api
    public BaseResponse<String> deleteMemo(@PathVariable int memoId) {
        memoService.deleteMemo(memoId);
        return new BaseResponse<>("삭제가 완료되었습니다.");
    }
}
