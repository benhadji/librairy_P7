
package org.webservice.service.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour findUserByEmailResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="findUserByEmailResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://services.service.WebService.org/}userAccount" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findUserByEmailResponse", propOrder = {
    "_return"
})
public class FindUserByEmailResponse {

    @XmlElement(name = "return")
    protected UserAccount _return;

    /**
     * Obtient la valeur de la propriété return.
     * 
     * @return
     *     possible object is
     *     {@link UserAccount }
     *     
     */
    public UserAccount getReturn() {
        return _return;
    }

    /**
     * Définit la valeur de la propriété return.
     * 
     * @param value
     *     allowed object is
     *     {@link UserAccount }
     *     
     */
    public void setReturn(UserAccount value) {
        this._return = value;
    }

}
