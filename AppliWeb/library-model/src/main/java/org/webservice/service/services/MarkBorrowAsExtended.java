
package org.webservice.service.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour markBorrowAsExtended complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="markBorrowAsExtended">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://services.service.WebService.org/}borrow" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "markBorrowAsExtended", propOrder = {
    "arg0"
})
public class MarkBorrowAsExtended {

    protected Borrow arg0;

    /**
     * Obtient la valeur de la propriété arg0.
     * 
     * @return
     *     possible object is
     *     {@link Borrow }
     *     
     */
    public Borrow getArg0() {
        return arg0;
    }

    /**
     * Définit la valeur de la propriété arg0.
     * 
     * @param value
     *     allowed object is
     *     {@link Borrow }
     *     
     */
    public void setArg0(Borrow value) {
        this.arg0 = value;
    }

}
