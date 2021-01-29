package guis;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class guiMainController {
	
	//GABARITO ALUNOS
	@FXML private TextField aGab0;
	@FXML private TextField aGab1;
	@FXML private TextField aGab2;
	@FXML private TextField aGab3;
	@FXML private TextField aGab4;
	@FXML private TextField aGab5;
	@FXML private TextField aGab6;
	@FXML private TextField aGab7;
	@FXML private TextField aGab8;
	@FXML private TextField aGab9;
	
	//GABARITO CERTO
	@FXML private TextField cGab0;
	@FXML private TextField cGab1;
	@FXML private TextField cGab2;
	@FXML private TextField cGab3;
	@FXML private TextField cGab4;
	@FXML private TextField cGab5;
	@FXML private TextField cGab6;
	@FXML private TextField cGab7;
	@FXML private TextField cGab8;
	@FXML private TextField cGab9;
	
	//NÚMERO DA PROVA
	@FXML private TextField numProva;

	//NOMES
	@FXML private TextField nomesAL;
	
	@FXML int linha = 0, colunaAlunos = 0, nota = 0, nProva = 0;
	@FXML String sit = "";

	@FXML String[][] gabaritoCerto = new String[10][10];
	@FXML String[][] gabaritoAlunos = new String[10][100];
	@FXML ArrayList<String> nomes = new ArrayList();
	@FXML ArrayList<Integer> notaFinal = new ArrayList();
	
	
	//inserindo gabarito
	@FXML
	public void noBotCadastrarEsq() {
		
		gabaritoCerto[0][nProva] = String.valueOf(cGab0.getText());
		gabaritoCerto[1][nProva] = String.valueOf(cGab1.getText());
		gabaritoCerto[2][nProva] = String.valueOf(cGab2.getText());
		gabaritoCerto[3][nProva] = String.valueOf(cGab3.getText());
		gabaritoCerto[4][nProva] = String.valueOf(cGab4.getText());
		gabaritoCerto[5][nProva] = String.valueOf(cGab5.getText());
		gabaritoCerto[6][nProva] = String.valueOf(cGab6.getText());
		gabaritoCerto[7][nProva] = String.valueOf(cGab7.getText());
		gabaritoCerto[8][nProva] = String.valueOf(cGab8.getText());
		gabaritoCerto[9][nProva] = String.valueOf(cGab9.getText());
		
		nProva = Integer.valueOf(numProva.getText());
		numProva.setText("");
		
		cGab0.setText("");
		cGab1.setText("");
		cGab2.setText("");
		cGab3.setText("");
		cGab4.setText("");
		cGab5.setText("");
		cGab6.setText("");
		cGab7.setText("");
		cGab8.setText("");
		cGab9.setText("");
		
	}
	
	@FXML
	public void noBotCadastrarDir() {
		
		gabaritoAlunos[0][colunaAlunos] = String.valueOf(aGab0.getText());
		gabaritoAlunos[1][colunaAlunos] = String.valueOf(aGab1.getText());
		gabaritoAlunos[2][colunaAlunos] = String.valueOf(aGab2.getText());
		gabaritoAlunos[3][colunaAlunos] = String.valueOf(aGab3.getText());
		gabaritoAlunos[4][colunaAlunos] = String.valueOf(aGab4.getText());
		gabaritoAlunos[5][colunaAlunos] = String.valueOf(aGab5.getText());
		gabaritoAlunos[6][colunaAlunos] = String.valueOf(aGab6.getText());
		gabaritoAlunos[7][colunaAlunos] = String.valueOf(aGab7.getText());
		gabaritoAlunos[8][colunaAlunos] = String.valueOf(aGab8.getText());
		gabaritoAlunos[9][colunaAlunos] = String.valueOf(aGab9.getText());
		
		nomes.add(nomesAL.getText());
		nomesAL.setText("");
		
		colunaAlunos++;
			
		aGab0.setText("");
		aGab1.setText("");
		aGab2.setText("");
		aGab3.setText("");
		aGab4.setText("");
		aGab5.setText("");
		aGab6.setText("");
		aGab7.setText("");
		aGab8.setText("");
		aGab9.setText("");
		
	}
	
	@FXML
	public void noBotResultados() {
		
		//ATRIBUINDO AS NOTAS
		for(colunaAlunos = 0; colunaAlunos < nomes.size(); colunaAlunos++) {
			for(linha = 0; linha < 10; linha++) {
				if(gabaritoAlunos[linha][colunaAlunos].equals(gabaritoCerto[linha][nProva-1])) {
					nota = nota + 1;
				}
			}
			notaFinal.add(colunaAlunos, nota);
			nota = 0;
		}
			
		for(colunaAlunos = 0; colunaAlunos < nomes.size(); colunaAlunos++) {
			System.out.println("Estudante: "+nomes.get(colunaAlunos));
			
			if(notaFinal.get(colunaAlunos) == 0) {
				notaFinal.add(colunaAlunos, 1);
			}
			
			if(notaFinal.get(colunaAlunos) >= 7)
				sit = "Aprovado";
			else
				sit = "Reprovado";
			
			System.out.println("Nota: "+notaFinal.get(colunaAlunos));
			System.out.println("Situação: "+sit+"\n");
			
		}
		System.out.println("------------------------------------\n");
	}
	
}
