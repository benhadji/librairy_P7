package org.WebService.business.impl.manager;

import org.WebService.business.contract.manager.EditorManager;
import org.WebService.model.Editor;

import java.util.List;

public class EditorManagerImpl extends AbstractManagerImpl implements EditorManager {
    @Override
    public List<Editor> getByName(String name) {
        return getDaoFactory().getEditorDAO().getByName(name);
    }

    @Override
    public List<Editor> getAllEditors() {
        return getDaoFactory().getEditorDAO().getAllEditors();
    }

    @Override
    public Editor getByID(Integer id) {
        return getDaoFactory().getEditorDAO().getById(id);
    }

    @Override
    public Editor getByBookTitle(String title) {
        return getDaoFactory().getEditorDAO().getByBookTitle(title);
    }
}
