import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

	public static void main(String[] args) throws Exception {
//		Diferentes API para serem consumidas:

//		String url = "https://imdb-api.com/en/API/Top250Movies/k_9pgylnim";
//		ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

//		String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
//		ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa(); 

		String url = "http://localhost:8080/linguagens";
		ExtratorDeConteudoDoIMDB extrator = new ExtratorDeConteudoDoIMDB();

		var http = new ClienteHttp();
		String json = http.buscaDados(url);

//		 exibindo e manipulando os dados
		List<Conteudo> conteudos = extrator.extraiConteudo(json);

		var geradora = new GeradoraDeFigurinhas();

//		 o tamanho do for será a quantidade de itens da Lista/Json que estamos usando:
		for (int i = 0; i < 3; i++) {

			Conteudo conteudo = conteudos.get(i);

			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo = "saida/" + conteudo.getTitulo().replace(":", "-") + ".png";

			geradora.cria(inputStream, nomeArquivo);

			System.out.println(conteudo.getTitulo());
			System.out.println();
		}
	}
}