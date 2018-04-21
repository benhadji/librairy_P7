package org.WebService.business.contract.manager;

import org.WebService.model.Editor;

import java.util.List;

public interface EditorManager {

    List<Editor> getByName(String name);
    List<Editor> getAllEditors();
    Editor getByID(Integer id);

}
