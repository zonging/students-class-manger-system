import java.util.ArrayList;
import java.util.List;

// 奖惩信息管理类
class RewardPunishmentManager {
    private List<RewardPunishment2> rewardPunishment2List;

    public RewardPunishmentManager() {
        rewardPunishment2List = new ArrayList<>();
    }

    public void addRewardPunishment(String studentId, String rewardType, String reason, String date) {
        RewardPunishment2 rewardPunishment2 = new RewardPunishment2(studentId, rewardType, reason, date);
        rewardPunishment2List.add(rewardPunishment2);
    }

    public List<RewardPunishment2> getRewardPunishment(String studentId) {
        List<RewardPunishment2> result = new ArrayList<>();
        for (RewardPunishment2 rewardPunishment2 : rewardPunishment2List) {
            if (rewardPunishment2.getStudentId().equals(studentId)) {
                result.add(rewardPunishment2);
            }
        }
        return result;
    }
}
