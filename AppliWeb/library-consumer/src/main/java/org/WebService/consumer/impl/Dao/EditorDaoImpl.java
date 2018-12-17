package org.WebService.consumer.impl.Dao;

import org.WebService.consumer.contract.Dao.EditorDao;
import org.webservice.service.services.Editor;
import org.webservice.service.services.EditorService;
import org.webservice.service.services.Editor_Service;


import java.util.List;



public class EditorDaoImpl implements EditorDao {

    private Editor_Service editorService = new Editor_Service();
    private EditorService editorSrv = editorService.getEditorServicePort();

    public Editor_Service getEditorService() {
        return editorService;
    }

    public void setEditorService(Editor_Service editorService) {
        this.editorService = editorService;
    }

    public EditorService getEditorSrv() {
        return editorSrv;
    }

    public void setEditorSrv(EditorService editorSrv) {
        this.editorSrv = editorSrv;
    }

    @Override
    public Editor getEditor(Editor editor) {
        return null;
    }

    @Override
    public List<Editor> listEditors() {
        return null;
    }

    @Override
    public Editor getByBookTitle(String title) {
        return editorSrv.getEditorByBookTitle(title);
    }

    @Override
    public Editor getById(Integer id) {
        return editorSrv.getEditorById(id);
    }
}
