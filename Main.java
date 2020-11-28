import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
//Julio Vicente Brych e Fabricio Oliveira Bezerra
public class Main {
	public static void main(String[] args) throws IOException{
		//le o arquivo .in e chama os metodos para obter a resposta
		
		JFileChooser fc = new JFileChooser("C:\\temp");
		String path = null;
		File[] arquivos = null;
		fc.setDialogTitle("Escolha o(s) arquivo(s)..."); fc.setDialogType(JFileChooser.OPEN_DIALOG);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("in", ".in", "in");
		fc.setFileFilter(filter);
		fc.setApproveButtonText("OK"); fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setMultiSelectionEnabled(true); int resultado = fc.showOpenDialog(fc);
		if (resultado == JFileChooser.CANCEL_OPTION){ System.exit(1); } path = fc.getSelectedFile().getAbsolutePath();
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		
		int casos = Integer.parseInt(buffRead.readLine());//quantidade de casos
		int quantidadearrestas = 0;
		int no1 = 0;
		int no2 = 0;
		for(int i=0;i<casos;i++) {
			String[] textosep = new String [2];
			char[]textochar = new char[2];
			String linha = buffRead.readLine();//le os dois primeiros numeros
			textosep = linha.split(" ");
			Processamento pro = new Processamento(Integer.parseInt(textosep[0]));//instancia o vetor
			pro.paipadrao();//coloca cada vertice sendo pai dele mesmo
			quantidadearrestas = Integer.parseInt(textosep[1]);//seta o valor para ser usado no for das arrestas
			for(int j=0;j<quantidadearrestas;j++) {
				linha = buffRead.readLine();
				textosep = linha.split(" ");
				no1 = (int)(textosep[0].charAt(0))-97;
				no2 = (int)(textosep[1].charAt(0))-97;
				pro.union(no1, no2);
			}
			System.out.println(pro.printvetor(i));
		}
		buffRead.close();
	}
	
}
