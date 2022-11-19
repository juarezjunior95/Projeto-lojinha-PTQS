package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver navegador;

    public LoginPage(WebDriver navegador) {
        this.navegador = navegador;
    }
    public LoginPage informarOusuario(String usuario) {
        navegador.findElement(By.cssSelector("label[for='usuario'")).click();
        navegador.findElement(By.id("usuario")).sendKeys(usuario);


        return this;
    }
    public LoginPage informarAsenha (String senha){
        navegador.findElement(By.cssSelector("label[for='senha'")).click();
        navegador.findElement(By.id("senha")).sendKeys(senha);

        return this;
    }
    public ListadeProdutosPage SubmeterformulariodeLogin(){
        navegador.findElement(By.xpath("//button[@class='btn waves-effect waves-light'][contains(.,'Entrar')]")).click();
        return new ListadeProdutosPage(navegador);
    }
}
