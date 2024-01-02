
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Driver extends Application {

    public static void main(String[] args) {
        launch(args);
        System.out.println ("llll");    }

    @Override
    public void start(Stage Stage) {
        TabPane tabPane = new TabPane();
        Tab mainTab = new Tab("main");
        Button SelectFile = new Button("Select File ");
        Button MangementScreen = new Button("Mangement Screen ");
        Button StatisticsScreen = new Button("Statistics Screen");
        Button SaveScreen = new Button("Save Screen ");
        Tab Mangement = new Tab("Mangement Screen ");
        Tab Statistics = new Tab("Statistics Screen:  ");
        Tab Save = new Tab("Save Screen ");
        Mangement.setStyle("-fx-background-color: Gray;");
        Statistics.setStyle("-fx-background-color: Gray;");
        Save.setStyle("-fx-background-color: Gray;");
        HBox hbox1 = new HBox(10);
        hbox1.setAlignment(Pos.BOTTOM_CENTER);
        hbox1.getChildren().addAll(SelectFile, MangementScreen, StatisticsScreen, SaveScreen);
        BorderPane borderpane = new BorderPane();
        borderpane.setBottom(hbox1); // but hbox that have the button in the buttom of border pane
        StackPane StackPane = new StackPane();
        Label Label = new Label(" Elictricity  System  ");
        Label.setFont(Font.font("times new Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
        Label.setTextFill(Color.RED);
        HBox hbox2 = new HBox(10);
        hbox2.setAlignment(Pos.TOP_CENTER);
        StackPane.getChildren().add(Label);
        Label Label2 = new Label("  إن الله بصيرا بالعباد ");
        Label2.setFont(Font.font("times new Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
        hbox2.getChildren().add(Label2);
        borderpane.setTop(hbox2);
        borderpane.setCenter(StackPane);
        mainTab.setContent(borderpane);
        mainTab.setStyle("-fx-background-color: red;");
        tabPane.getTabs().addAll(mainTab, Mangement, Statistics, Save);
        // Mangement tab
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Labels
        String[] labels = { "Date", "Israeli Lines MWs", "Gaza Power Plant MWs", "Egyptian Lines MWs",
                "Total daily Supply available in MWs", "Overall demand in MWs", "Power Cuts hours/day (400mg)",
                "Temp" };
        // Controls
        Control[] controls = new Control[labels.length];

        for (int i = 0; i < labels.length; i++) {
            Label label = new Label(labels[i]);
            Control control;

            if (labels[i].equals("Date")) {
                // Use a DatePicker for the "Date" field
                DatePicker datePicker = new DatePicker();
                control = datePicker;
            } else {
                // Use a regular TextField for other fields
                TextField textField = new TextField();
                control = textField;
            }

            Button insert = new Button("insert"); // button insert
            Button delete = new Button("delete "); // button delete
            Button search = new Button("search "); // button search
            Button update = new Button("update "); // button update
            HBox hbox3 = new HBox(10);
            hbox3.setAlignment(Pos.TOP_CENTER);
            hbox3.getChildren().addAll(insert, delete, search, update);

            gridPane.add(label, 0, i);
            gridPane.add(control, 1, i);
            gridPane.add(hbox3, 0, labels.length + 1);
            controls[i] = control;
        }

        // Add a button to demonstrate retrieving values
        Button getValueButton = new Button("Get Values");
        getValueButton.setOnAction(e -> {
            // Retrieve and print the values of each Control
            for (int i = 0; i < controls.length; i++) {
                String label = labels[i];
                String value;

                if (controls[i] instanceof DatePicker) {
                    // For DatePicker, get the selected date
                    value = ((DatePicker) controls[i]).getValue().toString();
                } else {
                    // For other Controls, get the text
                    value = ((Labeled) controls[i]).getText();
                }
                System.out.println(label + ": " + value);
            }
        });
        Mangement.setContent(gridPane);
        // statistic tab

        HBox hbox4 = new HBox(20);
        hbox4.setPadding(new Insets(20, 20, 20, 20));
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton yearRadioButton = new RadioButton("Year");
        yearRadioButton.setToggleGroup(toggleGroup);
        RadioButton monthRadioButton = new RadioButton("Month");
        monthRadioButton.setToggleGroup(toggleGroup);
        RadioButton dayRadioButton = new RadioButton("Day");
        dayRadioButton.setToggleGroup(toggleGroup);
        RadioButton alldataRadioButton = new RadioButton("All the data");
        alldataRadioButton.setToggleGroup(toggleGroup);
        hbox4.getChildren().addAll(yearRadioButton, monthRadioButton, dayRadioButton, alldataRadioButton);
        // Statistics tab
        Label l1 = new Label(" year ");
        Label l2 = new Label(" column ");
        Label l3 = new Label(" month ");
        Label l4 = new Label(" Day ");
        l3.setFont(Font.font("times new Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        l3.setTextFill(Color.BLACK);
        l3.setVisible(false);
        l4.setFont(Font.font("times new Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        l4.setTextFill(Color.BLACK);
        l4.setVisible(false);
        ComboBox<Integer> yearComboBox = new ComboBox<>(
                FXCollections.observableArrayList(2017, 2018, 2019, 2020, 2021, 2022, 2023));
        yearComboBox.setVisible(false);
        yearComboBox.setDisable(true); // Initially disabled until "Year" radio button is selected
        ComboBox<String> columnsComboBox = new ComboBox<>(FXCollections.observableArrayList("Date", "Israeli Lines MWs",
                "Gaza Power Plant MWs", "Egyptian Lines MWs", "Total daily Supply available in MWs",
                "Overall demand in MWs", "Power Cuts hours/day (400mg)", "Temp"));
        columnsComboBox.setDisable(true);
        columnsComboBox.setVisible(false);
        yearRadioButton.setOnAction(event -> {
            yearComboBox.setDisable(false);
            columnsComboBox.setDisable(false);
            l1.setVisible(true);
            l2.setVisible(true);
            l3.setVisible(false);
            l4.setVisible(false);
            yearComboBox.setVisible(true);
            columnsComboBox.setVisible(true);
        });
        columnsComboBox.setOnAction(event -> {
            yearComboBox.setDisable(true);
            columnsComboBox.setDisable(true);
        });
        ComboBox<String> monthComboBox = new ComboBox<>(
                FXCollections.observableArrayList(new DateFormatSymbols().getMonths()));
        monthComboBox.setDisable(true);
        monthComboBox.setVisible(false);
        monthRadioButton.setOnAction(event -> {
            monthComboBox.setDisable(false);
            columnsComboBox.setDisable(false);
            l3.setVisible(true);
            l2.setVisible(true);
            l1.setVisible(false);
            l4.setVisible(false);
            columnsComboBox.setVisible(true);
            yearComboBox.setVisible(false);
            monthComboBox.setVisible(true);
        });
        ComboBox<Integer> DayComboBox = new ComboBox<>(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31));
        DayComboBox.setDisable(true);
        DayComboBox.setVisible(false);
        dayRadioButton.setOnAction(event -> {
            DayComboBox.setDisable(false);
            columnsComboBox.setDisable(false);
            l1.setVisible(false);
            l2.setVisible(true);
            l3.setVisible(false);
            l4.setVisible(true);
            columnsComboBox.setVisible(true);
            yearComboBox.setVisible(false);
            monthComboBox.setVisible(false);
            DayComboBox.setVisible(true);
        });
        alldataRadioButton.setOnAction(event -> {
            l1.setVisible(true);
            l2.setVisible(true);
            l3.setVisible(true);
            l4.setVisible(true);
            columnsComboBox.setVisible(true);
            yearComboBox.setVisible(true);
            monthComboBox.setVisible(true);
            DayComboBox.setVisible(true);
        });
        Button submit = new Button("submit ");
        submit.setStyle("-fx-background-color: #89CFF0;");

        l1.setFont(Font.font("times new Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        l1.setTextFill(Color.BLACK);
        l1.setVisible(false);
        l2.setFont(Font.font("times new Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        l2.setTextFill(Color.BLACK);
        l2.setVisible(false);
        TextField txt1 = new TextField();
        txt1.setPrefColumnCount(5);
        TextField txt2 = new TextField();
        txt2.setPrefColumnCount(5);
        TextField txt3 = new TextField();
        txt3.setPrefColumnCount(5);
        TextField txt4 = new TextField();
        txt4.setPrefColumnCount(5);
        Label ll1 = new Label(" sum ");
        ll1.setFont(Font.font("times new Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        ll1.setTextFill(Color.BLACK);
        Label ll2 = new Label(" average ");
        ll2.setFont(Font.font("times new Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        ll2.setTextFill(Color.BLACK);
        Label ll3 = new Label(" max ");
        ll3.setFont(Font.font("times new Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        ll3.setTextFill(Color.BLACK);
        Label ll4 = new Label(" min ");
        ll4.setFont(Font.font("times new Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        ll4.setTextFill(Color.BLACK);
        HBox hbox5 = new HBox(30);
        hbox5.setAlignment(Pos.BOTTOM_CENTER);
        hbox5.getChildren().addAll(ll1, ll2, ll3, ll4);
        HBox hbox6 = new HBox(10);
        hbox6.setAlignment(Pos.BOTTOM_CENTER);
        hbox6.getChildren().addAll(txt1, txt2, txt3, txt4);
        // GridPane
        GridPane gridPane2 = new GridPane();
        gridPane2.setPadding(new Insets(10, 10, 10, 10));
        gridPane2.setVgap(10);
        gridPane2.setHgap(10);
        gridPane2.add(hbox4, 0, 0);
        gridPane2.add(l1, 0, 3);
        gridPane2.add(l2, 1, 3);
        gridPane2.add(l3, 0, 5);
        gridPane2.add(l4, 0, 7);
        gridPane2.add(submit, 1, 10);
        gridPane2.add(yearComboBox, 0, 4);
        gridPane2.add(columnsComboBox, 1, 4);
        gridPane2.add(monthComboBox, 0, 6);
        gridPane2.add(DayComboBox, 0, 8);
        gridPane2.add(ll1, 0, 12);
        gridPane2.add(ll2, 1, 12);
        gridPane2.add(ll3, 2, 12);
        gridPane2.add(ll4, 3, 12);
        gridPane2.add(txt1, 0, 13);
        gridPane2.add(txt2, 1, 13);
        gridPane2.add(txt3, 2, 13);
        gridPane2.add(txt4, 3, 13);
        Statistics.setContent(gridPane2);
        // save tab
        Button save = new Button("submit ");
        GridPane gridPane3 = new GridPane();
        gridPane3.setPadding(new Insets(10, 10, 10, 10));
        gridPane3.setVgap(10);
        gridPane3.setHgap(10);
        gridPane3.add(save, 2, 2);
        Save.setContent(gridPane3);

        Scene scene = new Scene(tabPane, 600, 700); // but the tabPane that has the all Tab pane in scene
        Stage.setTitle("Elictricity System  "); // set title
        Stage.setScene(scene);
        Stage.show();

        /// change between tabs
        MangementScreen.setOnAction(e -> {
            tabPane.getSelectionModel().select(Mangement);

        });
        StatisticsScreen.setOnAction(e -> {
            tabPane.getSelectionModel().select(Statistics);

        });

        SaveScreen.setOnAction(e -> {
            tabPane.getSelectionModel().select(Save);
        });
        SelectFile.setOnAction(e ->{
            try {
                readFile();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

    }

    public static void readFile() throws FileNotFoundException, IOException {
        JFrame frame = new JFrame("Electricity File");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            SortedLinkedList sortedLinkedList = new SortedLinkedList();
            YearCircularList YearCircularList = new YearCircularList();
            MonthCircularList MonthCircularList = new MonthCircularList();

            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                // Skip the header line
                br.readLine();

                String line;
                while ((line = br.readLine()) != null) {
                    // Split the line into values
                    String[] values = line.split(",");
                    LocalDate date = LocalDate.parse(values[0].trim());
                    Double israeliLines = Double.parseDouble(values[1].trim());
                    Double gazaPowerPlant = Double.parseDouble(values[2].trim());
                    Double egyptianLines = Double.parseDouble(values[3].trim());
                    Double totalSupply = Double.parseDouble(values[4].trim());
                    Double demand = Double.parseDouble(values[5].trim());
                    Double powerCutsHours = Double.parseDouble(values[6].trim());
                    Double temp = Double.parseDouble(values[7].trim());

                    DataRecord record = new DataRecord(date, israeliLines, gazaPowerPlant, egyptianLines, totalSupply,
                            demand, powerCutsHours, temp);
                    int year = date.getYear();
                    int month = date.getMonthValue();

                    YearNode yearNode = YearCircularList.searchYearNode(year);
                    if (!YearCircularList.contains(yearNode)) {
                        YearCircularList.insertSorted(year);
                    }
                    // Check if the month already exists in the list
                    MonthNode monthNode = yearNode.getMonths().searchMonthNode(month);
                    if (!yearNode.getMonths().contains(monthNode)) {
                        yearNode.getMonths().insertSorted(month);
                    }
                    monthNode.getRecords().add(record);
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }

        }

    }
}

    