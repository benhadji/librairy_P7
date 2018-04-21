package org.WebService.business.impl.manager;

import org.WebService.business.AbstractManager;
import org.WebService.business.contract.manager.EditorManager;
import org.webservice.service.services.Editor;


import java.util.List;

public class EditorManagerImpl extends AbstractManager implements EditorManager {

    @Override
    public Editor getEditor(Editor editor) {
        return null;
    }

    @Override
    public List<Editor> listEditors() {
        return null;
    }

    @Override
    public Editor getById(Integer id) {
        return getDaoFactory().getEditorDAO().getById(id);
    }



}
