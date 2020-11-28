import java.util.ArrayList;
//Julio Vicente Brych e Fabricio Oliveira Bezerra
public class Processamento {
	private int ver[];

	
	public Processamento (int quant) {
		this.ver = new int[quant];
	}
	
	public void paipadrao() {
		for (int i=0;i<ver.length;i++) {
			ver[i]=i;
		}
	}
	private int find(int no) { //encotra o pai da vertice 
	    return ver[no];
	}
	
	public void union(int no1, int no2) {
	    int paiA = find(no1);
	    int paiB = find(no2);
	    
	    if(paiA == paiB) { // se tiverem os mesmos pais nada acontece
	    	return;
	    }
	    //caso pais diferencetes o pai de B vai ser A
	    ver[paiB] = paiA;

	    for(int i = 0; i < ver.length; i++) {// e todos os que tiverem o pai B vao ter agora o pai como A
	        if(ver[i] == paiB) {
	            ver[i] = no1;
	        }
	    }
	    return;
	}
	public String printvetor(int caso) {
		String ret = "";
		ret += "Case #"+(caso+1)+":\n";
		ArrayList<String> pai = new ArrayList<String>();
		for(int i = 0; i < ver.length; i++) {//coloca em um Array todos os pais sem repetição
			if(!pai.contains(String.valueOf(ver[i]))) {
				pai.add(String.valueOf(ver[i]));
			}
		}
		for(int i = 0; i < pai.size(); i++) {//percore o array pegando os pais
			int aux =Integer.parseInt(pai.get(i));
			for(int j = 0; j < ver.length; j++) {//percore o vetor e adiciona no retorno os que tiverem o pai igual ao aux
				if(ver[j] == aux) {
					ret += ((char)(j+97))+",";
				}
			}
			ret += "\n";
		}
		ret += "\n"+pai.size()+" connected components\n";//a quantidade de componentes e igual a quantidade de pais
		return ret;
		
	}
}
