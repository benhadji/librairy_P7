package org.WebService.consumer.contract.DAO;

import org.WebService.model.Editor;

import java.util.List;

public interface EditorDAO {

    void create(Editor editor);
    List<Editor> getAllEditors();
    List<Editor> getByName(String name);
    Editor getById(Integer id);
    Editor getByBookTitle(String title);
}
