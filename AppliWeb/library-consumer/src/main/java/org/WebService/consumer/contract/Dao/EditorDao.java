package org.WebService.consumer.contract.Dao;



import org.webservice.service.services.Editor;

import java.util.List;

public interface EditorDao {

    Editor getEditor(Editor editor);
    List<Editor> listEditors();
    Editor getByBookTitle(String title);
    Editor getById(Integer editorId);
}
