
package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Dao.UserDao;
import Entity.User;
import View.LoginView;
import View.BikeView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
public class LoginController {
    private final UserDao userDao;
    private final LoginView loginView;
    private BikeView bikeView;
    
    public LoginController(LoginView view) {
        this.loginView = view;
        this.userDao = new UserDao();
        view.addLoginListener(new LoginListener());
    }
    
    public void showLoginView() {
        loginView.setVisible(true);
    }
    
    /**
     * Lớp LoginListener chứa cài đặt cho sự kiện click button "Login"
     * 
     * @author viettuts.vn
     */
    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getUser();
            if (userDao.checkUser(user)) {
                try {
                    // nếu đăng nhập thành công, mở màn hình quản lý sinh viên
                    bikeView = new BikeView();
                    BikeController bikeController = new BikeController(bikeView);
                    bikeController.showBikeView();
                    loginView.setVisible(false);
                } catch (JAXBException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                loginView.showMessage("Tên đăng nhập hoặc mật khẩu không đúng.");
            }
        }
    }
}
