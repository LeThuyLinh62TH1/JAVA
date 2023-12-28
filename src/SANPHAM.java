
public abstract class SANPHAM {
	String tensp;
	float soluong;
	float dongia;
	abstract float tinhtien();
	public SANPHAM(String msp, String tensp, float soluong,float dongia) {
		setDongia(dongia);
		setMsp(msp);
		setSoluong(soluong);
		setTensp(tensp);
	}
	
	String msp;
	public String getMsp() {
		return msp;
	}
	public void setMsp(String msp) {
		this.msp = msp;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public float getSoluong() {
		return soluong;
	}
	public void setSoluong(float soluong) {
		this.soluong = soluong;
	}
	public float getDongia() {
		return dongia;
	}
	public void setDongia(float dongia) {
		this.dongia = dongia;
	}
}
