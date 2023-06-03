import java.io.Serializable;

class RewardPunishment implements Serializable {
    private String rewardType;
    private String reason;
    private String date;

    public RewardPunishment(String rewardType, String reason, String date) {
        this.rewardType = rewardType;
        this.reason = reason;
        this.date = date;
    }

    public String getRewardType() {
        return rewardType;
    }

    public String getReason() {
        return reason;
    }

    public String getDate() {
        return date;
    }
}
