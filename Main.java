import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLySach ql = new QuanLySach();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== QUẢN LÝ THƯ VIỆN =====");
            System.out.println("1. Thêm mới tài liệu");
            System.out.println("2. Xóa tài liệu theo mã");
            System.out.println("3. Hiển thị thông tin tất cả tài liệu");
            System.out.println("4. Tìm kiếm tài liệu theo loại");
            System.out.println("0. Thoát chương trình");
            System.out.print("Mời bạn chọn chức năng (0-4): ");

            int chon = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ nhớ đệm

            switch (chon) {
                case 1:
                    System.out.println("Chọn loại tài liệu cần thêm:");
                    System.out.println("a. Sách | b. Tạp chí | c. Báo");
                    System.out.print("Nhập lựa chọn (a/b/c): ");
                    String subChon = scanner.nextLine().toLowerCase();

                    System.out.print("Nhập mã tài liệu: ");
                    String maTL = scanner.nextLine();
                    System.out.print("Nhập tên nhà xuất bản: ");
                    String nxb = scanner.nextLine();
                    System.out.print("Nhập số bản phát hành: ");
                    int soBan = scanner.nextInt();
                    scanner.nextLine();

                    if (subChon.equals("a")) {
                        System.out.print("Nhập tên tác giả: ");
                        String tacGia = scanner.nextLine();
                        System.out.print("Nhập số trang: ");
                        int soTrang = scanner.nextInt();
                        scanner.nextLine();
                        ql.themTaiLieu(new Sach(maTL, nxb, soBan, tacGia, soTrang));
                    } else if (subChon.equals("b")) {
                        System.out.print("Nhập số phát hành: ");
                        int soPH = scanner.nextInt();
                        System.out.print("Nhập tháng phát hành: ");
                        int thangPH = scanner.nextInt();
                        scanner.nextLine();
                        ql.themTaiLieu(new TapChi(maTL, nxb, soBan, soPH, thangPH));
                    } else if (subChon.equals("c")) {
                        System.out.print("Nhập ngày phát hành: ");
                        int ngayPH = scanner.nextInt();
                        scanner.nextLine();
                        ql.themTaiLieu(new Bao(maTL, nxb, soBan, ngayPH));
                    } else {
                        System.out.println("Lựa chọn loại tài liệu không hợp lệ.");
                    }
                    break;

                case 2:
                    System.out.print("Nhập mã tài liệu cần xóa: ");
                    String maXoa = scanner.nextLine();
                    ql.xoaTaiLieu(maXoa);
                    break;

                case 3:
                    ql.hienThiDanhSach();
                    break;

                case 4:
                    System.out.println("Chọn loại cần tìm kiếm:");
                    System.out.println("1. Sách | 2. Tạp chí | 3. Báo");
                    System.out.print("Nhập lựa chọn (1-3): ");
                    int loaiTim = scanner.nextInt();
                    scanner.nextLine();
                    ql.timKiemTheoLoai(loaiTim);
                    break;

                case 0:
                    System.out.println("Đã thoát chương trình!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Chức năng không hợp lệ, vui lòng chọn lại!");
            }
        }
    }
}