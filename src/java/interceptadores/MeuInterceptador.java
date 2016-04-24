/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptadores;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author 86132113568
 */

@Interceptor
@Log
public class MeuInterceptador {

    private static final Logger LOG = Logger.getLogger(MeuInterceptador.class.getName());
    
    /**
     * Chamado quando o método com a anotação Log for chamado
     * 
     * @param ctx
     * @return
     * @throws Exception 
     */
    @AroundInvoke
    public Object registrarEvento(InvocationContext ctx) throws Exception
    {
        Log annotation = ctx.getMethod().getAnnotation(Log.class);
        boolean deveRegistrar = annotation.registrar();
        
        if (deveRegistrar) {
            LOG.log(Level.INFO, "{0} executado.", ctx.getMethod().getName());
        }
        
        Object resultado = ctx.proceed();
        if (deveRegistrar) {
            LOG.log(Level.INFO, "P\u00e1gina de destino: {0}", resultado.toString());
        }
        
        return resultado;
    }
}
