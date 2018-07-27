package cn.canos.kanban.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author canos
 */
public abstract class BaseController {

    public BaseController() {
        log = LogManager.getLogger(this.getClass());
    }

    Logger log;
}
