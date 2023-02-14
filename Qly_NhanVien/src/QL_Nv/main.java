package QL_Nv;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class main {
    private static Scanner sc=new Scanner(System.in);
    public static NhanVien[] listNv;
    public static void main(String[] args) {
        menu();
    }
    public static  void menu(){
        boolean check = true;
        while (check){
            System.out.println("1.Mời bạn nhập thông tin nhân viên: ");
            System.out.println("2.check in: ");
            System.out.println("3.check out: ");
            System.out.println("4.show time: ");
            System.out.println("5.hiển thị thông tin: ");
            int so = Integer.parseInt(sc.nextLine());
            switch (so){
                case 1:
                    NhapThongtinNhanVien(listNv);
                    break;
                case 2:
                    HienthiThongTin(listNv);
                    break;
                case 3:
                    checkin(listNv);
                    break;
                case 4:
                    checkout(listNv);
                case 5:
                    ShowTime(listNv);
                    break;
            }
        }
    }
    private static void ShowTime(NhanVien[] listNv) {
        for (int i = 0;i<listNv.length;i++){
            System.out.println(listNv[i].getCheckin());
            System.out.println(listNv[i].getCheckout());
            ZonedDateTime zdtt= ZonedDateTime.of(listNv[i].getCheckin(), ZoneId.systemDefault());
            ZonedDateTime zdt= ZonedDateTime.of(listNv[i].getCheckout(), ZoneId.systemDefault());
            long date1 = zdtt.toInstant().toEpochMilli();
            long date2 = zdt.toInstant().toEpochMilli();
            System.out.println((date2/date1)/1000);
            if (date2-date1>=180){
                System.out.println("đủ chỉ tiêu");
            }else {
                System.out.println((200-((date2-date1)/1000)-20)+"s'");
                System.out.println("chưa đủ");
            }
        }
    }


    private static void checkout(NhanVien[] listNv) {
        System.out.println(" mời bạn nhập vào mã nhân viên của mình: ");
        int manv = Integer.parseInt(sc.nextLine());
        for (int i= 0; listNv.length>i;i++)
            if (listNv[i].getCheckout().equals(manv)) {
                System.out.println("đã check in ");
                LocalDateTime dateNow = LocalDateTime.now();
                listNv[i].setCheckout(dateNow);
                listNv[i].setStatus(2);
            }
    }

    private static void checkin(NhanVien[] listNv) {
        System.out.println(" mời bạn nhập vào mã nhân viên của mình: ");
        int manv = Integer.parseInt(sc.nextLine());
        for (int i= 0; listNv.length>i;i++)
            if (listNv[i].getCheckin().equals(manv)) {
                System.out.println("đã check in ");
                LocalDateTime dateNow = LocalDateTime.now();
                listNv[i].setCheckin(dateNow);
                listNv[i].setStatus(1);
            }
    }
    private static void HienthiThongTin(NhanVien[] listNv) {
        for (int i = 0; i<listNv.length;i++){
            listNv[i].inthongtinNV();
        }
    }


    private static void NhapThongtinNhanVien(NhanVien[] listNv) {
        System.out.println("Mời bạn khai báo số lượng nhân viên: ");
        int so = Integer.parseInt(sc.nextLine());
        for (int i=0;i<so;i++){
            System.out.println("Nhập mã nhân viên: ");
            int MaNV = Integer.parseInt(sc.nextLine());
            System.out.println("Nhập họ và tên: ");
            String UserName = sc.nextLine();
            System.out.println("Nhập giới tính: ");
            String sex = sc.nextLine();
            System.out.println("Nhập năm Sinh: ");
            int year = Integer.parseInt(sc.nextLine());
            NhanVien Nv = new NhanVien(MaNV,UserName,sex,year);
            listNv[i] = Nv;
        }
    }

}
