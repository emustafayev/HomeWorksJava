package homework13;

import homework13.controller.FamilyController;

public class FamilyApp {
    public static void main(String[] args) {
        FamilyController familyController = new FamilyController();
        familyController.downloadDataController();
        familyController.run();
    }
}
