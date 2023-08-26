/*Package Project*/

/*Import Login, Lista_Empleado GUI Class*/
import Vista.Login;
import Vista.Lista_Empleado;

public class Farmacia {
    
    public static void main (String[] args){
           java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
    
}
