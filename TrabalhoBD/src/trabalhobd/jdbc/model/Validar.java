package trabalhobd.jdbc.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validar {
	public static boolean validarEmail(String email){
		Pattern p = Pattern.compile("^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9,a-z,A-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$");
		Matcher m = p.matcher(email);
		boolean matchFound = m.matches();
		return matchFound;
	}
	
	public static boolean validarCPF(String CPF){
		int i=0;
		int j=0;
		int b=10;
		int cont=0;
		int CPFNum=0;
		int aux=0;
		if(CPF.length()<11){
			return false;
		}
		for(i=0;i<CPF.length()-1;i++){
			j++;
			if(CPF.charAt(i)=='.' || CPF.charAt(i)=='/' || CPF.charAt(i)=='-'){
				continue;
			}
			if((((int)CPF.charAt(i))-48)==(((int)CPF.charAt(j))-48)){
				cont++;
			}else{
				break;
			}
			if(cont>=11){
				return false;
			}
		}for(i=0; i<CPF.length()-2; i++){
			if(CPF.charAt(i)=='.' || CPF.charAt(i)=='-'){
				continue;
			}else{
				CPFNum=(((int)CPF.charAt(i))-48);
				if(CPFNum>9 || CPFNum<0){
					return false;
				}else{
					aux+=(CPFNum)*(b--);
				}
			}
		}
		aux=((aux*10)%11==10 || (aux*10)%11==11)?0:((aux*10)%11);
		if(aux==(((int)CPF.charAt(CPF.length()-2))-48)){
			aux=0;
			b=11;
			for(i=0; i<CPF.length()-1; i++){
				if(CPF.charAt(i)=='.' || CPF.charAt(i)=='-'){
					continue;
				}else{
					CPFNum=(((int)CPF.charAt(i))-48);
					if(CPFNum>9 || CPFNum<0){
						return false;
					}else{
						aux+=(CPFNum)*(b--);
					}
				}
			}
			aux=((aux*10)%11==10 || (aux*10)%11==11)?0:((aux*10)%11);
			if((aux==(((int)CPF.charAt(CPF.length()-1))-48)))
				return true;
		}
		return false;
	}
	
	public boolean validarCNPJ(String CNPJ){
		int i=0;
		int j=0;
		int b=2;
		int cont=0;
		int CNPJNum=0;
		int aux=0;
		if(CNPJ.length()<14){
			return false;
		}
		for(i=0;i<CNPJ.length()-1;i++){
			j++;
			if(CNPJ.charAt(i)=='.' || CNPJ.charAt(i)=='/' || CNPJ.charAt(i)=='-'){
				continue;
			}
			if((((int)CNPJ.charAt(i))-48)==(((int)CNPJ.charAt(j))-48)){
				cont++;
			}else{
				break;
			}
			if(cont>=14){
				return false;
			}
		}for(i=CNPJ.length()-3;i>=0;i--){
			if(CNPJ.charAt(i)=='.' || CNPJ.charAt(i)=='/' || CNPJ.charAt(i)=='-'){
				continue;
			}else{
				CNPJNum=(((int)CNPJ.charAt(i))-48);
				if(CNPJNum>9 || CNPJNum<0){
					return false;
				}else{
					if(b==10)
						b=2;
					aux+=(CNPJNum)*(b++);
				}
			}
		}if((aux)%11==0 || (aux)%11==1){
			aux=0;
		}else{
			aux=11-(aux%11);
		}if((aux==(((int)CNPJ.charAt(CNPJ.length()-2))-48))){
			aux=0;
			b=2;
			for(i=CNPJ.length()-2;i>=0;i--){
				if(CNPJ.charAt(i)=='.' || CNPJ.charAt(i)=='/' || CNPJ.charAt(i)=='-'){
					continue;
				}else{
					CNPJNum=(((int)CNPJ.charAt(i))-48);
					if(CNPJNum>9 || CNPJNum<0){
						return false;
					}else{
						if(b==10)
							b=2;
						aux+=(CNPJNum)*(b++);
					}
				}
			}
		}if((aux)%11==0 || (aux)%11==1){
			aux=0;
		}else{
			aux=11-(aux%11);
		}if((aux==(((int)CNPJ.charAt(CNPJ.length()-1))-48))){
			return true;
		}
		return false;
	}
	
	public boolean validarChaveNFe(String NFe){
		int i=0;
		int j=0;
		int cont=0;
		int b=10;
		int NFeNum=0;
		int aux=0;
		if(NFe.length()<44){
			return false;
		}
		for(i=0;i<NFe.length()-1;i++){
			j++;
			if(NFe.charAt(i)=='.' || NFe.charAt(i)=='/' || NFe.charAt(i)=='-'){
				continue;
			}
			if((((int)NFe.charAt(i))-48)==(((int)NFe.charAt(j))-48)){
				cont++;
			}else{
				break;
			}
			if(cont>43){
				return false;
			}
		}
		for(i=NFe.length()-2;i>=0;i--){
			if(NFe.charAt(i)=='.' || NFe.charAt(i)=='/' || NFe.charAt(i)=='-'){
				continue;
			}else{
				NFeNum=(((int)NFe.charAt(i))-48);
				System.out.print(NFeNum);
				if(b==10)
					b=2;
				aux+=(NFeNum)*(b++);
			}
		}if((aux)%11==0 || (aux)%11==1){
			aux=0;
		}else{
			aux=11-(aux%11);
		}if((aux==(((int)NFe.charAt(NFe.length()-1))-48)))
			return true;
		else
			return false;
	}
	public static void main(String args[]){
		Validar a = new Validar();
		System.out.println(a.validarEmail("alexfrederico@alu.ufc.br"));
	}
}
