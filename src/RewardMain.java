import java.util.List;

// 示例用法
public class RewardMain {
    public static void main(String[] args) {
        RewardPunishmentManager rewardPunishmentManager = new RewardPunishmentManager();

        // 添加奖惩信息
        rewardPunishmentManager.addRewardPunishment("001", "奖励", "优秀表现", "2023-05-01");
        rewardPunishmentManager.addRewardPunishment("002", "惩罚", "迟到", "2023-05-02");

        // 查询奖惩信息
        List<RewardPunishment2> rewardPunishment2s = rewardPunishmentManager.getRewardPunishment("001");
        for (RewardPunishment2 rewardPunishment2 : rewardPunishment2s) {
            System.out.println(rewardPunishment2.getRewardType() + " " +
                    rewardPunishment2.getReason() + " " +
                    rewardPunishment2.getDate());
        }
    }
}
