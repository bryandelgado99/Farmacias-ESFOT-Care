/*Package Project*/

/*Import Login GUI Class*/
import Vista.Login;

public class Farmacia {
    
    public static void main (String[] args){
           java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
    
}
