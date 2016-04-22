/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entidades.Mensagem;
import interceptadores.Log;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import negocio.MensagemFacade;

/**
 *
 * @author 86132113568
 * 
 * Usado pela View. 
 */
@Named(value = "messageView")
@RequestScoped
public class MessageView {

    @EJB
    private MensagemFacade mensagemFacade;

    private final Mensagem mensagem;

    public Mensagem getMensagem() {
        return mensagem;
    }
    
    /**
     * Creates a new instance of MessageView
     */
    public MessageView() {
        mensagem = new Mensagem();
    }
    
    /**
     * Cria a mensagem e envia
     * 
     * @return a próxima página JSF
     */
    @Log(registrar = true)
    public String postMessage() 
    {
        mensagemFacade.create(mensagem);
        return "ofim";          
    }
    
    public int getTotalMensagens()
    {
        return mensagemFacade.findAll().size();
    }
}
