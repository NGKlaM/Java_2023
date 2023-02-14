package QL_Nv;

import java.time.LocalDateTime;

public class NhanVien {
    private int MaNV;
    private String UserName;
    private  String sex;
    private int Year;
    private LocalDateTime checkin;
    private LocalDateTime checkout;
    private int Status=0;
    public NhanVien(int maNV, String userName, String sex, int year) {
        MaNV = maNV;
        UserName = userName;
        this.sex = sex;
        Year = year;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int maNV) {
        MaNV = maNV;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public LocalDateTime getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDateTime dateNow) {
        this.checkin = checkin;
    }

    public LocalDateTime getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDateTime checkout) {
        this.checkout = checkout;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "MaNV=" + MaNV +
                ", UserName='" + UserName + '\'' +
                ", sex='" + sex + '\'' +
                ", Year=" + Year +
                ", checkin=" + checkin +
                ", checkout=" + checkout +
                ", Status=" + Status +
                '}';
    }

    public void inthongtinNV(){
        System.out.println("Thông tin nhân viên :");
        System.out.println("Mã nhân viên :"+MaNV+"họ tên nhân viên :"+UserName+"Giới Tính nhân viên :"+sex+"năm sinh :"+Year+"check in"+checkin+"check out"+checkout+"status"+Status);
    }
}
