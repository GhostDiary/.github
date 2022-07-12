package Diary.demo.memo;

import Diary.demo.memo.model.GetMemoRes;
import Diary.demo.memo.model.PostMemoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Autowired
    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public int createMemo(PostMemoReq postMemoReq,int userId) {
        int memoId = memoRepository.createMemo(postMemoReq.getType(), postMemoReq.getTitle(), postMemoReq.getText(), userId);
        return memoId;
    }
    /** 메모 조회, userId 관련 validation 추가 */
    public GetMemoRes getMemoByMemoId(int userId,int memoId) {
        return memoRepository.getMemoByMemoId(memoId);
    }

    public List<GetMemoRes> getMemoListByUserId(int userId) {
        return memoRepository.getMemoListByUserId(userId);
    }
    /** userId 관련 validation 추가 */
    public List<GetMemoRes> getMemoListByType(int userId,String type){
        return memoRepository.getMemoListByType(type);
    }

    public int modifyMemo(int memoId,PostMemoReq postMemoReq){
        return memoRepository.updateMemo(memoId,postMemoReq.getType(), postMemoReq.getTitle(), postMemoReq.getText());
    }

    public int deleteMemo(int memoId){
        return memoRepository.deleteMemo(memoId);
    }
}
