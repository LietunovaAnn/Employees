package org.example.controller;

import org.example.view.*;

import java.util.ArrayList;
import java.util.List;

public class MainController extends Controller {
     private final MainView mainView;
    private final List<Controller> controllerList = new ArrayList<>();

    public MainController(MainView mainView) {
        super(mainView, Controller.MAIN_MENU_ACTION);
        this.mainView = mainView;

        controllerList.add(this);
        controllerList.add(new InfoEmployeeController(new InfoEmployeeView(), Controller.INFO_EMPL));
        controllerList.add(new AddEmployeeController(new AddEmployeeView(), Controller.ADD_EMPL_ACTION));
        controllerList.add(new RemoveEmployeeController(new RemoveEmployeeView(), Controller.REMOVE_EMPL_ACTION));

    }
    @Override
    public int process() {
        int action = mainView.chooseAction();
        while (action != FINISH_ACTION) {
            for (Controller controller : controllerList) {
                if (controller.canProcess(action)) {
                    action = controller.process();
                }
            }
        }
        return FINISH_ACTION;
    }
}
