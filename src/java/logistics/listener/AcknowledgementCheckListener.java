/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistics.listener;

import javax.annotation.Resource;
import javax.ejb.TimerService;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Vignesh
 */
@WebListener
public class AcknowledgementCheckListener implements ServletContextListener{

    @Resource TimerService timerService;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
    
    
}
