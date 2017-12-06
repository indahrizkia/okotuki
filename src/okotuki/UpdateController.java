/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package okotuki;

import com.jfoenix.controls.JFXRadioButton;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class UpdateController implements Initializable {

    @FXML
    private Button login;
    @FXML
    private ImageView tukI;
    @FXML
    private ImageView signout;
    @FXML
    private ImageView home;
    @FXML
    private TextField fullnam;
    @FXML
    private TextField usernam;
    @FXML
    private TextField passwor;
    @FXML
    private TextField pn;
    @FXML
    private TextArea addre;
  @FXML
    private Label nm;
  
    @FXML
    private RadioButton laki;

    @FXML
    private ToggleGroup g;

    @FXML
    private RadioButton wani;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void myFunction(String user, String jk){
         usernam.setText(user);
          nm.setText(user);
         
          try{
            String sql = "select * from tuki where username='"+usernam.getText()+"'";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet res=pst.executeQuery(sql);
            while(res.next()){ 
                fullnam.setText(res.getString(2));                
                passwor.setText(res.getString(4)); 
                pn.setText(res.getString(6));                
                addre.setText(res.getString(7));
                 if(jk=="female"){
                     wani.setSelected(true);
                     laki.setSelected(false);
                        wani.requestFocus();
                }if(jk=="male"){
                       laki.setSelected(true);
                     wani.setSelected(false);
                        laki.requestFocus();
                }
                  }
             } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @FXML
    private void update(ActionEvent event) {
        if(fullnam.getText().equals("")){
                 JOptionPane.showMessageDialog(null, "Fullname Belum diisi !");
            }else if(usernam.getText().equals("")){
                 JOptionPane.showMessageDialog(null, "Username Belum diisi !");
            }
            else if(passwor.getText().equals("")){
                 JOptionPane.showMessageDialog(null, "Password Belum diisi !");
            }
               else if(pn.getText().equals("")){
                 JOptionPane.showMessageDialog(null, "Phone Number  Belum diisi !");
            }
        else if(addre.getText().equals("")){
                 JOptionPane.showMessageDialog(null, "Alamat Belum diisi !");
            }
        else{
         try{
            String gende = null;
            if(laki.isSelected()){
                 gende="male";
        }else if(wani.isSelected()){
                gende="female";
        }
            
                String sql ="UPDATE `tuki` SET `nama_tukI`='"+fullnam.getText()+"',`username`='"+ usernam.getText()+"',`password`='"+passwor.getText()+"',`gender`='"+gende+"',`telp`='"+ pn.getText()+"',`alamat`='"+addre.getText()+"' WHERE username='"+nm.getText()+"'";
               java.sql.Connection conn=(Connection)config.configDB();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
               pst.execute(sql);
                 JOptionPane.showMessageDialog(null, "Update Succes");
                     try {
            // Hide this current window (if this is what you want)
            // Load the new fxml
           FXMLLoader loader = new FXMLLoader(getClass().getResource("Profile.fxml"));
            Parent root = (Parent) loader.load();
           
            ProfileController fxmlpController = loader.getController();
          
            fxmlpController.myFunction(usernam.getText());
           ((Node)(event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();   
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e.getMessage());
        }
             } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }}
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
          
            fxml2Controller.myFunction(nm.getText());
           ((Node)(event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();      
            
        } catch (IOException e) {
            System.out.println("Failed to go home ! " + e.getMessage());
        }
    }
    
}
