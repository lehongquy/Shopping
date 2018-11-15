package edu.fpt.lenovo.shoponline.model;

public class Loaisp {
    public int Id;
    public String Tenloaisp;
    public String Hinhanhloaisp;

    public Loaisp(int id, String tenloaisp, String hinhanhloaisp) {
        this.Id = id;
        Tenloaisp = tenloaisp;
        Hinhanhloaisp = hinhanhloaisp;
    }

    public int getId() {
         return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getTenloaisp() {
        return Tenloaisp;
    }

    public void setTenloaisp(String tenloaisp) {

        Tenloaisp = tenloaisp;
    }

    public String getHinhanhloaisp() {
        return Hinhanhloaisp;
    }

    public void setHinhanhloaisp(String hinhanhloaisp) {
        Hinhanhloaisp = hinhanhloaisp;
    }
}
