/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Mensagem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 86132113568
 * 
 * Fachada para acesso a entidade. Contém métodos CRUD típicos
 */
@Stateless
public class MensagemFacade extends AbstractFacade<Mensagem> {

    @PersistenceContext(unitName = "JavaEESamplePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MensagemFacade() {
        super(Mensagem.class);
    }
    
}
