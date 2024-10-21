package edu.badpals.proyectoud1_mcrecipes.controlls;

import com.fasterxml.jackson.databind.JsonNode;
import edu.badpals.proyectoud1_mcrecipes.cargar.Cache;
import edu.badpals.proyectoud1_mcrecipes.cargar.LoadLastOne;
import edu.badpals.proyectoud1_mcrecipes.cargar.SaveState;
import edu.badpals.proyectoud1_mcrecipes.consultas.ApiRequest;
import edu.badpals.proyectoud1_mcrecipes.consultas.MapeoJson;
import edu.badpals.proyectoud1_mcrecipes.objetos.Item;
import edu.badpals.proyectoud1_mcrecipes.objetos.Recipe;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class MainController {

    private static ArrayList<String> itemsSearched = new ArrayList<>();

    @FXML
    private SplitMenuButton tlbExportar;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnRecuperar;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField txtRecip;

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
    private TextField txtNomFich;

    /*

    btnLoginClicked(ActionEvent event) usa varios métodos ya creados en otros paquetes

     */

    @FXML
    void btnClicked(ActionEvent event) {

        try {

            if (Cache.existsCache(getTxtRecip())) {

                ArrayList<String> itemsImg = Cache.loadCache(getTxtRecip());
                itemsImg.removeFirst();
                setItemsSearched(itemsImg);
                setAllImages(itemsImg);

            } else {

                ApiRequest.setItem(getTxtRecip());
                Recipe[] recipes = MapeoJson.mapingRecipes();
                Integer num = MapeoJson.getCorrectCraft(recipes);

                Recipe recipe = recipes[num];

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

                setItemsSearched(itemsImg);

                setAllImages(itemsImg);

                Cache.saveFileCache(itemsImg, getTxtRecip());

            }

        } catch (Exception e) {
            setTxtRecip("Nombre no válido");
        }
    }

    /*
    * Botón que al ser presionado llama al método loadState() de la clase SaveState
     */

    @FXML
    void btnRecuperarClicked(ActionEvent event) {
        try {
            ArrayList<String> loadInfo = SaveState.loadState();
            setTxtRecip(loadInfo.getFirst());
            loadInfo.removeFirst();
            setAllImages(loadInfo);
        } catch (Exception e) {
            System.out.println("No se pudo recuperar el estado, porque no has buscado nada anteriormente");
        }
    }

    /*
    * Botón que al ser presionado cierra la ventana actual y guarda el estado actual
     */

    @FXML
    void btnSalirclicked(ActionEvent event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
        SaveState.saveLastState(getTxtRecip());
    }

    public void setTxtRecip(String text) {
        this.txtRecip.setText(text);
    }

    private MenuItem createMenuItem(String text, EventHandler<ActionEvent> event) {
        MenuItem menuItem = new MenuItem(text);
        menuItem.setOnAction(event);
        return menuItem;
    }

    /*
    * Método que inicializa el menú de exportación
     */

    @FXML
    public void initialize() {
        try {
            getTlbExportar().getItems().clear();
            getTlbExportar().getItems().addAll(
                    createMenuItem("Exportar a JSON", event -> {
                        try {
                            LoadLastOne.saveJson(getTxtRecip(), getTxtNomFich());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }),

                    createMenuItem("Exportar a XML", event -> {
                        try {
                            LoadLastOne.saveXML(getTxtRecip(), getTxtNomFich());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }),

                    createMenuItem("Exportar a TXT", event -> {
                        try {
                            LoadLastOne.saveTxt(getTxtRecip(), getTxtNomFich());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }),

                    createMenuItem("Exportar a BIN", event -> {
                        try {
                            LoadLastOne.saveBin(getTxtRecip(), getTxtNomFich());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }));
        } catch (Exception e){
            System.out.println("El archivo no se pudo exportar o ya existe");
        }
    }

    public String getTxtNomFich() {
        return txtNomFich.getText();
    }

    public static ArrayList<String> getItemsSearched() {
        return itemsSearched;
    }

    public void setItemsSearched(ArrayList<String> itemsSearched) {
        MainController.itemsSearched = itemsSearched;
    }

    public SplitMenuButton getTlbExportar() {
        return tlbExportar;
    }

    public String getTxtRecip() {
        return txtRecip.getText();
    }

    public void setImgRecip(String url) {
        Image image = new Image(url);
        this.imgRecip.setImage(image);
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

    /*
    * Método que recibe un ArrayList de Strings con las urls de las imágenes y las asigna a las variables de la clase
     */

    public void setAllImages(ArrayList<String> urls) {
        setImgRecip(urls.get(0));
        setImgTopLeft(urls.get(1));
        setImgTopCenter(urls.get(2));
        setImgTopRight(urls.get(3));
        setImgmidleft(urls.get(4));
        setImgcenter(urls.get(5));
        setImgmidright(urls.get(6));
        setImgbottonleft(urls.get(7));
        setImgbotton(urls.get(8));
        setImgbottonright(urls.get(9));
    }
}