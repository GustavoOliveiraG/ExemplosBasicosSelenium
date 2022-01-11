import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.xpath;


public class PraticaSelenium {
    WebDriver driver;

/*
Inclusão de dados via variavel;
Comparação se o dado informados era o dado esperado;
*/
    @Test
    public void EntradaDados(){
        String Num1;
        Integer Num2;

        Num1 = "Pera";
        Num2=4;

        Assert.assertEquals(4,2+2);
        Assert.assertTrue(Num1.equals("Pera"));
    }





/*
Abertura do Navegador;
Direcionamento para pagina do Google;
Desafio MODULO II do treinamento;
*/
    @Test
    public void Navegador(){

        driver = new ChromeDriver();
        driver.navigate().to("https://google.com.br");
    }





/*
Abertura do Navegador;
Direcionamento para pagina do Google;
Verificação pelo title da pagina se esta no google;
*/
    @Test
    public void Navegador2(){
        String PagGoogle;
        String NomeTitulo;

        PagGoogle="https://google.com.br";

        driver = new ChromeDriver();
        driver.navigate().to(PagGoogle);

        NomeTitulo = driver.getTitle();

        Assert.assertEquals("Google",NomeTitulo);
    }





/*
Abertura do Navegador;
Direcionamento para pagina do Google;
Busca pela palavra chave;
Validação da busca com pausa para carregamento.
Desafio MODULO II - do trenamento;
*/
    @Test
    public void PesquisaGoogle(){
        String Page;
        String TextBusca;
        String ValidarPage;

        Page = "https://www.google.com.br";
        TextBusca = "Base2";
        ValidarPage = "Base2 Tecnologia";


        driver = new ChromeDriver();
        driver.navigate().to(Page);

        /* Maximizar Janela */
        //driver.manage().window().maximize();

        WebElement Pesquisar = driver.findElement(By.name("q"));
        //Pesquisar.sendKeys(TextBusca + Keys.ENTER);
        Pesquisar.sendKeys(TextBusca);

        /* Pausar Codigo por 2segundos */
        //Thread.sleep(2000);

        WebElement Pesquisa = driver.findElement(xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']"));
        Pesquisa.click();

        WebElement Validar = driver.findElement(xpath("//div[@class='SPZz6b']//span[text()='Base2 Tecnologia']"));
        Assert.assertEquals(ValidarPage,Validar.getText());
    }





/*
Preenchimento do formulario teste
*/
    @Test
    public void PreenchimentoFomrs() throws InterruptedException {
        String Page;
        Page = "https://ultimateqa.com/filling-out-forms/";


        driver = new ChromeDriver();
        driver.navigate().to(Page);

        WebElement EsquerdaNome = driver.findElement(By.xpath("//input[@id='et_pb_contact_name_0']"));
        EsquerdaNome.sendKeys("Joao da Silva");

        WebElement EsquerdaMensagem = driver.findElement(By.xpath("//textarea[@id='et_pb_contact_message_0']"));
        EsquerdaMensagem.sendKeys("Essa é uma mensagem de TESTE");

        WebElement EsquerdaButton = driver.findElement(By.xpath("//div[@id='et_pb_contact_form_0']//button[@name='et_builder_submit_button']"));
        EsquerdaButton.click();

        Thread.sleep(3000);

    }




/*
Preenchimento do campo checkbox
*/
    @Test
    public void SelectBox(){
        String Page;
        Page = "http://the-internet.herokuapp.com/dropdown";

        driver = new ChromeDriver();
        driver.navigate().to(Page);

        //WebElement selectdropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        WebElement selectdropdown = driver.findElement(By.id("dropdown"));
        new Select(selectdropdown).selectByValue("2");
    }




/*
Acessar o site Crowdtest;
Buscar projeto criado;
Verificar se projeto criado confere com chave validada;
*/
    @Test
    public void CasodeTeste() throws InterruptedException {
        String Page;
        Page = "http://blackmirror.crowdtest.me.s3-website-us-east-1.amazonaws.com/auth";

        driver = new ChromeDriver();
        driver.navigate().to(Page);
        driver.manage().window().maximize();

        WebElement Login = driver.findElement(By.id("login"));
        Login.sendKeys("gustavo.gontijo@base2.com.br");

        WebElement Senha = driver.findElement(By.id("password"));
        Senha.sendKeys("Base@2021");

        WebElement FecharMsg = driver.findElement(By.xpath("//a[text()='Prosseguir']"));
        FecharMsg.click();

        WebElement Entrar = driver.findElement(By.xpath("//button[text()='ENTRAR']"));
        Entrar.click();


        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Gerenciar']")));


        WebElement EntrarGerenciar = driver.findElement(By.xpath("//button[text()='Gerenciar']"));
        EntrarGerenciar.click();

        WebElement EntrarProjetos0 = driver.findElement(By.xpath("//a[@href='/projects']"));
        EntrarProjetos0.click();

        Thread.sleep(4000);

        WebElement EntrarProjetoGOG = driver.findElement(By.xpath("//mat-cell[text()='GOG']"));
        EntrarProjetoGOG.click();

       WebElement casosTeste = driver.findElement(By.xpath("//div[text()='Casos de Teste']"));
       casosTeste.click();

        Thread.sleep(4000);

        WebElement Validar = driver.findElement(By.xpath("//mat-cell[text()='Cadastro de Release']"));
        Assert.assertEquals("Cadastro de Release",Validar.getText());

        driver.close();
    }





}
