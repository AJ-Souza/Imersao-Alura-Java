import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
	
	public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
		// leitura da imagem, 
			//aqui pegaria de um arquivo: 
				//InputStream inputStream = new FileInputStream("entrada/filmeMaior.jpg");
			// aqui pegaria de uma URL:
				//InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
			BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		// cria nova imagem em memoria com transparencia e com novo tamanho
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		// copiar a imagem original para nova imagem (em memoria)
		Graphics2D graphics = (Graphics2D)novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		// configura a fonte do texto a ser escrito na imagem
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		graphics.setColor(Color.YELLOW);
		graphics.setFont(fonte);
		
		
		// escrever uma frase na nova imagem
		graphics.drawString("TOPZERA", 187, novaAltura - 100);
		
		
		// escrever a nova imagem em novo arquivo
		ImageIO.write(novaImagem, "png", new File(nomeArquivo));
		
	}
}

