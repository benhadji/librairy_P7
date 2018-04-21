package org.WebService.business.contract.manager;


import org.webservice.service.services.Editor;

import java.util.List;

public interface EditorManager {

    Editor getEditor(Editor editor);

    List<Editor> listEditors();
    Editor getById(Integer id);
}
