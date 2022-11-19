package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.time.Duration;

@DisplayName("Testes Web do modulo de proudutos")
public class ProdutosTest {
    private  WebDriver  navegador;


    @BeforeEach
    public void beforeEach(){
        //Abrir o navgador
        System.setProperty("webdriver.chrome.driver.com" ,"\"C:\\chromedriver.exe\"");
        this.navegador= new ChromeDriver();

        //Navegar para pagina da lojinha Web
        this.navegador.manage().window().maximize();
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");
        //time out
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @Test
    @DisplayName("Não é permitido registrar um produto com valor igual a 0")
    public void testNaoPermitidoRegistrarProdutoComValorIgual0(){

        //Fazer login
        String mensagemToast = new LoginPage(navegador)
                .informarOusuario("admin")
                .informarAsenha("admin")
                .SubmeterformulariodeLogin()
                .AcessarFormularioDeAdicao()
                .InformardoProduto("Iphone 14 Max Golder")
                .InformardoValorDoPrdouto("000")
                .InformarAcorDoProduto("Golden")
                .SubmterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();


















        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00" ,mensagemToast);

    }

    @Test
    @DisplayName("Testes web para valor acima de 7000")
    public void NaoPermitidoRegistrarProdutoComValorMaiorque7000(){

        String mensagemToast = new LoginPage(navegador)
                .informarOusuario("admin")
                .informarAsenha("admin")
                .SubmeterformulariodeLogin()
                .AcessarFormularioDeAdicao()
                .InformardoProduto("Mac book ultra pro")
                .InformardoValorDoPrdouto("7000001")
                .InformarAcorDoProduto("White")
                .SubmterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();




        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00" ,mensagemToast);



    }
    @AfterEach
    public  void afterEach(){
        navegador.quit();
    }

}
