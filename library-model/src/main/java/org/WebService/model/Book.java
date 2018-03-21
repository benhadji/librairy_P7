package org.WebService.model;

public class Book {


    private Integer ISBN;
    private String title;
    private Integer nbOfCopy;
    private Integer year;
    private Integer editor_id;
    private Integer author_id;
    private Author author;
    private Editor editor;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public Integer getEditor_id() {
        return editor_id;
    }

    public void setEditor_id(Integer editor_id) {
        this.editor_id = editor_id;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNbOfCopy() {
        return nbOfCopy;
    }

    public void setNbOfCopy(Integer nbOfCopy) {
        this.nbOfCopy = nbOfCopy;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
