package edu.badpals.proyectoud1_mcrecipes.controlls;

import com.fasterxml.jackson.databind.JsonNode;
import edu.badpals.proyectoud1_mcrecipes.consultas.ApiRequest;
import edu.badpals.proyectoud1_mcrecipes.consultas.MapeoJson;
import edu.badpals.proyectoud1_mcrecipes.objetos.Item;
import edu.badpals.proyectoud1_mcrecipes.objetos.Recipe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class MainController {

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtRecip;

    @FXML
    private ImageView imgArrow;

    @FXML
    private ImageView imgRecip;

    @FXML
    private ImageView imgTopCenter;

    @FXML
    private ImageView imgTopLeft;

    @FXML
    private ImageView imgTopRight;

    @FXML
    private ImageView imgbotton;

    @FXML
    private ImageView imgbottonleft;

    @FXML
    private ImageView imgbottonright;

    @FXML
    private ImageView imgcenter;

    @FXML
    private ImageView imgmidleft;

    @FXML
    private ImageView imgmidright;

    @FXML
    void btnClicked(ActionEvent event) {

        try {

            // Meterle una imagen o algo que indique que se está cargando

            ApiRequest.setItem(getTxtRecip());
            Recipe recipe = MapeoJson.mapingRecipes()[0];

            ArrayList<String> itemsSearch = new ArrayList<>();
            itemsSearch.add(recipe.getItem());

            for (JsonNode item : recipe.getRecipe()) {
                itemsSearch.add(item.toString().replace("\"", ""));
            }

            ArrayList<String> itemsImg = new ArrayList<>();
            for (String item : itemsSearch) {
                if (!item.equals("null")) {
                    ApiRequest.setItem(item);
                    Item itemtoSearch = MapeoJson.mapingItems()[0];
                    itemsImg.add(itemtoSearch.getImage());
                } else {
                    itemsImg.add("https://minecraft-api.vercel.app/images/blocks/air.png");
                }
            }

            setImgRecip(itemsImg.get(0));
            setImgArrow();
            setImgTopLeft(itemsImg.get(1));
            setImgTopCenter(itemsImg.get(2));
            setImgTopRight(itemsImg.get(3));
            setImgmidleft(itemsImg.get(4));
            setImgcenter(itemsImg.get(5));
            setImgmidright(itemsImg.get(6));
            setImgbottonleft(itemsImg.get(7));
            setImgbotton(itemsImg.get(8));
            setImgbottonright(itemsImg.get(9));

            // Parar la imagen de carga

        } catch (Exception e) {
            setTxtRecip("Nombre no válido");
        }
    }

    @FXML
    void btnSalirclicked(ActionEvent event) {
        /*try {
            // Cargar el archivo FXML de la nueva escena
            Parent newSceneParent = FXMLLoader.load(getClass().getResource("/loginscene.fxml"));

            // Crear una nueva escena
            Scene newScene = new Scene(newSceneParent);

            // Obtener el escenario actual y establecer la nueva escena
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);

        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void setTxtRecip(String text) {
        this.txtRecip.setText(text);
    }

    public String getTxtRecip() {
        return txtRecip.getText();
    }

    public ImageView getImgRecip() {
        return imgRecip;
    }

    public void setImgRecip(String url) {
        this.imgRecip = imgRecip;
        imgRecip.setImage(new Image(url));
    }

    public void setImgArrow() {
        Image image = new Image("/flecha.png");
        this.imgArrow.setImage(image);
    }

    public void setImgTopCenter(String url) {
        Image image = new Image(url);
        this.imgTopCenter.setImage(image);
    }

    public void setImgTopLeft(String url) {
        Image image = new Image(url);
        this.imgTopLeft.setImage(image);
    }

    public void setImgTopRight(String url) {
        Image image = new Image(url);
        this.imgTopRight.setImage(image);
    }

    public void setImgbotton(String url) {
        Image image = new Image(url);
        this.imgbotton.setImage(image);
    }

    public void setImgbottonleft(String url) {
        Image image = new Image(url);
        this.imgbottonleft.setImage(image);
    }

    public void setImgbottonright(String url) {
        Image image = new Image(url);
        this.imgbottonright.setImage(image);
    }

    public void setImgmidright(String url) {
        Image image = new Image(url);
        this.imgmidright.setImage(image);
    }

    public void setImgmidleft(String url) {
        Image image = new Image(url);
        this.imgmidleft.setImage(image);
    }

    public void setImgcenter(String url) {
        Image image = new Image(url);
        this.imgcenter.setImage(image);
    }
}
