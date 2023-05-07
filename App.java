import java.awt.EventQueue;
import Controller.LoginController;
import View.LoginView;
public class App {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            LoginView view = new LoginView();
            LoginController controller = new LoginController(view);
            // hiển thị màn hình login
            controller.showLoginView();
        });
    }   
}
