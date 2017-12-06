/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package okotuki;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class ProfileController implements Initializable {

    @FXML
    private Button login;
    @FXML
    private Button signup;
    @FXML
    private ImageView tukI;
    @FXML
    private Label fullname;
    @FXML
    private Label username;
    @FXML
    private Label password;
    @FXML
    private Label gender;
    @FXML
    private Label pn;
    @FXML
    private Label Address;
    @FXML
    private ImageView signout;
    @FXML
    private ImageView home;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void myFunction(String user){
         username.setText(user);
          try{
            String sql = "select * from tuki where username='"+username.getText()+"'";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet res=pst.executeQuery(sql);
            while(res.next()){
                fullname.setText(res.getString(2));                
                password.setText(res.getString(4));                
                gender.setText(res.getString(5));
                pn.setText(res.getString(6));                
                Address.setText(res.getString(7));
                  }
             } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
         }
    @FXML
    private void update(ActionEvent event) {
         try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("Update.fxml"));
            Parent root = (Parent) loader.load();
           
            UpdateController fxmlpController = loader.getController();
          
            fxmlpController.myFunction(username.getText(),gender.getText());
           ((Node)(event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();   
            
        } catch (IOException e) {
            System.out.println("Failed to go update ! " + e.getMessage());
        }
    }

    @FXML
    private void delete(ActionEvent event) {
         try{
            String sql = "delete from tuki where username='"+username.getText()+"'";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
           pst.execute(sql);
            try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
             JOptionPane.showMessageDialog(null, "Delete Succes !");
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
            System.out.println("Failed to delete" + e.getMessage());
        }
             } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @FXML
    private void tukI(MouseEvent event) {
    }


    @FXML
    private void signout(MouseEvent event) {
          try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Log In");
            stage.show();
            
        } catch (IOException e) {
            System.out.println("Failed to Sign Out !" + e.getMessage());
        }
    }

    @FXML
    private void home(MouseEvent event) {
          try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("kategori.fxml"));
            Parent root = (Parent) loader.load();
           
            KategoriController fxml2Controller = loader.getController();
          
            fxml2Controller.myFunction(username.getText());
           ((Node)(event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();      
            
        } catch (IOException e) {
            System.out.println("Failed to go home ! " + e.getMessage());
        }
    }
    
}
