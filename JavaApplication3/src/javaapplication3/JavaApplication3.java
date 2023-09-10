/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Properties;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.lang.System.*;
import java.lang.System.Logger.Level;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;
/**
 *
 * @author bryan
 */
public class EnviarCorreo {
    
    private final String correo_app = "esfotcareplus.uio@gmail.com";
    private final String Pass_app = "xmkhimzucmvybngg";
    private final String email_to = "bryand9970@gmail.com";
    private final String subject = "FACTURA DE COMPRA para 0000114adafs";
    private final String content = "Este correo presenta la factura para el cliente Sr./Srta. Bryan Paul Delgasdo. \n Este correo es auto generado, por favor no responder.";
    
    private final Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;
            
    public EnviarCorreo(){
        mProperties = new Properties();
        
    }

    private void CreateEmail(){
        
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", Home_Cajero.getEmail());
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");
        
        mSession = Session.getDefaultInstance(mProperties);
             
        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(correo_app));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(email_to));
            mCorreo.setSubject(subject);
            mCorreo.setText(content, "ISO-8859-1", "html");
        } catch (AddressException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.ERROR, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.ERROR, null, ex);
        }
    }
    
    private void SendEmail(){
           try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(correo_app, Pass_app);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
            
            JOptionPane.showMessageDialog(null, "Correo enviado");
            
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.ERROR, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarCorreo.class.getName()).log(Level.ERROR, null, ex);
        }
    }
    
    
    
    public static void main(String[] args) {
        EnviarCorreo mEnvioCorreos = new EnviarCorreo();
    }
    
}


