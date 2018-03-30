

	import java.util.InputMismatchException;
import java.util.Scanner;

	 
	public class LinearProgram {
	
		
		public int nbrVariables;
		int nbrContraintes=0;
		String typeOp;
		String auxiliareObjective="";
		String auxiliaire="";
		String fonctionObjective="";
		
		
		
		Scanner Sc = new Scanner(System.in);
		
		String [] contrainte=new String[100];
		int[] coefficientFonction=new int[500];
		int coefficienContrainte[][]= new int [100][100];
		String arrayTypeOperateur[]=new String[100];
		int arrayOfBornes[]= new int [100];
		String arrayTypeOfSign[]=new String[100];
		
		
		
		public void typeOptimisation(){
			
			System.out.println("Donner le type d'optimisation \n si vous voulez une Maximisation tapez 1 si minimisation tapez 0" );
			
				int type = Sc.nextInt();
			 if(type==1)
				 {typeOp="Max";
			 
				System.out.println("vous avez choisi maximisation");}
				 else if(type==0) { typeOp="Min";
				System.out.println ("vous avez choisi un minimisation");
				}
				 else
				 	typeOptimisation();
			
		}
		public boolean isInteger(String str) {
		    return str.matches("^-?[0-9]+(\\.[0-9]+)?$");
		}
		public void saisirNbreVariables(){
			String nbrchar;
			System.out.println("Donnez le nombre des variables");
			nbrchar= Sc.next();
			if(!isInteger(nbrchar))
				saisirNbreVariables();
			else{
				nbrVariables=Integer.parseInt(nbrchar);
			}
		}
		
		
		public void saisirCoefficientsFonctionObjective(){
			for (int i=0;i<nbrVariables;i++){
				
				System.out.println("donner le "+(i+1)+"eme coefficient");
				coefficientFonction[i]=Sc.nextInt();
			}
		}
		
		public void saisirNbreContraintes(){
			String charcont;
			System.out.println("Donnez le nombre des contraintes");
			charcont=Sc.next();
			if(!isInteger(charcont))
				saisirNbreContraintes();
			else{
				nbrContraintes=Integer.parseInt(charcont);
			}
			
		}
		public void saisirContraintes(){
			int j=0;
			while (j<nbrContraintes){
				System.out.println("donnez les coefficients de la"+(j+1)+"eme contrainte");
				for (int i=0;i<nbrVariables;i++){
					System.out.println("donnez le "+(i+1)+"eme coefficient de la"+(j+1)+"eme contrainte");
					coefficienContrainte[j][i]=Sc.nextInt();
				}
				j++;
			}
		}
		public void saisirtypeOperateur(){
			System.out.println("pour choisir le type d'operateur tapez sur \n 1 si vous voulez < \n 2 si vous voulez > \n 3 si vous voulez <= \n 4 si vous voulez >= \n 5 si vous voulez =");
			
			for(int i=0;i<nbrContraintes;i++){
			System.out.println("donner le type d'operateur de la "+(i+1)+"eme contrainte");
			int typeOperateur = Sc.nextInt();
			switch (typeOperateur)
			{
				case 1:arrayTypeOperateur[i]="<";
				break;
				case 2:arrayTypeOperateur[i]=">";
				break;
				case 3:arrayTypeOperateur[i]="<=";
				break;
				case 4: arrayTypeOperateur[i]=">=";
				break;
				case 5:arrayTypeOperateur[i]="=";
				break;		
			}
			}
			
			
		}
		public void saisirBornes(){
			for(int i=0;i<nbrContraintes;i++){
				System.out.println("donner le borne de la"+(i+1)+"contrainte");
				arrayOfBornes[i]=Sc.nextInt();	
			}
		}
		
		public void saisirContraintesDeSigne(){
			System.out.println("pour choisir le signe\ntapez 1 pour >0 \n tapez 2 pour <0 \n tapez 3 pour >=0 \n tapez 4 pour <=0 \n tapez 5 pour définie sur R ");
			
			for (int i = 0 ; i<nbrVariables;i++){
				System.out.println("donner le signe du "+(i+1)+"eme variable ");
				int typeOperateur = Sc.nextInt();
				switch (typeOperateur)
				{
					case 1:arrayTypeOfSign[i]=">0";
					break;
					case 2:arrayTypeOfSign[i]="<0";
					break;
					case 3:arrayTypeOfSign[i]=">=0";
					break;
					case 4: arrayTypeOfSign[i]="<=0";
					break;
					case 5:arrayTypeOfSign[i]="Défini sur R";
					break;
					default:saisirContraintesDeSigne();
					break;
				}
				
			}
			
			
			
		}
		public void afficherFonctionObejctive(){
			for (int i=0;i<nbrVariables;i++){
				if (coefficientFonction[i]==0){
					if(i<(nbrVariables-1))
						fonctionObjective=fonctionObjective;
						else if(i==(nbrVariables-1))
							fonctionObjective=fonctionObjective.substring(0,(fonctionObjective.length()-1));
						
				}
				else if(coefficientFonction[i]==1){
					
					auxiliareObjective=("x"+(i+1));
					if(i<(nbrVariables-1))
					fonctionObjective=fonctionObjective+auxiliareObjective+"+";
					else if(i==(nbrVariables-1))
						fonctionObjective=fonctionObjective+auxiliareObjective;
				}
				else{
					auxiliareObjective=Integer.toString(coefficientFonction[i])+"x"+(i+1);
					if(i<(nbrVariables-1))
						fonctionObjective=fonctionObjective+auxiliareObjective+"+";
					else if(i==(nbrVariables-1))
						fonctionObjective=fonctionObjective+auxiliareObjective;
					
				}
				
			}
			System.out.println(typeOp+"(Z="+fonctionObjective+")");
			
		}
		
		public void afficherContraintes(){
			for(int i=0;i<contrainte.length;i++){
				contrainte[i]="";
			}
			for(int i=0;i<nbrContraintes;i++){
				//System.out.println("la contraine "+(i+1)+" est");
				for(int j=0;j<nbrVariables;j++){
					if (coefficienContrainte[i][j]==0){
						if(j<(nbrVariables-1))
							contrainte[i]=contrainte[i];
						else if(j==(nbrVariables-1))
							contrainte[i]=contrainte[i].substring(0, contrainte[i].length()-1);
						
						
					}
					else if(coefficienContrainte[i][j]==1){
						auxiliaire=("x"+(j+1));
						if(j<(nbrVariables-1))
							contrainte[i]=contrainte[i]+auxiliaire+"+";
						else if(j==(nbrVariables-1))
							contrainte[i]=contrainte[i]+auxiliaire;
					}
					else{
						auxiliaire=(Integer.toString(coefficienContrainte[i][j])+"x"+(j+1));
						if(j<(nbrVariables-1))
							contrainte[i]=contrainte[i]+auxiliaire+"+";
						else if(j==(nbrVariables-1))
							contrainte[i]=contrainte[i]+auxiliaire;
					}
					
				//	contrainte=contrainte+auxiliaire;
					
				}//end j
				contrainte[i]=contrainte[i]+arrayTypeOperateur[i]+Integer.toString(arrayOfBornes[i]);
				System.out.println(contrainte[i]);	
			}
			
		}
		public void afficherContraintesDeSigne(){
			/*for(int j=0;j<arrayTypeOfSign.length;j++){
				arrayTypeOfSign[j]="";
			}*/
			for (int i=0;i<nbrVariables;i++){
				System.out.print("\t x"+(i+1)+arrayTypeOfSign[i]);
			}
			
		}
		public boolean isStandard(){
			boolean isStandard=false;
			int i=0;
			while (arrayTypeOperateur[i]=="=" && i<arrayTypeOperateur.length) {
				isStandard=true;
				i++;
				
			}
			return(isStandard);
		}
		
		public boolean isGenerale(){
			boolean isGenerale=false;
			boolean iscanonique=false;
			int[] T = new int[nbrContraintes];
			for (int i=0;i<nbrContraintes;i++){
				if (arrayTypeOperateur[i]=="=") T[i]=1;
				else if (arrayTypeOperateur[i]=="<" || arrayTypeOperateur[i]=="<=") T[i]=2;
				else if (arrayTypeOperateur[i]==">" || arrayTypeOperateur[i]==">=") T[i]=3;
				
				}
			for (int i=0;i<T.length;i++){
				for(int j=i;j<T.length;j++){
				if (T[i] != T[j])
					isGenerale=true;
				}
			}
			return isGenerale;
			
		}
		
	
	public void typePL(){
		
	 if(isStandard())
			System.out.println(" \n la forme du programme linéaire est STANDARD");
		else if(isGenerale())
			System.out.println("\n la forme du programme linéaire est GENERALE");
		else
			System.out.println(" \n la forme du programme linéaire est CANONIQUE");
	}
	
		public void StandardToCanonique(){
			for(int i=0;i<(contrainte.length);i++){
				contrainte[i]="";
			}
			for(int i=0;i<nbrContraintes;i++){
				//System.out.println("la contraine "+(i+1)+" est");
				for(int j=0;j<nbrVariables;j++){
					if (coefficienContrainte[i][j]==0){
						if(j<(nbrVariables-1))
							contrainte[i]=contrainte[i];
						else if(j==(nbrVariables-1))
							contrainte[i]=contrainte[i].substring(0, contrainte[i].length()-1);
						
						
					}
					else if(coefficienContrainte[i][j]==1){
						auxiliaire=("x"+(j+1));
						if(j<(nbrVariables-1))
							contrainte[i]=contrainte[i]+auxiliaire+"+";
						else if(j==(nbrVariables-1))
							contrainte[i]=contrainte[i]+auxiliaire;
					}
					else{
						auxiliaire=(Integer.toString(coefficienContrainte[i][j])+"x"+(j+1));
						if(j<(nbrVariables-1))
							contrainte[i]=contrainte[i]+auxiliaire+"+";
						else if(j==(nbrVariables-1))
							contrainte[i]=contrainte[i]+auxiliaire;
					}
					
				//	contrainte=contrainte+auxiliaire;
					
				}//end j
			String	contrainte2=contrainte[i];
				contrainte[i]=contrainte[i]+"<="+Integer.toString(arrayOfBornes[i]);
				System.out.println(contrainte[i]);	
				contrainte2=contrainte2+">="+Integer.toString(arrayOfBornes[i]);
				System.out.println(contrainte2);
				
				
			}
			afficherContraintesDeSigne();
		}
		public void canoniqueToStandard(){
			if(typeOp=="Max"){
				for(int i=0;i<contrainte.length;i++){
					contrainte[i]="";
				}
				for(int i=0;i<nbrContraintes;i++){
					//System.out.println("la contraine "+(i+1)+" est");
					for(int j=0;j<nbrVariables;j++){
						if (coefficienContrainte[i][j]==0){
							if(j<(nbrVariables-1))
								contrainte[i]=contrainte[i];
							else if(j==(nbrVariables-1))
								contrainte[i]=contrainte[i].substring(0, contrainte[i].length()-1);
							
							
						}
						else if(coefficienContrainte[i][j]==1){
							auxiliaire=("x"+(j+1));
							if(j<(nbrVariables-1))
								contrainte[i]=contrainte[i]+auxiliaire+"+";
							else if(j==(nbrVariables-1))
								contrainte[i]=contrainte[i]+auxiliaire;
						}
						else{
							auxiliaire=(Integer.toString(coefficienContrainte[i][j])+"x"+(j+1));
							if(j<(nbrVariables-1))
								contrainte[i]=contrainte[i]+auxiliaire+"+";
							else if(j==(nbrVariables-1))
								contrainte[i]=contrainte[i]+auxiliaire;
						}
						
					//	contrainte=contrainte+auxiliaire;
						
					}//end j
					contrainte[i]=contrainte[i]+"+ x"+(nbrVariables+i+1)+"="+Integer.toString(arrayOfBornes[i]);
					System.out.println(contrainte[i]);	
					
				}
				afficherContraintesDeSigne();
				
			}
			if(typeOp=="Min"){
				for(int i=0;i<contrainte.length;i++){
					contrainte[i]="";
				}
				for(int i=0;i<nbrContraintes;i++){
					//System.out.println("la contraine "+(i+1)+" est");
					for(int j=0;j<nbrVariables;j++){
						if (coefficienContrainte[i][j]==0){
							if(j<(nbrVariables-1))
								contrainte[i]=contrainte[i];
							else if(j==(nbrVariables-1))
								contrainte[i]=contrainte[i].substring(0, contrainte[i].length()-1);
							
							
						}
						else if(coefficienContrainte[i][j]==1){
							auxiliaire=("x"+(j+1));
							if(j<(nbrVariables-1))
								contrainte[i]=contrainte[i]+auxiliaire+"+";
							else if(j==(nbrVariables-1))
								contrainte[i]=contrainte[i]+auxiliaire;
						}
						else{
							auxiliaire=(Integer.toString(coefficienContrainte[i][j])+"x"+(j+1));
							if(j<(nbrVariables-1))
								contrainte[i]=contrainte[i]+auxiliaire+"+";
							else if(j==(nbrVariables-1))
								contrainte[i]=contrainte[i]+auxiliaire;
						}
						
					//	contrainte=contrainte+auxiliaire;
						
					}//end j
					contrainte[i]=contrainte[i]+"- x"+(nbrVariables+i+1)+"="+Integer.toString(arrayOfBornes[i]);
					System.out.println(contrainte[i]);	
					
				}
				afficherContraintesDeSigne();
			}
			}
		public void generalToStandard(){
			
			for(int i=0;i<arrayTypeOperateur.length;i++){
				if(arrayTypeOperateur[i]=="="){
					contrainte[i]= contrainte[i].substring(0, (contrainte[i].length()-2));
					System.out.println(contrainte[i]);
				}
				else if((arrayTypeOperateur[i]=="<")||(arrayTypeOperateur[i]=="<=")){
					contrainte[i]=contrainte[i].substring(0, (contrainte[i].length()-2))+"+ x"+(nbrVariables+i+1)+"="+Integer.toString(arrayOfBornes[i]);
					System.out.println(contrainte[i]);
					
				}
				else if((arrayTypeOperateur[i]==">")||(arrayTypeOperateur[i]==">=")){
					contrainte[i]=contrainte[i].substring(0, (contrainte[i].length()-2))+"- x"+(nbrVariables+i+1)+"="+Integer.toString(arrayOfBornes[i]);
					System.out.println(contrainte[i]);
				}
			}
			for (int i=0;i<nbrVariables;i++){
				if (arrayTypeOfSign[i]=="<"  )
				System.out.print("\t -x"+(i+1)+">0");
				else if (arrayTypeOfSign[i]=="<=")
					System.out.print("\t -x"+(i+1)+">=0");
				else if (arrayTypeOfSign[i]==">")
					System.out.print("\t -x"+(i+1)+"<0");
				else if (arrayTypeOfSign[i]==">=")
					System.out.print("\t -x"+(i+1)+"<=0");
				else if (arrayTypeOfSign[i]=="Défini sur R") System.out.print("\t -x"+(i+1)+"= x"+(nbrVariables+i+1)+"- x"+(nbrVariables+i+2)+ "Telle que"+"x"+(nbrVariables+i+1)+">0 et x"+(nbrVariables+i+2)+">0");
					
			}
			
		}
			}
		
		
			
	


