
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Dao.BikeDao;
import Entity.Bike;
import View.BikeView;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;

public class BikeController {
    private final BikeDao bikeDao;
    private final BikeView bikeView;

    public BikeController(BikeView view) throws JAXBException {
        this.bikeView = view;
        bikeDao = new BikeDao();

        view.addAddBikeListener(new AddBikeListener());
        view.addEdiBikeListener(new EditBikeListener());
        view.addDeleteBikeListener(new DeleteBikeListener());
        view.addClearBikeListener(new ClearBikeListener());
        view.addSortBikeNameListener(new SortBikeNameListener());
        view.addSearchBikeListener(new SearchBikeListener());
        view.addListBikeSelectionListener(new ListBikeSelectionListener());
        view.addSortBikegiaListener(new sortBikegiaListener());
        view.addCancelSearchBikeListener (new CancelSearchBikeListener());
    }

    public void showBikeView() {
        List<Bike> bikeList = bikeDao.getListBikes();
        bikeView.setVisible(true);
        bikeView.showListBikes(bikeList);
    }

    class AddBikeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Bike bike = bikeView.getBikeInfo();
            System.out.println(bike);
            if (bike != null) {
                bikeDao.add(bike);
                bikeView.showBike(bike);
                bikeView.showListBikes(bikeDao.getListBikes());
                bikeView.showMessage("Thêm thành công!");
            }
        }
    }
    
    class EditBikeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Bike bike = bikeView.getBikeInfo();
            if (bike != null) {
                bikeDao.edit(bike);
                bikeView.showBike(bike);
                bikeView.showListBikes(bikeDao.getListBikes());
                bikeView.showMessage("Cập nhật thành công!");
            }
        }
    }

    class DeleteBikeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Bike bike = bikeView.getBikeInfo();
            if (bike != null) {
                bikeDao.delete(bike);
                bikeView.clearBikeInfo();
                bikeView.showListBikes(bikeDao.getListBikes());
                bikeView.showMessage("Xóa thành công!");
            }
        }
    }

    class ClearBikeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            bikeView.clearBikeInfo();
        }
    }
    
    class SortBikeNameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            bikeDao.sortBikeByName();
            bikeView.showListBikes(bikeDao.getListBikes());
        }
    }
    
    class SearchBikeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            List<Bike> bikeList = new ArrayList<>();
            String search = bikeView.validateSearch();
            bikeList = bikeDao.searchBikeName(search);
            if(!bikeList.isEmpty())bikeView.showListBikes(bikeList);
            else bikeView.showMessage("Không tìm thấy kết quả!");
        }
    }
    
    class CancelSearchBikeListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            bikeView.showListBikes(bikeDao.getListBikes());
            bikeView.cancelSearchBike();
        }
    }
    
    class sortBikegiaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            bikeDao.sortBikebygia();
            bikeView.showListBikes(bikeDao.getListBikes());
        }
    }

    class ListBikeSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            bikeView.fillBikeFromSelectedRow();
        }
    }
}
