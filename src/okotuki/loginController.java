/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package okotuki;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

import java.sql.Connection;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class loginController implements Initializable {

    @FXML
    public TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Button signup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void logn(ActionEvent event) {      
        

    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;                                      
                
        try {
            sql = "SELECT * FROM tuki WHERE username='"+username.getText()+"' AND password='"+password.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(username.getText().equals(rs.getString("username")) && password.getText().equals(rs.getString("password"))){
                    
                    
            // Hide this current window (if this is what you want)
            
            // Load the new fxml
              FXMLLoader loader = new FXMLLoader(getClass().getResource("kategori.fxml"));
            Parent root = (Parent) loader.load();
           
            KategoriController fxml2Controller = loader.getController();
          
            fxml2Controller.myFunction(username.getText());
           ((Node)(event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();   
                }
            }else{
                    JOptionPane.showMessageDialog(null, "username atau password salah");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    @FXML
    void enter(KeyEvent event) {
     
    }
    



    @FXML
    private void sign(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("signup.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Sign Up");
            stage.show();
            
        } catch (IOException e) {
            System.out.println("Failed to go Sign Up ! " + e.getMessage());
        }
    }
      @FXML
    void awal(MouseEvent event) {
        try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("awal.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Front Page");
            stage.show();
            
        } catch (IOException e) {
            System.out.println("Failed to go Beranda ! " + e.getMessage());
        }
    }
}
