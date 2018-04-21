
package org.webservice.service.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour book complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="book">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="author" type="{http://services.service.WebService.org/}author" minOccurs="0"/>
 *         &lt;element name="author_id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="borrowByBook" type="{http://services.service.WebService.org/}borrow" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="editor" type="{http://services.service.WebService.org/}editor" minOccurs="0"/>
 *         &lt;element name="editor_id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ISBN" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nbOfCopy" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "book", propOrder = {
    "author",
    "authorId",
    "borrowByBook",
    "editor",
    "editorId",
    "isbn",
    "nbOfCopy",
    "title",
    "year"
})
public class Book {

    protected Author author;
    @XmlElement(name = "author_id")
    protected Integer authorId;
    @XmlElement(nillable = true)
    protected List<Borrow> borrowByBook;
    protected Editor editor;
    @XmlElement(name = "editor_id")
    protected Integer editorId;
    @XmlElement(name = "ISBN")
    protected Integer isbn;
    protected Integer nbOfCopy;
    protected String title;
    protected Integer year;

    /**
     * Obtient la valeur de la propriété author.
     * 
     * @return
     *     possible object is
     *     {@link Author }
     *     
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Définit la valeur de la propriété author.
     * 
     * @param value
     *     allowed object is
     *     {@link Author }
     *     
     */
    public void setAuthor(Author value) {
        this.author = value;
    }

    /**
     * Obtient la valeur de la propriété authorId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * Définit la valeur de la propriété authorId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAuthorId(Integer value) {
        this.authorId = value;
    }

    /**
     * Gets the value of the borrowByBook property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the borrowByBook property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBorrowByBook().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Borrow }
     * 
     * 
     */
    public List<Borrow> getBorrowByBook() {
        if (borrowByBook == null) {
            borrowByBook = new ArrayList<Borrow>();
        }
        return this.borrowByBook;
    }

    /**
     * Obtient la valeur de la propriété editor.
     * 
     * @return
     *     possible object is
     *     {@link Editor }
     *     
     */
    public Editor getEditor() {
        return editor;
    }

    /**
     * Définit la valeur de la propriété editor.
     * 
     * @param value
     *     allowed object is
     *     {@link Editor }
     *     
     */
    public void setEditor(Editor value) {
        this.editor = value;
    }

    /**
     * Obtient la valeur de la propriété editorId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEditorId() {
        return editorId;
    }

    /**
     * Définit la valeur de la propriété editorId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEditorId(Integer value) {
        this.editorId = value;
    }

    /**
     * Obtient la valeur de la propriété isbn.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getISBN() {
        return isbn;
    }

    /**
     * Définit la valeur de la propriété isbn.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setISBN(Integer value) {
        this.isbn = value;
    }

    /**
     * Obtient la valeur de la propriété nbOfCopy.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNbOfCopy() {
        return nbOfCopy;
    }

    /**
     * Définit la valeur de la propriété nbOfCopy.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNbOfCopy(Integer value) {
        this.nbOfCopy = value;
    }

    /**
     * Obtient la valeur de la propriété title.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Définit la valeur de la propriété title.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Obtient la valeur de la propriété year.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Définit la valeur de la propriété year.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setYear(Integer value) {
        this.year = value;
    }

}
