package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListadeProdutosPage {
    private WebDriver navegador;
    public ListadeProdutosPage(WebDriver navegador){
        this.navegador = navegador;
    }
   public  FormularioAdicaodeProdutoPAge AcessarFormularioDeAdicao(){
       navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

       return new FormularioAdicaodeProdutoPAge(navegador);


   }
    public String capturarMensagemApresentada(){
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
