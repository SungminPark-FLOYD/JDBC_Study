package Singleton;

public class Member {
    private String memId;
    private String memPass;
    private String memName;
    private String memTel;
    private String memAddr;

    public Member(String memId, String memPass, String memName, String memTel, String memAddr) {
        this.memId = memId;
        this.memPass = memPass;
        this.memName = memName;
        this.memTel = memTel;
        this.memAddr = memAddr;
    }

    public static void main(String[] args) {

//        Singleton singleton = new Singleton();    <<- 사용 불가
        Singleton singleton = Singleton.getInstance();
    }


    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemPass() {
        return memPass;
    }

    public void setMemPass(String memPass) {
        this.memPass = memPass;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemTel() {
        return memTel;
    }

    public void setMemTel(String memTel) {
        this.memTel = memTel;
    }

    public String getMemAddr() {
        return memAddr;
    }

    public void setMemAddr(String memAddr) {
        this.memAddr = memAddr;
    }
}
