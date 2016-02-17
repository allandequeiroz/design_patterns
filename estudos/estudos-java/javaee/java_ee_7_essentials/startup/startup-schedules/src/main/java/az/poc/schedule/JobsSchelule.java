package az.poc.schedule;

import az.poc.manager.ThreadManager;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.Timer;
import java.util.logging.Logger;

@Stateless
@LocalBean
public class JobsSchelule implements Serializable{


    protected Logger log = Logger.getLogger(this.getClass().getName());

    private ThreadManager threadManager = new ThreadManager();

    public void begin(long nextExecution){
        //Verifica se monitor esta ativo
        //Listar Regras
        //For de regras enviando o tempo para a próxima execucao
        threadManager.begin(null, nextExecution);
    }


}

