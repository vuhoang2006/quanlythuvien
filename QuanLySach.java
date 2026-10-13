import java.util.ArrayList;

public class QuanLySach {
    private ArrayList<TaiLieu> danhSachTaiLieu;

    public QuanLySach() {
        this.danhSachTaiLieu = new ArrayList<>();
    }

    // 1. Thêm mới tài liệu (Kiểm tra trùng mã tài liệu)
    public boolean themTaiLieu(TaiLieu taiLieu) {
        for (TaiLieu tl : danhSachTaiLieu) {
            if (tl.getMaTaiLieu().equalsIgnoreCase(taiLieu.getMaTaiLieu())) {
                System.out.println("Lỗi: Mã tài liệu " + taiLieu.getMaTaiLieu() + " đã tồn tại!");
                return false;
            }
        }
        danhSachTaiLieu.add(taiLieu);
        System.out.println("Thêm thành công tài liệu mã: " + taiLieu.getMaTaiLieu());
        return true;
    }

    // 2. Xóa tài liệu theo mã
    public boolean xoaTaiLieu(String maTaiLieu) {
        TaiLieu tlXoa = null;
        for (TaiLieu tl : danhSachTaiLieu) {
            if (tl.getMaTaiLieu().equalsIgnoreCase(maTaiLieu)) {
                tlXoa = tl;
                break;
            }
        }

        if (tlXoa != null) {
            danhSachTaiLieu.remove(tlXoa);
            System.out.println("Đã xóa tài liệu có mã: " + maTaiLieu);
            return true;
        } else {
            System.out.println("Không tìm thấy tài liệu có mã: " + maTaiLieu);
            return false;
        }
    }

    // 3. Hiển thị thông tin tất cả tài liệu
    public void hienThiDanhSach() {
        if (danhSachTaiLieu.isEmpty()) {
            System.out.println("Danh sách tài liệu hiện đang trống.");
            return;
        }
        System.out.println("==== DANH SÁCH TÀI LIỆU ====");
        for (TaiLieu tl : danhSachTaiLieu) {
            tl.hienThiThongTin();
        }
    }

    // 4. Tìm kiếm tài liệu theo loại
    public void timKiemTheoLoai(int loai) {
        boolean timThay = false;
        for (TaiLieu tl : danhSachTaiLieu) {
            if (loai == 1 && tl instanceof Sach) {
                tl.hienThiThongTin();
                timThay = true;
            } else if (loai == 2 && tl instanceof TapChi) {
                tl.hienThiThongTin();
                timThay = true;
            } else if (loai == 3 && tl instanceof Bao) {
                tl.hienThiThongTin();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy tài liệu thuộc loại đã chọn.");
        }
    }
}