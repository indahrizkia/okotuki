/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package okotuki;

import com.jfoenix.controls.JFXCheckBox;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import java.text.DecimalFormat;
/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class stController implements Initializable {

    @FXML
    private JFXCheckBox c1;
    @FXML
    private TextField total;
    @FXML
    private Button hitung;
    @FXML
    private Button beli;
    @FXML
    private Button hapus;
    @FXML
    private JFXCheckBox c2;
    @FXML
    private JFXCheckBox c3;
    @FXML
    private JFXCheckBox c11;
    @FXML
    private JFXCheckBox c21;
    @FXML
    private JFXCheckBox c31;
    @FXML
    private ImageView home;
    @FXML
    private Label namatuki;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public String nama;
public void myFunction(String username){
         nama = username;
         namatuki.setText(username);
         }
    @FXML
    private void hitung(ActionEvent event) {
        int ttl = 0, harga;
 String baju,barang = null;
       if(c1.isSelected()){
            baju="Bycicle Cleaner";
            barang  += baju+" \n";
            harga= 500000;
            ttl += harga;
        } if(c2.isSelected()){
            baju="Truck Cleaner";
            harga= 75000000;
            ttl += harga;
            barang += baju+" \n";
        } if(c3.isSelected()){
            baju="Orange Street Tool";
            barang += baju+" \n";
            harga= 20000;
            ttl += harga;
        } if(c11.isSelected()){
            baju="Traffic Symbol";
            barang += baju+" \n";
            harga= 10000;
            ttl += harga;
        }if(c21.isSelected()){
            baju="Lamp Park Street";
            barang += baju+" \n";
            harga= 70000;
            ttl += harga;
        }if(c31.isSelected()){
            baju="Lamp Street";
            barang += baju+" \n";
            harga= 85000;
            ttl += harga;}
        DecimalFormat rph = new DecimalFormat("#,###,##0.00");
        total.setText("Rp "+ rph.format(ttl));
    }

    @FXML
    private void beli(ActionEvent event) {
        String nm = namatuki.getText();
         int ttl = 0, harga;
        String baju,barang = "";
        if(c1.isSelected()||c2.isSelected()||c3.isSelected()||c11.isSelected()||c21.isSelected()||c31.isSelected()){
        if(c1.isSelected()){
            baju="Bycicle Cleaner";
            barang  += baju+" \n";
            harga= 500000;
            ttl += harga;
        } if(c2.isSelected()){
            baju="Truck Cleaner";
            harga= 75000000;
            ttl += harga;
            barang += baju+" \n";
        } if(c3.isSelected()){
            baju="Orange Street Tool";
            barang += baju+" \n";
            harga= 20000;
            ttl += harga;
        } if(c11.isSelected()){
            baju="Traffic Symbol";
            barang += baju+" \n";
            harga= 10000;
            ttl += harga;
        }if(c21.isSelected()){
            baju="Lamp Park Street";
            barang += baju+" \n";
            harga= 70000;
            ttl += harga;
        }if(c31.isSelected()){
            baju="Lamp Street";
            barang += baju+" \n";
            harga= 85000;
            ttl += harga;}
       
        DecimalFormat rph = new DecimalFormat("#,###,##0.00");
       
         try{
            String sql = "INSERT INTO pembelian (`username`, `barang`, `total`) VALUES ('"+nm+"','"+barang+"','"+rph.format(ttl)+"')";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Buy Succes");
         }  catch(Exception e){
              JOptionPane.showMessageDialog(null, e.getMessage());
         }
         }else{
            JOptionPane.showMessageDialog(null, "Not Thing Selected !");
        }
         
        }
    

   

    @FXML
    private void home(MouseEvent event) {
       
        try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("kategori.fxml"));
            Parent root = (Parent) loader.load();
           
            KategoriController fxml2Controller = loader.getController();
          
            fxml2Controller.myFunction(namatuki.getText());
           ((Node)(event.getSource())).getScene().getWindow().hide();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();      
            
        } catch (IOException e) {
            System.out.println("Failed to go home ! " + e.getMessage());
        }
    }
    @FXML
    private void hapus(ActionEvent event) {
        c1.setSelected(false);
        c2.setSelected(false);
        c3.setSelected(false);
        c11.setSelected(false);
        c21.setSelected(false);
        c31.setSelected(false);
        total.setText("");
    }

    
    
}
