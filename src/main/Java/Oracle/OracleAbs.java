package Java.Oracle;

import Java.Controller.ModuleController;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by seraphiana on 17/07/14.
 */
public abstract class OracleAbs<T> implements Oracle<T> {

    private final ModuleController controller;

    public OracleAbs(ModuleController controller) {
        this.controller = controller;
    }

    protected ModuleController getController() {
        return controller;
    }

}
