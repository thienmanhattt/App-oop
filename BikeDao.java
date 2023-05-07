
package Dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Entity.Bike;
import Entity.BikeXML;
import Utils.FileUtils;
import javax.xml.bind.JAXBException;

public class BikeDao {
    private static final String BIKE_FILE_NAME = "Bike.xml";
    private List<Bike> listBikes;

    public BikeDao() throws JAXBException {
        this.listBikes = readListBikes();
    }

    /**
     * Lưu các đối tượng bike vào file bike.xml
     * 
     * @param bikes
     */
    public void writeListBikes(List<Bike> bikes) {
        BikeXML bikeXML = new BikeXML();
        bikeXML.setBike(bikes);
        FileUtils.writeXMLtoFile(BIKE_FILE_NAME, bikeXML);
    }

    /**
     * Đọc các đối tượng bike từ file bike.xml
     * 
     * @return list bike
     */
    public List<Bike> readListBikes() throws JAXBException {
        List<Bike> list = new ArrayList<>();
        BikeXML bikeXML = (BikeXML) FileUtils.readXMLFile(
                BIKE_FILE_NAME, BikeXML.class);
        if (bikeXML != null) {
            list = bikeXML.getBike();
        }
        return list;
    }
    
    
    public List<Bike> searchBikeName(String search){
        List<Bike>temp = new ArrayList<Bike>();
        for(Bike bike : listBikes){
            if(bike.getTen().contains(search)){
                temp.add(bike);
            }
        }
        return temp;
    }
    /**
     * thêm bike vào listBikes và lưu listBikes vào file
     * 
     * @param bike
     */
    public void add(Bike bike) {
        int id = (!listBikes.isEmpty()) ? (listBikes.size() + 1) : 1;
        bike.setId(id);
        listBikes.add(bike);
        writeListBikes(listBikes);
    }

    /**
     * cập nhật bike vào listBikes và lưu listBikes vào file
     * 
     * @param bike
     */
    public void edit(Bike bike) {
        int size = listBikes.size();
        for (int i = 0; i < size; i++) {
            if (listBikes.get(i).getId() == bike.getId()) {
                listBikes.get(i).setTen(bike.getTen());
                listBikes.get(i).setBienso(bike.getBienso());
                listBikes.get(i).setHang(bike.getHang());
                writeListBikes(listBikes);
                break;
            }
        }
    }

    /**
     * xóa bike từ listBikes và lưu listBikes vào file
     * 
     * @param bike
     * @return 
     */
    public boolean delete(Bike bike) {
        boolean isFound = false;
        int size = listBikes.size();
        for (int i = 0; i < size; i++) {
            if (listBikes.get(i).getId() == bike.getId()) {
                bike = listBikes.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listBikes.remove(bike);
            writeListBikes(listBikes);
            return true;
        }
        return false;
    }

    /**
     * sắp xếp danh sách bike theo name theo tứ tự tăng dần
     */
    public void sortBikeByName() {
        Collections.sort(listBikes, (Bike bike1, Bike bike2) -> bike1.getTen().compareTo(bike2.getTen()));
    }
    
    public void sortBikebygia() {
        Collections.sort(listBikes, (Bike bike1, Bike bike2) -> {
            if (bike1.getGia() > bike2.getGia()) {
                return 1;
            }
            return -1;
        });
    }
    
    public List<Bike> SearchBike(String search){
        new ArrayList<>();
        Iterable<Bike> listBike = null;
        for(Bike bike : listBike){
            if(bike.getTen().contains(search)){
                listBikes.add(bike);
            }
        }
        return listBikes;
    }

    public List<Bike> getListBikes() {
        return listBikes;
    }

    public void setListBikes(List<Bike> listBikes) {
        this.listBikes = listBikes;
    }
}
