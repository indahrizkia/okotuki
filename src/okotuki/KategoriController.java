/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package okotuki;

import java.io.IOException;
import java.net.URL;
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

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class KategoriController implements Initializable {

    @FXML
    private Button cl;
    @FXML
    private Button bt;
    @FXML
    private Button bk;
    @FXML
    private Button ec;
    @FXML
    private Button st;
    @FXML
    private Button sh;
    @FXML
    private Button bg;
    @FXML
    private Button fd;
    @FXML
    private Button f;
    @FXML
    private ImageView logo;
    @FXML
    private Label nama;
    @FXML
    private ImageView signout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 
 public String name;
   public void myFunction(String username){
         nama.setText(username);
         name = username;
        }
   
    
    @FXML
    private void cl(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            // Load the new fxml
           FXMLLoader loader = new FXMLLoader(getClass().getResource("perkat.fxml"));
            Parent root = (Parent) loader.load();
           
            PerkatController fxmlpController = loader.getController();
          
            fxmlpController.myFunction(nama.getText());
           ((Node)(event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();   
            
        } catch (IOException e) {
            System.out.println("Failed to go clothes ! " + e.getMessage());
        }
    }
    @FXML
    private void bt(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            // Load the new fxml
           FXMLLoader loader = new FXMLLoader(getClass().getResource("bt.fxml"));
            Parent root = (Parent) loader.load();
           
            BtController fxmlpController = loader.getController();
          
            fxmlpController.myFunction(nama.getText());
           ((Node)(event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();   
            
        } catch (IOException e) {
            System.out.println("Failed to go beauty ! " + e.getMessage());
        }
    }

@FXML
    private void bk(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            // Load the new fxml
           FXMLLoader loader = new FXMLLoader(getClass().getResource("bk.fxml"));
            Parent root = (Parent) loader.load();
           
            bkController fxmlpController = loader.getController();
          
            fxmlpController.myFunction(nama.getText());
           ((Node)(event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();   
            
        } catch (IOException e) {
            System.out.println("Failed to go book ! " + e.getMessage());
        }
    }
    @FXML
    private void ec(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            // Load the new fxml
           FXMLLoader loader = new FXMLLoader(getClass().getResource("ec.fxml"));
            Parent root = (Parent) loader.load();
           
            ecController fxmlpController = loader.getController();
          
            fxmlpController.myFunction(nama.getText());
           ((Node)(event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();   
            
        } catch (IOException e) {
            System.out.println("Failed to go electronic ! " + e.getMessage());
        }
    }

    @FXML
    private void st(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            // Load the new fxml
           FXMLLoader loader = new FXMLLoader(getClass().getResource("st.fxml"));
            Parent root = (Parent) loader.load();
           
            stController fxmlpController = loader.getController();
          
            fxmlpController.myFunction(nama.getText());
           ((Node)(event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();   
            
        } catch (IOException e) {
            System.out.println("Failed to go street tools ! " + e.getMessage());
        }
    }

    @FXML
    private void sh(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            // Load the new fxml
           FXMLLoader loader = new FXMLLoader(getClass().getResource("sh.fxml"));
            Parent root = (Parent) loader.load();
           
            shController fxmlpController = loader.getController();
          
            fxmlpController.myFunction(nama.getText());
           ((Node)(event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();   
            
        } catch (IOException e) {
            System.out.println("Failed to go shoes ! " + e.getMessage());
        }
    }

    @FXML
    private void bg(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            // Load the new fxml
           FXMLLoader loader = new FXMLLoader(getClass().getResource("bg.fxml"));
            Parent root = (Parent) loader.load();
           
            bgController fxmlpController = loader.getController();
          
            fxmlpController.myFunction(nama.getText());
           ((Node)(event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();   
            
        } catch (IOException e) {
            System.out.println("Failed to go bag ! " + e.getMessage());
        }
    }

    @FXML
    private void fd(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            // Load the new fxml
           FXMLLoader loader = new FXMLLoader(getClass().getResource("fad.fxml"));
            Parent root = (Parent) loader.load();
           
            fadController fxmlpController = loader.getController();
          
            fxmlpController.myFunction(nama.getText());
           ((Node)(event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();   
            
        } catch (IOException e) {
            System.out.println("Failed to go food and drink !" + e.getMessage());
        }
    }

    @FXML
    private void f(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            // Load the new fxml
           FXMLLoader loader = new FXMLLoader(getClass().getResource("f.fxml"));
            Parent root = (Parent) loader.load();
           
            fController fxmlpController = loader.getController();
          
            fxmlpController.myFunction(nama.getText());
           ((Node)(event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();   
            
        } catch (IOException e) {
            System.out.println("Failed to go furniture ! " + e.getMessage());
        }
    }

     @FXML
    void signout(MouseEvent event) {
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
    void profil(MouseEvent event) {
         try {
            // Hide this current window (if this is what you want)
            // Load the new fxml
           FXMLLoader loader = new FXMLLoader(getClass().getResource("Profile.fxml"));
            Parent root = (Parent) loader.load();
           
            ProfileController fxmlpController = loader.getController();
          
            fxmlpController.myFunction(nama.getText());
           ((Node)(event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();   
            
        } catch (IOException e) {
            System.out.println("Failed to go profile !" + e.getMessage());
        }
    }
}
