import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LiquidSoapViewController implements Initializable {

    @FXML
    private ChoiceBox<LiquidSoap> choiceBox;

    @FXML
    private Label brandLabel;

    @FXML
    private Label intendedUseLabel;

    @FXML
    private Label volumeLabel;

    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<LiquidSoap> soap = choiceBox.getItems();
        soap.add(new LiquidSoap("Palmolive", "Dish", 887, new Image("palmolive.jpg")));
        soap.add(new LiquidSoap("Dawn", "Dish", 8000, new Image("dawn.jpg")));
        soap.add(new LiquidSoap("Meyers", "Hand", 370, new Image("meyers.jpg")));
        soap.add(new LiquidSoap("Soft Soap", "Hand", 236, new Image("Softsoap.jpg")));
        soap.add(new LiquidSoap("Murphys", "Floor", 473, new Image("murphys.jpg")));

        //Add a change listener
        choiceBox.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> updateViewWithSelectedSoap());

        choiceBox.setValue(choiceBox.getItems().get(0));
        updateViewWithSelectedSoap();
    }

    public void updateViewWithSelectedSoap()
    {
        LiquidSoap soap = choiceBox.getValue();
        brandLabel.setText(soap.getBrand());
        intendedUseLabel.setText(soap.getIntendedUse());
        volumeLabel.setText(Integer.toString(soap.getVolume()));
        imageView.setImage(soap.getImage());
    }

    public void changeToWeekendScene(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "WeekendView.fxml","Wahoo-the weekend");
    }
}
