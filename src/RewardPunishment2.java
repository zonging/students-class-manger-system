// 学生管理模块

// 奖惩信息类
class RewardPunishment2 {
    private String studentId;
    private String rewardType;
    private String reason;
    private String date;

    public RewardPunishment2(String studentId, String rewardType, String reason, String date) {
        this.studentId = studentId;
        this.rewardType = rewardType;
        this.reason = reason;
        this.date = date;
    }

    public String getStudentId() {
        return studentId;
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

