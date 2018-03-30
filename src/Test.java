
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinearProgram lp = new LinearProgram();
		lp.typeOptimisation();
		lp.saisirNbreVariables();
		lp.saisirCoefficientsFonctionObjective();
		
		lp.saisirNbreContraintes();
		lp.saisirContraintes();
		lp.saisirtypeOperateur();
		lp.saisirBornes();
		lp.saisirContraintesDeSigne();
		
		lp.afficherFonctionObejctive();
		lp.afficherContraintes();
		lp.afficherContraintesDeSigne();
		lp.typePL();
		//lp.StandardToCanonique();
		//lp.canoniqueToStandard();
		lp.generalToStandard();
	}

}
