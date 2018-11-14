
package org.webservice.service.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour addReservation complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="addReservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://services.service.WebService.org/}book" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://services.service.WebService.org/}userAccount" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addReservation", propOrder = {
    "arg0",
    "arg1"
})
public class AddReservation {

    protected Book arg0;
    protected UserAccount arg1;

    /**
     * Obtient la valeur de la propriété arg0.
     * 
     * @return
     *     possible object is
     *     {@link Book }
     *     
     */
    public Book getArg0() {
        return arg0;
    }

    /**
     * Définit la valeur de la propriété arg0.
     * 
     * @param value
     *     allowed object is
     *     {@link Book }
     *     
     */
    public void setArg0(Book value) {
        this.arg0 = value;
    }

    /**
     * Obtient la valeur de la propriété arg1.
     * 
     * @return
     *     possible object is
     *     {@link UserAccount }
     *     
     */
    public UserAccount getArg1() {
        return arg1;
    }

    /**
     * Définit la valeur de la propriété arg1.
     * 
     * @param value
     *     allowed object is
     *     {@link UserAccount }
     *     
     */
    public void setArg1(UserAccount value) {
        this.arg1 = value;
    }

}
