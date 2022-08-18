/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package calculadora_tarea3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Noé Sosa
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button buttonLimpiar;
    @FXML
    private Button buttonBorrar;
    @FXML
    private Button buttonNegative;
    @FXML
    private Button buttonPorcentaje;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button buttonDividir;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button buttonMultiplicar;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button buttonRestar;
    @FXML
    private Button button0;
    @FXML
    private Button buttonComa;
    @FXML
    private Button buttonSumar;
    @FXML
    private TextField textfieldPantalla ;
    private boolean bandera = false;
    private boolean punto = false;
    private double numero1;
    private double numero2;
    private double resultado = 0;
    private String operador;
    private int numOperandos = 0;
    private boolean espia = false;
    private boolean entra = false;
    private boolean respuesta = false;
    private String operador1;
    private boolean b = false;
    @FXML
    private Button buttonIgual;
        
    @FXML
    private void cero(ActionEvent event) {
        mostrar("0");
        if(entra == true){
            terminado();
        }
    }
    
    @FXML
    private void uno(ActionEvent event) {
        mostrar("1");
        if(entra == true){
            terminado();
        }
    }
    @FXML
    private void dos(ActionEvent event) {
        mostrar("2");
        if(entra == true){
            terminado();
        }
        
    }
    @FXML
    private void tres(ActionEvent event) {
        mostrar("3");
        if(entra == true){
            terminado();
        }
    }
    @FXML
    private void cuatro(ActionEvent event) {
        mostrar("4");
    }
    @FXML
    private void cinco(ActionEvent event) {
        mostrar("5");
        if(entra == true){
            terminado();
        }
    }
    @FXML
    private void seis(ActionEvent event) {
        mostrar("6");
        if(entra == true){
            terminado();
        }
    }
    @FXML
    private void siete(ActionEvent event) {
        mostrar("7");
        if(entra == true){
            terminado();
        }
    }
    @FXML
    private void ocho(ActionEvent event) {
        mostrar("8");
        if(entra == true){
            terminado();
        }
    }
    @FXML
    private void nueve(ActionEvent event) {
        mostrar("9");
        if(entra == true){
            terminado();
        }
    }
    @FXML
    private void sumar(ActionEvent event) {
        mostrar("+");
        operaciones("+");
 
    }
    @FXML
    private void restar(ActionEvent event) {
        mostrar("-");
        operaciones("-");
    }
    @FXML
    private void dividir(ActionEvent event) {
        mostrar("/");
        operaciones("/");
    }
    @FXML
    private void multi(ActionEvent event) {
        mostrar("*");
        operaciones("*");
    }
    
    @FXML
    private void porcentaje(ActionEvent event) {
        mostrar("%");
        resulPorcentaje();
        if ( b == true){
            resultado = (numero1 * numero2)/100;
            textfieldPantalla.setText(String.valueOf(resultado));
        }
        
        bandera = true;
    }

    @FXML
    private void punto(ActionEvent event) {
        
        if(!bandera && !punto){
            textfieldPantalla.setText("0.");
            bandera = true;
        }else if(!punto){
            String valor = textfieldPantalla.getText();
            valor = textfieldPantalla.getText().concat(".");
            textfieldPantalla.setText(valor);
        }
        punto = true;
    }
    
    @FXML
    private void limpiarPantalla(ActionEvent event){
        textfieldPantalla.clear();
    }
    
    @FXML
    private void Delete(){
        if ( !(textfieldPantalla.getText().length() == 0)){
            textfieldPantalla.setText(textfieldPantalla.getText().substring( 0,textfieldPantalla.getText().length() -1 ) );
        }
    }
    private void resulPorcentaje(){
        
        String aver = textfieldPantalla.getText();
        if(  aver.substring(aver.length()-1, aver.length()).equals("%")  ){
            b =  true;
        }else{
            b =  false;
        }
    }

    @FXML 
    private void resultNegative(){
        //Pasamos a negativo lo de la pantalla
        String s = textfieldPantalla.getText();
        double num = Double.parseDouble(s);
        num = num*-1;
        textfieldPantalla.setText(String.valueOf(num));
        
    }
    private void mostrar(String num){
        
        if(!bandera && num.equals("0")){
            return;
        }
        
        //---OBTENGO EL VALOR PARA CONCATENARLO DE NUEVO AL CLICKEAR DE NUEVO---
        String valor = textfieldPantalla.getText();
        valor = textfieldPantalla.getText().concat(num);
        
        textfieldPantalla.setText(valor);
        bandera = true; //--> SERVIRÁ PARA CONTAR CUANDO SE PRESIONE EL MOSTRAR
        respuesta = true;
        if(respuesta == true){
            numOperandos++;
        }
        if (espia == true){
            entra = true;
        }
    }
    
    private void operaciones(String operador){
        operador1 = operador;
        //Esta funcion yo la veo solo como espia 
        espia = true;
    }
    
    private void terminado(){
        int posicion = 0;
        
        if(espia = true){
            //AQUI HAGO UN RECORRIDO DE LA CADENA PARA OBTENER LUEGO LOS VALORES
            String recorrido2 = textfieldPantalla.getText();
            for(int i=0; i<recorrido2.length();i++){
                char letra = recorrido2.charAt(i);
                String aux = String.valueOf(letra);
                if( aux.equals("+") || aux.equals("-") || aux.equals("*") || aux.equals("/") ){
                    posicion = i;
                }
            }
            
            //obtencion del numero 1
            String number1 = recorrido2.substring(0,posicion);
            numero1 = Double.parseDouble(number1);
            
            //-----obtencion del numero 2
            String auxiliar = recorrido2.substring(posicion+1);
            numero2 = Double.parseDouble(auxiliar);
            
            switch(operador1){
                case "+":
                    resultado = numero1 + numero2;
                    break;
                case "-":
                    resultado = numero1 - numero2;
                    break;
                case "*":
                    resultado = numero1 * numero2;
                    break;
                case "/":
                    //ESTO ES PARA EVITAR QUE EL USUARIO HAGA UNA DIVISIÓN ENTRE 0
                        resultado = numero1 / numero2;
                    break;
            }         
            punto = false;        
            numOperandos = 0;
            entra = false;
            espia = false;
        
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void igual(ActionEvent event) {
        terminado();
        if(numero2 == 0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Esta tratando de dividir entre 0");
            alert.showAndWait();
            resultado = 0;
            textfieldPantalla.clear();
        }else{
            textfieldPantalla.clear();
            textfieldPantalla.setText(String.valueOf(resultado));
        }
        
    }
    
}
