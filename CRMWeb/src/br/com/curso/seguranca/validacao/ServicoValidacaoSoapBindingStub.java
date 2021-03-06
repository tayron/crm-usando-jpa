/**
 * ServicoValidacaoSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.curso.seguranca.validacao;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Vector;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;

import org.apache.axis.AxisEngine;
import org.apache.axis.AxisFault;
import org.apache.axis.NoEndPointException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Stub;
import org.apache.axis.constants.Style;
import org.apache.axis.constants.Use;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.soap.SOAPConstants;
import org.apache.axis.utils.JavaUtils;

import br.com.crm.negocio.excecoes.ExcecaoNegocio;

/**
 * 
 * @author tayron
 *
 */
public class ServicoValidacaoSoapBindingStub extends Stub implements ServicoValidacao {
	
	/**
	 * 
	 */
	private Vector cachedSerClasses = new Vector();
	
	/**
	 * 
	 */
	private Vector cachedSerQNames = new Vector();
	
	/**
	 * 
	 */
	private Vector cachedSerFactories = new Vector();
	
	/**
	 * 
	 */
	private Vector cachedDeserFactories = new Vector();

	/**
	 * 
	 */
	static org.apache.axis.description.OperationDesc[] _operations;

	/**
	 * 
	 */
	static {
		_operations = new org.apache.axis.description.OperationDesc[1];
		_initOperationDesc1();
	}

	/**
	 * 
	 */
	private static void _initOperationDesc1() {
		OperationDesc oper;
		ParameterDesc param;
		
		oper = new OperationDesc();
		oper.setName("validarSenha");
		
		param = new ParameterDesc(
				new QName("http://validacao.seguranca.curso.com.br", "senha"),
				ParameterDesc.IN,
				new QName("http://www.w3.org/2001/XMLSchema", "string"),
				String.class, false, false);
		
		oper.addParameter(param);
		oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "boolean"));
		oper.setReturnClass(boolean.class);
		oper.setReturnQName(new QName("http://validacao.seguranca.curso.com.br", "validarSenhaReturn"));
		oper.setStyle(Style.WRAPPED);
		oper.setUse(Use.LITERAL);
		_operations[0] = oper;

	}

	/**
	 * 
	 * @throws AxisFault
	 */
	public ServicoValidacaoSoapBindingStub() throws AxisFault {
		this(null);
	}

	/**
	 * 
	 * @param endpointURL
	 * @param service
	 * @throws AxisFault
	 */
	public ServicoValidacaoSoapBindingStub(URL endpointURL,
			Service service) throws AxisFault {
		this(service);
		super.cachedEndpoint = endpointURL;
	}

	/**
	 * 
	 * @param service
	 * @throws AxisFault
	 */
	public ServicoValidacaoSoapBindingStub(Service service)
			throws AxisFault {
		if (service == null) {
			super.service = new org.apache.axis.client.Service();
		} else {
			super.service = service;
		}
		((org.apache.axis.client.Service) super.service)
				.setTypeMappingVersion("1.2");
	}

	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	protected Call createCall() throws RemoteException {
		try {
			Call _call = super._createCall();
			if (super.maintainSessionSet) {
				_call.setMaintainSession(super.maintainSession);
			}
			if (super.cachedUsername != null) {
				_call.setUsername(super.cachedUsername);
			}
			if (super.cachedPassword != null) {
				_call.setPassword(super.cachedPassword);
			}
			if (super.cachedEndpoint != null) {
				_call.setTargetEndpointAddress(super.cachedEndpoint);
			}
			if (super.cachedTimeout != null) {
				_call.setTimeout(super.cachedTimeout);
			}
			if (super.cachedPortName != null) {
				_call.setPortName(super.cachedPortName);
			}
			Enumeration keys = super.cachedProperties.keys();
			while (keys.hasMoreElements()) {
				String key = (String) keys.nextElement();
				_call.setProperty(key, super.cachedProperties.get(key));
			}
			return _call;
		} catch (Throwable _t) {
			throw new AxisFault(
					"Falha ao tentar recuperar o objeto", _t);
		}
	}

	/**
	 * @throws ExcecaoNegocio
	 * 
	 */
	public boolean validarSenha(String senha) throws RemoteException,
			ExcecaoNegocio {

		if (super.cachedEndpoint == null) {
			throw new NoEndPointException();
		}

		Call _call = createCall();
		_call.setOperation(_operations[0]);
		_call.setUseSOAPAction(true);
		_call.setSOAPActionURI("");
		_call.setEncodingStyle(null);
		_call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
		_call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
		_call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new QName(
				"http://validacao.seguranca.curso.com.br", "validarSenha"));

		setRequestHeaders(_call);
		setAttachments(_call);

		try {
			Object _resp = _call
					.invoke(new Object[] { senha });

			if (_resp instanceof RemoteException) {
				throw (RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return ((Boolean) _resp).booleanValue();
				} catch (Exception _exception) {
					return ((Boolean) JavaUtils.convert(_resp, boolean.class))
							.booleanValue();
				}
			}
		} catch (AxisFault e) {
			throw new ExcecaoNegocio(e.getMessage());
		}
	}
}