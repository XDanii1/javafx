package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    Button button11;
    @FXML
    Button button12;
    @FXML
    Button button13;
    @FXML
    Button button21;
    @FXML
    Button button22;
    @FXML
    Button button23;
    @FXML
    Button button31;
    @FXML
    Button button32;
    @FXML
    Button button33;

    boolean nowXorO;
    char[] squareInfo = new char[9];
    short writerStart = 0;

    public void button11Clicked(MouseEvent event) {
        writerXO(0, button11);
    }

    public void button12Clicked(MouseEvent event) {
        writerXO(1, button12);
    }

    public void button13Clicked(MouseEvent event) {
        writerXO(2, button13);
    }

    public void button21Clicked(MouseEvent event) {
        writerXO(3, button21);
    }

    public void button22Clicked(MouseEvent event) {
        writerXO(4, button22);
    }

    public void button23Clicked(MouseEvent event) {
        writerXO(5, button23);
    }

    public void button31Clicked(MouseEvent event) {
        writerXO(6, button31);
    }

    public void button32Clicked(MouseEvent event) {
        writerXO(7, button32);
    }

    public void button33Clicked(MouseEvent event) {
        writerXO(8, button33);
    }

    private void writerXO(int square, Button button) {
        switch (squareInfo[square]) {
            case 'O':
            case 'X':
                break;
            default:
                if (!nowXorO) {
                    button.textProperty().setValue("X");
                    squareInfo[square] = 'X';
                    nowXorO = true;
                    writerStart++;
                    if (writerStart >= 5) {
                        checker("X");
                    }
                } else {
                    button.textProperty().setValue("O");
                    squareInfo[square] = 'O';
                    nowXorO = false;
                    writerStart++;
                    if (writerStart >= 5) {
                        checker("O");
                    }
                }
                break;
        }

    }

    private void checker(String squareInfo) {
        if (button11.textProperty().getValue() == squareInfo && button12.textProperty().getValue() == squareInfo && button13.textProperty().getValue() == squareInfo) {
            win(squareInfo);
        } else if (button21.textProperty().getValue() == squareInfo && button22.textProperty().getValue() == squareInfo && button23.textProperty().getValue() == squareInfo) {
            win(squareInfo);
        } else if (button31.textProperty().getValue() == squareInfo && button32.textProperty().getValue() == squareInfo && button33.textProperty().getValue() == squareInfo) {
            win(squareInfo);
        } else if (button11.textProperty().getValue() == squareInfo && button21.textProperty().getValue() == squareInfo && button31.textProperty().getValue() == squareInfo) {
            win(squareInfo);
        } else if (button12.textProperty().getValue() == squareInfo && button22.textProperty().getValue() == squareInfo && button32.textProperty().getValue() == squareInfo) {
            win(squareInfo);
        } else if (button13.textProperty().getValue() == squareInfo && button23.textProperty().getValue() == squareInfo && button33.textProperty().getValue() == squareInfo) {
            win(squareInfo);
        } else if (button11.textProperty().getValue() == squareInfo && button22.textProperty().getValue() == squareInfo && button33.textProperty().getValue() == squareInfo) {
            win(squareInfo);
        } else if (button13.textProperty().getValue() == squareInfo && button22.textProperty().getValue() == squareInfo && button31.textProperty().getValue() == squareInfo) {
            win(squareInfo);
        }
    }

    private void win(String symbol) {
        button11.textProperty().setValue(">");
        button12.textProperty().setValue(symbol);
        button13.textProperty().setValue("<");
        button21.textProperty().setValue("W");
        button22.textProperty().setValue("O");
        button23.textProperty().setValue("N");
        button31.textProperty().setValue("");
        button32.textProperty().setValue("");
        button33.textProperty().setValue("");
    }
}
