package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioAdicaodeProdutoPAge {
    private WebDriver navegador;
    public FormularioAdicaodeProdutoPAge(WebDriver navegador){
        this.navegador = navegador;

    }
    public FormularioAdicaodeProdutoPAge InformardoProduto(String produtoNome){
        navegador.findElement(By.id("produtonome")).sendKeys(produtoNome);
        return this;
    }

    public FormularioAdicaodeProdutoPAge InformardoValorDoPrdouto(String produtoValor){
        navegador.findElement(By.name("produtovalor")).sendKeys(produtoValor);
        return this;

    }
    public FormularioAdicaodeProdutoPAge InformarAcorDoProduto(String CorDoProduto){
        navegador.findElement(By.id("produtocores")).sendKeys(CorDoProduto);
        return this;

    }
    public ListadeProdutosPage SubmterFormularioDeAdicaoComErro(){
        navegador.findElement(By.xpath("//button[@class='btn waves-effect waves-light'][contains(.,'Salvar')]")).click();
        return  new ListadeProdutosPage(navegador);
    }

}

