package com.macuxi.camarao.services;
import javax.swing.SwingWorker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class BackGroundService extends SwingWorker<Object, Object> {
    	
    	@Autowired
    	private TemperaturaService temperaturaService;
    	
        @Override
		public Object doInBackground() throws Exception {
            while (true) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        temperaturaService.generateTemperatura();                         
                    }
                });
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

