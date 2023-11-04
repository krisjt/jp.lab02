package entry;

import lab02.operations.Solution;
import lab02.operations.FileCreator;


import static lab02.operations.ListInitialization.*;

public class Main {

    public static void start(){

        FileCreator.ownedSkiesCreation();
        FileCreator.preferenceCreation();
        FileCreator.discountCreation();

        fillDiscountList();
        fillOwnedSkiesList();
        fillPreferenceList();

        Solution.bestSkiMatch();
    }
    }
