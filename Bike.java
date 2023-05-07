
package Entity;

import java.io.Serializable;

public class Bike implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String ten;//tên xe
    private String hang;//tên hãng sản xuất
    private String tinhtrang;//tình trạng xe
    private float gia;//giá cho thuê
    private String bienso;// biển số xe

    public Bike() {
    }

    public Bike (int id, String ten, String hang, String tinhtrang, float gia, String bienso) {
        super();
        this.id = id;
        this.ten = ten;
        this.hang = hang;
        this.tinhtrang = tinhtrang;
        this.gia = gia;
        this.bienso = bienso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }
    
    public String getTinhtrang(){
        return tinhtrang;
    }
    
    public void setTinhtrang(String tinhtrang){
        this.tinhtrang = tinhtrang;
    }
    
    public float getGia(){
        return gia;
    } 
    
    public void setGia(float gia){
        this.gia = gia;
    }
    
    public String getBienso(){
        return bienso;
    }
    
    public void setBienso(String bienso){
        this.bienso = bienso;
    }
}
