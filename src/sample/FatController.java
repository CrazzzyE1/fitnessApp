package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;


public class FatController {

    @FXML
    private TextField fatAge;

    @FXML
    private RadioButton fatRadioMaleButton;

    @FXML
    private RadioButton fatRadioFemaleButton;

    @FXML
    private TextField fatNeck;

    @FXML
    private TextField fatWeight;

    @FXML
    private TextField fatWaist;


    @FXML
    private TextField fatHip;

    @FXML
    private TextField fatHeight;

    @FXML
    private Button fatCalcButton;

    @FXML
    private Button fatClearButton;

    @FXML
    private TextArea fTextArea;

    @FXML
    void initialize() {
        ToggleGroup tg = new ToggleGroup();
        fatRadioFemaleButton.setToggleGroup(tg);
        fatRadioMaleButton.setToggleGroup(tg);
        Text text = new Text();

        fatClearButton.setOnAction(event -> {
            fatRadioFemaleButton.setSelected(true);
            fatHip.setVisible(true);
            clean();
            fTextArea.setVisible(false);
        });

        fatRadioFemaleButton.setOnAction(event -> {
            fatHip.setVisible(true);
        });

        fatRadioMaleButton.setOnAction(event -> {
            fatHip.setVisible(false);
        });

        fatCalcButton.setOnAction(event -> {
            text.setText("");
            fTextArea.setText(text.getText());
            int fAge;
            double fWeight;
            double fHeight;
            double fNeck;
            double fWaist;
            try {
                fAge = Integer.parseInt(fatAge.getText());
            } catch (Exception e) {
                fatAge.setStyle("-fx-border-color: #f00; -fx-border-radius: 50; -fx-background-radius: 50;");
                fatAge.setText("Wrong age");
                return;
            }
            fatAge.setStyle("-fx-border-color: #212121; -fx-border-radius: 50; -fx-background-radius: 50;");

            try {
                fWeight = Double.parseDouble(fatWeight.getText());
            } catch (Exception e) {
                fatWeight.setStyle("-fx-border-color: #f00; -fx-border-radius: 50; -fx-background-radius: 50;");
                fatWeight.setText("Wrong weight");
                return;
            }
            fatWeight.setStyle("-fx-border-color: #212121; -fx-border-radius: 50; -fx-background-radius: 50;");
            try {
                fHeight = Double.parseDouble(fatHeight.getText());
            } catch (Exception e) {
                fatHeight.setStyle("-fx-border-color: #f00; -fx-border-radius: 50; -fx-background-radius: 50;");
                fatHeight.setText("Wrong height");
                return;
            }
            fatHeight.setStyle("-fx-border-color: #212121; -fx-border-radius: 50; -fx-background-radius: 50;");
            try {
                fNeck = Double.parseDouble(fatNeck.getText());
            } catch (Exception e) {
                fatNeck.setStyle("-fx-border-color: #f00; -fx-border-radius: 50; -fx-background-radius: 50;");
                fatNeck.setText("Wrong neck");
                return;
            }
            fatNeck.setStyle("-fx-border-color: #212121; -fx-border-radius: 50; -fx-background-radius: 50;");
            try {
                fWaist = Double.parseDouble(fatWaist.getText());
            } catch (Exception e) {
                fatWaist.setStyle("-fx-border-color: #f00; -fx-border-radius: 50; -fx-background-radius: 50;");
                fatWaist.setText("Wrong waist");
                return;
            }
            fatWaist.setStyle("-fx-border-color: #212121; -fx-border-radius: 50; -fx-background-radius: 50;");

            if (fatRadioFemaleButton.isSelected()) {
                double fHip;
                try {
                    fHip = Double.parseDouble(fatHip.getText());
                } catch (Exception e) {
                    fatHip.setStyle("-fx-border-color: #f00; -fx-border-radius: 50; -fx-background-radius: 50;");
                    fatHip.setText("Wrong hip");
                    return;
                }
                fatHip.setStyle("-fx-border-color: #212121; -fx-border-radius: 50; -fx-background-radius: 50;");
                double bfpFemale = 495 / (1.29579 - 0.35004 * Math.log10(fWaist + fHip - fNeck)
                        + 0.22100 * Math.log10(fHeight)) - 450;
                double bfMassFemale = bfpFemale * fWeight / 100;
                double leanMassFemale = fWeight - bfMassFemale;
                double idealWeight = (fHeight * 3.5 / 2.54 - 108) * 0.453;
                double bmr = 10 * fWeight + 6.25 * fHeight - 5 * fAge - 161;
                String fbodyFatCategory;

                if (bfpFemale >= 0 && bfpFemale < 13) {
                    fbodyFatCategory = "Essential fat";
                } else if (bfpFemale >= 13 && bfpFemale < 20) {
                    fbodyFatCategory = "Athletes";
                } else if (bfpFemale >= 20 && bfpFemale < 24) {
                    fbodyFatCategory = "Fitness";
                } else if (bfpFemale >= 24 && bfpFemale < 31) {
                    fbodyFatCategory = "Average";
                } else {
                    fbodyFatCategory = "Obese";
                }
                text.setText("Body Fat (U.S. Navy Method): " + String.format("%.1f", bfpFemale) + "%" + "\n" +
                        "Body Fat Category: " + fbodyFatCategory + "\n" +
                        "Body Fat Mass: " + String.format("%.1f", bfMassFemale) + " kgs \n" +
                        "Lean Body Mass: " + String.format("%.1f", leanMassFemale) + " kgs \n" +
                        "Ideal Weight: " + String.format("%.1f", idealWeight) + " kgs\n" +
                        "Basal Metabolic Rate: " + String.format("%.0f", bmr) + " Calories/day \n");

            } else {
                double bfpMale = 495 / (1.0324 - 0.19077 * Math.log10(fWaist - fNeck) +
                        0.15456 * Math.log10(fHeight)) - 450;
                double bfMassMale = bfpMale * fWeight / 100;
                double leanMassMale = fWeight - bfMassMale;
                String fbodyFatCategory;
                double bmr = 10 * fWeight + 6.25 * fHeight - 5 * fAge + 5;
                double idealWeight = (fHeight * 4 / 2.54 - 128) * 0.453;

                if (bfpMale >= 0 && bfpMale < 5) {
                    fbodyFatCategory = "Essential fat";

                } else if (bfpMale >= 5 && bfpMale < 13) {
                    fbodyFatCategory = "Athletes";
                } else if (bfpMale >= 13 && bfpMale < 17) {
                    fbodyFatCategory = "Fitness";
                } else if (bfpMale >= 17 && bfpMale < 25) {
                    fbodyFatCategory = "Average";
                } else {
                    fbodyFatCategory = "Obese";
                }
                text.setText("Body Fat (U.S. Navy Method): " + String.format("%.1f", bfpMale) + "%" + "\n" +
                        "Body Fat Category: " + fbodyFatCategory + "\n" +
                        "Body Fat Mass: " + String.format("%.1f", bfMassMale) + " kgs \n" +
                        "Lean Body Mass: " + String.format("%.1f", leanMassMale) + " kgs \n" +
                        "Ideal Weight: " + String.format("%.1f", idealWeight) + " kgs\n" +
                        "Basal Metabolic Rate: " + String.format("%.0f", bmr) + " Calories/day \n");

            }

            fTextArea.appendText(text.getText());
            fTextArea.setVisible(true);
        });
    }

    void clean() {

        fatAge.setText("");
        fatWeight.setText("");
        fatHeight.setText("");
        fatNeck.setText("");
        fatWaist.setText("");
        fatHip.setText("");

    }
}
